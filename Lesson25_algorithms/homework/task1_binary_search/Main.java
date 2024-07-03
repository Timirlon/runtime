package Lesson25_algorithms.homework.task1_binary_search;

public class Main {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120};
        int[] reversedNums = {120, 110, 100, 90, 80, 70, 60, 50, 40, 30, 20, 10};

        System.out.println(binarySearch(nums, 10));
        System.out.println(binarySearch(reversedNums, 90));
    }

    static int binarySearch(int[] nums, int target) {
        boolean isSortedAsc = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                continue;
            }
            isSortedAsc = false;
            break;
        }

        if (isSortedAsc) {
            System.out.println("Список отсортирован по возрастанию.");
            System.out.println("Бинарный поиск:");
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
            System.out.println("Число " + target + " не найдено");
            return -1;
        }

        boolean isSortedDesc = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                continue;
            }
            isSortedDesc = false;
            break;
        }

        if (isSortedDesc) {
            System.out.println("Список отсортирован по убыванию.");
            System.out.println("Бинарный поиск:");
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                System.out.println("Шаг");
                int mid = (low + high) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (target < nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            System.out.println("Число " + target + " не найдено");
            return -1;
        }

        System.out.println("Список не отсортирован!");
        return -1;
    }
}
