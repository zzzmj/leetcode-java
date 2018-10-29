package indi.zmj.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zmj
 * @Description 检查一颗二叉树是否对称
 * @create 2018/9/27
 */
public class SymmetricTree_101 {
  /**
   * 递归方法
   */
  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    
    return checkIsSymmetric(root.left, root.right);
  }
  private boolean checkIsSymmetric(TreeNode left, TreeNode right) {
    if (left == null && right ==null) return true;
    if (left == null || right == null) return false;
    if (left.val != right.val) return false;
    return checkIsSymmetric(left.left, right.right) && checkIsSymmetric(left.right, right.left);
  }

  /**
   * 迭代方法
   * 思路，层序遍历，双端队列
   */
  
  public boolean isSymmetric2(TreeNode root) {
    if (root == null) return true;
    Deque<TreeNode> deque = new LinkedList<>();
    
    deque.offerFirst(root.left);
    deque.offerFirst(root.right);
    
    TreeNode preNode = null;
    TreeNode postNode = null;
    while (!deque.isEmpty()) {
      preNode = deque.pollFirst();
      postNode = deque.pollLast();
      
    }
    
    
    return true;
  }
  
}
