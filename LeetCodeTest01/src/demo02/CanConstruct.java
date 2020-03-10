package demo02;
/*
 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。

(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)

注意：

你可以假设两个字符串均只含有小写字母。

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ransom-note
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class CanConstruct {
	public static void main(String[] args) {
        long s = System.currentTimeMillis();

		System.out.println(canConstruct("asadadaasasddddddddddddddddddddddaaaasddddddddddda", "sadafaafgasdasaaaaaaaaaaaaaffffwasgaaaaaaaasdddddddddddddddddddddddddddddddddddddddddddd"));
		System.out.println(canConstructCopy("asadadaasasddddddddddddddddddddddaaaasddddddddddda", "sadafaafgasdasaaaaaaaaaaaaaffffwasgaaaaaaaasdddddddddddddddddddddddddddddddddddddddddddd"));
	
        long e = System.currentTimeMillis();
        System.out.println("时间："+ (e-s));
	}
	
    /*2020-02-29
     执行用时 :27 ms, 在所有 Java 提交中击败了28.82%的用户
     内存消耗 :40.9 MB, 在所有 Java 提交中击败了5.10%的用户
     * */
	public static boolean canConstruct(String ransomNote, String magazine) {
		long s = System.currentTimeMillis()*10;
        char[] ransom = ransomNote.toCharArray();
        char[][] mag = new char[magazine.length()][2];
        for(int i=0;i<magazine.length();i++){
            mag[i][0]=magazine.charAt(i);
            mag[i][1]='0';
        }
        if (magazine.length() < ransomNote.length()) return false;
        boolean flag = true;
        for(int i=0;i<ransom.length;i++){
           if(flag){
              for(int j=0;j<mag.length;j++){
               if(ransom[i]==mag[j][0]&&mag[j][1]!='1'){
                   mag[j][1]='1';
                   break;
               }
               if(j==mag.length-1){
                   flag = false;
               }
              } 
           }
           else break;   
        }
        long e = System.currentTimeMillis()*10;
        System.out.println(e-s);
        return flag;
   }
	//摘抄到的最强方法
	/*
	 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
   	 内存消耗 :41.6 MB, 在所有 Java 提交中击败了5.10%的用户
	 * */
	public static boolean canConstructCopy(String ransom, String magazine) {
		long s = System.currentTimeMillis()*10;
        if (magazine.length() < ransom.length()) return false;//比较magazine的长度和ransom的长度，相当于在magazine中找到ransom，如果magazine小，则必定找不到
        int caps[] = new int[26];//由于只有26个字母，则为每个字母分配一个位置，用于记录已经被用过的位置（小于记录数之前的本位字母已经被用过了）
        for (char c : ransom.toCharArray()) {//由ransom中的每个字符开始遍历
            int index = magazine.indexOf(c, caps[c - 'a']);//由于数组初始都为0，则从magazine最初开始遍历字符c，并返回caps【c-'a'】中数字后初次遇见他的地址
            if (index == -1)//如果找不到
                return false;
            caps[c - 97] = index + 1;//如果找到了，再将这个字母对应位置后移，因为magazine中的一个字母只能用一次
        }
        long e = System.currentTimeMillis()*10;
        System.out.println(e-s);
        return true;
    }
}
