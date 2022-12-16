package fr.william.lawnmowerkata.entities;

public record Dimension(int width, int height) {
    public boolean contains(Position position) {
        int x = position.x();
        int y = position.y();
        return x >= 0 && x <= width
                && y >= 0 && y <= height;
    }
}
