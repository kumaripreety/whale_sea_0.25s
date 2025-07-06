# Text Analysis V2

A Spring Boot application that analyzes text files and finds word statistics.

## What it does?

- Upload a text file
- Get total word count
- Find top 5 most used words
- Get list of top 50 unique words
- Removes common words like "the", "and", "is" etc.


## How to run?

1. Make sure you have Java 17 installed
2. Open terminal in the project folder
3. Run: `./mvnw spring-boot:run`
4. Application starts at: `http://localhost:8080`

## How to use?

### Using the API:

Send a POST request to: `http://localhost:8080/api/v2/text/analyze`

**Request:**
- Method: POST
- Content-Type: multipart/form-data
- Parameter: file (your text file)

**Response:**
```json
{
  "totalWordCount": 150,
  "topWords": {
    "java": 15,
    "spring": 12,
    "boot": 10
  },
  "uniqueWords": [
    "application",
    "boot",
    "java",
    "spring"
  ]
}
```


## API Documentation

Once running, visit: `http://localhost:8080/swagger-ui.html`
<img width="1024" alt="TextAnalysisV2_API_Screenshot" src="https://github.com/user-attachments/assets/b156a6d3-9893-4c91-889e-b69bff17a2d0" />

## File limits

- Maximum file size: 10MB
- Supported formats: Text files (.txt)

## Testing

Run tests with: `./mvnw test`

## Build

Create JAR file: `./mvnw clean package`

Run JAR: `java -jar target/textAnalysisV2-0.0.1-SNAPSHOT.jar`

## Time Spent: ~2 hours
- Problem Statement: 1/4 hours
- Devising Solution: 1/4 hours
- Code for Core Logic: 1 hours
- Testing, Test Cases, Documentation: 1/2 hours


  
