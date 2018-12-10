import java.util.List;
import java.util.ArrayList;

public class Tosses2Test
{
    public static int[] getCubeTosses(NumberCube cube, int numTosses)
    {
        int[] tosses = new int[numTosses];
        for (int i = 0; i < numTosses; i++)
            tosses[i] = cube.toss();

        return tosses;
    }

    public static int getLengthOfLongestRun(int[] values)
    {
        int longestRunLen = 1;
        int currentRunLen = 1;

        for (int i = 1; i < values.length; i++)
        {
            if (values[i] == values[i - 1])
                currentRunLen++;

            else
            {
                if (currentRunLen > longestRunLen)
                {
                    longestRunLen = currentRunLen;
                }
                currentRunLen = 1;
            }
        } //end for

        if (currentRunLen > longestRunLen)
            longestRunLen = currentRunLen;

        return longestRunLen;
        //tells how long is the longest run

    }

    public static void main(String[] args)
    {
        int[] myArray = {2,2,2,1,1,4,3,6,6,6,5,5,2,5,5,5};
        List<Integer> startIndexes = getStartingIndexesOfRuns(myArray, getLengthOfLongestRun(myArray));
        System.out.println(startIndexes);
    }

    public static List<Integer> getStartingIndexesOfRuns(int[] values, int targetLength)
    {
        List<Integer> startIndexes = new ArrayList<Integer>();
        int currentRunLen = 1;
        int i;

        for (i = 1; i < values.length; i++)
        {
            if (values[i] == values[i - 1])
            {
                currentRunLen++;
            }
            else
            {
                if (currentRunLen == targetLength)
                    //targetLength was given before, which defines the length of the longest run
                    //this will search for starting index of runs with the same length
                {
                    startIndexes.add(new Integer(i - targetLength));
                    //the startingIndex will be the current index (end of run) - length of longest run
                }
                currentRunLen = 1;
                //resets the run length that's currently being tested
            }
        }
        if (currentRunLen == targetLength)
            startIndexes.add(new Integer(i - targetLength));
        //doing one last test in case the last item is also a tie with longest run

        return startIndexes;
    }
}
