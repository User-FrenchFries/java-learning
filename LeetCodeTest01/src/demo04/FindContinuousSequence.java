package demo04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
  
     输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

     序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

     示例 1：

     输入：target = 9
     输出：[[2,3,4],[4,5]]
  */
public class FindContinuousSequence {

	public static void main(String[] args) {

		/*int[][] ans = findContinuousSequence(9);
		for (int[] num : ans) {
			System.out.print("[");
			for (int i = 0; i < num.length; i++) {
				if (i == num.length - 1) {
					System.out.println(num[i] + "]");
				} else {
					System.out.print(num[i] + ",");
				}

			}
		}*/
		Scanner in = new Scanner(System.in);
        int a = 0;
        a = in.nextInt();
        String[] str = new String[a+1];
        for(int i=0;i<a+1;i++){
           str[i] = in.nextLine(); 
        }
        /*System.out.println("--------------------");
        System.out.println(str[0]);
        System.out.println("--------------------");*/
        for(int i=1;i<a+1;i++){
        	System.out.println(str[i]);
            System.out.println(PAT(str[i]));
        }
		//System.out.println(PAT("APAAATAA"));
		
	}

	/*
	 * 当然也可以暴力法，就是从某个数开始一直往上加，看是否可以等于target，如果大于了，就直接换一个数继续
	 * 
	 * 优化暴力法就是用数学思想来算，其实和累加没有很大区别，只是用来算是否等式有根，有就继续，没有就算了
	 */

	// 滑动窗口的解法，就像毛毛虫一样，在数组上爬行求解，理解好思路
	public static int[][] findContinuousSequence(int target) {
		int i = 1; // 滑动窗口的左边界
		int j = 1; // 滑动窗口的右边界
		int sum = 0; // 滑动窗口中数字的和
		List<int[]> res = new ArrayList<>();
		int FLAG;

		while (i <= target / 2) {
			if (sum < target) {
				// 右边界向右移动
				sum += j;
				j++;
			} else if (sum > target) {
				// 左边界向右移动
				sum -= i;
				i++;
			} else {
				// 记录结果
				int[] arr = new int[j - i];
				for (int k = i; k < j; k++) {
					arr[k - i] = k;
				}
				res.add(arr);
				// 左边界向右移动
				sum -= i;
				i++;
			}
		}
		return res.toArray(new int[res.size()][]);
	}
	
	public static int Callatz(int num) {
		int count = 0;
		if (num==1) {
			return 0;
		}else {
			if (num%2==0) {
				num = num/2;
				count += Callatz(num)+1;				
			}else {
				num = (num*3+1)/2;
				count += Callatz(num)+1;
			}
		}		
		return count;	
	}
	
	public static String PAT(String string) {
		boolean P_flag = false;
		boolean T_flag = false;
		int Pnum = 0;
		int Tnum = 0;
		int sum = 0;
		for(int i=0;i<string.length();i++) {
			if(string.charAt(i)=='A'||string.charAt(i)=='P'||string.charAt(i)=='T'||string.charAt(i)==' ') {//正确字符
				if ((T_flag&&string.charAt(i)=='T')||(P_flag&&string.charAt(i)=='P')) {
					return "NO";
				}else {
					if (!P_flag&&string.charAt(i)=='P') {
						P_flag = true;
						Pnum = i;
					}
					if (!T_flag&&string.charAt(i)=='T') {
						T_flag = true;
						Tnum = i;
					}
				}	
			}else {
				return "NO";
			}
		}//过滤完的只含有A “ ”之类的了
		if(Tnum-Pnum==2) {
			return "YES";
		}else if (Tnum-Pnum==3) {
			if(string.charAt(Tnum-1)=='A') {
				return "YES";
			}
			return "NO";
		}else {
			return "NO";
		}
	}
	
}
