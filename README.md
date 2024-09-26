# BottomSheetButtonLibrary

A simple and customizable Android library that creates a bottom sheet dialog with positive and negative buttons. This library allows developers to easily prompt users with options while maintaining a clean and intuitive user interface.

## Features

- Easily create a bottom sheet dialog with a title, message, and buttons.
- Supports customizable button texts for positive and negative actions.
- Simple integration with any Android application.
- Lightweight and efficient.

## Getting Started

### Installation

To use this library in your project, add the following dependency to your `build.gradle` file:

```groovy
dependencies {
    implementation 'com.github.hardeepmonga:bottom_sheet:1.0.0'
}


### Usage

To create a Yes/No dialog using the `YesNoDialog.Builder`, follow the example below:

```kotlin
YesNoDialog.Builder(requireContext())
    .isCancellable(true) // Allows the dialog to be canceled
    .setTitleTxt(title) // Set the title of the dialog
    .setMessage(message) // Set the message of the dialog
    .setYesText(Positive Text) // Set the text for the Yes button
    .setNoText(Negative Text) // Set the text for the No button
    .setYesBackgroundColor(yourColor) // Replace with your desired color for the Yes button
    .setNoBorderColor(yourColor) // Replace with your desired border color for the No button
    .onPositiveClick {
        // Handle positive button action here
    }
    .onNegativeClick {
        // Handle negative button action here
    }
    .build() // Build and show the dialog

