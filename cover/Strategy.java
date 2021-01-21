package cover;

import java.util.ArrayList;

// Wspólna nadklasa strategii.
public abstract class Strategy
{
    // Wypisanie odpowiedzi.
    protected void giveAnswer(int leftToCover, ArrayList<Integer> Answer)
    {
        if (leftToCover == 0)
        {
            for (int i = 0; i != Answer.size(); ++i)
            {
                System.out.print(Answer.get(i));
                if (i < Answer.size() - 1)
                    System.out.print(" ");
                else
                    System.out.println();
            }
        }
        else
        {
            System.out.println(0);
        }
    }

    // Tworzenie tabeli pomocniczej stanów zakrycia.
    protected boolean[] cover(int range)
    {
        return new boolean[range+1];
    }

    // Użycie strategii.
    abstract public void launch(int range, ArrayList<Set> allSets);
}
