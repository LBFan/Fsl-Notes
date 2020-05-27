package hanshunping.datastructrue.search;

/**
 * @author :  PF_23
 * @Description : 插值查找算法
 * 1) 插值查找原理介绍: 插值查找算法类似于二分查找，不同的是插值查找每次从自适应 mid 处开始查找。
 * 2) 将折半查找中的求mid索引的公式,low表示左边索引left,high表示右边索引right. key 就是前面我们讲的 findVal
 * 3) int mid = low + (high - low) * (key - arr[low]) / (arr[high] - arr[low]) ;
 * 插值索引对应前面的代码公式:
 * int mid=left+(right – left)*(findVal – arr[left])/(arr[right] – arr[left])
 * <p>
 * 插值查找注意事项:
 * 1) 对于数据量较大，关键字分布比较均匀的查找表来说，采用插值查找, 速度较快.
 * 2) 关键字分布不均匀的情况下，该方法不一定比折半查找要好
 * @date : 2020/04/15.
 */

public class InsertValueSearch {
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        System.out.println("使用插值查找~~~");
        //注意:findVal < arr[0] 和 findVal > arr[arr.length - 1] 必须需要 //否则我们得到的 mid 可能越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        // 求出 mid, 自适应
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) {
            // 说明应该向右边递归
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            // 说明向左递归查找
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

    public static int insertValSearch(int[] nums, int target) {
        int le = 0, ri = nums.length - 1;
        while (le <= ri) {
            int mid = le + (ri - le) * (target - nums[le]) / (nums[ri] - nums[le]);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                ri = mid - 1;
            } else {
                le = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1234};
        int search = insertValueSearch(arr, 0, arr.length - 1, 1000);
//        int search = insertValSearch(arr, 1000);
        System.out.println(search);

    }
}

