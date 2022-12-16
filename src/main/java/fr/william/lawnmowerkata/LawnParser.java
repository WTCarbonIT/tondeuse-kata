package fr.william.lawnmowerkata;

import fr.william.lawnmowerkata.entities.Lawn;

import java.util.List;

public interface LawnParser {
    Lawn parse(List<String> lines);
}
