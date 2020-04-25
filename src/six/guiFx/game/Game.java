
package six.guiFx.game;

import java.io.File;
import java.util.Random;
import java.util.Scanner;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Game {
    public static final int SCORE = 10;
    public static final String FILE_NAME = "score.txt";
    private IntegerProperty homeProperty = new SimpleIntegerProperty(this, " HOME ", 0);
    private IntegerProperty awayProperty = new SimpleIntegerProperty(this, " AWAY ", 0);
    
    public Game(){
        GameScoreWriter gameScoreWriter = new GameScoreWriter(new File(FILE_NAME));
        homeProperty.addListener(gameScoreWriter);
        awayProperty.addListener(gameScoreWriter);
    }
    
    public void start(){
        Random winnerRandom = new Random();
        try(Scanner scanner = new Scanner(System.in)){
            while(true){
                String korisnickiUnos = scanner.nextLine();
                if(korisnickiUnos.equals("EXIT")){
                    break;
                }
                if(winnerRandom.nextInt(2)==0){
                    homeProperty.set(homeProperty.get()+SCORE);
                    awayProperty.set(awayProperty.get()-SCORE);
                }else{
                    awayProperty.set(awayProperty.get()+SCORE);
                    homeProperty.set(homeProperty.get()-SCORE);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Game game = new Game();
        Random randomGenerator = new Random();
        while(true){
            System.out.println("Vrijednost: " + randomGenerator.nextInt(10));
        }
    }
    
}
