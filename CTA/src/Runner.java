import java.sql.Array;
import java.text.DecimalFormat;
import java.util.*;

public class Runner {

    private static DecimalFormat df = new DecimalFormat("#.###");
    private static String format = "|%1$-14s|%2$-7s|%3$-7s|%4$-7s|%5$-7s|%6$-7s|%7$-7s|%8$-7s|%9$-7s|%10$-7s|%11$-7s|%12$-7s|%13$-7s|%14$-7s|\n";

    private static int[] randomArray(int n, int inputRange) {//method generating an array of n random numbers within specified range
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * inputRange);
        }
        return array;
    }

    public static double conventer(long endTime, long startTime) {//method calculating the running time of another method and converting the result to milliseconds
        long timeElapsedNanos = endTime - startTime;
        double timeElapsedMillis = timeElapsedNanos / 1000000.0;
        return timeElapsedMillis;
    }

    public static double calculateAverage(List<Double> tempList) {
        double avgTime; //method iterating over list of elements and calculating their average value.
        double sumTime = 0.0;
        for (Double value : tempList) {
            sumTime = sumTime + value;
        }
        avgTime = sumTime / tempList.size();
        return avgTime;
    }

    public static void calculateSort(SortingInterface sortingAlgo, List<String> list, int inputSize) {
        double avgRunningTime, runningTime;
        ArrayList<Double> tempList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            int[] input = new int[inputSize]; //new field created every time
            input = randomArray(inputSize, inputSize); //the field populated with new values
            long startTime = System.nanoTime();
            sortingAlgo.sort(input);
            long endTime = System.nanoTime();
            runningTime = conventer(endTime, startTime);
            tempList.add(runningTime);
        }
        avgRunningTime = calculateAverage(tempList);
        list.add(df.format(avgRunningTime));
    }

    public static void printListRow(List<String> list) {
        for (String time : list) {
            System.out.format("%1$-7s|", time);
        }
        System.out.println();
    }

    public static void dualPivotQuickSort(List<String> list, int inputSize) {
        double avgRunningTime, runningTime;
        ArrayList<Double> tempList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            int[] input = new int[inputSize];
            input = randomArray(inputSize, inputSize);
            long startTime = System.nanoTime();
            Arrays.sort(input);
            long endTime = System.nanoTime();
            runningTime = conventer(endTime, startTime);
            tempList.add(runningTime);
        }
        avgRunningTime = calculateAverage(tempList);
        list.add(df.format(avgRunningTime));
    }



    public static void main(String[] args) {
        List<SortingInterface> sortingAlgos = Arrays.asList(new BubbleSort(), new SelectionSort(), new MergeSort(), new QuickSort(), new CountingSort());
        int[] inputSize = {100, 250, 500, 750, 1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10000};

        System.out.format(format, "Size", "100", "250", "500", "750", "1000", "1250", "2500", "3750", "5000", "6250", "7500", "8750", "10000");

        for (SortingInterface sortingAlgo : sortingAlgos) {
            ArrayList<String> averagesForSpecificAlgo = new ArrayList<>(inputSize.length);
            for (int i = 0; i < inputSize.length; i++) {
                calculateSort(sortingAlgo, averagesForSpecificAlgo, inputSize[i]);
            }
            System.out.format("|%1$-14s|", sortingAlgo.getSortName());
            printListRow(averagesForSpecificAlgo);
        }
       System.out.format("|%1$-14s|", "Arrays.sort");
        ArrayList<String> averagesForSpecificAlgo = new ArrayList<>(inputSize.length);
        for (int i = 0; i < inputSize.length; i++) {
        dualPivotQuickSort(averagesForSpecificAlgo, inputSize[i]);
        }
        printListRow(averagesForSpecificAlgo);

    }


}


