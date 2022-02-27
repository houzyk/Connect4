public class MyConnectFour {

  private boolean win = false;
  private Player winner;

  public MyConnectFour() {
    playGame();
  }

  private void playGame() {
    HumanPlayer player1 = new HumanPlayer("Player 1");
    ComputerPlayer computerPlayer = new ComputerPlayer();
    Board board = new Board(6, 7);
    board.printBoard();

    while (!this.win) {

      String playerMove = player1.move();
      while (board.isColumnFull(Integer.parseInt(playerMove))) {
        System.out.println("The Column is full, Try Again!");
        playerMove = player1.move();
      }
      board.placeCounter('r', Integer.parseInt(playerMove));
      board.printBoard();
      boolean player1Status = GameStatus.checkWin(board.getBoard(), 'r');
      player1.setStatus(player1Status);

      if (player1.getStatus()) {
        this.winner = player1;
        this.win = true;
      } else {

        String computerMove = computerPlayer.move();
        while (board.isColumnFull(Integer.parseInt(computerMove))) {
          computerMove = computerPlayer.move();
        }
        board.placeCounter('y', Integer.parseInt(computerMove));
        board.printBoard();
        boolean computerPlayerStatus = GameStatus.checkWin(board.getBoard(), 'y');
        computerPlayer.setStatus(computerPlayerStatus);

        if (computerPlayer.getStatus()) {
          this.winner = computerPlayer;
          this.win = true;
        }
      }
    }
    Interface.printWinningMessage(this.winner.getTitle());
  }
}
