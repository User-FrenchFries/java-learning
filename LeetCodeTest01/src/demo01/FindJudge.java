package demo01;
/*
 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。

如果小镇的法官真的存在，那么：

小镇的法官不相信任何人。
每个人（除了小镇法官外）都信任小镇的法官。
只有一个人同时满足属性 1 和属性 2 。
给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。

如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。


eg:
输入：N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
输出：3

 * */
public class FindJudge {
	public static void main(String[] args) {
		int N=2;
		int[][] trust ={};//{{1,3},{1,4},{2,3},{2,4},{4,3}};
		int value = findJudge(N,trust);
		System.out.print(value);		
	}	
	 public static int findJudge(int N, int[][] trust) {
		/*
		 //思考方向错误，解法有问题
		int[] find = new int[N];
		int count_find = 1;
		find[0]=trust[0][0];
		for(int i=1;i<trust.length;i++) {
			int exist = 0;
	        if(trust[i][0]==trust[i-1][0]) {
	        	exist=1;
	        }
			if(exist==0) {
				find[count_find] = trust[i][0];
				count_find++;
			}
		}
		int length = 0;
		for(int i=0;i<find.length;i++) {
			if(find[i]!=0) {
				length++;
			}
		} 
		if(length==N) return -1;
		
		int Judge = 1;
		int sumA = 0;
		int sumB = 0;
		for(int i=0;i<=N;i++) {
			sumA+=i;
		}
		for(int i=0;i<find.length;i++) {
           sumB += find[i];
		}
		Judge = sumA-sumB;
		
		int count = 0;
		for(int i=0;i<trust.length;i++) {
			if(trust[i][1]==Judge) count++;
		}
		if(count==N-1) return Judge;
		else return -1;
	    }
	 */
	 
	  //网上找到的解答,真正正确的版本
		/* 
        int[] trusted = new int[N+1];
        trusted[0] = -1;
       

        for (int[] tr : trust) {//将trust中的各个对引入到数组tr中，按顺序进入
        	System.out.print(trusted[tr[0]]);
        	System.out.println(trust[tr[1]]);
            trusted[tr[0]] = -1;
            if (trusted[tr[1]] != -1) {
                trusted[tr[1]]++;
            }
        }

        for (int i = 0; i < trusted.length; i++) {
            if (trusted[i] == N - 1 ) {
                return i;
            }
        }

        return N == 1 ? 1 : -1;
        */
		 //根据上述方法自己copy想出来的
		int[] trusted = new int[N];
		
		for(int[] tr : trust) {
			trusted[tr[0]-1] = -1;
			if(trusted[tr[1]-1]!=-1) {
			trusted[tr[1]-1] += 1; 
			}
		}
		for(int i=0;i<trusted.length;i++) {
			if(trusted[i]==N-1){
				return i+1;
			}
		}
		return -1;
    }
	 
	  
}
