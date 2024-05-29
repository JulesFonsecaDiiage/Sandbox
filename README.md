# Exam Android Project

This project is an Android application developed using Kotlin. It follows the MVVM (Model-View-ViewModel) architecture pattern and uses Gradle for the build.

## Project Architecture

The project is structured into several packages, each with a specific purpose:

- `ui`: This package contains all the UI components of the application, including screens and custom composables. It's also includes the viewmodels that contains the logic of the screen. It is divided into sub-packages based on the screens.

- `data`: This package contains classes related to data handling, such as repositories and data sources.

- `domain`: This package contains the data schemes, such as models and interfaces for the repositories.

The project also have the `res` directory, which contains all the resources of the application, such as layouts, strings, images, sounds.

## Code Organization and Naming

The code in this project is organized and named following best practices:

- Classes and functions are named in a way to indicates their purpose.

- Code is grouped into packages and classes based on their functionality.

- Comments are added to the code to explain what it does.