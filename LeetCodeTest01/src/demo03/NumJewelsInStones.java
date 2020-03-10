package demo03;

import java.util.HashMap;

/*
 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 
 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。

示例 1:

输入: J = "aA", S = "aAAbbbb"
输出: 3

 * */
public class NumJewelsInStones {
	
	public static void main(String[] args) {
		System.out.println(numJewelsInStones("aA", "aAAbbbb"));
	}

	public static int numJewelsInStones(String J, String S) {
		/*
		int count = 0;
        for(int i=0;i<J.length();i++) {
        	for(int j=0;j<S.length();j++) {
        		if(J.charAt(i)==S.charAt(j)) count++;
        	}
        }
        */
        HashMap<Character, Integer> Jewels = new HashMap<>();//hashmap在使用时一定记得初始化，不要用null进行初始化
        int count = 0;
        String string = "String";
        for(int i=0;i<J.length();i++) {
        	Jewels.put(J.charAt(i), 0);
        }
        for(int j=0;j<S.length();j++) {
        	//if((Jewels.put(string, 0)) == -1) count++;   //类型 HashMap<Character,Integer> 中的方法 put（Character, Integer）
        	                                               //对于参数（String, int）不适用
        	/*
        	 这种想法是错的，put方法只会返回 1.null 2.被覆盖的值（其实换句话说，也就是会返回被当前put的值里面的value给覆盖的值
        	 null也可以看作是一种类型的value）并不会返回-1。如果插入类型不同，是无法编译的。
        	 * */
        	if(Jewels.containsKey(S.charAt(j))) count++;
        }
		return count;

    }
}
