public class ConnectFour {

  private boolean win = false;
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

    while (!this.win) {
      executeTurn(player1, 'r');
      executeTurn(computerPlayer, 'y');
    }
    Interface.printWinningMessage(this.winner.getTitle());
  }

  private void executeTurn (Player player, char color) {
    String playerMove = player.move();

    while (this.board.isColumnFull(Integer.parseInt(playerMove))) {
      if (player instanceof HumanPlayer) {
        System.out.println("The Column is full, Try Again!");
      }
      playerMove = player.move();
    }

    this.board.placeCounter(color, Integer.parseInt(playerMove));
    this.board.printBoard();

    boolean playerStatus = GameStatus.checkWin(this.board.getBoard(), 'r');
    player.setStatus(playerStatus);

    if (player.getStatus()) {
      this.winner = player;
      this.win = true;
    }
  }
}
