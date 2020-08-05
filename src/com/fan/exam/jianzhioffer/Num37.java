package com.fan.exam.jianzhioffer;

/**
 * @Description : 序列化二叉树
 * @Author : shulin.fan
 * @Date : 2020/7/16
 */
public class Num37 {
    private final String SHAP = "#";
    private String deserializeStr;

    public String Serialize(TreeNode root) {
        if (root == null) {
            return SHAP;
        }
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    public TreeNode deserialize(String str) {
        deserializeStr = str;
        return Deserialize();
    }

    private TreeNode Deserialize() {
        if (deserializeStr.length() == 0) {
            return null;
        }
        int index = deserializeStr.indexOf(" ");
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
        if (node.equals(SHAP)) {
            return null;
        }
        int val = Integer.parseInt(node);
        TreeNode t = new TreeNode(val);
        t.left = Deserialize();
        t.right = Deserialize();
        return t;
    }
}
