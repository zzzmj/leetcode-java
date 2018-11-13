package indi.zmj.leetcode;

/**
 * @author zmj
 * @Description 判断两棵树是否完全相同
 * @create 2018/9/27
 */
public class SameTree_100 {
    /**
     * 分析递归模型
     * 1. p和q都为空，则返回true
     * 2. p和q仅一个为空，则返回false
     * 3. p和q值不相等，返回false
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
