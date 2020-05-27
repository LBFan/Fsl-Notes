package focusonoffer;

public class TreeLinkNode {

    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    /**
     * 指向父结点的指针
     */
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}