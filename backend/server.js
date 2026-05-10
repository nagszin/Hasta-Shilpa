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
    name: "Modern Bamboo Lamp",
    description: "Premium handcrafted lamp shade with geometric patterns.",
    imageUrl: "https://images.unsplash.com/photo-1540932239986-30128078f3c5?auto=format&fit=crop&w=400",
    measurements: "35cm x 20cm",
    materials: "Bamboo, Silk thread, LED",
    difficulty: "Medium",
    estimatedTime: "6 hours"
  },
  {
    id: 2,
    name: "Eco Laptop Stand",
    description: "Foldable bamboo stand for ergonomic workspace.",
    imageUrl: "https://images.unsplash.com/photo-1593642702821-c8da6771f0c6?auto=format&fit=crop&w=400",
    measurements: "45cm x 30cm",
    materials: "Heavy bamboo, Steel hinges",
    difficulty: "Easy",
    estimatedTime: "4 hours"
  },
  {
    id: 3,
    name: "Minimalist Cane Chair",
    description: "Sustainable seating for modern interiors.",
    imageUrl: "https://images.unsplash.com/photo-1519947486511-46149fa0a254?auto=format&fit=crop&w=400",
    measurements: "80cm x 60cm x 60cm",
    materials: "Cane, Wood, Cotton cushion",
    difficulty: "Hard",
    estimatedTime: "12 hours"
  }
];

// Mock Data for Marketplace
const marketplaceProducts = [
  {
    id: 101,
    name: "Artisan Weave Basket",
    price: 550.0,
    sellerName: "Nagszain",
    location: "Calicut",
    imageUrl: "https://images.unsplash.com/photo-1590059521360-1e58284617ec?auto=format&fit=crop&w=400"
  },
  {
    id: 102,
    name: "Bamboo Mirror Frame",
    price: 1200.0,
    sellerName: "Nagszain",
    location: "Calicut",
    imageUrl: "https://images.unsplash.com/photo-1618220179428-22790b461013?auto=format&fit=crop&w=400"
  }
];

// API Endpoints
app.get('/designs', (req, res) => {
  res.json(trendingDesigns);
});

app.get('/designs/:id', (req, res) => {
  const design = trendingDesigns.find(d => d.id === parseInt(req.params.id));
  if (design) res.json(design);
  else res.status(404).send('Design not found');
});

app.get('/marketplace', (req, res) => {
  res.json(marketplaceProducts);
});

// AI Price Suggestion Endpoint (Simulated)
app.post('/calculate-price', (req, res) => {
  const { materialCost, laborHours, laborRate, profitPercent } = req.body;

  const baseCost = materialCost + (laborHours * laborRate);
  const profitAmount = baseCost * (profitPercent / 100);
  const suggestedPrice = baseCost + profitAmount;

  // Add some "AI" randomness or adjustment
  const aiAdjustment = (Math.random() * 0.1) - 0.05; // +/- 5% adjustment
  const finalPrice = suggestedPrice * (1 + aiAdjustment);

  res.json({
    suggestedPrice: finalPrice.toFixed(2),
    baseCost: baseCost.toFixed(2),
    profitAmount: (finalPrice - baseCost).toFixed(2),
    aiConfidence: "High"
  });
});

// Artisan Stats Endpoint
app.get('/artisan-stats', (req, res) => {
  res.json({
    productsCreated: 15,
    totalEarnings: 24500.00,
    rating: 4.8
  });
});

app.listen(port, () => {
  console.log(`Hasta-Shilpa backend running at http://localhost:${port}`);
});
