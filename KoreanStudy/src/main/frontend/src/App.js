// src/App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Word from './components/VocabularyCard';
import Card from './components/card'
import Result from './components/QuizResult'
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    <Router>
      <Routes>
        {/* クイズ画面を /word に表示 */}
        <Route path="/home" element={<Card />} />
        <Route path="/food" element={<Word />} />
        <Route path="/plants" element={<Word />} />
        <Route path="/animals" element={<Word />} />
        <Route path="/sports" element={<Word />} />
        <Route path="/adjectives" element={<Word />} />
        <Route path="/adverbs" element={<Word />} />
        <Route path="/result" element={<Result />} />

        {/* 他のルート例（必要であれば） */}
        <Route path="/home" element={<div className="text-center mt-5">トップページ</div>} />

      </Routes>
    </Router>
  );
}

export default App;
