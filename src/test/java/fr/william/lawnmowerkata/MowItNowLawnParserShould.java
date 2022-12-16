package fr.william.lawnmowerkata;

import fr.william.lawnmowerkata.entities.Dimension;
import fr.william.lawnmowerkata.entities.Lawn;
import fr.william.lawnmowerkata.entities.Mower;
import fr.william.lawnmowerkata.entities.Position;
import fr.william.lawnmowerkata.enums.CardinalPoint;
import fr.william.lawnmowerkata.enums.Movement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MowItNowLawnParserShould {

    private MowItNowLawnParser mowItNowLawnParser;

    @BeforeEach
    void initialize() {
        mowItNowLawnParser = new MowItNowLawnParser();
    }

    @Test
    void return_lawn_and_its_mowers_from_a_file_with_lawn_and_two_mowers() {
        List<String> lines = List.of(
                "5 5",
                "1 2 N GAGAGAGAA",
                "3 3 E AADAADADDA"
        );

        Lawn resultLawn = mowItNowLawnParser.parse(lines);

        List<Movement> firstMowerMovements =
                List.of(
                        Movement.LEFT,
                        Movement.FORWARD,
                        Movement.LEFT,
                        Movement.FORWARD,
                        Movement.LEFT,
                        Movement.FORWARD,
                        Movement.LEFT,
                        Movement.FORWARD,
                        Movement.FORWARD
                );
        List<Movement> secondMowerMovements = List.of(
                Movement.FORWARD,
                Movement.FORWARD,
                Movement.RIGHT,
                Movement.FORWARD,
                Movement.FORWARD,
                Movement.RIGHT,
                Movement.FORWARD,
                Movement.RIGHT,
                Movement.RIGHT,
                Movement.FORWARD
        );
        Lawn expectedLawn = new Lawn(
                new Dimension(5, 5),
                List.of(
                        new Mower(
                                new Position(1, 2),
                                CardinalPoint.NORTH,
                                firstMowerMovements
                        )
                        ,
                        new Mower(
                                new Position(3, 3),
                                CardinalPoint.EAST,
                                secondMowerMovements
                        ))
        );
        assertEquals(expectedLawn, resultLawn);
    }

    @Test
    void return_lawn_with_no_mowers() {
        List<String> lines = List.of("10 10");

        Lawn resultLawn = mowItNowLawnParser.parse(lines);

        Lawn expectedLawn = new Lawn(
                new Dimension(10, 10),
                Collections.emptyList()
        );
        assertEquals(expectedLawn, resultLawn);
    }
}