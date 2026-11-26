import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Spiel Objekte
        Playingfield field = new Playingfield(20);
        Snake snake = new Snake();
        Food food = new Food(20);
        Scanner scanner = new Scanner(System.in);

        boolean gameIsRunning = true;

        // game-loop
        while (gameIsRunning) {
            // Draw everything on the console
            field.draw(snake, food); 
            
            System.out.print("Direction (w/a/s/d) or 'q' to quit: ");
            String input = scanner.nextLine();

            if (input.equals("w")) {
                snake.setDirection("up");
            } else if (input.equals("s")) {
                snake.setDirection("down");
            } else if (input.equals("a")) {
                snake.setDirection("left");
            } else if (input.equals("d")) {
                snake.setDirection("right");
            }
            
            snake.move();
        }
        System.out.println("Game Over.");
    }
}