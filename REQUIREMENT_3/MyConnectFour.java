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

      // check vertical
      count = 0;
      for (int i = 0; i < board[0].length; i++) {
        for (int j = 0; j < board.length; j++) {
          if (board[j][i] == 'r') {
            count = count + 1;
            if (count >= 4) {
              hasWon = true;
            }
          } else {
            count = 0;
          }
        }
      }

      // check diagonal A1
      count = 0;
      for (int i = 0; i < 3; i++) {
        for (int j = 2; j >= 0; j--) {
          for (int k = 0; k < 4; k++) {
            if (board[j + k][i + k] == 'r') {
              count = count + 1;
              if (count >= 4) hasWon = true;
            } else {
              count = 0;
            }
          }
        }
      }

      // check diagonal A2
      count = 0;
      for (int i = 0; i < 3; i++) {
        for (int j = 5; j >= 3; j--) {
          for (int k = 0; k < 4; k++) {
            if (board[j - k][i + k] == 'r') {
              count = count + 1;
              if (count >= 4) hasWon = true;
            } else {
              count = 0;
            }
          }
        }
      }

      // check diagonal B1
      count = 0;
      for (int i = 6; i > 3; i--) {
        for (int j = 2; j >= 0; j--) {
          for (int k = 0; k < 4; k++) {
            if (board[j + k][i - k] == 'r') {
              count = count + 1;
              if (count >= 4)
                hasWon = true;
            } else {
              count = 0;
            }
          }
        }
      }

      // check diagonal B2
      count = 0;
      for (int i = 6; i > 3; i--) {
        for (int j = 5; j >= 3; j--) {
          for (int k = 0; k < 4; k++) {
            if (board[j - k][i - k] == 'r') {
              count = count + 1;
              if (count >= 4)
                hasWon = true;
            } else {
              count = 0;
            }
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

  private void printBoard() {
    for (int i = 0; i < board.length; i++)
    {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 'r') {
          System.out.print("| r ");
        } else if (board[i][j] == 'y') {
          System.out.print("| y ");
        } else {
          System.out.print("|   ");
        }
      }
      System.out.println("|");
    }
    System.out.println("  1   2   3   4   5   6   7");
  }

  private void placeCounter(char player, int position) {
    boolean placed = false;
    if (player == 'r') {
      for (int i = board.length - 1; i >= 0; i--) {
        if (!placed) {
          if (board[i][position - 1] == 'y') {
            // skip
          } else if (board[i][position - 1] != 'r') {
            board[i][position - 1] = 'r';
            placed = true;
          }
        }
      }
    } else {
      for (int i = board.length - 1; i >= 0; i--) {
        if (!placed) {
          if (board[i][position - 1] == 'r') {
            // skip
          } else if (board[i][position - 1] != 'y') {
            board[i][position - 1] = 'y';
            placed = true;
          }
        }
      }
    }
  }
}
