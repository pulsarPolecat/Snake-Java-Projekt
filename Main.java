import java.util.Scanner;

public class Main {
    static final int SIZE = 20; // Spielfeldgröße

    public static void main(String[] args) {
        // Spiel Objekte
        Playingfield field = new Playingfield(SIZE);
        Snake snake = new Snake();
        Food food = createFood(snake);
        Scanner scanner = new Scanner(System.in);

        // Game-Loop
        while (true) {
            field.draw(snake, food);
            System.out.print("Direction (w/a/s/d) or 'q' to quit: ");
            String input = scanner.nextLine();

            switch (input) {
                case "q": 
                    System.out.println("Game Over."); 
                    scanner.close(); 
                    return;
                case "w": snake.setDirection("up"); break;
                case "s": snake.setDirection("down"); break;
                case "a": snake.setDirection("left"); break;
                case "d": snake.setDirection("right"); break;
            }

            // Schlange bewegen
            snake.move();

            // --- HIER KOMMT DIE WAND-KOLLISION REIN ---
            // Kopf der Schlange holen (Index 0)
            int[] head = snake.getBody().get(0);
            
            // Prüfen, ob der Kopf die Wand berührt (0 oder SIZE-1, also 19)
            if (head[0] <= 0 || head[0] >= SIZE - 1 || head[1] <= 0 || head[1] >= SIZE - 1) {
                field.draw(snake, food); // Noch einmal zeichnen, damit man den Crash sieht
                System.out.println("\nCRASH! Du bist gegen die Wand gefahren.");
                System.out.println("GAME OVER");
                scanner.close();
                return; // Beendet das Programm sofort
            }

            // Kopf auf Futter: wachsen und neues Futter erzeugen
            if (snake.contains(food.getX(), food.getY())) {
                snake.grow();
                food = createFood(snake);
            }
        }   
    }

    // Neues Futter so lange würfeln, bis es nicht auf der Schlange liegt
    private static Food createFood(Snake snake) {
        Food food;
        do {
            food = new Food(SIZE);
        } while (snake.contains(food.getX(), food.getY()));
        return food;
    }
}