package demo01;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class IsPalindrome {
	public static void main(String[] args) {
		
		//String[] string = {"asdasds","asdC","sadA","asdB","sadad"};		
		int[] list = {100,2,33,56,54,6,545,8746,455,5,4,64,54};
		//Arrays.sort(string, comparator());
		Arrays.sort(list);
		//Arrays.parallelSort(list);
		System.out.println(Arrays.toString(list));//默认升序
		
		//System.out.println(isPalindrome("saassada"));
		
		//split("你好,在吗");
	}
	
    public static boolean isPalindrome(String s) {
    	
    	return (s.equals(reverseString(s)));
    	
    	//return s.equals(ReverseString(s));
		
	}
    //该方法将字符串反转后返回
    public static String reverseString(String inputString) {
    	char[] inputStringArray = inputString.toCharArray();
    	String reverseString = "";
    	for (int i = inputStringArray.length - 1; i >= 0; i--) {
    	reverseString += inputStringArray[i];
    	}
    	return reverseString;
    	}
    //反转方法2
    public static String ReverseString(String inputString) {
    	String outputString = new StringBuffer(inputString).reverse().toString();
		return outputString;
		
	}
    
    public static Comparator<String> comparator() {
    	    			   	
		return (o1, o2) -> o1.length()-o2.length();		
	}
    
    public static void split(String str) {
    	
    	String[] strings = str.split(",");
        for(String i:strings) {
        	System.out.println(i);
        }	
	}
    
}
