package demo02;
/*
 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。

//这是一个贪心算法的题，暂时还不是很会----------动态规划
 */
public class MinPathSum {
	public static void main(String[] args) {
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(minPathSum(grid));
	}
	
	public static int minPathSum(int[][] grid) {
		/*
		int rowLength = grid.length;
		int colLength = grid[0].length;
		System.out.println(grid[0][0]+"-->");
		int nowX=0;
		int nowY=0;
        if(grid[nowX+1][nowY]>grid[nowX][nowY+1]) {
        	nowX++;
        	System.out.println(grid[nowX][nowY]+"-->");
        }
        else if (grid[nowX+1][nowY]==grid[nowX][nowY+1]) {
			
		}
		return 0;
     	*/	    
		      	//解法如下
		        //思路：首先想到可以使用动态规划来解决，对于每一个状态都是由于上面或者左边的值加上当前值
		        //过程：
		        /* 1、创建 一个dp数组，状态转移方程，dp[i][j] = Math.min(dp[i][j-1]+grid[i][j],dp[i-1][j]+grid[i][j])
		           2、考虑边界状态
		                2.1 由于状态转移必须来自上一个状态，因此第一个状态dp[0][0]初始化为grid[0][0]
		                2.2 最上一行的格子的上一个状态只可能来自左边
		                2.2 最左一列的格子的上一个状态只可能来自上面
		            3、循环，需要注意的是当i为0时候j不能为0，避免数组越界
		        * */


		        //只有1格,要自主测试一下返回0还是返回这个格子的值作为开销
		        if (grid.length <= 1 && grid[0].length <= 1) {
		            return grid[0][0];
		        }

		        int[][] dp = new int[grid.length][grid[0].length];
		        dp[0][0] = grid[0][0];

		        for (int i = 0; i < grid.length; i++) {
		            for (int j = i==0?1:0; j < grid[0].length; j++) {

		                if (i==0){
		                    dp[i][j] = dp[i][j - 1] + grid[i][j];
		                }else if (j==0){
		                    dp[i][j] = dp[i - 1][j] + grid[i][j];
		                }else {
		                    dp[i][j] = Math.min(dp[i][j - 1] + grid[i][j], dp[i - 1][j] + grid[i][j]);
		                }
		            }
		        }

		        return dp[grid.length - 1][grid[0].length - 1];
		    }
    
}
