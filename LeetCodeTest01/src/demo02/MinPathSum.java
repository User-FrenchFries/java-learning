package demo02;
/*
 ����һ�������Ǹ������� m x n �������ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��

˵����ÿ��ֻ�����»��������ƶ�һ����

ʾ��:

����:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
���: 7
����: ��Ϊ·�� 1��3��1��1��1 ���ܺ���С��

//����һ��̰���㷨���⣬��ʱ�����Ǻܻ�----------��̬�滮
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
		      	//�ⷨ����
		        //˼·�������뵽����ʹ�ö�̬�滮�����������ÿһ��״̬�����������������ߵ�ֵ���ϵ�ǰֵ
		        //���̣�
		        /* 1������ һ��dp���飬״̬ת�Ʒ��̣�dp[i][j] = Math.min(dp[i][j-1]+grid[i][j],dp[i-1][j]+grid[i][j])
		           2�����Ǳ߽�״̬
		                2.1 ����״̬ת�Ʊ���������һ��״̬����˵�һ��״̬dp[0][0]��ʼ��Ϊgrid[0][0]
		                2.2 ����һ�еĸ��ӵ���һ��״ֻ̬�����������
		                2.2 ����һ�еĸ��ӵ���һ��״ֻ̬������������
		            3��ѭ������Ҫע����ǵ�iΪ0ʱ��j����Ϊ0����������Խ��
		        * */


		        //ֻ��1��,Ҫ��������һ�·���0���Ƿ���������ӵ�ֵ��Ϊ����
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
