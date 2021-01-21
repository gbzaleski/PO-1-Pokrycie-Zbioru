/**
 Pokrycie zbioru
 Grzegorz B. Zaleski (418494)
 22-24 kwietnia 2020
 */
package cover;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

// Główna klasa programu - analizująca dane.
public class Main
{
    static ArrayList<Set> allSets = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    private static void analyseInput(ArrayList<Integer> curInput)
    {
        Set newSet = new Set();
        // Corner case tj. przypadek skrajny z setem bez zawartości.
        if (curInput.size() == 0)
        {
            allSets.add(newSet);
            return;
        }

        int pos = curInput.size() - 1;
        while (pos != 0)
        {
            // Ciąg skończony.
            if (curInput.get(pos) < 0 && curInput.get(pos-1) < 0)
            {
                newSet.append(curInput.get(pos-2), -curInput.get(pos-1), -curInput.get(pos));
                curInput.set(pos-2, 0);
                curInput.set(pos-1, 0);
                curInput.set(pos, 0);
            }
            // Ciąg nieskończony.
            else if (curInput.get(pos) < 0)
            {
                newSet.append(curInput.get(pos-1), -curInput.get(pos));
                curInput.set(pos-1, 0);
                curInput.set(pos, 0);
            }
            pos--;
        }

        // Reszta to zbiór niezależnych elementów.
        // Struktura setu na drzewie usuwa powtarzające się elementy.
        TreeSet<Integer> discreteElems = new TreeSet();
        for (int element: curInput)
            if (element != 0)
                discreteElems.add(element);

         // Dorzucamy tylko zbiór niepusty.
         if (discreteElems.size() != 0)
            newSet.append(discreteElems.stream().mapToInt(Integer::intValue).toArray());

        allSets.add(newSet);
    }

    public static void main(String[] args)
    {
        // Tabela dostępnych stretegii.
        Strategy[] Strategies = new Strategy[4];
        Strategies[1] = new Precise();
        Strategies[2] = new Greedy();
        Strategies[3] = new Naive();

        // Wczytywanie.
        while (scanner.hasNext())
        {
            int inp = scanner.nextInt();
            if (inp < 0)
            {
                int whichStrategy = scanner.nextInt();
                Strategies[whichStrategy].launch(-inp, allSets);
            }
            else
            {
                ArrayList<Integer> curInput = new ArrayList<>();
                while (inp != 0)
                {
                    curInput.add(inp);
                    inp = scanner.nextInt();
                }
                analyseInput(curInput);
            }
        }
    }
}

