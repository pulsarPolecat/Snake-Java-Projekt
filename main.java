import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //game objects
        Playingfield field = new Playingfield(20);
        Snake snake = new Snake();
        Food food = new Food(20);
        Scanner scanner = new Scanner(System.in);

        boolean gameIsRunning = true;

        // game-loop
        while (gameIsRunning) {
            field.draw(snake, food); // Draw everything on the console
            
            System.out.print("Direction (w/a/s/d) or 'q' to quit: ");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                gameIsRunning = false;
            } 
            // TODO: Add movement logic here later
        }
        System.out.println("Game Over.");
    }
}