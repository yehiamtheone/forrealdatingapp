# Environment Variables Configuration and important notes

## Branches
- [`frontend`](https://github.com/yehiamtheone/forrealdatingapp/tree/Frontend): Contains JavaFX code  
- [`backend`](https://github.com/yehiamtheone/forrealdatingapp/tree/Backend): Contains Node.js/API code  
- `main`: Environment Variables Configuration and important notes

This document outlines the environment variables required for different deployment scenarios and application components.

## Docker Compose / System Variables

For Docker Compose deployments or system-wide configuration:

```bash
EXPRESS=http://<ip>:<port>/
TCP=<ip>:<port>
CLOUDINARY_URL=cloudinary://<your_api_key>:<your_api_secret>@<your_cloud_name>
TOKEN_SECRET=<any_string>
MONGO_URL=<mongodb://localhost:27017/ || mongodb+srv://<username>:<password>@cluster0.eyhd9.mongodb.net/>
GMAIL_SMTP_EMAIL=<your_email>
GMAIL_SMTP_PASS=<your_api_password_from_google_account_settings>
```

## Backend Environment (.env)

For backend-only configuration:

```bash
EXPRESS=http://<ip>:<port>/
TCP=<ip>:<port>
TOKEN_SECRET=<any_string>
MONGO_URL=<mongodb://localhost:27017/ || mongodb+srv://<username>:<password>@cluster0.eyhd9.mongodb.net/>
GMAIL_SMTP_EMAIL=<your_email>
GMAIL_SMTP_PASS=<your_api_password_from_google_account_settings>
```

## Frontend Environment (.env)

For frontend-only configuration:

```bash
EXPRESS=http://<ip>:<port>/
TCP=<ip>:<port>
CLOUDINARY_URL=cloudinary://<your_api_key>:<your_api_secret>@<your_cloud_name>

```

## Environment Variables Reference

### Core Configuration
- `EXPRESS`: HTTP server endpoint URL (e.g., `http://127.0.0.1:3000/`)
- `TCP`: TCP server endpoint for socket connections (e.g., `127.0.0.1:4000`)
- `TOKEN_SECRET`: Secret key for JWT token generation and validation (use any secure random string)

### Database Configuration
- `MONGO_URL`: MongoDB connection string
  - Local: `mongodb://localhost:27017/`
  - Atlas: `mongodb+srv://<username>:<password>@cluster0.eyhd9.mongodb.net/`

### File Upload Configuration
- `CLOUDINARY_URL`: Cloudinary service URL for image/file uploads
  - Format: `cloudinary://<your_api_key>:<your_api_secret>@<your_cloud_name>`

### Email Configuration
- `GMAIL_SMTP_EMAIL`: Gmail address for SMTP email sending
- `GMAIL_SMTP_PASS`: App-specific password from Google Account settings (not your regular Gmail password)

## Notes

- Replace all placeholder values (`<>`) with your actual configuration values
- For `GMAIL_SMTP_PASS`, use an App Password generated from your Google Account security settings, not your regular password
- The `TOKEN_SECRET` should be a long, random string for security purposes
- MongoDB URL format depends on whether you're using a local instance or MongoDB Atlas cloud service
- For deployment web servers like render etc the backend ip interface will be selected automatically by the service, for custom domains its better go by the dotenv configuration 