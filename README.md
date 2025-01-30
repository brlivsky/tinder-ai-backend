# Tinder AI Backend

This is the backend service for the Tinder AI project, which enables AI-powered interactions for the Tinder platform. It is developed as part of a "Code with Me" series by [JavaBrains](https://www.youtube.com/watch?v=k3fSQpz2Esg).

## Frontend Repository

The frontend for this project is available at: [Tinder AI Frontend](https://github.com/koushikkothagal/tinder-ai-frontend)

## Features

- AI-powered profile recommendations
- Simple backend APIs for Tinder AI frontend

## Tech Stack

- **Language:** Java (Spring Boot)
- **AI Integration:** Spring AI with Ollama (Llama 3)
- **AI Model:** Ollama (Llama3)
- **Database:** MongoDB

## Installation and Setup

### Prerequisites

- Java 17+
- Docker (for MongoDB and Ollama AI service)

### Steps to Run Locally

1. Clone the repository:

    ```bash
    git clone https://github.com/brlivsky/tinder-ai-backend.git
    cd tinder-ai-backend
    ```

2. Start required services using Docker Compose:

    ```bash
    docker-compose up -d
    ```

    This starts:
    - MongoDB on port `27017`
    - Ollama AI service on port `11434`

3. Build and run the application:

    ```bash
    ./mvnw spring-boot:run
    ```

4. The backend should now be running at `http://localhost:8080`

## API Endpoints

### Conversation Endpoints

| Method | Endpoint                       | Description                      |
|--------|--------------------------------|----------------------------------|
| POST   | `/conversations`               | Create a new conversation        |
| POST   | `/conversations/{conversationId}` | Add message to a conversation    |
| GET    | `/conversations/{conversationId}` | Get a conversation by ID         |

### Match Endpoints

| Method | Endpoint           | Description         |
|--------|--------------------|---------------------|
| POST   | `/matches`         | Create a new match  |
| GET    | `/matches`         | Fetch all matches   |

### Profile Endpoints

| Method | Endpoint           | Description         |
|--------|--------------------|---------------------|
| GET    | `/profiles/random` | Get a random profile|

## Configuration

The application uses the following configuration properties from `application.properties`:

```properties
spring.application.name=tinder-ai-backend

spring.ai.ollama.base-url=http://localhost:11434
spring.ai.ollama.chat.options.model=llama3

startup-actions.initializeProfiles=true
tinderai.lookingForGender=woman

# User's profile
tinderai.character.user={id:'user', firstName:'Donald', lastName:'Trump', age:78, ethnicity:'American', gender:'MALE', bio:'The president of USA and I love to hook up with Russians', imageUrl:'', myersBriggsPersonalityType:'ESFJ'}
```

## Project Structure
└── tinder-ai-backend\
    ├── compose.yaml\
    ├── HELP.md\
    ├── Instructions.pdf\
    ├── mvnw\
    ├── mvnw.cmd\
    ├── Notes.txt\
    ├── pom.xml\
    ├── profiles.json\
    ├── src\
    │   ├── main\
    │   │   ├── java\
    │   │   │   └── io\
    │   │   │       └── javabrains\
    │   │   │           └── tinder_ai_backend\
    │   │   │               ├── conversations\
    │   │   │               │   ├── ChatMessage.java\
    │   │   │               │   ├── ConversationController.java\
    │   │   │               │   ├── Conversation.java\
    │   │   │               │   ├── ConversationRepository.java\
    │   │   │               │   └── ConversationService.java\
    │   │   │               ├── matches\
    │   │   │               │   ├── MatchController.java\
    │   │   │               │   ├── Match.java\
    │   │   │               │   └── MatchRepository.java\
    │   │   │               ├── profiles\
    │   │   │               │   ├── Gender.java\
    │   │   │               │   ├── ProfileController.java\
    │   │   │               │   ├── ProfileCreationService.java\
    │   │   │               │   ├── Profile.java\
    │   │   │               │   └── ProfileRepository.java\
    │   │   │               ├── TinderAiBackendApplication.java\
    │   │   │               └── Utils.java\
    │   │   └── resources\
    │   │       ├── application.properties\
    │   │       ├── static\
    │   │       │   └── images

## Screenshot

![front-end-collage](https://github.com/user-attachments/assets/13c470bb-b873-44c0-8358-4727bf865c71)

    
