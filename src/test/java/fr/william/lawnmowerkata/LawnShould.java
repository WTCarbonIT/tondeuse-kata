package fr.william.lawnmowerkata;

import fr.william.lawnmowerkata.entities.*;
import fr.william.lawnmowerkata.enums.CardinalPoint;
import fr.william.lawnmowerkata.enums.Movement;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LawnShould {

    @Test
    void be_mowed() {
        Dimension dimension = new Dimension(5, 5);

        List<Movement> firstMovements = List.of(
                Movement.FORWARD,
                Movement.RIGHT,
                Movement.FORWARD,
                Movement.FORWARD,
                Movement.LEFT,
                Movement.LEFT,
                Movement.FORWARD,
                Movement.RIGHT,
                Movement.FORWARD
        );
        Mower firstMower = new Mower(new Position(1, 2), CardinalPoint.NORTH, firstMovements);

        List<Movement> secondMovements = List.of(
                Movement.FORWARD,
                Movement.FORWARD,
                Movement.RIGHT,
                Movement.RIGHT,
                Movement.FORWARD,
                Movement.FORWARD,
                Movement.LEFT,
                Movement.FORWARD
        );
        Mower secondMower = new Mower(new Position(5, 4), CardinalPoint.EAST, secondMovements);

        Lawn resultLawn = new Lawn(dimension, List.of(firstMower, secondMower));
        List<MowingResult> resultMowingResult = resultLawn.mow();

        List<MowingResult> expectedPoses = List.of(
                new MowingResult(new Position(2, 4), CardinalPoint.NORTH),
                new MowingResult(new Position(3, 3), CardinalPoint.SOUTH)
        );
        assertEquals(expectedPoses, resultMowingResult);
    }
}
