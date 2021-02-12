public class QuickSort implements SortingInterface {
    /*
    Sarah Ettrich's implementation of QuickSort from online course Data Structures and Algorithms: Deep Dive Using Java available on Udemy.com
     */
    @Override
    public void sort(int[] input) {

        quickSort(input, 0, input.length);
    }

    @Override
    public String getSortName() {

        return "Quick sort";
    }

    public static void quickSort(int[] input, int start, int end) {
        if (end - start < 2) { //breaks recursion if this method is called with one element array.
            return;
        }
        int pivotIndex = partition(input, start, end);  //Figures out where a pivot will belong in the sorted array,
                                                        //returns the position of the pivot in the sorted array.
        quickSort(input, start, pivotIndex);//sorts left subarray.
        quickSort(input, pivotIndex + 1, end);//sorts right subarray.
    }

    public static int partition(int[] input, int start, int end) {
        int pivot = input[start];   //the first element of the input is used as the pivot.
                                    // If we have any information about the field being sorted,
                                    //the best practice is to use the median value for its pivot.
        int i = start;// i is traversing from left to the right
        int j = end;//j is traversing from right to the left.

        while (i < j) {// The array traversal stops when i and j cross each other.
            while (i < j && input[--j] >= pivot);//Empty loop body. Used for decrementing j until we either find an element that's less than the pivot or j crosses i.
            if (i < j) {// if i is still less than j...
                input[i] = input[j]; //...then the elements at index i and j are swapped. swaps the element at j into position i because basically the sort has found the first element that is less than the pivot.
                //j found the first element that is less than the pivot
            }
            while (i < j && input[++i] <= pivot);//Empty loop body. Used for incrementing j until it either finds an element that's greater than the pivot or j crosses i.
            if (i < j) {
                input[j] = input[i];
            }
        }
        input[j] = pivot;
        return j; // returns the index of pivot which is in the sorted position towards other unsorted elements.
    }
}

