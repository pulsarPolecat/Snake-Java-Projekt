import java.util.Random;

// Jedes Food Objekt ist genau ein Futterstück, das auf dem Spielfeld erscheint. Es hat eine x- und y-Koordinate, die zufällig innerhalb der Grenzen des Spielfelds generiert wird.
public class Food {
// Die Position des Futters auf dem Spielfeld.
    private int x;
    private int y;


    public Food(int playingFieldSize) {
//Zufallsgenerator, um die Position des Futters innerhalb der Grenzen des Spielfelds zu bestimmen. Die Positionen werden so gewählt, dass sie nicht auf den Wänden liegen (daher die -2 und +1).
        Random random = new Random();
        this.x = random.nextInt(playingFieldSize - 2) +1;
        this.y = random.nextInt(playingFieldSize -2) + 1;
        }
//Getter-Methoden, geben die Position des Futters zurück, damit andere Klassen (wie Playingfield) darauf zugreifen können.
        public int getX() {return x; }
        public int getY() {return y; }           
}
