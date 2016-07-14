package test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ANTON on 07.07.2016.
 */
public class WinCombinations {

   static List<int[]> listWinCombination = new ArrayList<int[]>();

    private int[] winCombinationRow1 = {0, 1, 2};
    private int[] winCombinationRow2 = {3, 4, 5};
    private int[] winCombinationRow3 = {6, 7, 8};

    private int[] winCombinationColumn1 = {0, 3, 6};
    private int[] winCombinationColumn2 = {1, 4, 7};
    private int[] winCombinationColumn3 = {2, 5, 8};

    private int[] winCombinationDiagonal1 = {0, 4, 8};
    private int[] winCombinationDiagonal2 = {2, 4, 6};

    {
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
