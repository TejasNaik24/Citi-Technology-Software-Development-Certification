# Citi-Technology-Software-Development-Certificate

My attempt at the Citi Technology Software Development Certificate.

This project includes a simple stock monitoring tool built in Java. It uses the Yahoo Finance API to get live updates of the Dow Jones Industrial Average every 5 seconds and displays the data in a live-updating line graph using JavaFX.

## What's in this repo

- Java application that fetches live DJIA stock prices
- Graph that updates every 5 seconds with new prices
- Data stored in a queue and displayed using JavaFX
- Built using Gradle

## How to run it
### Make sure you have Java 21 installed

```bash
./gradlew build
./gradlew run
