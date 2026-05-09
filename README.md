# Hasta-Shilpa - Artisan Empowerment App

Hasta-Shilpa is a modern Android application designed to help bamboo and cane artisans in the Western Ghats modernize their craft. It provides design inspirations, blueprint guides, material tracking, and an AI-powered price suggestion tool to bridge the gap between traditional skills and modern urban markets.

## Features

- **Splash Screen**: Engaging welcome screen with auto-navigation.
- **Home Dashboard**: Quick access to all app features using Material 3 Cards.
- **Trending Designs**: A curated feed of modern bamboo and cane product inspirations.
- **Blueprint Library**: Detailed measurements, material lists, and difficulty levels for products.
- **Material Tracker**: Local storage (Room Database) to track bamboo usage and labor hours.
- **AI Price Suggester**: Smart calculator to estimate selling prices based on costs and profit margins.
- **Marketplace**: A simulated marketplace to showcase finished products and artisan details.
- **Artisan Profile**: Summary of artisan achievements and earnings.

## Technical Details

- **Language**: Kotlin
- **Architecture**: MVVM (Model-View-ViewModel)
- **UI**: Material Design 3, ViewBinding, ConstraintLayout, RecyclerView
- **Database**: Room Persistence Library
- **Navigation**: Jetpack Navigation Component
- **Image Loading**: Glide
- **Minimum SDK**: API 26 (Android 8.0)

## Project Structure

- `data/`: Room entities, DAOs, and data models.
- `ui/`: Fragments and UI logic.
- `ui/adapters/`: RecyclerView adapters for various lists.
- `viewmodel/`: ViewModels for state management and data operations.

## Setup Instructions

1. Open the project in **Android Studio (Hedgehog or newer recommended)**.
2. Sync the project with Gradle files.
3. Run the app on an emulator or physical device with **API 26+**.

## Author
Developed for the Internship Final Project.
