public class CountingSort implements SortingInterface {
    /*
    Sarah Ettrich's implementation of CountingSort from online course: "Data Structures and Algorithms: Deep Dive Using Java" available on Udemy.com
     */
    @Override
    public void sort(int[] input) {
       int start = 0;
       int end = input.length;
       int[] countArray = new int[(end - start) + 1];//Creating array which needs to be long enough to count each possible value.

        for (int i = 0; i < input.length; i++) {//traversing over unsorted array and incrementing values in the count array.
            //Counting phase
            countArray[input[i]]++;//The array needs to know, where to count each value.
        }

        //once the counting phase is finished, all the sorted values are written back into the input array.

        int j = 0;//j is the index which is being used to write to the input array.
        for (int i = start; i <= end; i++) {//and i is the index that is being used to traverse the countArray.
            while (countArray[i] > 0) {//Each element in the countArray has a count and that count can be greater than one.
                input[j++] = i;
                countArray[i]--;
            }
        }
    }

    @Override
    public String getSortName() {
        return "Counting sort";
    }
}
