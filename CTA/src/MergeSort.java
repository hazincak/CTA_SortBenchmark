import java.util.Collections;
/*
Sarah Ettrich's implementation of  MergeSort from online course: "Data Structures and Algorithms: Deep Dive Using Java" available on Udemy.com
 */
public class MergeSort implements SortingInterface {

    @Override
    public void sort(int[] input) {
        mergeSort(input, 0, input.length);
    }

    @Override
    public String getSortName() {
        return "Merge sort";
    }

    private void mergeSort(int[] input, int start, int end) {
        if (end - start < 2) { //base case - breaks recursion if this method is called with one element array.
            return;
        }
        //partitioning phase
        int mid = (start + end) / 2; //getting middle element, therefore the array can be split into two subarrays.
        mergeSort(input, start, mid); //This method is recursively called until the left array is not partitioned. Every call takes the same input array.
        mergeSort(input, mid, end); //This method is recursively called until the right array is not partitioned. Every call takes the same input array.
        //In this implementation, the end index is always one greater than the last valid index in the array and this implementation throws any extra elements into the right partition.

        //merging phase
        merge(input, start, mid, end);
    }

    private void merge(int[] input, int start, int mid, int end) {

        if (input[mid - 1] <= input[mid]) { //if true, no merging is needed as two sorted arrays are being merged.
                                            //The "mid" value it the first element in the right side and it is one greater than the last element in the left side.
            return;                         //if false, there are some elements in the left array, that are greater than some of the elements in the right array, so some merging needs to be done.
        }

        int i = start;
        int j = mid;
        int tempIndex = 0; // Tracking index for the temporary array.
        int[] temp = new int[end - start]; //length long enough to hold the number of elements in the left and right partitions.

        while (i < mid && j < end) { //traversing left and right subarrays, as soon as both of them are traversed, the loop stops.

            //sorting process
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];   //elements from the right and the left partition are being compared. The smaller of the two is written to the temporary array.
        }
        //handling the remaining elements.
        //if there are elements remaining in the left partition, we have to copy them into the temp array.
        //if there are elements in the right partition, we don't have to do anything as its position in the input array is not going to change as a result of the merge.
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);//copying sorted elements from the temp array to the default array.


    }
}
