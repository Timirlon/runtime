package Lesson25_algorithms.classwork.task1;

public class Main {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120};
        System.out.println(binarySearch(nums, 30));
    }

    static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            System.out.println("Шаг");
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    static void bubbleSort(int[] nums) {
        for (int round = 0; round < nums.length; round++) {
            boolean isSorted = true;
            for (int i =0; i < nums.length - round - 1; i++) {
                if(nums[i] > nums[i+1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    isSorted = false;
                }
            }
            if(isSorted)
                break;
        }
    }

    static void selectionSort (int[] nums) {
        for (int round = 0; round < nums.length; round++) {
            int smallest = round;

            for (int i = round + 1; i < nums.length; i++) {
                if (nums[i] < nums[smallest]) {
                    smallest = 1;
                }
            }

            if (smallest != round) {
                int temp = nums[round];
                nums[round] = nums[smallest];
                nums[smallest] = temp;
            }
        }
    }
}
