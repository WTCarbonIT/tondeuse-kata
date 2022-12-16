package fr.william.lawnmowerkata;

import fr.william.lawnmowerkata.entities.MowingResult;

import java.util.List;

public interface MowersPositionFormatter {
    String format(List<MowingResult> positions);
}
