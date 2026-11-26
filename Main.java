import java.util.Scanner;

public class Main {
    static final int SIZE = 20; // Spielfeldgröße
        public static void main(String[] args) {
        //Spiel Objekte
        Playingfield field = new Playingfield (SIZE);
        Snake snake = new Snake();
        Food food = createFood(snake);
        Scanner scanner = new Scanner(System.in);


        // game-loop
        while (true) {
            field.draw(snake, food);
            System.out.print("Direction (w/a/s/d) or 'q' to quit: ");
            String input = scanner.nextLine();
            
            

           switch (input) {
                case "q": System.out.println("Game Over."); scanner.close(); return;
                case "w": snake.setDirection("up"); break;
                case "s": snake.setDirection("down"); break;
                case "a": snake.setDirection("left"); break;
                case "d": snake.setDirection("right"); break;
            }
                //Schlange bewegen
                snake.move();

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
        do food = new Food(SIZE);
        while (snake.contains(food.getX(), food.getY()));
        return food;
    }

       // System.out.println("Game Over.");
    }