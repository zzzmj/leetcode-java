package easy._104;

import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zmj
 * @Description
 * @create 2018/10/14
 */
public class Solution {
    /*
     * 递归方法
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 迭代办法
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            res++;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode t = q.poll();
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
        }
        return res;
    }
}
