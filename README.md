# Real Dating App - Backend

A JavaScript-based backend application for a real-time dating platform with MongoDB database, Express-js backend and socket integration.

## Prerequisites

- **Frontend Setup Required**: Clone and set up the [frontend branch](https://github.com/yehiamtheone/forrealdatingapp/tree/Frontend) first

- **Database**: MongoDB (Atlas cloud or local installation)


This project uses multiple branches. Clone the backend branch specifically:

```bash
git clone -b Backend https://github.com/yehiamtheone/forrealdatingapp.git
cd forrealdatingapp
```

### Environment Configuration

Copy the `env.example` file and configure your environment variables:

- `EXPRESS`: Backend server URL (e.g., `http://localhost:3000`)

- `MONGO_URL`: Atlas url from mongo atlas or localhost usually on PORT 27017
if used locally.   
 
- `TOKEN_SECRET`: for jwt token authentications

- `GMAIL_SMTP_EMAIL`: Gmail address for SMTP email sending

- `GMAIL_SMTP_PASS`: App-specific password from Google Account settings (not your regular Gmail password)

- `TCP`: For real time socket connection

## Development Setup

### Local Development

1. **Clone and navigate to project directory**
   ```bash
   git clone -b Backend https://github.com/yehiamtheone/forrealdatingapp.git
   cd forrealdatingapp
   ```
2. **Build the application**
   ```bash
   npm ci
   npm start
   
   ```
3. **Set environment variables (Windows)**
   ```bat
   setx EXPRESS "e.g., http:localhost:3000"
   setx TCP "e.g., http:localhost:3000"\
   setx TOKEN_SECRET "any_string"
   setx CLOUDINARY_URL "your_cloudinary_url_here"
   setx MONGO_URL "atlas srv domain or local domain"
   setx GMAIL_SMTP_EMAIL "your_email"
   setx GMAIL_SMTP_PASS "your_password"
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
**Jenkinsfile**: projectRoot/Jenkinsfile

**Purpose**: Upload the server and make it ready to handle api requests and tcp requests.

**Requirements**: 
- could be Unix or windows agent/container (labeled 'unix || win could be either one or both of them')
- Node (reccomended @11+)

**Stages**:
- **Checkout**: Verify Git repository access
- **Add Env File**: creating .env file
with values that injected from jenkins credentials
could be set through http://your-domain:8080/ in Dashboard -> Mange jenkins -> credintales -> Stores scoped to Jenkins -> System -> Global credentials (unrestricted) -> Add Credentials -> kind Secret text
- **Upload Server**: use command 
```sh
npm ci
```
and for make the jenkins stages go through and not stuck as the server up 
use
```sh
nohup npm start &
```
gurantee to work on unix with nohup (windows might struggle with this).


