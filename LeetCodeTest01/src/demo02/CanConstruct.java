package demo02;
/*
 ����һ������� (ransom) �ַ�����һ����־(magazine)�ַ������жϵ�һ���ַ���ransom�ܲ����ɵڶ����ַ���magazines������ַ����ɡ�������Թ��ɣ����� true �����򷵻� false��

(��Ŀ˵����Ϊ�˲���¶������ּ���Ҫ����־������������Ҫ����ĸ����ɵ����������˼��)

ע�⣺

����Լ��������ַ�����ֻ����Сд��ĸ��

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/ransom-note
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * */
public class CanConstruct {
	public static void main(String[] args) {
        long s = System.currentTimeMillis();

		System.out.println(canConstruct("asadadaasasddddddddddddddddddddddaaaasddddddddddda", "sadafaafgasdasaaaaaaaaaaaaaffffwasgaaaaaaaasdddddddddddddddddddddddddddddddddddddddddddd"));
		System.out.println(canConstructCopy("asadadaasasddddddddddddddddddddddaaaasddddddddddda", "sadafaafgasdasaaaaaaaaaaaaaffffwasgaaaaaaaasdddddddddddddddddddddddddddddddddddddddddddd"));
	
        long e = System.currentTimeMillis();
        System.out.println("ʱ�䣺"+ (e-s));
	}
	
    /*2020-02-29
     ִ����ʱ :27 ms, ������ Java �ύ�л�����28.82%���û�
     �ڴ����� :40.9 MB, ������ Java �ύ�л�����5.10%���û�
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
	//ժ��������ǿ����
	/*
	 ִ����ʱ :1 ms, ������ Java �ύ�л�����100.00%���û�
   	 �ڴ����� :41.6 MB, ������ Java �ύ�л�����5.10%���û�
	 * */
	public static boolean canConstructCopy(String ransom, String magazine) {
		long s = System.currentTimeMillis()*10;
        if (magazine.length() < ransom.length()) return false;//�Ƚ�magazine�ĳ��Ⱥ�ransom�ĳ��ȣ��൱����magazine���ҵ�ransom�����magazineС����ض��Ҳ���
        int caps[] = new int[26];//����ֻ��26����ĸ����Ϊÿ����ĸ����һ��λ�ã����ڼ�¼�Ѿ����ù���λ�ã�С�ڼ�¼��֮ǰ�ı�λ��ĸ�Ѿ����ù��ˣ�
        for (char c : ransom.toCharArray()) {//��ransom�е�ÿ���ַ���ʼ����
            int index = magazine.indexOf(c, caps[c - 'a']);//���������ʼ��Ϊ0�����magazine�����ʼ�����ַ�c��������caps��c-'a'�������ֺ�����������ĵ�ַ
            if (index == -1)//����Ҳ���
                return false;
            caps[c - 97] = index + 1;//����ҵ��ˣ��ٽ������ĸ��Ӧλ�ú��ƣ���Ϊmagazine�е�һ����ĸֻ����һ��
        }
        long e = System.currentTimeMillis()*10;
        System.out.println(e-s);
        return true;
    }
}
