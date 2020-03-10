package demo04;

import java.util.Arrays;

/*
 排排坐，分糖果。

我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。

给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。

然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。

重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。
注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。

返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。

 

示例 1：

输入：candies = 7, num_people = 4
输出：[1,2,3,1]
解释：
第一次，ans[0] += 1，数组变为 [1,0,0,0]。
第二次，ans[1] += 2，数组变为 [1,2,0,0]。
第三次，ans[2] += 3，数组变为 [1,2,3,0]。
第四次，ans[3] += 1（因为此时只剩下 1 颗糖果），最终数组变为 [1,2,3,1]。
 * */
public class DistributeCandies {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(distributeCandies(22,3)));
		System.out.println(Arrays.toString(distributeCandies03(22,3)));
	}

	public static int[] distributeCandies(int candies, int num_people) {
		int count = 1;
		int lastNum = 0;
		int[] ans = new int[num_people];
		while(candies!=0) {
			for(int i=0;i<num_people;i++) {
				if(count==2*num_people+1) {//分发完成了
					lastNum = candies;
					candies = 0;
				}else {
					if(candies-count<0) {//不够分
						ans[i] += candies;
						candies = 0;
						break;
					}else {
						ans[i] += count;
						candies -= count;
						count++;
					}
				}					
			}
		}
		return ans;
    }
	
	//更加精简版的暴力方法
	public static int[] distributeCandies02(int candies, int num_people) {
        int[] ans = new int[num_people];
        int i = 0;
        while (candies != 0) {
            ans[i % num_people] += Math.min(candies, i + 1);//亮点就是这里的i%num_people，可以精简的得到下标位置，不用一直for循环
            candies -= Math.min(candies, i + 1);
            i += 1;
        }
        return ans;
    }
	
	//当成数学题来做，其实就是一个等差数列求和
	public static int[] distributeCandies03(int candies, int num_people) {
	    int n = num_people;
	    // how many people received complete gifts
	    int p = (int)(Math.sqrt(2 * candies + 0.25) - 0.5);
	    int remaining = (int)(candies - (p + 1) * p * 0.5);
	    int rows = p / n, cols = p % n;

	    int[] d = new int[n];
	    for(int i = 0; i < n; ++i) {
	      // complete rows
	      d[i] = (i + 1) * rows + (int)(rows * (rows - 1) * 0.5) * n;
	      // cols in the last row
	      if (i < cols) d[i] += i + 1 + rows * n;
	    }
	    // remaining candies        
	    d[cols] += remaining;
	    return d;
	  }
}
