import java.util.ArrayList;

public class Snake {
    private ArrayList<int[]> body = new ArrayList<>(); // Index 0 = Kopf
    private String direction = "right";
    private boolean shouldGrow = false; // true = beim nächsten move() wachsen

    public Snake() {
        // Start in der Mitte: Kopf, Körper, Schwanz
        body.add(new int[]{10, 10});
        body.add(new int[]{9, 10});
        body.add(new int[]{8, 10});
    }

    public ArrayList<int[]> getBody() { return body; }
    public int[] getHead() { return body.get(0); }
    public void setDirection(String d) { direction = d; }
    public void grow() { shouldGrow = true; }

    // Prüft, ob die Schlange auf Feld (x, y) liegt
    public boolean contains(int x, int y) {
        for (int[] p : body) if (p[0] == x && p[1] == y) return true;
        return false;
    }

    public void move() {
        int x = getHead()[0], y = getHead()[1];
        switch (direction) {
            case "up":    y--; break;
            case "down":  y++; break;
            case "left":  x--; break;
            case "right": x++; break;
        }
        body.add(0, new int[]{x, y}); // neuer Kopf vorne
        // Schwanz nur entfernen, wenn nicht gefressen wurde
        if (shouldGrow) shouldGrow = false;
        else body.remove(body.size() - 1);
    }
}