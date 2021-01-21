package cover;

// Klasa elementu setu typu ciąg arytmetyczny.
public class Arithm extends SetElement
{
    int start;
    int step;
    int end;

    // Ciąg skończony.
    public Arithm(int start, int step, int end)
    {
        this.start = start;
        this.step = step;
        this.end = end;
    }

    // Ciąg "nieskończony" tj. taki idący do maksymalnej długości inta
    public Arithm(int start, int step)
    {
        this.start = start;
        this.step = step;
        this.end = Integer.MAX_VALUE;
    }

    public int commonValues(boolean[] curCovered)
    {
        long curVa = start;
        int counter = 0;
        while (curVa < curCovered.length && curVa <= end)
        {
            if (curCovered[Math.toIntExact(curVa)] == false)
            {
                counter++;
                curCovered[Math.toIntExact(curVa)] = true;
            }
            curVa += step;
        }
        return counter;
    }

    public void cover(boolean[] curCovered)
    {
        long curVa = start;
        while (curVa < curCovered.length && curVa <= end)
        {
            curCovered[Math.toIntExact(curVa)] = true;
            curVa += step;
        }
    }
}
