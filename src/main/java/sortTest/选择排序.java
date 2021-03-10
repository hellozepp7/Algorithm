package sortTest;

import java.util.Arrays;

/**
 * <pre>
 * Description:
 *          思路与插入排序很类似，分为已排序和未排序
 *          每次从未排序区间找到最小的元素，将其放到已排序区间的末尾。
 *          但是不会像插入排序会移动数组，而是进行交换。
 *          时间复杂度O(n²)，空间复杂度O(n)，稳定性不稳定
 * @author Zepp Deng
 * @date 2021/3/9
 * </pre>
 */
public class 选择排序 {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 0, 1, 3, 2};
        // 做第i次排序
        for (int i = 0; i < arr.length - 1; i++) {
            int k = i;
            // 选最小的记录
            for (int j = k + 1; j < arr.length; j++) {
                if (arr[j] < arr[k]) {
                    //记下目前找到的最小值所在的位置
                    k = j;
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if (i != k) {
                //交换a[i]和a[k]
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
                System.out.println(Arrays.toString(arr));
            }
        }
    }
}
