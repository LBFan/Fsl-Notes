package hanshunping.datastructrue.sort;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description :希尔排序
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序;随着增量逐渐减少，每组包含的关键词越来越多，
 * 当增量减至 1 时，整个文件恰被分成一组，算法便终止
 * 有一群小牛, 考试成绩分别是 {8,9,1,7,2,3,5,4,6,0} 请从小到大排序. 请分别使用
 * 1) 希尔排序时， 对有序序列在插入时采用交换法, 并测试排序速度.
 * 2) 希尔排序时， 对有序序列在插入时采用移动法, 并测试排序速度
 * @date : 2020/04/15.
 */

public class ShellSort {

    /**
     * 交换式
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素(共 gap 组，每组有个元素), 步长 gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            //System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));
        }
    }

    /**
     * 移位方式 -> 对交换法的优化
     *
     * @param arr
     */
    public static void shellSort2(int[] arr) {
        // 增量 gap, 并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第 gap 个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int min = arr[j];

                if (arr[j] < arr[j - gap]) {
                    // 注意while中为什么是min！！！
                    while (j - gap >= 0 && min < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出 while 后，就给 min 找到插入的位置
                    arr[j] = min;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 5, 7, 4, 9};
        shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

