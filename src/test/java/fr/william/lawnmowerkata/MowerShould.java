package fr.william.lawnmowerkata;

import fr.william.lawnmowerkata.entities.Dimension;
import fr.william.lawnmowerkata.entities.Mower;
import fr.william.lawnmowerkata.entities.Position;
import fr.william.lawnmowerkata.enums.CardinalPoint;
import fr.william.lawnmowerkata.enums.Movement;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MowerShould {
    @ParameterizedTest
    @CsvSource({"1, 1, NORTH, 1, 2",
            "1, 2, EAST, 2, 2",
            "3, 1, SOUTH, 3, 0",
            "2, 2, WEST, 1, 2"})
    void advance_when_it_is_still_in_the_lawn(int inputX,
                                              int inputY,
                                              CardinalPoint orientation,
                                              int outputX,
                                              int outputY
    ) {
        Mower mower = new Mower(new Position(inputX, inputY), orientation, List.of(Movement.FORWARD));

        Mower resultMower = mower.act(
                new Position(inputX, inputY),
                orientation,
                List.of(Movement.FORWARD),
                new Dimension(5, 5)
        );

        Mower expectedMower = new Mower(new Position(outputX, outputY), orientation, Collections.emptyList());
        assertEquals(expectedMower, resultMower);
    }

    @ParameterizedTest
    @CsvSource({"1, 5, NORTH",
            "5, 3, EAST",
            "4, 0, SOUTH",
            "0, 1, WEST"})
    void stay_at_the_same_position_when_it_is_off_the_lawn(int inputX,
                                                           int inputY,
                                                           CardinalPoint orientation
    ) {
        Mower mower = new Mower(new Position(inputX, inputY), orientation, List.of(Movement.FORWARD));

        Mower resultMower = mower.act(
                new Position(inputX, inputY),
                orientation,
                List.of(Movement.FORWARD),
                new Dimension(5, 5)
        );

        Mower expectedMower = new Mower(new Position(inputX, inputY), orientation, Collections.emptyList());
        assertEquals(expectedMower, resultMower);
    }
}
