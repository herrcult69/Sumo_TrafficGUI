# Dependencies Guide

## Overview

This document provides information about project dependencies and how to obtain them.

## Core Dependencies

All standard dependencies are automatically managed by Maven and downloaded from Maven Central:

- **JavaFX 17**: UI framework
- **JUnit 5**: Testing framework
- **Logback/SLF4J**: Logging
- **Gson**: JSON parsing
- **TestFX**: JavaFX testing

## TraaS (TraCI as a Service) Dependency

### Important Note

The TraaS library for SUMO integration may not be available in Maven Central. You have several options:

### Option 1: Download TraaS JAR (Recommended)

1. Download TraaS from the SUMO distribution:
   - Visit: https://sumo.dlr.de/docs/TraCI/TraaS.html
   - TraaS is typically included in SUMO installations at: `$SUMO_HOME/tools/traas/`

2. Install to local Maven repository:
   ```bash
   mvn install:install-file \
     -Dfile=path/to/traas.jar \
     -DgroupId=de.tudresden.sumo \
     -DartifactId=traas \
     -Dversion=1.15.0 \
     -Dpackaging=jar
   ```

### Option 2: Use System Scope in POM

If you prefer not to install to local Maven repo, you can reference the JAR directly:

```xml
<dependency>
    <groupId>de.tudresden.sumo</groupId>
    <artifactId>traas</artifactId>
    <version>1.15.0</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/lib/traas.jar</systemPath>
</dependency>
```

Then place the TraaS JAR in a `lib/` directory in your project root.

### Option 3: Alternative TraCI Libraries

Consider these alternatives if TraaS is unavailable:

1. **SumoWebAPI**: REST API approach
2. **Python + Jython**: Use SUMO's Python TraCI with Jython
3. **Direct TraCI Socket**: Implement TraCI protocol directly (advanced)

## Building Without TraaS

To build the project without TraaS for development:

1. Comment out the TraaS dependency in `pom.xml`:
   ```xml
   <!-- Temporarily disabled
   <dependency>
       <groupId>de.tudresden.sumo</groupId>
       <artifactId>traas</artifactId>
       <version>1.15.0</version>
   </dependency>
   -->
   ```

2. Comment out or mock the TraaS-related code:
   - `SumoConnectionService.java`
   - `SimulationService.java` (TraaS-specific parts)

3. Build and test the UI independently:
   ```bash
   mvn clean compile
   ```

## Verifying Dependencies

### Check all dependencies
```bash
mvn dependency:tree
```

### Download all dependencies
```bash
mvn dependency:resolve
```

### Check for updates
```bash
mvn versions:display-dependency-updates
```

## Troubleshooting

### Issue: "Cannot resolve dependency: traas"

**Solution**: Follow one of the TraaS installation options above.

### Issue: "JavaFX runtime components are missing"

**Solution**: Ensure you're using Java 11+ and running with Maven:
```bash
mvn javafx:run
```

### Issue: "Package javax.xml.ws does not exist"

**Solution**: Add JAXB dependencies if using Java 11+:
```xml
<dependency>
    <groupId>javax.xml.ws</groupId>
    <artifactId>jaxws-api</artifactId>
    <version>2.3.1</version>
</dependency>
```

## Dependency Versions

Current versions used in this project:

| Dependency | Version | Purpose |
|-----------|---------|---------|
| JavaFX | 17.0.2 | UI Framework |
| TraaS | 1.15.0 | SUMO Integration |
| JUnit | 5.9.1 | Testing |
| TestFX | 4.0.16-alpha | JavaFX Testing |
| Logback | 1.4.5 | Logging |
| SLF4J | 2.0.5 | Logging API |
| Gson | 2.10 | JSON Parsing |

## Updating Dependencies

To update to newer versions:

1. Edit version properties in `pom.xml`:
   ```xml
   <properties>
       <javafx.version>17.0.2</javafx.version>
       <junit.version>5.9.1</junit.version>
   </properties>
   ```

2. Rebuild the project:
   ```bash
   mvn clean install
   ```

3. Test thoroughly after updates

## Additional Resources

- [Maven Dependency Plugin](https://maven.apache.org/plugins/maven-dependency-plugin/)
- [SUMO TraaS Documentation](https://sumo.dlr.de/docs/TraCI/TraaS.html)
- [JavaFX Maven Plugin](https://github.com/openjfx/javafx-maven-plugin)
