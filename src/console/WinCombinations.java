package console;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ANTON on 07.07.2016.
 */
public class WinCombinations {

    static List<int[]> listWinCombination = new ArrayList<>();

    public WinCombinations() {

         int[] winCombinationRow1 = {0, 1, 2};
         int[] winCombinationRow2 = {3, 4, 5};
         int[] winCombinationRow3 = {6, 7, 8};

         int[] winCombinationColumn1 = {0, 3, 6};
         int[] winCombinationColumn2 = {1, 4, 7};
         int[] winCombinationColumn3 = {2, 5, 8};

         int[] winCombinationDiagonal1 = {0, 4, 8};
         int[] winCombinationDiagonal2 = {2, 4, 6};

        listWinCombination.add(winCombinationRow1);
        listWinCombination.add(winCombinationRow2);
        listWinCombination.add(winCombinationRow3);

        listWinCombination.add(winCombinationColumn1);
        listWinCombination.add(winCombinationColumn2);
        listWinCombination.add(winCombinationColumn3);

        listWinCombination.add(winCombinationDiagonal1);
        listWinCombination.add(winCombinationDiagonal2);
    }
}
