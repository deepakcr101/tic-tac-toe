
# 🎮 Tic-Tac-Toe Web Application

A clean and responsive Tic-Tac-Toe game built with **Spring Boot** (Java backend) and **HTML/CSS/JavaScript** frontend. Features animated gameplay, basic AI, and modern UI design.

---

## ✨ Features

### 🔙 Backend (Spring Boot)
- RESTful APIs for game management
- In-memory game state (no DB required)
- Game rules enforcement: move validation, win/draw logic
- Multiple game support (via UUIDs)
- Lightweight and stateless

### 🖥️ Frontend (Vanilla JS + CSS3)
- Animated 3x3 grid board with click interactivity
- Smooth CSS transitions for X/O placement
- Highlight winning line with visual animation
- Player symbol selection (X/O)
- Basic AI (random move logic)
- Real-time feedback with game status and messages
- Minimal **glassmorphism-inspired** design
- Responsive layout (mobile & desktop)

---

## 📸 Screenshots

| Home Screen | Gameplay | Game Over |
|-------------|----------|-----------|
| ![home](src/main/resources/static/images/Game%20Home.png) | ![gameplay](src/main/resources/static/images/Game%20Play.png) | ![gameover](src/main/resources/static/images/Game%20Result.png) |

---

## 🚀 Quick Start

### Prerequisites
- Java 17+
- Maven 3.6+

### 🔧 Setup & Run

```bash
# Clone or create project directory
mkdir tic-tac-toe-game && cd tic-tac-toe-game

# Generate structure
mvn archetype:generate -DgroupId=com.tictactoe -DartifactId=tic-tac-toe-game -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

# Add source files
# (Copy Java controllers, models, and index.html as shown in folder structure)

# Build & run
mvn spring-boot:run
```

Navigate to: [http://localhost:8080](http://localhost:8080)

---

## 📁 Folder Structure

```
tic-tac-toe-game/
├── src/main/
│   ├── java/com/tictactoe/
│   │   ├── TicTacToeApplication.java
│   │   ├── controller/GameController.java
│   │   └── model/Game.java
│   └── resources/
│       ├── static/index.html
│       └── application.properties
└── pom.xml
```

---

## 🎯 How to Play

1. Choose X or O  
2. Click on grid cells to play  
3. Watch the AI respond  
4. Get 3 in a row to win!  
5. Click “New Game” to restart  

---

## 🔌 API Endpoints

### ➕ Start New Game
```http
POST /api/game/start
```

### 🎯 Make Move
```http
POST /api/game/{id}/move
Body: { "position": 4, "player": "X" }
```

### 📊 Get Game State
```http
GET /api/game/{id}/state
```

### ❌ Delete Game
```http
DELETE /api/game/{id}
```

---

## 🎨 UI Highlights

- 🎉 Animated piece drop  
- 🔊 Sound effects (optional)  
- ✨ Visual highlights for win/draw  
- 🧊 Glassmorphic styling  
- 📱 Fully responsive design  

---

## 🚧 Troubleshooting

**Port conflict?**
```properties
server.port=8081
```

**Static files not loading?**
- Ensure `index.html` is in `src/main/resources/static`
- Check browser console for 404s

**Build fails?**
```bash
mvn clean install -U
```

---

## 🌱 Future Ideas

- Minimax-based smart AI  
- Real-time multiplayer with WebSocket  
- Player name input  
- Theme switching  
- Game stats dashboard  

---

## 📝 License

This project is open for use and learning. Fork it, tweak it, and build upon it freely.

---

## 🤝 Contribute

Pull requests and improvements are welcome!

---

🎉 **Enjoy Tic-Tac-Toe!** Relive the classic in a sleek modern web interface.
