package REQUIREMENT_3;

public abstract class Interface {
  public static void welcomeUser () {
    String welcomeMessage = "Welcome to Connect 4\nThere are 2 players red and yellow\nPlayer 1 is Red, Player 2 is Yellow\nTo play the game type in the number of the column you want to drop you counter in\nA player wins by connecting 4 counters in a row - vertically, horizontally or diagonally\n";
    System.out.println(welcomeMessage);
  }

  public static void printWinningMessage (String player) {
    System.out.println(player + " has won!!!");
  }
}
