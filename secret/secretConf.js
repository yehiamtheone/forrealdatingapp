const dotenv = require('dotenv');
dotenv.config();

module.exports = {
    EXPRESS_PORT : process.env.EXPRESS_PORT,
    TOKEN_STRING: process.env.TOKEN_STRING,
    SOCKET_PORT: process.env.SOCKET_PORT,
    MONGO_URL: process.env.MONGO_URL,
    GMAIL_SMTP_EMAIL: process.env.GMAIL_SMTP_EMAIL,
    GMAIL_SMTP_PASS: process.env.GMAIL_SMTP_PASS

}
