import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class Interface {

  private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

  public static void welcomeUser () {
    String welcomeMessage = "Welcome to Connect 4\nThere are 2 players red and yellow\nPlayer 1 is Red, Player 2 is Yellow\nTo play the game type in the number of the column you want to drop you counter in\nA player wins by connecting 4 counters in a row - vertically, horizontally or diagonally\n";
    System.out.println(welcomeMessage);
  }

  public static void printWinningMessage (String player) {
    System.out.println(player + " has won!!!");
  }

  public static void printColumnFullMessage () {
    System.out.println("The Column is full, Please try Again!");
  }

  public static void printDrawMessage() {
    System.out.println("It's a draw!");
  }

  public static String getUserInput() {
    String playerMove;
    try {
      playerMove = input.readLine();
      Parser parser = new Parser(7);
      if (parser.sanitizeInput(playerMove)) return playerMove;
    } catch (Exception e) {
      return getUserInput();
    }
    return getUserInput();
  }
}
