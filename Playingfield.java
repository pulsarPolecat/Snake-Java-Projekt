public class Playingfield {

    private char[][] field; 
    private int size; 

    public Playingfield(int size) {
        this.size = size;
        this.field = new char[size][size];
    }

    public void draw(Snake snake, Food food) {
        //clear console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                
                // 1. Check if its a wall
                if (x == 0 || x == size - 1 || y == 0 || y == size - 1) {
                    field[y][x] = '#';
                } 
                // 2. Check if its the food
                else if (x == food.getX() && y == food.getY()) {
                    field[y][x] = '*';
                }
                // 3. Check if its the snake
                else {
                    boolean isSnake = false;
                    for (int[] part : snake.getBody()) {
                        if (part[0] == x && part[1] == y) {
                            isSnake = true;
                            break;
                        }
                    }
                    if (isSnake) {
                        field[y][x] = 'O';
                    } else {
                        field[y][x] = ' '; // Leerer Platz
                    }
                }
                System.out.print(field[y][x]);
            }
            System.out.println();
        }
    }
}