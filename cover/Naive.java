package cover;

import java.util.ArrayList;

// Strategia naiwna.
public class Naive extends Strategy
{
    public void launch(int range, ArrayList<Set> allSets)
    {
        boolean[] toCover = cover(range);
        ArrayList<Integer> Answer = new ArrayList<>();
        int leftToCover = range;

        for (int i = 0; i < allSets.size() && leftToCover != 0; ++i)
        {
            int diff = allSets.get(i).allCommonValues(toCover);
            if (diff > 0)
            {
                leftToCover -= diff;
                Answer.add(i+1);
                allSets.get(i).coverAll(toCover);
            }
        }

        giveAnswer(leftToCover, Answer);
    }
}
