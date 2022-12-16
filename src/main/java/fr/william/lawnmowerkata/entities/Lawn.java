package fr.william.lawnmowerkata.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lawn {
    private final Dimension dimension;
    private final List<Mower> mowers;

    public Lawn(Dimension dimension, List<Mower> mowers) {
        this.dimension = dimension;
        this.mowers = new ArrayList<>(mowers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lawn lawn = (Lawn) o;
        return Objects.equals(dimension, lawn.dimension) && Objects.equals(mowers, lawn.mowers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dimension, mowers);
    }
}
