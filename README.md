<div align="center">

# 🎓 VAST-TC Placements

**Android app listing campus placement records year by year for Vidya Academy of Science & Technology, Technical Campus.**

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=flat-square&logo=android&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=flat-square&logo=gradle&logoColor=white)

</div>

## Overview

Built for **VAST-TC, Kilimanoor (Thiruvananthapuram)** — students can open the app, pick an academic year from 2017 to 2022, and browse every placed student with their branch and the company that hired them.

## How it works

- `MainActivity` → placements button → `pace_year` (year picker)
- Each year's records ship with the app as JSON in `res/raw/` (`d2017.json` … `d2022.json`)
- `Company` parses the JSON and renders the list with a `RecyclerView` + `CardView` adapter

## Build & run

**Requirements:** Android Studio, Android SDK 32 (min SDK 23, Java 8 source level).

1. Open the project in Android Studio.
2. Let Gradle sync.
3. Run on an emulator or a device with Android 6.0+.

## Project structure

```
app/src/main/java/com/example/vasttc/
  MainActivity.java      home screen
  pace_year.java         year selection
  Company.java           loads and lists placement records
  RecyclerAdapter.java   list adapter
  Data.java              record model
app/src/main/res/raw/    placement data per year (JSON)
```

## Related

[VidyaApp](https://github.com/safar-byte/VidyaApp) — the cross-platform React Native app for the same campus.

## Author

**Muhammed Safar** — [@safar-byte](https://github.com/safar-byte)
