package com.tictactoe.controller;

import com.tictactoe.model.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/game")
@CrossOrigin(origins = "*")
public class GameController {
    
    private final Map<String, Game> games = new ConcurrentHashMap<>();
    
    @PostMapping("/start")
    public ResponseEntity<Map<String, Object>> startGame() {
        String gameId = UUID.randomUUID().toString();
        Game game = new Game(gameId);
        games.put(gameId, game);
        
        Map<String, Object> response = new HashMap<>();
        response.put("gameId", gameId);
        response.put("board", game.getBoard());
        response.put("currentPlayer", game.getCurrentPlayer());
        response.put("gameOver", game.isGameOver());
        response.put("winner", game.getWinner());
        
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/{gameId}/move")
    public ResponseEntity<Map<String, Object>> makeMove(
            @PathVariable String gameId,
            @RequestBody Map<String, Object> request) {
        
        Game game = games.get(gameId);
        if (game == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Game not found"));
        }
        
        int position = (Integer) request.get("position");
        String player = (String) request.get("player");
        
        if (position < 0 || position > 8) {
            return ResponseEntity.badRequest().body(Map.of("error", "Invalid position"));
        }
        
        boolean moveSuccessful = game.makeMove(position, player);
        
        if (!moveSuccessful) {
            return ResponseEntity.badRequest().body(Map.of("error", "Invalid move"));
        }
        
        Map<String, Object> response = new HashMap<>();
        response.put("board", game.getBoard());
        response.put("currentPlayer", game.getCurrentPlayer());
        response.put("gameOver", game.isGameOver());
        response.put("winner", game.getWinner());
        response.put("winningLine", game.getWinningLine());
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{gameId}/state")
    public ResponseEntity<Map<String, Object>> getGameState(@PathVariable String gameId) {
        Game game = games.get(gameId);
        if (game == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Game not found"));
        }
        
        Map<String, Object> response = new HashMap<>();
        response.put("board", game.getBoard());
        response.put("currentPlayer", game.getCurrentPlayer());
        response.put("gameOver", game.isGameOver());
        response.put("winner", game.getWinner());
        response.put("winningLine", game.getWinningLine());
        
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{gameId}")
    public ResponseEntity<Map<String, Object>> deleteGame(@PathVariable String gameId) {
        games.remove(gameId);
        return ResponseEntity.ok(Map.of("message", "Game deleted"));
    }
}
