package fr.william.lawnmowerkata.entities;

import fr.william.lawnmowerkata.enums.CardinalPoint;
import fr.william.lawnmowerkata.enums.Movement;

import java.util.List;

public record Mower(Position position, CardinalPoint orientation, List<Movement> movements) {
    public Mower act(Position position, CardinalPoint orientation, List<Movement> movements, Dimension dimension) {
        if (movements.isEmpty()) {
            return new Mower(position, orientation, movements);
        }

        int movementsLeft = movements.size();
        return switch (movements.get(0)) {
            case FORWARD -> new Mower(
                    advance(position, orientation, dimension),
                    orientation,
                    movements.subList(1, movementsLeft)
            );
            case LEFT, RIGHT -> new Mower(
                    position,
                    orientation,
                    movements.subList(1, movementsLeft)
            );
        };
    }

    private Position advance(Position position, CardinalPoint orientation, Dimension dimension) {
        Position newPosition = getNewPosition(position, orientation);
        return dimension.contains(newPosition) ? newPosition : position;
    }

    private Position getNewPosition(Position position, CardinalPoint orientation) {
        return switch (orientation) {
            case NORTH -> new Position(position.x(), position.y() + 1);
            case EAST -> new Position(position.x() + 1, position.y());
            case SOUTH -> new Position(position.x(), position.y() - 1);
            case WEST -> new Position(position.x() - 1, position.y());
        };
    }
}
