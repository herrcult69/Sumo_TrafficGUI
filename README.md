# SUMO Traffic GUI

An interactive graphical user interface for SUMO (Simulation of Urban MObility) traffic simulations built with JavaFX and TraaS (TraCI as a Service).

## Overview

This application provides a user-friendly interface to:
- Connect to and control SUMO simulations via TraCI
- Visualize traffic simulations in real-time
- Monitor vehicle movements and traffic conditions
- Configure simulation parameters
- Interact with the simulation dynamically

## Features

- ✅ JavaFX-based modern user interface
- ✅ Integration with SUMO via TraaS library
- ✅ Real-time simulation control (start, pause, stop)
- ✅ Vehicle tracking and monitoring
- ✅ Traffic light state visualization
- ✅ Customizable simulation settings
- ✅ Extensible architecture for future enhancements

## Project Structure

For a detailed overview of the project structure, see [PROJECT_STRUCTURE.md](PROJECT_STRUCTURE.md).

```
Sumo_TrafficGUI/
├── src/
│   ├── main/
│   │   ├── java/com/sumo/trafficgui/
│   │   │   ├── MainApplication.java        # Application entry point
│   │   │   ├── model/                      # Data models
│   │   │   ├── controller/                 # JavaFX controllers
│   │   │   ├── service/                    # Business logic
│   │   │   ├── util/                       # Utilities
│   │   │   └── config/                     # Configuration
│   │   └── resources/
│   │       ├── fxml/                       # UI layouts
│   │       ├── css/                        # Stylesheets
│   │       ├── config/                     # Configuration files
│   │       └── sumo/                       # SUMO simulation files
│   └── test/                               # Unit and integration tests
└── pom.xml                                 # Maven configuration
```

## Prerequisites

- **Java 11** or higher
- **Maven 3.6+**
- **SUMO** traffic simulation software installed
  - Download from: https://sumo.dlr.de/docs/Downloads.php
  - Ensure `sumo` or `sumo-gui` is accessible in your PATH

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/herrcult69/Sumo_TrafficGUI.git
   cd Sumo_TrafficGUI
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

## Usage

### Running the Application

```bash
mvn javafx:run
```

### Using the GUI

1. **Connect to SUMO**:
   - Enter the path to SUMO executable (e.g., `/usr/bin/sumo` or `sumo-gui`)
   - Enter the path to your SUMO configuration file (.sumocfg)
   - Click "Connect to SUMO"

2. **Control Simulation**:
   - Click "Start" to begin the simulation
   - Click "Pause/Resume" to pause or resume execution
   - Click "Stop" to end the simulation

3. **Monitor**:
   - View real-time simulation statistics
   - Track active vehicles in the list
   - Observe the visualization canvas

## Configuration

### Application Settings

Edit `src/main/resources/config/application.json` to customize:
- SUMO executable path
- Default simulation parameters
- Visualization settings
- Logging preferences

### SUMO Configuration

Place your SUMO network and route files in `src/main/resources/sumo/` or reference external files via the GUI.

Example SUMO configuration structure:
```xml
<configuration>
    <input>
        <net-file value="network.net.xml"/>
        <route-files value="routes.rou.xml"/>
    </input>
    <time>
        <begin value="0"/>
        <end value="1000"/>
    </time>
</configuration>
```

## Development

### Running Tests

```bash
mvn test
```

### Building Distribution

```bash
mvn package
```

This creates an executable JAR in the `target/` directory.

### Adding Features

1. **Models**: Add entity classes in `com.sumo.trafficgui.model`
2. **Controllers**: Add UI controllers in `com.sumo.trafficgui.controller`
3. **Services**: Add business logic in `com.sumo.trafficgui.service`
4. **Views**: Add FXML files in `resources/fxml/`
5. **Tests**: Add corresponding tests in `src/test/`

## Technologies Used

- **JavaFX 17**: Modern UI framework for Java applications
- **TraaS**: SUMO's TraCI (Traffic Control Interface) library for Java
- **Maven**: Build automation and dependency management
- **JUnit 5**: Unit testing framework
- **TestFX**: JavaFX application testing
- **Logback/SLF4J**: Logging framework
- **Gson**: JSON parsing and serialization

## Architecture

The application follows a layered architecture:

- **Presentation Layer** (JavaFX Controllers + FXML)
- **Service Layer** (Business logic and SUMO integration)
- **Data Layer** (Models and state management)

Key design patterns:
- MVC (Model-View-Controller)
- Singleton (for configuration)
- Service layer for business logic separation

## Contributing

Contributions are welcome! Please:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## Troubleshooting

### Common Issues

**Issue**: "Cannot find SUMO executable"
- Solution: Ensure SUMO is installed and the path is correct

**Issue**: "Connection to SUMO failed"
- Solution: Check that the configuration file path is valid and contains proper SUMO configuration

**Issue**: "JavaFX components not found"
- Solution: Run `mvn clean install` to ensure all dependencies are downloaded

## License

This project is licensed under the terms specified in the [LICENSE](LICENSE) file.

## Resources

- [SUMO Documentation](https://sumo.dlr.de/docs/)
- [TraaS Documentation](https://sumo.dlr.de/docs/TraCI/TraaS.html)
- [JavaFX Documentation](https://openjfx.io/)
- [Project Structure Guide](PROJECT_STRUCTURE.md)

## Contact

For questions or support, please open an issue on GitHub.

---

**Note**: This is an initial project structure. The application is designed to be extensible and can be enhanced with additional features such as advanced visualization, statistics, and custom traffic control algorithms.
