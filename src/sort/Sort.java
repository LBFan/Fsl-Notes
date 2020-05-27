package sort;

/**
 * @author :  PF_23
 * @Description : 约定
 * 待排序的元素需要实现 Java 的 Comparable 接口，该接口有 compareTo() 方法，可以用它来判断两个元素的大小关系。
 * 使用辅助函数 less() 和 swap() 来进行比较和交换的操作，使得代码的可读性和可移植性更好。
 * <p>
 * 排序算法的成本模型是比较和交换的次数
 * @date : 2019/11/29.
 */

    public abstract class Sort<T extends Comparable<T>> {
    public abstract void sort(T[] nums);

    protected boolean less(T t1, T t2) {
        return t1.compareTo(t2) < 0;
    }

    protected void swap(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}

