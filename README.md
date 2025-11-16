# 📱 DVT Weather App 

Simple weather app that shows forecast for 5 days

## 🏗️ Tech Stack

* Language: Kotlin
* Architecture: MVVM
* UI: Jetpack Compose
* Libraries & Tools:
  * Android Jetpack (ViewModel, StateFlow)
  * Retrofit / OkHttp / Gson
  * Hilt
  * Coroutines
  * Google Location Service

## 🚀 Getting Started
### Prerequisites
* Android Studio Ladybug or newer
* JDK 17+
* Gradle (handled automatically by Android Studio)

### Setup
```bash
git clone https://github.com/tnurdinov/dvt_weather.git
cd your-project
```

Open with **Android Studio**, let Gradle sync, and run the app.

## ⚙️ Configuration

1. Create a local.properties file:
```ini
API_KEY=open_weather_api_key
```

2. Access it in Gradle or BuildConfig.

## 📷 Screenshots
<div>
<img height="720" alt="Image" src="https://github.com/user-attachments/assets/f99b93f5-efd3-4d2d-ac80-810a9761506d" />
</div>

## :penguin: Plan
- [x] Using Compose UI
- [x] Dependency injection Hilt
- [x] Location service to get lat/lon
- [x] Integration with weather API
- [ ] Unit test
- [ ] Espresso tests
- [x] MVVM
- [x] CI/CD pipeline on push/release builds
- [ ] Image backgrounds
- [ ] Lint checks
- [ ] .editconfig rules
- [x] App icon
- [ ] Current weather updates
- [ ] Loaders
- [ ] No Internet