package test;

/**
 * 选择排序
 * 
 * @author Administrator
 * 
 */
public class SelectionSort {
	public static void main(String[] args) {
		int[] src = { 9, 2, 4, 5, 8 };
		int len = src.length;
		int temp;
		for (int i = 0; i < len; i++) {
			temp = src[i];
			int j;
			int samllestLocation = i;// 最小数的下标
			for (j = i + 1; j < len; j++) {
				if (src[j] < temp) {
					temp = src[j];// 取出最小值
					samllestLocation = j;// 取出最小值所在下标
				}
			}
			src[samllestLocation] = src[i];
			src[i] = temp;
			
			for (int k = 0; k < src.length; k++) {
				if(k==src.length-1){
					System.out.println(src[k]);
				}else{
					System.out.print(src[k]+" ");
				}
			}
		}
	}
}
