# Real Dating App - Frontend

A Java-based frontend application for a real-time dating platform with MongoDB backend and socket.io integration.

## Prerequisites

- **Backend Setup Required**: Clone and set up the [backend repository](https://github.com/yehiamtheone/forrealdatingapp) first
- **Database**: MongoDB (Atlas cloud or local installation)
- **Media Storage**: Cloudinary account (optional, for image uploads)

## Quick Start

### Clone the Repository

This project uses multiple branches. Clone the frontend branch specifically:

```bash
git clone -b Frontend https://github.com/yehiamtheone/forrealdatingapp.git
cd forrealdatingapp
```

### Environment Configuration

Copy the `env.example` file and configure your environment variables:

- `EXPRESS_HOST`: Backend server URL (e.g., `localhost:3000`)
- `SOCKET_HOST`: Socket server host (e.g., `127.0.0.1`)
- `SOCKET_PORT`: Socket server port (e.g., `4000`)
- `CLOUDINARY_URL`: Cloudinary API URL (if using cloud media storage)

## Development Setup

### Local Development

1. **Clone and navigate to project directory**
   ```bash
   git clone -b Frontend https://github.com/yehiamtheone/forrealdatingapp.git
   cd forrealdatingapp
   ```

2. **Build the application**
   ```bash
   ./gradlew clean build
   ./gradlew downloadJre
   ./gradlew createExe
   ./gradlew zipLaunch4j
   ```

3. **Extract and run**
   - Navigate to `build/distribution/`
   - Extract `forrealdatingapp.zip`
   - Run the executable

4. **Set environment variables (Windows)**
   ```cmd
   setx EXPRESS_HOST "localhost:3000"
   setx SOCKET_HOST "127.0.0.1"
   setx SOCKET_PORT "4000"
   setx CLOUDINARY_URL "your_cloudinary_url_here"
   ```

## Jenkins CI/CD Pipeline

### Pipeline Configuration

1. **Jenkins Setup**
   - Access Jenkins on port 8080
   - Go to: Dashboard → Pipeline → Configure → Pipeline script from SCM
   - Set Repository URL to this repository
   - Configure branch specifier for the correct branch

2. **Node Configuration**
   - Navigate to: Manage Jenkins → Nodes
   - Create or configure existing node
   - Set label to `unix` for Unix-based builds

### Pipeline Files

#### Release Pipeline (`jenkins-file-for-release/Jenkinsfile`)

**Purpose**: Creates executable JAR and standalone Windows executable

**Requirements**: 
- Unix agent/container (labeled 'unix')
- Gradle build tool

**Stages**:
- **Checkout**: Verify Git repository access
- **Build**: Clean build using Gradle (`./gradlew clean build`)
- **Add Runtime**: Bundle JRE for standalone execution
- **Create EXE**: Generate executable using Launch4j (`./gradlew createExe`)
- **Create ZIP**: Bundle JRE with executable for distribution
- **Publish GitHub Release**: Upload distribution ZIP with auto-versioning

#### Setup Pipeline (`jenkins-file-for-setwin/Jenkinsfile`)

**Purpose**: Environment setup and automatic release download for Windows

**Features**:
- Injects environment variables automatically
- Downloads latest release to workspace
- Windows-specific setup commands

**Stages**:
- **Checkout**: Verify Git repository access
- **Add Environment Variables**: Configure Windows environment using `setx` commands
- **Download Latest Release**: Fetch the latest executable from GitHub releases

## Architecture Notes

### Technology Stack
- **Frontend**: Java with Gradle build system
- **Backend**: Express.js (Node.js)
- **Database**: MongoDB
- **Real-time Communication**: Socket.io
- **Media Storage**: Cloudinary (optional)
- **Build Tool**: Gradle with Launch4j plugin

### Port Configuration
- **Backend API**: Port 3000
- **Socket Server**: Port 4000
- **Jenkins**: Port 8080

### Platform Support
- **Windows**: Full support with standalone executable
- **macOS/Linux**: Manual runtime setup required (not packaged as standalone)

## Important Notes

- **Official App Limitation**: If running the official app without connection handling, manual environment configuration is required
- **Cloudinary Integration**: Follow the existing Cloudinary API implementation; do not substitute with different APIs
- **Database Instructions**: Refer to the backend branch for MongoDB setup and connection strings
- **Cross-Platform**: While Gradle supports dynamic runtime for macOS/Linux, standalone app packaging is Windows-only

## Troubleshooting

1. **Build Issues**: Ensure all environment variables are properly set
2. **Connection Problems**: Verify backend server is running on the specified port
3. **Database Errors**: Check MongoDB connection string in backend configuration
4. **Jenkins Failures**: Confirm the correct branch is specified and Unix agent is available

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## License

[Add your license information here]

## Support

For issues related to:
- **Backend Setup**: Check the backend branch documentation
- **Database Configuration**: Refer to MongoDB connection setup in backend
- **Jenkins Pipeline**: Ensure correct branch and agent configuration