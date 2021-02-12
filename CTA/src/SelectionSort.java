public class SelectionSort implements SortingInterface {

//    My implementation of the SelectionSort based information I have received from GMIT Moodle lectures.

    @Override
    public void sort(int[] input) {
      //  Array divided into the sorted and unsorted partitions.
        for (int lastUnsortedIndex = input.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largest = 0;//Sets index of the largest element to 0.
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (input[i] > input[largest]) { //If there is larger element from the preset "largest" element found...
                    largest = i;                 //index of "largest" is assigned to the new element.
                }
            }
            int temp = input[largest]; //the largest element is then swapped with the last unsorted element.
            input[largest] = input[lastUnsortedIndex];
            input[lastUnsortedIndex] = temp;
        }
    }
    @Override
    public String getSortName() {
        return "Selection sort";
    }


}