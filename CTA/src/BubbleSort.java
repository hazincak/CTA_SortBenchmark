import java.util.Collections;

  //  My implementation of the SelectionSort based information I have received from GMIT Moodle lectures.

public class BubbleSort implements SortingInterface {

    @Override
    public void sort(int[] input) {

        //Array divided into the sorted and unsorted partition so sorted elements are not revisited.
        for (int lastUnsortedIndex = input.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (input[i] > input[i + 1]) {//simple compare and swap process. Swaps elements if the element is smaller than its neighbouring element.

                    int temp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = temp;
                }
            }
        }
    }

        @Override
    public String getSortName() {
        return "Bubble sort";
    }
}
