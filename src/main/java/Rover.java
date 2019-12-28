public class Rover {
    public final static String EAST = "E";
    public final static String WEST = "W";
    public final static String SOUTH = "S";
    public final static String NORTH = "N";
    private Area area;
    private int x;
    private int y;
    private String forward;

    public void land(Area area, int x, int y, String forward) {
        this.area = area;
        this.x = x;
        this.y = y;
        this.forward = forward;
    }

    public void move() {
        if (forward.equals("E")) {
            x += 1;
        } else if (forward.equals("W")) {
            x -= 1;
        } else if (forward.equals("N")) {
            y += 1;
        } else {
            y -= 1;
        }

    }


    public String getPosition() {
        return "" + x + y + forward;
    }

    public void turnLeft() {
        if (forward.equals(SOUTH)) {
            forward = EAST;
            return;
        }
        if (forward.equals(EAST)) {
            forward = NORTH;
            return;
        }
        if (forward.equals(NORTH)) {
            forward = WEST;
            return;
        }
        if (forward.equals(WEST)) {
            forward = SOUTH;
            return;
        }
    }

    public void turnRight() {
        if (forward.equals(SOUTH)) {
            forward = WEST;
            return;
        }
        if (forward.equals(EAST)) {
            forward = SOUTH;
            return;
        }
        if (forward.equals(NORTH)) {
            forward = EAST;
            return;
        }
        if (forward.equals(WEST)) {
            forward = NORTH;
            return;
        }
    }
}