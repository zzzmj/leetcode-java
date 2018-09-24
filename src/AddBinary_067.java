/**
 * @author zmj
 * @Description 二进制数相加，返回他们的和（二进制表示）
 * 这道题我一开始把二进制转成十进制运算，最后转换回来，发现不行，二进制转十进制的时候，数太大可能会溢出
 * 所以还是用硬办法，把两个二进制数逐位相加
 * @create 2018/9/24
 */
public class AddBinary_067 {
  /**
   * 要考虑的问题是两个字符串可能不等，所以循环里要对相加做处理，在两者长度相同的部分，两者相加再加上进位
   * 再长度超出的部分，单独拿出与进位相加
   * 最后将首位情况拿出来单独考虑
   * 注意，得到的字符串是逆序的，所以返回的时候，要将字符串逆转一下
   * 
   * 这里我用字符转整数的方法有很多种~~
   */
  public String addBinary(String a, String b) {
    StringBuilder num = new StringBuilder();
    int lenA = a.length(), lenB = b.length();
    int carry = 0, s, i = 1;
    while (lenA - i >= 0 || lenB - i >= 0) {
      if (lenA - i >= 0 && lenB - i >= 0) {
        s = (a.charAt(lenA - i) - '0') + (b.charAt(lenB - i) - '0') + carry;
      } else if (lenA - i >= 0) {
        s = (a.charAt(lenA - i) - '0') + carry;
      } else {
        s = (b.charAt(lenB - i) - '0') + carry;
      }
      carry = s/2;
      num.append(s%2);
      i++;
    }
    if (carry > 0) {
      num.append(carry);
    }
    return num.reverse().toString();
  }
  
}
