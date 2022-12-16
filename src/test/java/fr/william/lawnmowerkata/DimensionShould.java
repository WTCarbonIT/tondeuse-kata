package fr.william.lawnmowerkata;

import fr.william.lawnmowerkata.entities.Dimension;
import fr.william.lawnmowerkata.entities.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DimensionShould {
    private Dimension dimension;

    @BeforeEach
    void initialize() {
        dimension = new Dimension(5, 5);
    }

    @ParameterizedTest
    @CsvSource({"-1, 3", "3, -1", "6, 3", "3, 6", "-1, -1", "6, 6"})
    void return_false_if_dimension_does_not_contain_position(int inputX, int inputY) {
        assertFalse(dimension.contains(new Position(inputX, inputY)));
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "5, 5", "5, 0", "0, 5", "3, 3"})
    void return_true_if_dimension_contains_position(int inputX, int inputY) {
        assertTrue(dimension.contains(new Position(inputX, inputY)));
    }
}