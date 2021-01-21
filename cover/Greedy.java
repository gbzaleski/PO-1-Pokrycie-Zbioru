package cover;

import java.util.ArrayList;
import java.util.Collections;

// Strategia zachłanna.
public class Greedy extends Strategy
{
    // Sprawdzenie,który set teraz wziąć.
    private int findBestSet(boolean[] toCover, boolean[] usedSets, ArrayList<Set> allSets)
    {
        int resultInd = -1;
        int resultSize = 0;

        for (int i = 0; i < allSets.size(); ++i)
        {
            if (usedSets[i] == false)
            {
                int diff = allSets.get(i).allCommonValues(toCover);
                if (resultSize < diff)
                {
                    resultInd = i;
                    resultSize = diff;
                }
            }
        }

        return resultInd;
    }

    public void launch(int range, ArrayList<Set> allSets)
    {
        boolean[] toCover = cover(range);
        boolean[] usedSets = cover(allSets.size() - 1);
        ArrayList<Integer> Answer = new ArrayList<>();
        int leftToCover = range;

        // Dobiera nowe sety dopóki są niepokryte elementy.
        while (leftToCover != 0)
        {
            int newInd = findBestSet(toCover, usedSets, allSets);
            if (newInd == -1)
            {
                // Zwrócenie negatywnej odpowiedzi jeśli się nie udało.
                giveAnswer(leftToCover, Answer);
                return;
            }

            leftToCover -= allSets.get(newInd).allCommonValues(toCover);
            allSets.get(newInd).coverAll(toCover);
            Answer.add(newInd+1);
        }

        Collections.sort(Answer);
        giveAnswer(leftToCover, Answer);
    }

}
