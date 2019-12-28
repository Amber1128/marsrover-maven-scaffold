import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.fest.assertions.api.Assertions.assertThat;


public class MarsRoverTest {
    private ExpectedException expectedException = ExpectedException.none();
    @Test
    public void should_land_the_rover_on_area() {
        Area area = new Area(10,10);
        Rover rover = new Rover();
        rover.land(area,5,5,Rover.EAST);
        String position = rover.getPosition();
        assertThat(position).isEqualTo("55E");
    }

    @Test
    public void should_move_forward() {
        Area area = new Area(10,10);
        Rover rover = new Rover();
        rover.land(area,5,5,Rover.EAST);
        rover.move();
        String position = rover.getPosition();
        assertThat(position).isEqualTo("65E");
    }

    @Test
    public void name() {
        Rover rover = new Rover();
        RoverController roverController = new RoverController(rover);
        String mission = "10,10,5,5,E,M,L,M,R";
        String position = roverController.execute(mission);
        assertThat(position).isEqualTo("66E");
    }

    @Test
    public void should_move_forward_when_direction_to_east() {
        Area area = new Area(10,10);
        Rover rover = new Rover();
        rover.land(area,5,5,"E");
        rover.move();
        String position = rover.getPosition();
        assertThat(position).isEqualTo("65E");
    }
    @Test
    public void should_turn_left() {
        Area area = new Area(10,10);
        Rover rover = new Rover();
        rover.land(area,5,5,"S");

        rover.turnLeft();
        assertThat(rover.getPosition()).isEqualTo("55E");

        rover.turnLeft();
        assertThat(rover.getPosition()).isEqualTo("55N");

        rover.turnLeft();
        assertThat(rover.getPosition()).isEqualTo("55W");

        rover.turnLeft();
        assertThat(rover.getPosition()).isEqualTo("55S");
    }

    @Test
    public void should_execute_batch_commands() {
        Rover rover = new Rover();
        RoverController roverController = new RoverController(rover);
        String mission ="10,10,5,5,E,M,L,M";
        String position = roverController.execute(mission);
            assertThat(position).isEqualTo("66N");
        }
        @Test
        public void should_warning_when_land_out_of_area() {
            expectedException.expect(IllegalArgumentException.class);
            expectedException.expectMessage("x=20 is out of area width 10");
            Area area = new Area(10,10);
            Rover rover = new Rover();
            rover.land(area,20,20,"South");
        }
    }