package fr.william.lawnmowerkata;

import fr.william.lawnmowerkata.entities.MowingResult;
import fr.william.lawnmowerkata.enums.CardinalPoint;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TextMowersPositionFormatter implements MowersPositionFormatter {
    private final Map<CardinalPoint, String> cardinalPoints = Map.of(
            CardinalPoint.NORTH, "N",
            CardinalPoint.EAST, "E",
            CardinalPoint.SOUTH, "S",
            CardinalPoint.WEST, "W"
    );

    @Override
    public String format(List<MowingResult> mowingResults) {
        return mowingResults.stream().map(
                        mowingResult -> mowingResult.position().x() + " " +
                                mowingResult.position().y() + " " +
                                cardinalPoints.get(mowingResult.orientation()))
                .collect(Collectors.joining(" "));
    }
}
