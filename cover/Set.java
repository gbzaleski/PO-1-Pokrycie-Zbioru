package cover;

import java.util.ArrayList;
import java.util.Arrays;

// Klasa pojedynczego setu.
public class Set
{
    ArrayList<SetElement> Elements;

    public Set()
    {
        Elements = new ArrayList<>();
    }

    // Dodanie zbioru elementów naturalnych.
    public void append(int[] tabDiscrete)
    {
        Elements.add(new Discrete(tabDiscrete));
    }

    // Dodanie ciagu nieskończonego.
    public void append(int start, int step)
    {
        Elements.add(new Arithm(start, step));
    }

    // Dodanie ciagu skończonego.
    public void append(int start, int step, int end)
    {
        Elements.add(new Arithm(start, step, end));
    }

    // Obliczenie ile nowych elementów może pokryć ten set.
    public int allCommonValues(boolean[] curCovered)
    {
        boolean[] backUpCovered = Arrays.copyOf(curCovered, curCovered.length);
        int counter = 0;

        for (SetElement element: Elements)
        {
            counter += element.commonValues(backUpCovered);
        }

        return counter;
    }

    // Pokrycie rozważanego zbioru tym setem.
    public void coverAll(boolean[] curCovered)
    {
        for (SetElement element: Elements)
        {
            element.cover(curCovered);
        }
    }
}
