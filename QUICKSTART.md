# Quick Start Guide

## Getting Started with SUMO Traffic GUI

This guide will help you get the SUMO Traffic GUI up and running quickly.

## Prerequisites Checklist

- [ ] Java 11 or higher installed
- [ ] Maven 3.6+ installed
- [ ] SUMO traffic simulator installed (optional for initial setup)

Check your Java version:
```bash
java -version
```

Check your Maven version:
```bash
mvn -version
```

## Installation Steps

### 1. Clone the Repository

```bash
git clone https://github.com/herrcult69/Sumo_TrafficGUI.git
cd Sumo_TrafficGUI
```

### 2. Build the Project

```bash
mvn clean install
```

This will:
- Download all dependencies
- Compile the source code
- Run tests
- Package the application

### 3. (Optional) Install TraaS Library

The TraaS library is required for actual SUMO integration. For initial project setup, this is optional.

See [DEPENDENCIES.md](DEPENDENCIES.md) for detailed TraaS installation instructions.

## Running the Application

### Development Mode

```bash
mvn javafx:run
```

This starts the application in development mode with hot-reload capabilities.

### Production Mode

After building with `mvn clean package`, run:

```bash
java -jar target/sumo-traffic-gui-1.0.0-SNAPSHOT.jar
```

## Project Structure Overview

```
Sumo_TrafficGUI/
├── src/main/java/           # Java source files
│   └── com/sumo/trafficgui/
│       ├── model/           # Data models (Vehicle, TrafficLight, etc.)
│       ├── controller/      # UI controllers
│       ├── service/         # Business logic
│       └── util/            # Utilities
├── src/main/resources/      # Resources
│   ├── fxml/               # UI layouts
│   ├── css/                # Stylesheets
│   ├── config/             # Configuration
│   └── sumo/               # SUMO files
└── src/test/               # Tests
```

## Testing the Application

Run all tests:
```bash
mvn test
```

Run specific test class:
```bash
mvn test -Dtest=VehicleTest
```

## Current Status

✅ **Working:**
- Project structure and build system
- Model classes (Vehicle, TrafficLight, SimulationState)
- UI layout and styling
- Service architecture
- Unit tests

⚠️ **In Progress:**
- TraaS integration (requires library installation)
- SUMO connection functionality
- Real-time visualization

## Next Steps

1. **Install TraaS** (optional):
   - Follow instructions in [DEPENDENCIES.md](DEPENDENCIES.md)
   - Uncomment TraaS dependency in `pom.xml`
   - Uncomment TraaS code in service classes

2. **Create SUMO Network**:
   - Use NETEDIT or NETCONVERT to create network files
   - Place `.net.xml` and `.rou.xml` files in `src/main/resources/sumo/`
   - Create or modify `.sumocfg` configuration file

3. **Customize the UI**:
   - Edit `src/main/resources/fxml/main-view.fxml` for layout changes
   - Edit `src/main/resources/css/styles.css` for styling
   - Modify controllers in `src/main/java/com/sumo/trafficgui/controller/`

4. **Add Features**:
   - Implement custom traffic algorithms
   - Add data visualization components
   - Create export/import functionality

## Troubleshooting

### Build Fails

**Problem**: Maven cannot resolve dependencies

**Solution**: 
```bash
mvn clean install -U
```
The `-U` flag forces update of dependencies.

### JavaFX Not Found

**Problem**: JavaFX runtime components missing

**Solution**: Always run with Maven:
```bash
mvn javafx:run
```

### SUMO Not Connected

**Problem**: Application can't connect to SUMO

**Solution**: 
1. Ensure SUMO is installed and in PATH
2. Check the executable path in the UI
3. Verify the configuration file path is correct
4. See [DEPENDENCIES.md](DEPENDENCIES.md) for TraaS setup

## Documentation

- [README.md](README.md) - Main project documentation
- [PROJECT_STRUCTURE.md](PROJECT_STRUCTURE.md) - Detailed structure guide
- [DEPENDENCIES.md](DEPENDENCIES.md) - Dependency management
- [CONTRIBUTING.md](CONTRIBUTING.md) - Contribution guidelines

## Getting Help

- Check existing documentation files
- Review code comments and JavaDoc
- Open an issue on GitHub
- Check SUMO documentation: https://sumo.dlr.de/docs/

## Sample Workflow

Here's a typical development workflow:

1. Make code changes
2. Build and test:
   ```bash
   mvn clean test
   ```
3. Run the application:
   ```bash
   mvn javafx:run
   ```
4. Commit changes:
   ```bash
   git add .
   git commit -m "Description of changes"
   git push
   ```

## Tips

- Use an IDE like IntelliJ IDEA or Eclipse for better development experience
- Enable auto-import in your IDE for faster development
- Use the Maven wrapper (`./mvnw`) if you don't have Maven installed globally
- Check the logs in `logs/application.log` for debugging

---

**Ready to start?** Run `mvn javafx:run` and explore the application!
