package sortTest;

import java.util.Arrays;

/**
 * <pre>
 * Description:
 *          先把整个序列排得相对比较有序，
 *          再进行插入排序的时候，需要比较的次数就会变得很少
 *          在插入排序外加一层循环分段
 * @author Zepp Deng
 * @date 2021/3/9
 * </pre>
 */
public class 希尔排序 {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 0, 1, 3, 2};
        int n = arr.length;

        for (int add = n / 2; add >= 1; add /= 2) {
            for (int i = add; i < n; i++) {
                int data = arr[i];
                int j = i - add;
                for (; j >= 0; j -= add) {
                    if (arr[j] > data) {
                        arr[j + add] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + add] = data;
                System.out.println(Arrays.toString(arr));
            }
        }
    }

}
