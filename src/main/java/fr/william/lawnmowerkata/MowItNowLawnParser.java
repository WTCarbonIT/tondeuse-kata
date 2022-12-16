package fr.william.lawnmowerkata;

import fr.william.lawnmowerkata.entities.Dimension;
import fr.william.lawnmowerkata.entities.Lawn;
import fr.william.lawnmowerkata.entities.Mower;
import fr.william.lawnmowerkata.entities.Position;
import fr.william.lawnmowerkata.enums.CardinalPoint;
import fr.william.lawnmowerkata.enums.Movement;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MowItNowLawnParser implements LawnParser {

    @Override
    public Lawn parse(List<String> lines) {
        List<String> initialLawn = Arrays.stream(lines.get(0).split(" ")).toList();

        Dimension dimension = new Dimension(
                Integer.parseInt(initialLawn.get(0)),
                Integer.parseInt(initialLawn.get(1))
        );

        List<Mower> mowers = parseMowers(lines.subList(1, lines.size()));

        return new Lawn(dimension, mowers);
    }

    private final Map<String, Movement> movements = Map.of(
            "A", Movement.FORWARD,
            "G", Movement.LEFT,
            "D", Movement.RIGHT
    );
    private final Map<String, CardinalPoint> cardinalPoints = Map.of(
            "N", CardinalPoint.NORTH,
            "E", CardinalPoint.EAST,
            "S", CardinalPoint.SOUTH,
            "W", CardinalPoint.WEST
    );

    private List<Mower> parseMowers(List<String> lines) {
        return lines.stream().map(line -> {
            String[] mowerAttributes = line.split(" ");

            Position position = new Position(
                    Integer.parseInt(mowerAttributes[0]),
                    Integer.parseInt(mowerAttributes[1]));
            CardinalPoint orientation = cardinalPoints.get(mowerAttributes[2]);
            List<Movement> movements = Arrays.stream(
                    mowerAttributes[3]
                            .split("")).map(this.movements::get).toList();

            return new Mower(position, orientation, movements);
        }).toList();
    }
}