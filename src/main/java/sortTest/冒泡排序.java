package sortTest;

import java.util.Arrays;

/**
 * <pre>
 * Description:
 *          只会操作相邻的两个数据，比较相邻的两个数据，看是否满足大小关系，不满足就交换
 *          一次冒泡至少让一个元素移到它应该的位置
 * @author Zepp Deng
 * @date 2021/3/9
 * </pre>
 */
public class 冒泡排序 {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 0, 1, 3, 2};
        int n = arr.length;

        //排序的次数
        for (int i = 0; i < n - 1; i++) {
            //具体冒泡n-1-i
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    //引入第三变量，也可以用加减异或
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    System.out.println(Arrays.toString(arr));
                }
            }
        }
    }
}
