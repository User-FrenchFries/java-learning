package demo01;
/*
 ��һ��С������� 1 �� N ����� N ���ˡ����Գƣ���Щ������һ����С���ϵ����ܷ��١�

���С��ķ�����Ĵ��ڣ���ô��

С��ķ��ٲ������κ��ˡ�
ÿ���ˣ�����С�򷨹��⣩������С��ķ��١�
ֻ��һ����ͬʱ�������� 1 ������ 2 ��
�������� trust�������������ζ� trust[i] = [a, b] ��ɣ���ʾ���Ϊ a �������α��Ϊ b ���ˡ�

���С��������ܷ��ٲ��ҿ���ȷ��������ݣ��뷵�ظ÷��ٵı�ǡ����򣬷��� -1��


eg:
���룺N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
�����3

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
		 //˼��������󣬽ⷨ������
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
	 
	  //�����ҵ��Ľ��,������ȷ�İ汾
		/* 
        int[] trusted = new int[N+1];
        trusted[0] = -1;
       

        for (int[] tr : trust) {//��trust�еĸ��������뵽����tr�У���˳�����
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
		 //�������������Լ�copy�������
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
