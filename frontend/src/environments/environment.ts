import dotenv from "dotenv"

dotenv.config();

export const environment = {
  production: false,
  apiUrl: process.env['API_URL'] || 'www.localhost:8080',
};
 