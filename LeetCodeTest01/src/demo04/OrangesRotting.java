package demo04;
/*
在给定的网格中，每个单元格可以有以下三个值之一：

值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。

返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。

 * */
public class OrangesRotting {
	
	public static void main(String[] args) {
		//int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};    //4
		//int[][] grid = {{1,2}};   //1
		int[][] grid = {{2},{2},{1},{0},{1},{1}};   //-1
		System.out.println(orangesRotting(grid));
	}
    //思考的暴力解法，好ex
	/*
	 执行用时 :4 ms, 在所有 Java 提交中击败了45.60%的用户
        内存消耗 :37.9 MB, 在所有 Java 提交中击败了68.62%的用户
	 * */
	public static int orangesRotting(int[][] grid) {
		int count = 0;
		boolean broken = findNum(grid, 2);
		boolean good = findNum(grid, 1);
		
		if(!good&&broken|| !good&&!broken) {//全坏没有一个橘子
			return 0;				
		}else if (good&&!broken ) {//全好
			return -1;
		}else {//有好有坏的正常情况
			//有一个好的出不来或者坏的感染不完
			if(existOne(grid, 1)||allTheBroken(grid, 2)) return -1;
			//开始感染
			while (findNum(grid, 1)) {
				if(allTheBroken(grid, 2)) return -1;
				changeNum(grid, 2, 1);
				count++;				
			}
		}		
		return count;
    }
	
