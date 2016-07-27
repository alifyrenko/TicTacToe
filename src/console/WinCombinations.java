package console;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ANTON on 07.07.2016.
 */
public class WinCombinations {

    static List<int[]> listWinCombination = new ArrayList<>();

    static {
        listWinCombination.add(new int[]{0, 1, 2});
        listWinCombination.add(new int[]{3, 4, 5});
        listWinCombination.add(new int[]{6, 7, 8});

        listWinCombination.add(new int[]{0, 3, 6});
        listWinCombination.add(new int[]{1, 4, 7});
        listWinCombination.add(new int[]{2, 5, 8});

        listWinCombination.add(new int[]{0, 4, 8});
        listWinCombination.add(new int[]{2, 4, 6});
    }
}
