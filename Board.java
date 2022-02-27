public class Board {
  private char[][] board;

  public Board (int row, int column) {
    this.board = new char[row][column];
  }

  public char[][] getBoard () { return this.board; }

  public void printBoard() {
    for (int i = 0; i < this.board.length; i++) {
      for (int j = 0; j < this.board[i].length; j++) {
        if (this.board[i][j] == 'r') {
          System.out.print("| r ");
        } else if (this.board[i][j] == 'y') {
          System.out.print("| y ");
        } else {
          System.out.print("|   ");
        }
      }
      System.out.println("|");
    }
    System.out.println("  1   2   3   4   5   6   7");
  }

  public boolean isColumnFull (int position) {
    int count = 0;
    for (int i = board.length - 1; i >= 0; i--) {
      if (board[i][position - 1] == 'y' || board[i][position - 1] == 'r') {
        count++;
      }
    }
    if (count >= 6) {
      return true;
    }
    return false;
  }

  public void placeCounter (char player, int position) {
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
