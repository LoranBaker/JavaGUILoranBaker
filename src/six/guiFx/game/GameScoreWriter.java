package six.guiFx.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class GameScoreWriter implements ChangeListener<Number>{

    private final StringBuilder scoreBuilder = new StringBuilder();
    private final File file;

    public GameScoreWriter(File file) {
        this.file = file;
    }

    private void writeScoreOne(String scoreVaule) {
        try (PrintWriter printWriter = new PrintWriter(new PrintStream(file))) {
            printWriter.println(scoreVaule);
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public void changed(ObservableValue<? extends Number> obseravble, Number oldValue, Number newValue) {
        IntegerProperty playerProperty = (IntegerProperty) obseravble;
        scoreBuilder.append(playerProperty.getName())
                .append(" Old score = ")
                .append(oldValue)
                .append(" New score = ")
                .append(newValue)
                .append(System.lineSeparator());
        writeScoreOne(scoreBuilder.toString());
    }

}
