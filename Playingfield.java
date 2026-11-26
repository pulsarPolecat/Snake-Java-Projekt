public class Playingfield {

    private boolean firstDraw = true; 
    private int size; 

    public Playingfield(int size) {
        this.size = size;
    }

    public void draw(Snake snake, Food food) {
       StringBuilder sb = new StringBuilder(); // ganzes Feld sammeln, dann einmal ausgeben

        if (firstDraw) {
            sb.append("\033[2J"); // Bildschirm einmal komplett leeren
            firstDraw = false;
        }
        sb.append("\033[H"); // Cursor nach oben links, altes Feld wird überschrieben


        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (x == 0 || x == size - 1 || y == 0 || y == size - 1) {
                    sb.append('#');                          // Wand
                } else if (x == food.getX() && y == food.getY()) {
                    sb.append('*');                          // Futter
                } else if (snake.contains(x, y)) {
                    sb.append('O');                          // Schlange
                } else {
                    sb.append(' ');                          // leeres Feld
                }
            }
            sb.append('\n');
        }
        sb.append("\033[J"); // alles unterhalb löschen (z. B. alte Eingabe)

        System.out.print(sb);
        System.out.flush();
        }
    }
