# Real Dating App - Frontend

A Java-based frontend application for a real-time dating platform with MongoDB backend and socket integration.

## Prerequisites

- **Backend Setup Required**: Clone and set up the [backend branch](https://github.com/yehiamtheone/forrealdatingapp/tree/Backend) first

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
- `Express`:Making requests to the backend api (e.g., `http://127.0.0.1:3000`)

- `TCP`: Socket server host and port (e.g., `127.0.0.1:4000`)

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
   *or for a preview before creating the executable run those commands instead:*
   ```bash
      ./gradlew clean build
      ./gradlew run
   ```

3. **Extract and run**
   - Navigate to `build/distribution/`
   - Extract `forrealdatingapp.zip`
   - Run the executable

4. **Set environment variables (Windows)**
   ```bat
   setx EXPRESS "http://127.0.0.1:3000"
   setx TCP "127.0.0.1:4000"
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

