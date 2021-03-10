package sortTest;

import java.util.Arrays;

/**
 * <pre>
 * Description:
 *          基准数：一般取要排序序列的第一个。基准数的好坏决定了效率的高低。
 *          从后面往前找到比基准数小的进行对换，但是基准数不变，再从前往后找，找到比基准数大的进行对换
 *          重复往前和往后找并对换的操作，直到基准数无法交换，终止第一次操作，此时基准数左边比基准数小，右边比基准数大
 *          左右分别再次快速排序，最后得到的就是有序数组
 * @author Zepp Deng
 * @date 2021/3/9
 * </pre>
 */
public class 快速排序 {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 0, 1, 3, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        //基准数，取序列第一个，而不是arr[0]
        int base = arr[left];
        //表示从左边找的位置和从右边开始找的位置
        int ll = left;
        int rr = right;
        while (ll < rr) {
            //从后面找比基准数小的数
            while (ll < rr && arr[rr] >= base) {
                rr--;
            }
            //表示找到有比之大的
            if (ll < rr) {
                int temp = arr[rr];
                arr[rr] = arr[ll];
                arr[ll] = temp;
                ll++;
            }
            while (ll < rr && arr[ll] <= base) {
                ll++;
            }
            //表示找到有比之大的
            if (ll < rr) {
                int temp = arr[rr];
                arr[rr] = arr[ll];
                arr[ll] = temp;
                rr--;
            }
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
        //分成左右后继续递归
        if (left < ll) {
            quickSort(arr, left, ll - 1);
        }
        if (ll < right) {
            quickSort(arr, ll + 1, right);
        }
    }


}
