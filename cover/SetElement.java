package cover;

// Abstrakcyjna klasa elementu w secie.
public abstract class SetElement
{
    // Pokrycie rozważanego zbioru tym elementem.
    abstract public int commonValues(boolean[] curCovered);

    // Obliczenie ile nowych elementów zbioru może pokryć ten element.
    abstract void cover(boolean[] curCovered);
}
