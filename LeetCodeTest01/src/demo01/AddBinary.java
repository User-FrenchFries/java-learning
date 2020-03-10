package demo01;
/*
 *          2020-02-28
给定两个二进制字符串，返回他们的和（用二进制表示）。

输入为非空字符串且只包含数字 1 和 0。

示例 1:

输入: a = "11", b = "1"
输出: "100"

 * */
public class AddBinary {
	public static void main(String[] args) {
		System.out.print(addBinary("111", "1"));
		
	}

	public static String addBinary(String a, String b) {
		char[] A = a.toCharArray();
		char[] B = b.toCharArray();
		int numA=0;
		int numB=0;
		for(int i=A.length-1;i>=0;i--) {//char类型转换为int类型会根据ASCⅡ码表转换 ‘1’=49
			numA += ((int)A[i]-48)*Math.pow(2, (A.length-1)-i);
		}
		for(int i=B.length-1;i>=0;i--) {
			numB += ((int)B[i]-48)*Math.pow(2, (B.length-1)-i);
		}
		int sum = numA+numB;
 		return Integer.toBinaryString(sum);

    }
}
