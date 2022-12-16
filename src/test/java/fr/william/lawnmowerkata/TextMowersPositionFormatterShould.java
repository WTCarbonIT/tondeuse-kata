package fr.william.lawnmowerkata;

import fr.william.lawnmowerkata.entities.MowingResult;
import fr.william.lawnmowerkata.entities.Position;
import fr.william.lawnmowerkata.enums.CardinalPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextMowersPositionFormatterShould {
    private TextMowersPositionFormatter textMowersPositionFormatter;

    @BeforeEach
    void initialize() {
        textMowersPositionFormatter = new TextMowersPositionFormatter();
    }

    @Test
    void return_formatted_positions_and_orientations() {
        String result = textMowersPositionFormatter.format(
                List.of(
                        new MowingResult(
                                new Position(1, 1),
                                CardinalPoint.NORTH)
                )
        );

        String expected = "1 1 N";
        assertEquals(expected, result);
    }

    @Test
    void return_formatted_positions_and_orientations_list() {
        String result = textMowersPositionFormatter.format(
                List.of(new MowingResult(new Position(1, 1), CardinalPoint.NORTH),
                        new MowingResult(new Position(2, 1), CardinalPoint.SOUTH)
                )
        );

        String expected = "1 1 N 2 1 S";
        assertEquals(expected, result);
    }

    @Test
    void return_formatted_empty_list() {
        String result = textMowersPositionFormatter.format(Collections.emptyList());

        String expected = "";
        assertEquals(expected, result);
    }
}
