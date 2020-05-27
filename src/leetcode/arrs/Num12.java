package leetcode.arrs;

/**
 * @author :  PF_23
 * @Description : 分隔数组
 * Input: arr = [1,0,2,3,4]
 * Output: 4
 * Explanation:
 * We can split into two chunks, such as [1, 0], [2, 3, 4].
 * However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
 * 题目描述：分隔数组，使得对每部分排序后数组就为有序。
 * <p>
 * 思路：
 * 首先找到从左块开始最小块的大小。如果前 k 个元素为 [0, 1, ..., k-1]，可以直接把他们分为一个块。
 * 当我们需要检查 [0, 1, ..., n-1] 中前 k+1 个元素是不是 [0, 1, ..., k] 的时候，只需要检查其中最大的数是不是 k 就可以了。
 * @date : 2020/02/26.
 */

public class Num12 {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int res = 0;
        int right = 0;
        for (int i = 0; i < arr.length; i++) {
            right = Math.max(right, arr[i]);
            if (right == i) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 3, 2, 4};
        int chunksToSorted = new Num12().maxChunksToSorted(nums);
        System.out.println(chunksToSorted);
    }
}