	//存在某个数字嘛
	public static boolean findNum(int[][] grid,int num) {
		boolean flag = false;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]==num) {
					flag = true;
				}
			}
		}
		return flag;		
	}
	
	//坏橘子感染好橘子//num1感染num2
	public static void changeNum(int[][] grid,int num1,int num2) {
		boolean[][] gridFlag = new boolean[grid.length][grid[0].length];
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]==num1) {
					gridFlag[i][j] = true;
				}
			}
		}
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(gridFlag[i][j]) {
					//上
					if(0<=i-1&&grid[i-1][j]==num2) grid[i-1][j]=num1;
					//下
					if(i+1<grid.length&&grid[i+1][j]==num2) grid[i+1][j]=num1;
					//左
					if(0<=j-1&&grid[i][j-1]==num2) grid[i][j-1]=num1;
					//右
					if(j+1<grid[0].length&&grid[i][j+1]==num2) grid[i][j+1]=num1;	
				}
			}
		}	
	}
	//存不存在一个好橘子被孤立
	public static boolean existOne(int[][] grid,int num) {//给好橘子写的//num是好橘子的编号
		int count = 0;
		int X = grid.length;
		int Y = grid[0].length;
		boolean flag = false;
		
		//对四个特殊点判断,这就是正常情况下会有四个特殊点
		if (X==1) {
			for(int i=0;i<Y;i++) {
				if(i==0) {
					if(grid[0][0]==num) {
						if(1<Y&&grid[0][1]==0) flag = true;
					}
				}else if (i==Y-1) {
					if (grid[0][Y-1]==num) {
						if(Y-2>=0&&grid[0][Y-2]==0) flag = true;		
					}
				}else {
					if(grid[0][i]==num&&grid[0][i-1]==0&&grid[0][i+1]==0) flag = true;
				}
			}
		}else if (Y==1) {
			for(int i=0;i<X;i++) {
				if(i==0) {
					if(grid[0][0]==num) {
						if(1<X&&grid[1][0]==0) flag = true;
					}
				}else if (i==X-1) {
					if (grid[X-1][0]==num) {
						if(X-2>=0&&grid[X-2][0]==0) flag = true;		
					}
				}else {
					if(grid[i][0]==num&&grid[i-1][0]==0&&grid[i+1][0]==0) flag = true;
				}
			}
			
		}else {//含有四个点的
			for(int i=0;i<X;i++) {
				for(int j=0;j<Y;j++) {
					if(grid[i][j]==num) {
						if (i==0&&j==0) {
							if(grid[0][0]==num) {
								if(grid[0][1]==0&&grid[1][0]==0) flag = true;
							}
						}else if (i==X-1&&j==Y-1) {
							if(grid[X-1][Y-1]==num) {
								if(0<=X-2&&0<=Y-2&&grid[X-2][Y-1]==0&&grid[X-1][Y-2]==0) flag = true;
							}
						}else if (i==0&&j==Y-1) {
							if(grid[0][Y-1]==num) {
								if(0<=Y-2&&grid[0][Y-2]==0&&grid[1][Y-1]==0) flag = true;
							}
						}else if (i==X-1&&j==0) {
							if(grid[X-1][0]==num) {
								if(0<=X-2&&grid[X-2][0]==0&&grid[X-1][1]==0) flag = true;
							}
						}else {
							//四条边
							if(i==0||i==X-1||j==0||j==Y-1) {
								//上
								if(0<=i-1&&grid[i-1][j]==0) count++;
								//下
								if(i+1<X&&grid[i+1][j]==0) count++;
								//左
								if(0<=j-1&&grid[i][j-1]==0) count++;
								//右
								if(j+1<Y&&grid[i][j+1]==0) count++;
								if(count==3) flag=true;
							}else {
								if(0<=i-1&&grid[i-1][j]==0) count++;
								//下
								if(i+1<X&&grid[i+1][j]==0) count++;
								//左
								if(0<=j-1&&grid[i][j-1]==0) count++;
								//右
								if(j+1<Y&&grid[i][j+1]==0) count++;
								if(count==4) flag=true;
							}
						}
						count = 0;
					}
				}
			}
			
		}		
		return flag;		
	}
	
	//所有的坏橘子是不是被孤立了
	public static boolean allTheBroken(int[][] grid,int num) {//给坏橘子写的//num是坏橘子的编号
		
		int BrokenNum = 0;//坏橘子总数
		int CheakNum = 0;//被孤立橘子总数
		int X=grid.length;
		int Y=grid[0].length;
		int count = 0;
		
		if (X==1) {
			for(int i=0;i<Y;i++) {
				if(i==0) {
					if(grid[0][0]==num) {
						BrokenNum++;
						if(1<Y&&grid[0][1]!=1) CheakNum++;
					}
				}else if (i==Y-1) {
					if (grid[0][Y-1]==num) {
						BrokenNum++;
						if(Y-2>=0&&grid[0][Y-2]!=1) CheakNum++;	
					}
				}else {
					if(grid[0][i]==num) {
						BrokenNum++;
						if (grid[0][i-1]!=1&&grid[0][i+1]!=1) {
							CheakNum++;
						}
					}
				}
			}
		}else if (Y==1) {
			for(int i=0;i<X;i++) {
				if(i==0) {
					if(grid[0][0]==num) {
						BrokenNum++;
						if(1<X&&grid[1][0]!=1) CheakNum++;
					}
				}else if (i==X-1) {
					if (grid[X-1][0]==num) {
						BrokenNum++;
						if(X-2>=0&&grid[X-2][0]!=1) CheakNum++;
					}
				}else {
					if(grid[i][0]==num) {
						BrokenNum++;
						if (grid[i-1][0]!=1&&grid[i+1][0]!=1) {
							CheakNum++;
						}
					} 
				}
			}
			
		}else {//含有四个点的
			for(int i=0;i<X;i++) {
				for(int j=0;j<Y;j++) {
					if(grid[i][j]==num) {
						BrokenNum++;
						if (i==0&&j==0) {
							if(grid[0][0]==num) {
								if(grid[0][1]!=1&&grid[1][0]!=1) CheakNum++;
							}
						}else if (i==X-1&&j==Y-1) {
							if(grid[X-1][Y-1]==num) {
								if(0<=X-2&&0<=Y-2&&grid[X-2][Y-1]!=1&&grid[X-1][Y-2]!=1) CheakNum++;
							}
						}else if (i==0&&j==Y-1) {
							if(grid[0][Y-1]==num) {
								if(0<=Y-2&&grid[0][Y-2]!=1&&grid[1][Y-1]!=1) CheakNum++;
							}
						}else if (i==X-1&&j==0) {
							if(grid[X-1][0]==num) {
								if(0<=X-2&&grid[X-2][0]!=1&&grid[X-1][1]!=1) CheakNum++;
							}
						}else {
							//四条边
							if(i==0||i==X-1||j==0||j==Y-1) {
								//上
								if(0<=i-1&&grid[i-1][j]!=1) count++;
								//下
								if(i+1<X&&grid[i+1][j]!=1) count++;
								//左
								if(0<=j-1&&grid[i][j-1]!=1) count++;
								//右
								if(j+1<Y&&grid[i][j+1]!=1) count++;
								if(count==3) CheakNum++;
							}else {
								if(0<=i-1&&grid[i-1][j]!=1) count++;
								//下
								if(i+1<X&&grid[i+1][j]!=1) count++;
								//左
								if(0<=j-1&&grid[i][j-1]!=1) count++;
								//右
								if(j+1<Y&&grid[i][j+1]!=1) count++;
								if(count==4) CheakNum++;
							}
						}
						count = 0;
					}
				}
			}	
		}
		if(BrokenNum!=0) {
			return BrokenNum==CheakNum;
		}else {
			return false;
		}
		
	}
	
	/*//大佬解法，使用BFS进行搜索
	  // dr,dc 配合使用得到 grid[r][c] 上grid[r-1][c]左grid[r][c-1]下grid[r+1][c]右grid[r][c+1]的元素
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, -1, 0, 1};

        public int orangesRotting(int[][] grid) {
            // 获取二维数组的行数row 和 列数 column
            int R = grid.length, C = grid[0].length;

            // queue : all starting cells with rotten oranges
            Queue<Integer> queue = new ArrayDeque();
            Map<Integer, Integer> depth = new HashMap();
            for (int r = 0; r < R; ++r)
                for (int c = 0; c < C; ++c)
                    if (grid[r][c] == 2) {
                        int code = r * C + c;  // 转化为索引唯一的一维数组
                        queue.add(code); //存储腐烂橘子
                        depth.put(code, 0); //存储橘子变为腐烂时的时间,key为橘子的一维数组下标，value为变腐烂的时间
                    }

            int ans = 0;
            while (!queue.isEmpty()) {
                int code = queue.remove();
                int r = code / C, c = code % C;
                for (int k = 0; k < 4; ++k) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        int ncode = nr * C + nc;
                        queue.add(ncode);
                        // 计次的关键 元素 grid[r][c] 的上左下右元素得腐烂时间应该一致
                        depth.put(ncode, depth.get(code) + 1);
                        ans = depth.get(ncode);
                    }
                }
            }

           //检查grid，此时的grid能被感染已经都腐烂了，此时还新鲜的橘子无法被感染
            for (int[] row: grid)
                for (int v: row)
                    if (v == 1)
                        return -1;
            return ans;

        }
	 
	 
	 */
	
}
