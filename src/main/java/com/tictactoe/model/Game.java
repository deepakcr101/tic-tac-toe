package com.tictactoe.model;

import java.util.Arrays;

public class Game {
    private String[] board;
    private String currentPlayer;
    private String winner;
    private boolean gameOver;
    private int[] winningLine;
    private String gameId;
    
    public Game(String gameId) {
        this.gameId = gameId;
        this.board = new String[9];
        Arrays.fill(this.board, "");
        this.currentPlayer = "X";
        this.winner = null;
        this.gameOver = false;
        this.winningLine = null;
    }
    
    public boolean makeMove(int position, String player) {
        if (gameOver || !board[position].isEmpty() || !currentPlayer.equals(player)) {
            return false;
        }
        
        board[position] = player;
        
        if (checkWinner()) {
            winner = player;
            gameOver = true;
        } else if (isBoardFull()) {
            gameOver = true;
        } else {
            currentPlayer = currentPlayer.equals("X") ? "O" : "X";
        }
        
        return true;
    }
    
    private boolean checkWinner() {
        int[][] winPatterns = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
            {0, 4, 8}, {2, 4, 6}  // diagonals
        };
        
        for (int[] pattern : winPatterns) {
            if (!board[pattern[0]].isEmpty() &&
                board[pattern[0]].equals(board[pattern[1]]) &&
                board[pattern[1]].equals(board[pattern[2]])) {
                winningLine = pattern;
                return true;
            }
        }
        return false;
    }
    
    private boolean isBoardFull() {
        return Arrays.stream(board).noneMatch(String::isEmpty);
    }
    
    // Getters and Setters
    public String[] getBoard() { return board; }
    public String getCurrentPlayer() { return currentPlayer; }
    public String getWinner() { return winner; }
    public boolean isGameOver() { return gameOver; }
    public int[] getWinningLine() { return winningLine; }
    public String getGameId() { return gameId; }
}
