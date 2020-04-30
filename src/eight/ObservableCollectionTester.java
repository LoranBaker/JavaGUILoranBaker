
package eight;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class ObservableCollectionTester {

    public static void main(String[] args) {
        ObservableList<Integer> matchScoreList = FXCollections.observableArrayList(1, 2);
        System.out.println(String.format("Match score: %d - %d", matchScoreList.get(0), matchScoreList.get(1)));
        ListChangeListener<Integer> matchScoreListener = new MatchScoreListener();
        matchScoreList.addListener(matchScoreListener);
        matchScoreList.set(0, 3);
    }

    static class MatchScoreListener implements ListChangeListener<Integer> {

        @Override
        public void onChanged(Change<? extends Integer> c) {
            System.out.println(String.format("Match score changed : %d - %d", c.getList().get(0), c.getList().get(1)));
        }

    }
}
