package hanshunping.algorithm.binarysearch;

/**
 * @author :  PF_23
 * @Description : 二分查找
 * @date : 2020/04/15.
 */

public class BinarySearchNoRecur {
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            System.out.println("binarySearch~~~");
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,5,7,9,10};
        int index = binarySearch(nums, 10);
        System.out.println(index);
    }
}

