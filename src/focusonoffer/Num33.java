package focusonoffer;

/**
 * @author :  PF_23
 * @Description : 二叉搜索树的后序遍历序列
 * 二叉搜索树结点值的特点：左子树 < 根 < 右子树
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * 例如，下图是后序遍历序列 1,3,2 所对应的二叉搜索树。
 * @date : 2019/12/25.
 */

public class Num33 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int first, int last) {
        // 递归遍历左右子树
        if (last - first < 1) {
            return true;
        }
        int rootVal = sequence[last];
        int curIndex = first;
        while (curIndex < last && sequence[curIndex] <= rootVal) {
            curIndex++;
        }
        for (int i = curIndex; i < last; i++) {
            if (sequence[curIndex] < sequence[last]) {
                return false;
            }
        }
        return verify(sequence, first, curIndex - 1) && verify(sequence, curIndex, last - 1);
    }

}

