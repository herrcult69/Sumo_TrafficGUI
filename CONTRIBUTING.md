# Contributing to SUMO Traffic GUI

Thank you for considering contributing to SUMO Traffic GUI! This document provides guidelines and instructions for contributing to the project.

## Code of Conduct

- Be respectful and inclusive
- Focus on constructive feedback
- Help others learn and grow
- Maintain a professional environment

## How to Contribute

### Reporting Bugs

If you find a bug, please create an issue with:
- Clear description of the problem
- Steps to reproduce
- Expected vs actual behavior
- Environment details (OS, Java version, SUMO version)
- Screenshots if applicable

### Suggesting Features

For feature requests, please:
- Check if the feature already exists or is planned
- Provide a clear use case
- Explain the expected behavior
- Consider implementation complexity

### Pull Requests

1. **Fork the repository**
2. **Create a feature branch**
   ```bash
   git checkout -b feature/your-feature-name
   ```

3. **Make your changes**
   - Follow the existing code style
   - Add tests for new functionality
   - Update documentation as needed
   - Ensure all tests pass

4. **Commit your changes**
   ```bash
   git commit -m "Add feature: description"
   ```
   - Use clear, descriptive commit messages
   - Reference issues when applicable (#123)

5. **Push to your fork**
   ```bash
   git push origin feature/your-feature-name
   ```

6. **Create a Pull Request**
   - Provide a clear description
   - Reference related issues
   - Explain what was changed and why

## Development Guidelines

### Code Style

- Follow Java naming conventions
- Use meaningful variable and method names
- Keep methods focused and concise
- Add JavaDoc comments for public APIs
- Maintain consistent indentation (4 spaces)

### Package Organization

- `model/`: Data models and entities
- `controller/`: JavaFX controllers
- `service/`: Business logic and integrations
- `util/`: Utility and helper classes
- `config/`: Configuration management

### Testing

- Write unit tests for all new features
- Maintain or improve code coverage
- Use descriptive test names
- Test edge cases and error conditions

### Documentation

- Update README.md for major changes
- Add JavaDoc for public methods
- Update PROJECT_STRUCTURE.md if adding new components
- Include inline comments for complex logic

## Building and Testing

### Build the project
```bash
mvn clean install
```

### Run tests
```bash
mvn test
```

### Run the application
```bash
mvn javafx:run
```

### Check code coverage
```bash
mvn jacoco:report
```

## Project Structure

Refer to [PROJECT_STRUCTURE.md](PROJECT_STRUCTURE.md) for detailed information about the project organization.

## Questions?

Feel free to open an issue for:
- Clarification on contribution guidelines
- Help with development setup
- Discussion of implementation approaches
- General questions about the project

## License

By contributing, you agree that your contributions will be licensed under the same license as the project.

Thank you for contributing! 🚗🚦
