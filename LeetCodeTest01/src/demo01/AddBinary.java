package demo01;
/*
 *          2020-02-28
���������������ַ������������ǵĺͣ��ö����Ʊ�ʾ����

����Ϊ�ǿ��ַ�����ֻ�������� 1 �� 0��

ʾ�� 1:

����: a = "11", b = "1"
���: "100"

 * */
public class AddBinary {
	public static void main(String[] args) {
		System.out.print(addBinary("111", "1"));
		
	}

	public static String addBinary(String a, String b) {
		char[] A = a.toCharArray();
		char[] B = b.toCharArray();
		int numA=0;
		int numB=0;
		for(int i=A.length-1;i>=0;i--) {//char����ת��Ϊint���ͻ����ASC�����ת�� ��1��=49
			numA += ((int)A[i]-48)*Math.pow(2, (A.length-1)-i);
		}
		for(int i=B.length-1;i>=0;i--) {
			numB += ((int)B[i]-48)*Math.pow(2, (B.length-1)-i);
		}
		int sum = numA+numB;
 		return Integer.toBinaryString(sum);

    }
}
