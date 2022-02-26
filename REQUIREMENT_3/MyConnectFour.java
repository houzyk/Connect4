package REQUIREMENT_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyConnectFour {

  private BufferedReader input;
  private char[][] board;

  public MyConnectFour() {
    board = new char[6][7];
    input = new BufferedReader(new InputStreamReader(System.in));
    playGame();
  }

  private void playGame() {
    printBoard();
    boolean win = false;
    while (!win) {
      // player 1
      String userInput = getUserInput();
      int move = Integer.parseInt(userInput);
      placeCounter('r', move);
      boolean hasWon = false;
      int count = 0;
      // // check horizontal
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          if (board[i][j] == 'r') {
            count = count + 1;
            if (count >= 4) {
              hasWon = true;
            }
          } else {
            count = 0;
          }
        }
      }


      printBoard();
      if (hasWon) {
        win = true;
      } else {
        // player 2
        userInput = getUserInput();
        move = Integer.parseInt(userInput);
        placeCounter('y', move);
        hasWon = false;
        count = 0;
        // check horizontal
        for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[i].length; j++) {
            if (board[i][j] == 'y') {
              count = count + 1;
              if (count >= 4) {
                hasWon = true;
              }
            } else {
              count = 0;
            }
          }
        }
        // check vertical
        count = 0;
        for (int i = 0; i < board[0].length; i++) {
          for (int j = 0; j < board.length; j++) {
            if (board[j][i] == 'y') {
              count = count + 1;
              if (count >= 4) {
                hasWon = true;
              }
            } else {
              count = 0;
            }
          }
        }
        printBoard();
        if (hasWon) {
          win = true;
        }
      }
    }
    System.out.println("You Have Won!!!");
  }

  private String getUserInput() {
    String toReturn;
    try {
      toReturn = input.readLine();
      Parser p = new Parser(7);
      if (p.sanitizeInput(toReturn)) return toReturn;
    } catch (Exception e) {
      return getUserInput();
    }
    return getUserInput();
  }
}
