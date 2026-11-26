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

            if (input.equals("q")) {
                gameIsRunning = false;
            } else {
                // Richtung setzen
                if (input.equals("w")) {
                    snake.setDirection("up");
                } else if (input.equals("s")) {
                    snake.setDirection("down");
                } else if (input.equals("a")) {
                    snake.setDirection("left");
                } else if (input.equals("d")) {
                    snake.setDirection("right");
                }
                //Schlange bewegen
                snake.move();

                // Kollision mit der Wand
                int[] head = snake.getBody().get(0);
                int headX = head[0];
                int headY = head[0];

                //Prüfen, ob der Kopf die Wand berührt (0 oder 19)
                if (headX <= 0 || headX >= 19 || headY <= 0 || headY >= 19) {
                    gameIsRunning =  false; // Spiel beendet

                    // Noch einmal zeichen, damit man den Code sieht
                    field.draw(snake, food);
                    System.out.println("\nCRASH! Du bist gegen die Wand gefahren");
                    System.out.println("GAME OVER");
                }
                // Kollision mit der Wand
            }

            
        }
        System.out.println("Game Over.");
    }
}