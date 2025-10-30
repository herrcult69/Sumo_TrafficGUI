# SUMO Traffic GUI - Project Structure

This document outlines the complete folder and file structure for the SUMO Traffic GUI application built with JavaFX and TraaS (TraCI as a Service).

## Project Overview

This is a JavaFX-based graphical user interface for controlling and visualizing SUMO (Simulation of Urban MObility) traffic simulations using the TraaS library for TraCI (Traffic Control Interface) communication.

## Directory Structure

```
Sumo_TrafficGUI/
├── pom.xml                             # Maven configuration file
├── README.md                           # Project README
├── PROJECT_STRUCTURE.md                # This file
├── LICENSE                             # Project license
├── .gitignore                          # Git ignore rules
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── sumo/
│   │   │           └── trafficgui/
│   │   │               ├── MainApplication.java          # Application entry point
│   │   │               │
│   │   │               ├── model/                        # Data models
│   │   │               │   ├── Vehicle.java              # Vehicle entity model
│   │   │               │   ├── TrafficLight.java         # Traffic light entity model
│   │   │               │   └── SimulationState.java      # Current simulation state
│   │   │               │
│   │   │               ├── controller/                   # JavaFX controllers
│   │   │               │   ├── MainController.java       # Main window controller
│   │   │               │   └── VisualizationController.java  # Simulation visualization
│   │   │               │
│   │   │               ├── service/                      # Business logic services
│   │   │               │   ├── SumoConnectionService.java    # SUMO TraCI connection
│   │   │               │   └── SimulationService.java        # Simulation management
│   │   │               │
│   │   │               ├── util/                         # Utility classes
│   │   │               │   └── ConfigLoader.java         # Configuration file loader
│   │   │               │
│   │   │               ├── config/                       # Configuration classes
│   │   │               │   └── AppConfig.java            # Application configuration
│   │   │               │
│   │   │               └── view/                         # Custom JavaFX components
│   │   │                   └── (Future custom components)
│   │   │
│   │   └── resources/
│   │       ├── fxml/                                     # FXML layout files
│   │       │   └── main-view.fxml                        # Main application view
│   │       │
│   │       ├── css/                                      # Stylesheets
│   │       │   └── styles.css                            # Main stylesheet
│   │       │
│   │       ├── images/                                   # Image resources
│   │       │   └── (Icons, logos, etc.)
│   │       │
│   │       ├── config/                                   # Configuration files
│   │       │   └── application.json                      # Application settings
│   │       │
│   │       ├── sumo/                                     # SUMO configuration files
│   │       │   ├── README.md                             # SUMO files documentation
│   │       │   ├── example.sumocfg                       # Example SUMO config
│   │       │   ├── example.net.xml                       # (Network file - to be added)
│   │       │   └── example.rou.xml                       # (Route file - to be added)
│   │       │
│   │       └── logback.xml                               # Logging configuration
│   │
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── sumo/
│       │           └── trafficgui/
│       │               ├── model/                        # Model tests
│       │               │   ├── VehicleTest.java
│       │               │   └── SimulationStateTest.java
│       │               │
│       │               ├── service/                      # Service tests
│       │               │   └── (Future test files)
│       │               │
│       │               ├── controller/                   # Controller tests
│       │               │   └── (Future test files)
│       │               │
│       │               └── util/                         # Utility tests
│       │                   └── (Future test files)
│       │
│       └── resources/
│           └── (Test configuration files)
│
├── logs/                                                 # Application logs (auto-generated)
│   └── application.log
│
└── target/                                               # Maven build output (auto-generated)
    └── (Compiled classes, packaged JAR, etc.)
```

## Package Structure

### `com.sumo.trafficgui`
Root package for the application.

### `com.sumo.trafficgui.model`
Contains data model classes representing entities in the simulation:
- **Vehicle**: Represents a vehicle with properties like speed, position, route
- **TrafficLight**: Represents a traffic light with state and phase information
- **SimulationState**: Contains the overall state of the simulation

### `com.sumo.trafficgui.controller`
JavaFX controller classes that handle user interactions:
- **MainController**: Controls the main application window and simulation control
- **VisualizationController**: Handles rendering of the simulation visualization

### `com.sumo.trafficgui.service`
Business logic and external service integrations:
- **SumoConnectionService**: Manages the TraCI connection to SUMO via TraaS
- **SimulationService**: Manages simulation execution and state updates

### `com.sumo.trafficgui.util`
Utility classes for common operations:
- **ConfigLoader**: Loads and parses configuration files

### `com.sumo.trafficgui.config`
Configuration management:
- **AppConfig**: Singleton for application configuration

### `com.sumo.trafficgui.view`
Custom JavaFX components (to be added as needed)

## Key Technologies

- **JavaFX 17**: UI framework
- **TraaS**: SUMO TraCI library for Java
- **Maven**: Build and dependency management
- **JUnit 5**: Testing framework
- **TestFX**: JavaFX testing library
- **Logback**: Logging framework
- **Gson**: JSON parsing

## Build and Run

### Prerequisites
- Java 11 or higher
- Maven 3.6+
- SUMO installed and accessible in PATH

### Build
```bash
mvn clean install
```

### Run
```bash
mvn javafx:run
```

### Test
```bash
mvn test
```

## Configuration

### Application Configuration
The main application configuration is located at:
`src/main/resources/config/application.json`

### SUMO Configuration
SUMO simulation configuration files should be placed in:
`src/main/resources/sumo/`

### Logging Configuration
Logging settings are configured in:
`src/main/resources/logback.xml`

## Development Guidelines

### Adding New Features

1. **Models**: Add new entity classes in `model/` package
2. **Controllers**: Add UI controllers in `controller/` package
3. **Services**: Add business logic in `service/` package
4. **Views**: Add FXML files in `resources/fxml/`
5. **Styles**: Update CSS in `resources/css/styles.css`
6. **Tests**: Add corresponding test files in `test/` directory

### Code Style

- Use meaningful variable and method names
- Follow Java naming conventions
- Add JavaDoc comments for public methods and classes
- Keep methods focused and small
- Use dependency injection where appropriate

### Testing

- Write unit tests for all model classes
- Write integration tests for services
- Use TestFX for UI testing
- Aim for high code coverage

## Future Enhancements

- Add support for multiple simulation scenarios
- Implement advanced visualization features
- Add real-time statistics and analytics
- Support for custom traffic control algorithms
- Export simulation data to various formats
- Multi-window support for detailed views
- Plugin system for extensibility

## Resources

- [SUMO Documentation](https://sumo.dlr.de/docs/)
- [TraaS Documentation](https://sumo.dlr.de/docs/TraCI/TraaS.html)
- [JavaFX Documentation](https://openjfx.io/)
- [Maven Documentation](https://maven.apache.org/)
