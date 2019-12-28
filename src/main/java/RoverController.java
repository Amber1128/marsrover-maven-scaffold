public class RoverController {

    private final Rover rover;

    public RoverController(Rover rover) {
        this.rover = rover;
    }

    public String execute(String mission) {
        String[] commands = mission.split(",");
        int areaWidth = Integer.parseInt(commands[0]);
        int areaHeight = Integer.parseInt(commands[1]);
        int x = Integer.parseInt(commands[2]);
        int y = Integer.parseInt(commands[3]);
        //  String mission = "10,10,5,5,E,M,L,M,R";
        rover.land(new Area(areaHeight, areaWidth), x, y, Rover.EAST);
        for (int i = 5; i < commands.length; i++) {
            String command = commands[i];
            executeOneCommand(command);
        }
        return rover.getPosition();
    }

    private void executeOneCommand(String command) {
        if (command.equals("M")) {
            rover.move();
        }else if (command.equals("L")){
            rover.turnLeft();
        }
        else{
            rover.turnRight();
        }
    }
}