public class Playingfield {

    private char[][] feld; 
    private int groesse; 

    public Playingfield(int groesse) {
        this.groesse = groesse;
        this.feld = new char[groesse][groesse];
    }

    public void zeichnen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        for (int y = 0; y < groesse; y++) {
            for (int x = 0; x < groesse; x++) {
                if (x == 0 || x == groesse - 1 || y == 0 || y == groesse - 1) {
                    feld[y][x] = '#';
                } else {
                    feld[y][x] = ' '; 
                }
                System.out.print(feld[y][x]);
            }
            System.out.println();
        }
    }
}