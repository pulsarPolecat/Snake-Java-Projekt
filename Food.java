import java.util.Random;

public class Food {
    private int x;
    private int y;

    public Food(int playingFieldSize) {
        Random random = new Random();
        //random number between walls
        this.x = random.nextInt(playingFieldSize - 2) +1;
        this.y = random.nextInt(playingFieldSize -2) + 1;
        }

        public int getX() {return x; }
        public int getY() {return y; }           
}
