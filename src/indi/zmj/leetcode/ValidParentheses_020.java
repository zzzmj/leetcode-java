package indi.zmj.leetcode;

import java.util.Stack;

/**
 * @author zmj
 * @Description 括号配对问题
 * @create 2018/9/13
 */
public class ValidParentheses_020 {
  public boolean isVaild(String s) {
    Stack<Character> stack = new Stack<>();
    
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else if (c == ')' || c == '}' || c == ']') {
        if(stack.empty())
          return false;
        else if (c == ')' && stack.peek() == '(')
          stack.pop();
        else if (c == '}' && stack.peek() == '{')
          stack.pop();
        else if (c == ']' && stack.peek() == '[')
          stack.pop();
        else
          return false;
      }
    }
    
    return stack.empty();
  }
}
