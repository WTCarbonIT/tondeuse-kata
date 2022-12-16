package fr.william.lawnmowerkata.entities;

import fr.william.lawnmowerkata.enums.CardinalPoint;

public record MowingResult(Position position, CardinalPoint orientation) {
}
