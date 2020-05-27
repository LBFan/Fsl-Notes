package hanshunping.datastructrue.sort;

import java.util.Arrays;

/**
 * @author :  PF_23
 * @Description : 堆排序
 * 堆排序是利用堆这种数据结构而设计的一种排序算法，堆排序是一种选择排序，它的最坏，最好，平均时间复 杂度均为 O(nlogn)，
 * 它也是不稳定排序。
 * <p>
 * 堆是具有以下性质的完全二叉树:
 * 每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆,
 * 注意 : 没有 要求结点的左孩子的值和右孩子的值的大小关系。
 * 每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆
 * <p>
 * 一般升序采用大顶堆，降序采用小顶堆
 * <p>
 * 堆排序的基本思想是:
 * 1) 将待排序序列构造成一个大顶堆
 * 2) 此时，整个序列的最大值就是堆顶的根节点。
 * 3) 将其与末尾元素进行交换，此时末尾就为最大值。
 * 4) 然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次大值。如此反复执行，便能得到一个有序
 * 序列了。
 * @date : 2020/04/15.
 */

public class HeapSort {

    public static void heapSort(int[] arr) {
        int temp;
        System.out.println("堆排序!!");

        //分步完成
        // 1.构造一个大顶堆（升序排序）
//        adjustHeap(arr, 1, arr.length);
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        // 2.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
        // 3.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换 步骤，直到整个序列有序。
        for (int i = arr.length - 1; i > 0; i--) {
            //交换
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            // 调整 使其维持成一个大顶堆
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 将一个数组(二叉树), 调整成一个大顶堆
     *
     * @param arr
     * @param i      表示非叶子结点在数组中索引
     * @param length 表示对多少个元素继续调整， length 是在逐渐的减少
     */
    private static void adjustHeap(int[] arr, int i, int length) {
        //先取出当前元素的值，保存在临时变量
        int temp = arr[i];
        //开始调整
        //说明
        //1.k=i*2+1k 是 i结点的左子结点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //说明左子结点的值小于右子结点的值
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                // k 指向右子结点
                k++;
            }
            if (arr[k] > temp) {
                //如果子结点大于父结点
                //把较大的值赋给当前结点
                arr[i] = arr[k];
                //!!! i 指向 k,继续循环比较
                i = k;
            } else {
                break;
            }
        }

        //当 for 循环结束后，我们已经将以 i 为父结点的树的最大值，放在了 最顶(局部)
        //将 temp 值放到调整后的位置
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 8, 5, 9};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

