public class ConnectFour {

  private boolean stopPlay = false;
  private boolean draw = false;
  private Player winner;
  private Board board = new Board(6, 7);

  public ConnectFour() {
    Interface.welcomeUser();
    this.board.printBoard();
    playGame();
  }

  private void playGame() {

    HumanPlayer player1 = new HumanPlayer("Player 1");
    ComputerPlayer computerPlayer = new ComputerPlayer();

    while (!this.stopPlay) {
      executeTurn(player1, 'r');
      executeTurn(computerPlayer, 'y');
    }

    if (this.draw) {
      Interface.printDrawMessage();
    } else {
      Interface.printWinningMessage(this.winner.getTitle());
    }
  }

  private void executeTurn(Player player, char color) {
    if (this.board.isBoardFull()) {
      this.draw = true;
      this.stopPlay = true;
    } else {
      String playerMove = player.move();

      while (this.board.isColumnFull(Integer.parseInt(playerMove))) {
        if (player instanceof HumanPlayer)
          Interface.printColumnFullMessage();
        playerMove = player.move();
      }

      this.board.placeCounter(color, Integer.parseInt(playerMove));
      this.board.printBoard();

      boolean playerStatus = GameStatus.checkWin(this.board.getBoard(), color);
      player.setStatus(playerStatus);

      if (player.getStatus()) {
        this.winner = player;
        this.stopPlay = true;
      }
    }
  }
}
