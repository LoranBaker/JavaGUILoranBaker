package eight;

import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Vjezba3 {
    
    static final double KOTIZACIJA = 200.00;
    public static void main(String[] args) {
        ObservableList<String> players = FXCollections.observableArrayList();
        ListChangeListener<String> fondPrinter = new fondPrinter();
        players.addListener(fondPrinter);
        try(Scanner scanner = new Scanner(System.in)){
            String playerName = scanner.nextLine();
            players.add(playerName);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    static class fondPrinter implements ListChangeListener<String>{

        @Override
        public void onChanged(Change<? extends String> change) {
            int numberOfplayers = change.getList().size();
            double nagradniFond = KOTIZACIJA*numberOfplayers;
            System.out.println("Novi nagradni fond: " + nagradniFond);
        }
        
    }
}
