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
        // 1. Get the current head position
        int[] currentHead = body.get(0); 
        int newX = currentHead[0];
        int newY = currentHead[1];

        // 2. Calculate the new position based on the direction
        if (direction.equals("up")) {
            newY = newY - 1;
        } else if (direction.equals("down")) {
            newY = newY + 1;
        } else if (direction.equals("left")) {
            newX = newX - 1;
        } else if (direction.equals("right")) {
            newX = newX + 1; 
        }

        // 3. Add the new head to the front of the list
        body.add(0, new int[]{newX, newY});

        // 4. Remove the tail (the last element) to simulate movement
        // (We will handle "eating food" later!)
        body.remove(body.size() -1);
    }
}
