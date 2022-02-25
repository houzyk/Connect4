package REQUIREMENT_3;

import java.util.ArrayList;

public class Parser {
  ArrayList<String> validInputs = new ArrayList<>();

  public Parser (int columns) {
    initializeValidInputs(columns);
  }

  public boolean sanitizeInput(String input) {
    return this.validInputs.contains(input);
  }

  private void initializeValidInputs (int columns) {
    for (int i = 1; i <= columns; i++) {
      validInputs.add(Integer.toString(i));
    }
  }
}
