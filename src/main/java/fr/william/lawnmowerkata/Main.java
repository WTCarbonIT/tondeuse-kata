package fr.william.lawnmowerkata;

import fr.william.lawnmowerkata.entities.Lawn;
import fr.william.lawnmowerkata.entities.MowingResult;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> lines = Files.readAllLines(Path.of(ClassLoader.getSystemResource("LawnFixture.txt").toURI()));

        MowItNowLawnParser mowItNowLawnParser = new MowItNowLawnParser();
        Lawn lawn = mowItNowLawnParser.parse(lines);

        List<MowingResult> finalMowingResults = lawn.mow();

        TextMowersPositionFormatter textMowersPositionFormatter = new TextMowersPositionFormatter();
        System.out.print(textMowersPositionFormatter.format(finalMowingResults));
    }
}