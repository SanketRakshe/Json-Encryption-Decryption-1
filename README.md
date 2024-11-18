
# Encryption API

A Spring Boot-based REST API for encrypting and decrypting JSON data using RSA encryption. This project demonstrates the use of public-private key encryption to securely handle data.

## Features
- **Encryption**: Encrypt JSON data with a public key using RSA encryption.
- **Decryption**: Decrypt encoded data with a private key.
- **Key Generation**: Automatically generates a public-private key pair upon application startup.

## Project Structure

- `controller/EncryptionController`: REST API controller with endpoints for encryption and decryption.
- `service/EncryptionService`: Service layer implementing encryption and decryption using RSA with OAEP padding.
- `util/KeyUtil`: Utility class for generating and storing RSA key pairs.

## Getting Started

### Prerequisites

- **Java 17** (or a compatible version)
- **Maven** (for building the project)
- **Spring Boot** (used for REST API framework)

### Installation and Setup

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/encryption-api.git
   cd encryption-api
   ```

2. **Build the project**:
   Run the following command to build the project using Maven:
   ```bash
   mvn clean install
   ```

3. **Run the application**:
   Start the application by executing:
   ```bash
   mvn spring-boot:run
   ```

   The application will start on `http://localhost:8080`.

4. **Test the endpoints**:
   Use a REST client like [Postman](https://www.postman.com/) or [curl](https://curl.se/) to test the API endpoints.

### API Endpoints

- **Encrypt Data**  
  - **URL**: `/api/encrypt`
  - **Method**: `POST`
  - **Request Body**: JSON string
  - **Response**: Base64 encoded encrypted data
  
  Example:
  ```bash
  curl -X POST http://localhost:8080/api/encrypt -d "your JSON data"
  ```

- **Decrypt Data**  
  - **URL**: `/api/decrypt`
  - **Method**: `POST`
  - **Request Body**: Base64 encoded encrypted string
  - **Response**: Decrypted JSON data
  
  Example:
  ```bash
  curl -X POST http://localhost:8080/api/decrypt -d "your encrypted data"
  ```

### Example Usage

1. Encrypt JSON data:
   ```json
   POST /api/encrypt
   {
       "exampleKey": "exampleValue"
   }
   ```

   Response:
   ```
   "Base64EncodedEncryptedData"
   ```

2. Decrypt Base64 encrypted data:
   ```json
   POST /api/decrypt
   {
       "Base64EncodedEncryptedData"
   }
   ```

   Response:
   ```json
   {
       "exampleKey": "exampleValue"
   }
   ```

### Key Pair Information

The `KeyUtil` class generates a 2048-bit RSA key pair upon application startup. The public and private keys are printed to the console (this is for demonstration purposes; in production, use secure key management practices).

### Technologies Used

- **Java 17**
- **Spring Boot**
- **Maven**
- **RSA Encryption**

## Troubleshooting

- **Encryption/Decryption Errors**: Ensure the data format is correct and that the encryption data is in Base64 format before decrypting.
- **Key Generation Issues**: Verify that Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files are installed if needed.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---
