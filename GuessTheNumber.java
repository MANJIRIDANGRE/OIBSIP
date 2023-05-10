import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {
    public static void main(String[] args) {
        int lowerRange = 1;
        int upperRange = 100;
        int maxAttempts = 5;
        int score = 0;
        
        JOptionPane.showMessageDialog(null, "Welcome to Guess the Number!\nI'm thinking of a number between "
                + lowerRange + " and " + upperRange + ".\nCan you guess it in " + maxAttempts + " attempts?");
        
        Random random = new Random();
        int randomNumber = random.nextInt(upperRange - lowerRange + 1) + lowerRange;
        
        boolean guessedCorrectly = false;
        int attempts = 0;
        
        while (!guessedCorrectly && attempts < maxAttempts) {
            String input = JOptionPane.showInputDialog("Attempt " + (attempts + 1) + ": Enter your guess:");
            
            try {
                int guess = Integer.parseInt(input);
                
                if (guess < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Too low!");
                } else if (guess > randomNumber) {
                    JOptionPane.showMessageDialog(null, "Too high!");
                } else {
                    guessedCorrectly = true;
                    score += maxAttempts - attempts;
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number " + randomNumber +
                            " correctly in " + (attempts + 1) + " attempts.\nYour score: " + score);
                }
                
                attempts++;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            }
        }
        
        if (!guessedCorrectly) {
            JOptionPane.showMessageDialog(null, "Game over! You failed to guess the number " + randomNumber +
                    " within the given number of attempts.\nYour score: " + score);
        }
    }
}
