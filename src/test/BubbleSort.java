package test;
/**
 * 冒泡排序
 * @author Administrator
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] src = { 9, 2, 4, 5, 8 };
		int len = src.length;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				int temp;
				if (src[i] > src[j]) {
					temp = src[j];
					src[j] = src[i];
					src[i] = temp;
				}
			}
			for (int k = 0; k < src.length; k++) {
				if(k==src.length-1){
					System.out.println(src[k]);
				}else{
					System.out.print(src[k]+"  ");
				}
			}
		}
	}
}
