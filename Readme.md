# Docker Compose Setup Instructions

---
## Build Jar
use following command to build jar file
```
$ mvn package spring-boot:repackage
```

---
## Project Structure
Your project directory should look like this:
```
project/
 ├── Dockerfile
 ├── docker-compose.yml
 └── target/
      └── sprih-0.0.1-SNAPSHOT.jar
```
The JAR file must be inside the **target/** folder before building the Docker image.

---

## How to Run the Application
Navigate to the project folder:
```
$ cd project
```

### Build and run using Docker Compose
```
$ docker compose up --build
```
This will:
- Build the Docker image
- Start the container
- Expose the API on **http://localhost:8080**

### Run in background mode
```
$ docker compose up --build -d
```

---

## API Endpoint
Once running, the main API endpoint is:
```
POST http://localhost:8080/api/events
```

Example Request:
```json
{
  "eventType": "EMAIL",
  "payload": {
    "recipient": "test@example.com",
    "message": "Hello World"
  },
  "callbackUrl": "http://localhost:9000/callback"
}
```

