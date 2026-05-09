const express = require('express');
const cors = require('cors');
const app = express();
const port = 3000;

app.use(cors());
app.use(express.json());

// Mock Data for Trending Designs
const trendingDesigns = [
  {
    id: 1,
    name: "Modern Bamboo Lamp (Backend)",
    description: "Premium handcrafted lamp shade with geometric patterns.",
    imageUrl: "https://images.unsplash.com/photo-1540932239986-30128078f3c5?auto=format&fit=crop&w=400",
    measurements: "35cm x 20cm",
    materials: "Bamboo, Silk thread, LED",
    difficulty: "Medium",
    estimatedTime: "6 hours"
  },
  {
    id: 2,
    name: "Eco Laptop Stand (Backend)",
    description: "Foldable bamboo stand for ergonomic workspace.",
    imageUrl: "https://images.unsplash.com/photo-1593642702821-c8da6771f0c6?auto=format&fit=crop&w=400",
    measurements: "45cm x 30cm",
    materials: "Heavy bamboo, Steel hinges",
    difficulty: "Easy",
    estimatedTime: "4 hours"
  }
];

// Mock Data for Marketplace
const marketplaceProducts = [
  {
    id: 101,
    name: "Artisan Weave Basket",
    price: 550.0,
    sellerName: "Gopal Hegde",
    location: "Sirsi",
    imageUrl: "https://images.unsplash.com/photo-1590059521360-1e58284617ec?auto=format&fit=crop&w=400"
  },
  {
    id: 102,
    name: "Cane Office Chair",
    price: 3200.0,
    sellerName: "Sunita M.",
    location: "Sagar",
    imageUrl: "https://images.unsplash.com/photo-1519947486511-46149fa0a254?auto=format&fit=crop&w=400"
  }
];

app.get('/designs', (req, res) => {
  res.json(trendingDesigns);
});

app.get('/marketplace', (req, res) => {
  res.json(marketplaceProducts);
});

app.listen(port, () => {
  console.log(`Hasta-Shilpa backend running at http://localhost:${port}`);
});
