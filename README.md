# Appium 2 Project Starting Guide

Welcome to the Appium 2 Project Starting Guide! This document will help you set up the essential tools and dependencies for your project, along with providing details about utilities available in the project.

## Requirements

To start working with Appium 2, make sure to have the following tools installed:

### 1. [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) <img src="https://upload.wikimedia.org/wikipedia/en/3/30/Java_programming_language_logo.svg" alt="Java" width="20" />
Ensure that Java is installed and configured in your environment.

### 2. [Android Studio](https://developer.android.com/studio) <img src="https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/android-studio-icon.png" alt="Android Studio" width="30" />
Install Android Studio for Android device emulation and SDK tools.

### 3. [Node.js](https://nodejs.org/) <img src="https://upload.wikimedia.org/wikipedia/commons/d/d9/Node.js_logo.svg" alt="Node.js" width="30" />
Download and install Node.js, required for running Appium.

### 4. [Appium Documentation](https://appium.io/docs/en/) <img src="https://appium.io/docs/en/latest/assets/images/appium-logo-horiz.png" alt="Appium" width="80" />
Refer to the official documentation to understand Appium's capabilities and features.

### 5. [Appium Inspector](https://github.com/appium/appium-inspector) <img src="https://raw.githubusercontent.com/appium/appium-inspector/main/docs/assets/images/icon.png" alt="Appium Inspector" width="40" />
Appium Inspector is a GUI tool for inspecting and interacting with elements of a mobile application.

### 6. [UiAutomator Framework](https://github.com/appium/appium-uiautomator2-driver) <img src="https://avatars.githubusercontent.com/u/3221291?s=48&v=4" alt="UiAutomator" width="30" />
UiAutomator is used for writing UI automation scripts in Android.

### 7. [UiScrollable Documentation]() <img src="https://www.gstatic.com/devrel-devsite/prod/vdf1c73ddfa29bc07c1524d67528b078b0717f3e7ffc0621bf09846cb55759e81/android/images/lockup.svg" alt="UiScrollable" width="70" />
UiScrollable is helpful for automating scroll actions in Android apps.

## Utilities Package

The project includes a utilities package to simplify common tasks. Here are the main utilities:

### 1. `JsonReader`
A utility class for reading and parsing JSON files.

### 2. `PropertyReader`
A utility class for reading properties from configuration files.

### 3. `Actions`
A custom actions class to handle interacting with elements, sendKeys, click, Scroll ...etc

## Getting Started

1. Clone the project repository.
   ```bash
   git clone <repository-url>
   ```
2. Install the required dependencies listed above.
3. Set up your environment variables for Java, Android SDK, and Node.js.
4. Start the Appium server and connect your device/emulator.
5. Run the tests using your preferred IDE or command-line tool.

---
