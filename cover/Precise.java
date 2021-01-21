package cover;

import java.util.ArrayList;
import java.util.Arrays;

// Strategia dokładna.
public class Precise extends Strategy
{
    int answer;
    boolean[] chosenSets;

    // DFS na tablicy stanów - sprawdzenie wszystkich możliwości wzięcia setów.
    private void DFS (int curPos, int curInUse, int leftToCover, boolean[] toCover, boolean[] curUsedSets, ArrayList<Set> allSets)
    {
        // Aktualnie wybrane sety pokryły wszystko.
        if (leftToCover == 0)
        {
            if (curInUse < answer)
            {
                answer = curInUse;
                chosenSets = curUsedSets;
            }
        }
        else if (curPos < curUsedSets.length && curInUse + 1 < answer)
        {
            // Bierzemy ten zbiór.
            boolean[] toCoverUsed = Arrays.copyOf(toCover, toCover.length);
            boolean[] curUsedSetsNew = Arrays.copyOf(curUsedSets, curUsedSets.length);

            int diff = allSets.get(curPos).allCommonValues(toCoverUsed);
            if (diff > 0)
            {
                curUsedSetsNew[curPos] = true;
                allSets.get(curPos).coverAll(toCoverUsed);
                DFS(curPos + 1, curInUse + 1, leftToCover - diff, toCoverUsed, curUsedSetsNew, allSets);
            }

            // Nie bierzemy.
            DFS(curPos+1, curInUse, leftToCover, toCover, curUsedSets, allSets);
        }
    }

    public void launch(int range, ArrayList<Set> allSets)
    {
        boolean[] toCover = cover(range);
        boolean[] usedSets = cover(allSets.size() - 1);
        answer = allSets.size() + 1;

        DFS(0,0, range, toCover, usedSets, allSets);

        if (answer == allSets.size() + 1)
        {
            System.out.println(0);
        }
        else
        {
            for (int i = 0; i < chosenSets.length; ++i)
            {
                if (chosenSets[i])
                {
                    System.out.print(i + 1);
                    answer--;
                    if (answer == 0)
                        System.out.println();
                    else
                        System.out.print(" ");
                }
            }
        }
    }
}
