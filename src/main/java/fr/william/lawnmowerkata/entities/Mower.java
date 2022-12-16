package fr.william.lawnmowerkata.entities;

import fr.william.lawnmowerkata.enums.CardinalPoint;
import fr.william.lawnmowerkata.enums.Movement;

import java.util.List;

public record Mower(Position position, CardinalPoint orientation, List<Movement> movements) {
}
