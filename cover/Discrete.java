package cover;

// Klasa elementu setu typu zbior liczb naturalnych.
public class Discrete extends SetElement
{
    int[] points;
    public Discrete(int[] newPoints)
    {
        this.points = newPoints;
    }

    public int commonValues(boolean[] curCovered)
    {
        int counter = 0;

        for (int point: points)
        {
            if (point < curCovered.length && curCovered[point] == false)
            {
                counter++;
                curCovered[point] = true;
            }
        }
        return  counter;
    }

    public void cover(boolean[] curCovered)
    {
        for (int point: points)
        {
            if (point < curCovered.length)
                curCovered[point] = true;
            else
                return;
        }
    }
}
