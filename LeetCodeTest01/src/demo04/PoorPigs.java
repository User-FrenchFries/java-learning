package demo04;
/*
 
 有 1000 只水桶，其中有且只有一桶装的含有毒药，其余装的都是水。它们从外观看起来都一样。如果小猪喝了毒药，它会在 15 分钟内死去。

问题来了，如果需要你在一小时内，弄清楚哪只水桶含有毒药，你最少需要多少只猪？

回答这个问题，并为下列的进阶问题编写一个通用算法。

进阶:

假设有 n 只水桶，猪饮水中毒后会在 m 分钟内死亡，你需要多少猪（x）就能在 p 分钟内找出 “有毒” 水桶？这 n 只水桶里有且仅有一只有毒的桶。

提示：

可以允许小猪同时饮用任意数量的桶中的水，并且该过程不需要时间。
小猪喝完水后，必须有 m 分钟的冷却时间。在这段时间里，只允许观察，而不允许继续饮水。
任何给定的桶都可以无限次采样（无限数量的猪）。

 * 
 * */
public class PoorPigs {
	
	public static void main(String[] args) {
		System.out.println(poorPigs01(1, 1, 1));
	}
	
	/*
	 *得到的启示与分析：养成思维导向！
	 *1.由于测试时间给定为minuteToTest,死亡时间为minuteTODie，那么猪就会有minuteToTest/minuteTODie+1种状态
	 *       分析如下：
	 *               如果minuteToTest为60，minuteTODie为30
	 *               那么对应一只猪来说，他可能会出现：
	 *                     1.30分钟时死亡
	 *                     2.60分钟时死亡
	 *                     3.存活下来
	 *                那么每一只猪在时间限制内最多可以测试自己维度内的3个桶
	 *                当有N只M维度的猪，就会在时限内测试出M的N次方个桶，那么只需要被测桶的数量小于可测数量就行了           
	 * */
	
	public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
		int Num = minutesToTest/minutesToDie + 1;//小猪状态数
		int PigNum = 0;//小猪数
		int Bucket = 1;//可测的最大桶数
		while(Bucket<buckets) {
			Bucket *= Num;
			PigNum++;
		}		
		return PigNum;
    }
	//标准答案版
	public static int poorPigs01(int buckets, int minutesToDie, int minutesToTest) {
        int states = minutesToTest / minutesToDie + 1;
        return (int) Math.ceil(Math.log(buckets) / Math.log(states));
    }

}
