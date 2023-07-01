# Random Star Wars Character App
This app is part of a coding challenge for a job interview.

## Task/Scope
The task at hand was:
Please implement a Star Wars themed Android App using state-of-the-art architecture and technologies. The App should connect to one or multiple APIs like https://swapi.dev/ and display the retrieved data.
Please do not invest more than 4-6 hours on this. Also, keep the UI design effort to a minimum. If you need to cut anything from the implementation or make any assumptions due to time constraints, please make a note and let us know later when presenting your solution to us. Treat this as a showcase for your working style and as a chance to show off your skills as a developer. Of course you don’t have to overdo it. In the end, we know that you have to work on it next to your daily life. A pragmatic solution is perfectly fine. Should you hit a roadblock don’t hesitate to ask us. Please commit your code to a public github repository and provide us with the link.

## Solution
The app uses the "SWAPI" to retrieve data about a random Star Wars character.

The architecture is based on clean architecture, using a domain layer, a data layer and a presentation layer. The domain layer contains the business logic, the data layer contains the repository and the presentation layer contains the UI.

The single components are connected via dependency injection using Dagger Hilt.

Next possible steps would be:
* Add unit tests (the components have been designed to be testable in isolation)
* Add details about the character (e.g. homeworld, species, etc.)
* Cache the data (e.g. using Room) to avoid unnecessary network requests
* Polish the UI