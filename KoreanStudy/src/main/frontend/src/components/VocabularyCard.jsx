// src/components/VocabularyCard.jsx
import { useEffect, useState } from 'react';
import { VolumeUp } from 'react-bootstrap-icons';
import { useNavigate, useLocation } from 'react-router-dom';

export default function VocabularyCard() {
  const [questions, setQuestions] = useState([]);
  const [currentIndex, setCurrentIndex] = useState(0);
  const [selectedId, setSelectedId] = useState(null);
  const [score, setScore] = useState(0);
  const navigate = useNavigate();
  const location = useLocation();

  useEffect(() => {
    // URLに応じてAPIを切り替える
    let apiUrl = '';
    if (location.pathname === '/food') {
      apiUrl = 'http://localhost:9090/api/words';
    } else if (location.pathname === '/plants') {
      apiUrl = 'http://localhost:9090/api/plants';
    } else if (location.pathname === '/sports') {
      apiUrl = 'http://localhost:9090/api/sports';
    } else if (location.pathname === '/animals') {
    apiUrl = 'http://localhost:9090/api/animals';
    } else if (location.pathname === '/adjectives') {
    apiUrl = 'http://localhost:9090/api/adjectives';
    } else {
    apiUrl = 'http://localhost:9090/api/adverbs';
    }

    fetch(apiUrl)
      .then((res) => res.json())
      .then((data) => {
        console.log(data);
        const filtered = data.filter(w => w.name_kr?.trim() && w.name_jp?.trim());
        const generated = generateQuestions(filtered, 20);
        setQuestions(generated);
      });
  }, [location.pathname]);

  const generateQuestions = (wordList, count) => {
    const usedIds = new Set();
    const questions = [];
    const shuffleArray = (array) => {
      const result = [...array];
      for (let i = result.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [result[i], result[j]] = [result[j], result[i]];
      }
      return result;
    };

    while (questions.length < count && usedIds.size < wordList.length) {
      const remainingWords = wordList.filter(w => !usedIds.has(w.id));
      const correct = remainingWords[Math.floor(Math.random() * remainingWords.length)];
      usedIds.add(correct.id);
      const others = shuffleArray(wordList.filter(w => w.id !== correct.id)).slice(0, 3);
      const allChoices = shuffleArray([...others, correct]);
      questions.push({ correct, choices: allChoices });
    }

    return questions;
  };

  const currentQuestion = questions[currentIndex];

  const playAudio = () => {
    const utterance = new SpeechSynthesisUtterance(currentQuestion.correct.name_jp);
    utterance.lang = 'ja-JP';
    window.speechSynthesis.speak(utterance);
  };

  const handleSelect = (id) => {
    if (selectedId !== null) return;
    setSelectedId(id);
    if (id === currentQuestion.correct.id) {
      setScore(prev => prev + 1);
    }
  };

  const handleNextQuestion = () => {
    if (currentIndex + 1 >= questions.length) {
      navigate('/result', { state: { score, total: questions.length } });
    } else {
      setCurrentIndex(prev => prev + 1);
      setSelectedId(null);
    }
  };

  const handleGoHome = () => {
    navigate('/home');
  };

  if (questions.length === 0 || !currentQuestion) return <div>読み込み中...</div>;

  return (
    <div className="container d-flex flex-column align-items-center justify-content-center min-vh-100 bg-light">
      <h2 className="text-secondary mb-4">
        {location.pathname === '/home' ? '韓国語 単語クイズ' : '韓国語 単語クイズ'}
      </h2>
      <div className="bg-white p-5 rounded shadow text-center w-100" style={{ maxWidth: "600px" }}>
        <div className="mb-3">
          <h5>問題 {currentIndex + 1} / {questions.length}</h5>
        </div>
        <div className="mb-4 d-flex justify-content-center align-items-center fs-3 fw-bold text-dark">
          {currentQuestion.correct.name_jp}
          <VolumeUp
            className="ms-2"
            style={{ cursor: "pointer" }}
            onClick={playAudio}
            size={24}
          />
        </div>
        <div className="row row-cols-2 g-3 mb-4">
          {currentQuestion.choices.map(choice => (
            <div className="col" key={choice.id}>
              <button
                className={`btn w-100 text-start ${
                  selectedId === null
                    ? 'btn-outline-secondary'
                    : choice.id === currentQuestion.correct.id
                    ? 'btn-success'
                    : choice.id === selectedId
                    ? 'btn-danger'
                    : 'btn-outline-secondary'
                }`}
                onClick={() => handleSelect(choice.id)}
                disabled={selectedId !== null}
              >
                {choice.name_kr}
              </button>
            </div>
          ))}
        </div>
        {selectedId !== null && (
          <div className="d-flex flex-column gap-3 align-items-center mt-3">
            <button className="btn btn-primary" onClick={handleNextQuestion}>
              次の問題へ
            </button>
            <button className="btn btn-outline-secondary" onClick={handleGoHome}>
              ホームに戻る
            </button>
          </div>
        )}
      </div>
    </div>
  );
}
