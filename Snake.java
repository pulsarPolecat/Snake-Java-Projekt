import java.util.ArrayList;

public class Snake {
    private ArrayList<int[]> body;
    private String direction;

    public Snake() {
        body = new ArrayList<>();
        //Start in the middle of the playfield
        body.add(new int[]{10,10}); //head
        body.add(new int[]{9, 10}); //Body
        body.add(new int[]{8,10}); // Tail
        direction = "right";
    }

    // Getter method so the Playingfield can access the body parts
    public ArrayList<int[]> getBody() {
        return body;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String newDirection) {
        this.direction = newDirection;
    }

    // The logic to move the snake (Will be implemented in the next step)
    public void move() {
        //TODO
    }
}
