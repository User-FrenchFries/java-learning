package demo02;

/*
 
����һ����ά�����һ�����ʣ��ҳ��õ����Ƿ�����������С�

���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��ͬһ����Ԫ���ڵ���ĸ�������ظ�ʹ�á�

ʾ��:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

���� word = "ABCCED", ���� true.
���� word = "SEE", ���� true.
���� word = "ABCB", ���� false.

 */
public class Exist {

	public boolean exist(char[][] board, String word) {
		int Xlength = board.length;
		int Ylength = board[0].length;
		char[] words = word.toCharArray();
		int count = 0;
		for(int i=0;i<Xlength;i++) {
			for(int j=0;j<Ylength;j++) {
				if(words[count]==board[i][j]) {
					count++;
				}
			}
		}
		return false;
      
		
    }
}
