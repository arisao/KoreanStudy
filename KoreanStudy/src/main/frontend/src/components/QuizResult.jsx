// src/components/QuizResult.jsx
import { useLocation, useNavigate } from "react-router-dom";

export default function QuizResult() {
  const navigate = useNavigate();
  const location = useLocation();
  const { score, total } = location.state || { score: 0, total: 0 };

  const handleGoHome = () => {
    navigate("/home");
  };

  return (
    <div className="container d-flex flex-column align-items-center justify-content-center min-vh-100 bg-light">
      <h2 className="mb-4">クイズ終了</h2>
      <p className="fs-4">スコア: {score} / {total}</p>
      <button className="btn btn-primary mt-4" onClick={handleGoHome}>
        ホームに戻る
      </button>
    </div>
  );
}