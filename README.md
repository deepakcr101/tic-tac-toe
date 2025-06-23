# 🎮 Tic-Tac-Toe Web Application

A complete, animated Tic-Tac-Toe game built with **Spring Boot** backend and **HTML/CSS/JavaScript** frontend.

## ✨ Features

### 🔙 Backend (Spring Boot)
- RESTful API endpoints for game management
- In-memory game state storage
- Move validation and game logic
- Winner detection and draw handling
- Multiple concurrent games support

### 🖥️ Frontend (Web UI)
- Interactive 3x3 grid with click events
- Smooth CSS animations for X/O placement
- Winning line highlighting with animations
- Player symbol selection (X or O)
- Score tracking across games
- Basic AI opponent (random moves)
- Sound effects for moves and game events
- Responsive design with glassmorphism UI

### 🎯 Game Features
- Player vs AI gameplay
- Score tracking (wins/draws)
- New game and reset functionality
- Real-time game state updates
- Move validation and error handling

## 🚀 Quick Start

### Prerequisites
- **Java 17** or higher
- **Maven 3.6+** 

### 📁 Project Structure
```
tic-tac-toe-game/
├── src/
│   └── main/
│       ├── java/com/tictactoe/
│       │   ├── TicTacToeApplication.java
│       │   ├── controller/
│       │   │   └── GameController.java
│       │   └── model/
│       │       └── Game.java
│       └── resources/
│           ├── static/
│           │   └── index.html
│           └── application.properties
└── pom.xml
```

### 🛠️ Installation & Setup

1. **Create the project directory:**
```bash
mkdir tic-tac-toe-game
cd tic-tac-toe-game
```

2. **Set up the Maven project structure:**
```bash
mkdir -p src/main/java/com/tictactoe/{controller,model}
mkdir -p src/main/resources/static
mkdir -p src/test/java
```

3. **Copy the files:**
   - Copy `pom.xml` to the root directory
   - Copy `TicTacToeApplication.java` to `src/main/java/com/tictactoe/`
   - Copy `GameController.java` to `src/main/java/com/tictactoe/controller/`
   - Copy `Game.java` to `src/main/java/com/tictactoe/model/`
   - Copy `index.html` to `src/main/resources/static/`
   - Copy `application.properties` to `src/main/resources/`

4. **Build the project:**
```bash
mvn clean compile
```

5. **Run the application:**
```bash
mvn spring-boot:run
```

6. **Open your browser:**
   Navigate to: `http://localhost:8080`

### 🎮 Alternative Run Methods

**Method 1: Using Maven wrapper (if available):**
```bash
./mvnw spring-boot:run
```

**Method 2: Build JAR and run:**
```bash
mvn clean package
java -jar target/tic-tac-toe-game-1.0.0.jar
```

**Method 3: Run from IDE:**
- Import the project into your IDE (IntelliJ IDEA, Eclipse, VS Code)
- Run the `TicTacToeApplication.java` main method

## 🎯 How to Play

1. **Choose Your Symbol:** Click X or O to select your playing symbol
2. **Make Moves:** Click on empty cells to place your symbol
3. **AI Opponent:** The computer will automatically make moves after yours
4. **Win Conditions:** Get 3 in a row (horizontal, vertical, or diagonal)
5. **New Game:** Click "New Game" to start fresh
6. **Score Tracking:** Your wins, losses, and draws are tracked automatically

## 🔌 API Endpoints

The game exposes these REST endpoints:

### Start New Game
```http
POST /api/game/start
Response: {
  "gameId": "uuid",
  "board": ["","","","","","","","",""],
  "currentPlayer": "X",
  "gameOver": false,
  "winner": null
}
```

### Make Move
```http
POST /api/game/{gameId}/move
Content-Type: application/json

Body: {
  "position": 0,
  "player": "X"
}

Response: {
  "board": ["X","","","","","","","",""],
  "currentPlayer": "O",
  "gameOver": false,
  "winner": null,
  "winningLine": null
}
```

### Get Game State
```http
GET /api/game/{gameId}/state
Response: {
  "board": ["X","O","","","","","","",""],
  "currentPlayer": "X",
  "gameOver": false,
  "winner": null,
  "winningLine": null
}
```

### Delete Game
```http
DELETE /api/game/{gameId}
Response: {
  "message": "Game deleted"
}
```

## 🎨 UI Features

- **Glassmorphism Design:** Modern, translucent UI with backdrop blur
- **Smooth Animations:** CSS animations for piece placement and winning celebrations
- **Responsive Layout:** Works on desktop and mobile devices
- **Sound Effects:** Audio feedback for moves and game events
- **Visual Feedback:** Hover effects, winning line highlights, and status updates
- **Score Persistence:** Scores are saved in browser session storage

## 🔧 Configuration

### Server Configuration
- **Port:** 8080 (configurable in `application.properties`)
- **Context Path:** / (root)
- **Static Resources:** Served from `/resources/static/`

### Customization Options
- Change server port in `application.properties`
- Modify UI colors and animations in the CSS section of `index.html`
- Extend AI logic in the `makeAIMove()` JavaScript function
- Add more sound effects by modifying the `playSound()` function

## 🚨 Troubleshooting

### Common Issues

**Port Already in Use:**
```bash
# Change port in application.properties
server.port=8081
```

**Maven Build Fails:**
```bash
# Clean and rebuild
mvn clean install -U
```

**Static Files Not Loading:**
- Ensure `index.html` is in `src/main/resources/static/`
- Check browser console for 404 errors
- Verify application.properties static resource configuration

**Game State Issues:**
- The game uses in-memory storage, so restarting the server clears all games
- Each browser tab creates independent game sessions

## 🎯 Future Enhancements

Possible improvements you could add:

1. **Better AI:** Implement minimax algorithm for smarter AI
2. **Multiplayer:** Add real-time multiplayer using WebSockets
3. **Themes:** Multiple UI themes and color schemes
4. **Difficulty Levels:** Easy, Medium, Hard AI opponents
5. **Game History:** Persistent game history and statistics
6. **Player Names:** Custom player names instead of X/O
7. **Tournament Mode:** Best of N games
8. **Mobile App:** React Native or Flutter mobile version

## 📝 License

This project is open source and avilable for use and learning feel free to learn and use it.

## 🤝 Contributing

Feel free to fork, modify, and submit pull requests to improve the game!

---

Enjoy playing Tic-Tac-Toe! 🎉
