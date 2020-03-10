package demo02;

/*
 
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true.
给定 word = "SEE", 返回 true.
给定 word = "ABCB", 返回 false.

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
