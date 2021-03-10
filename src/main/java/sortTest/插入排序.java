package sortTest;

import java.util.Arrays;

/**
 * <pre>
 * Description:
 *      1.将数组分为已排序和未排序段，初始化时已排序端只有一个元素。
 *      2.到未排序段取元素插入到已排序段，并保证插入后仍有序
 *      3.重复执行上述过程直到全部排序完。
 * @author Zepp Deng
 * @date 2021/3/9
 * </pre>
 */
public class 插入排序 {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 0, 1, 3, 2};
        int n = arr.length;
        //从1开始，第一个不用排序，我们数组从i分开，0-i代表已经排好序
        for (int i = 1; i < n; i++) {
            int data = arr[i];
            int j = i - 1;
            //从已排序的最后往前对比，避免后移问题
            for (; j >= 0; j--) {
                if (arr[j] > data) {
                    //1.将被对比的数放到当前位置
                    arr[j + 1] = arr[j];
                } else {
                    //前面已经排好序，比当前位置的数小说明位置正确不需要再对比
                    break;
                }
            }
            //2.将当前的数放到之前对比的位置
            arr[j + 1] = data;
            System.out.println(Arrays.toString(arr));
        }
    }
}
