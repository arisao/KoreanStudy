import React from "react";

export default function Home() {
  const categories = [
    { title: "食べ物編", emoji: "🍙", path: "/food" },
    { title: "動物編", emoji: "🐱", path: "/animals" },
    { title: "スポーツ編", emoji: "⚽", path: "/sports" },
    { title: "植物編", emoji: "🌸", path: "/plants" },
    { title: "形容詞編", emoji: "✨", path: "/adjectives" },
    { title: "副詞編", emoji: "💓", path: "/adverbs" },
  ];

  return (
    <div className="container mt-5 text-center">
      <h1 className="mb-4">韓国語マスター</h1>
      <div className="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
        {categories.map((cat, index) => (
          <div className="col" key={index}>
            <a href={cat.path} className="text-decoration-none">
              <div className="card shadow-sm h-100">
                <div className="card-body">
                  <h5 className="card-title">{cat.title}</h5>
                  <div style={{ fontSize: "2rem" }}>{cat.emoji}</div>
                </div>
              </div>
            </a>
          </div>
        ))}
      </div>
    </div>
  );
}
