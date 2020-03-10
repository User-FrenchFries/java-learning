package demo02;
/*
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。

 

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：

假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。
如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

示例 1:

输入: "42"
输出: 42
 * */
public class StrToInt {
	
	public static void main(String[] args) {
		//System.out.println(strToInt("21474836476"));
		System.out.println(Integer.MAX_VALUE+Integer.MIN_VALUE);//2147483647
		System.out.println(Integer.MIN_VALUE);//-2147483648
		System.out.println(Integer.SIZE);//32
	}
	//解法有问题，具体向下看
	public static int strToInt(String str) {
		char flag;
		boolean flag_Z = false;
		boolean flag_F = false;
		String Num = "";
		for(int i=0;i<str.length();i++) {
			flag = str.charAt(i);
			if(flag==32) {
				if (flag_F||flag_Z) {
					return 0;
				}
				continue;
			}else if (flag==43) {
				if (flag_F||flag_Z) {
					return 0;
				}
				flag_Z = true;
				continue;
			}else if (flag==45) {
				if (flag_F||flag_Z) {
					return 0;
				}
				flag_F = true;
				continue;
			}else if (flag-'0'<=9 && flag-'0'>=0) {
				Num += flag;
				continue;
			}else {
				break;
			}									
		}
		if(Num.equals("")) {
			return 0;
		}else {
			if(Long.valueOf(Num)>2147483647) {//超出int范围,所以可以用long嘛，但是如果要转换long呢，到时候该用谁？此处为不足点！！
				                              //假如这个值超出了long的范围，也是GG！！
				if(flag_F) {
					return 0-2147483647;
				}else {
					return 2147483647;
				}
			}else {
				if(flag_F) {
					return 0-Integer.valueOf(Num);
				}else {
					return Integer.valueOf(Num);
				}
			}
		}   
    }
	
	//大佬解法：一个字母字母的比较，而不是将他汇总之后再比较，因为太大的数根本无法储存下来，所以比较条件都不成立
	public int myAtoi(String str) { 
		int begin = 0; 
		int sign = 1; 
		int res = 0;
		
		if (str.length() == 0) return 0;
	    
	    // 处理前导空白
	    while (str.charAt(begin) == ' ') {
	        begin++;
	        if (begin == str.length())  return 0;
	    }
	    
	    // 处理正负号
	    if (str.charAt(begin) == '-') {
	        sign = -1;
	        begin++;
	    } else if (str.charAt(begin) == '+') {
	        begin++;
	    } else if (str.charAt(begin) < '0' && str.charAt(begin) > '9') {
	        return 0;
	    }
	    //------------------------------------------------------------------------------------------------------------------
	    while (begin < str.length() && str.charAt(begin) >= '0' && str.charAt(begin) <= '9') {
	        // 处理大数---这里处理的大数，很刁钻，只看最后一位的时候，相当于先剔出最后一位数           //Integer.MIN_VALUE=2147483647
	    	//            如果他已经很大了，就不需要比较了；假如刚刚等于这个值，那就比较下最后一位，这时候只需要和‘7’比较即可
	        if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && str.charAt(begin) > '7')) {
	            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	        }
	        res = res * 10 + (str.charAt(begin) - '0');
	        begin++;
	    }
	    //--------------------------------------------------------------------------------------------------------------------
	    // 处理符号
	    return res * sign;
	}

}
