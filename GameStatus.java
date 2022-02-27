public abstract class GameStatus {

  public static boolean checkWin(char[][] board, char color) {
    return checkHorizontalWin(board, color) ||
    checkVerticalWin(board, color) ||
    checkDiagonalWin(board, color);
  }

  private static boolean checkHorizontalWin(char[][] board, char color) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == color) {
          count++;
          if (count >= 4) return true;
        } else {
          count = 0;
        }
      }
    }
    return false;
  }

  private static boolean checkVerticalWin(char[][] board, char color) {
    int count = 0;
    for (int i = 0; i < board[0].length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[j][i] == color) {
          count++;
          if (count >= 4) return true;
        } else {
          count = 0;
        }
      }
    }
    return false;
  }

  private static boolean checkDiagonalWin (char[][] board, char color) {
    return checkForwardDiagonalWin(board, color) ||
    checkBackWardDiagonalWin(board, color);
  }

  private static boolean checkForwardDiagonalWin(char[][] board, char color) {
    int count = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 5; j >= 3; j--) {
        for (int k = 0; k < 4; k++) {
          if (board[j - k][i + k] == color) {
            count++;
            if (count >= 4) return true;
          } else {
            count = 0;
          }
        }
      }
    }
    count = 0;
    for (int i = 6; i > 3; i--) {
      for (int j = 2; j >= 0; j--) {
        for (int k = 0; k < 4; k++) {
          if (board[j + k][i - k] == color) {
            count++;
            if (count >= 4) return true;
          } else {
            count = 0;
          }
        }
      }
    }
    return false;
  }

  private static boolean checkBackWardDiagonalWin(char[][] board, char color) {
    int count = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 2; j >= 0; j--) {
        for (int k = 0; k < 4; k++) {
          if (board[j + k][i + k] == color) {
            count++;
            if (count >= 4) return true;
          } else {
            count = 0;
          }
        }
      }
    }
    count = 0;
    for (int i = 6; i > 3; i--) {
      for (int j = 5; j >= 3; j--) {
        for (int k = 0; k < 4; k++) {
          if (board[j - k][i - k] == color) {
            count++;
            if (count >= 4) return true;
          } else {
            count = 0;
          }
        }
      }
    }
    return false;
  }
}
