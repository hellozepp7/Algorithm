package sortTest;

import java.util.Arrays;

/**
 * <pre>
 * Description:
 *          核心思想递归跟分治，时间复杂度O(n㏒n)
 * @author Zepp Deng
 * @date 2021/3/9
 * </pre>
 */
public class 归并排序 {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 0, 1, 3, 2};
        //递：传入数组与起始于结尾的下标，
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            //每次取中间位置下标，分左右再次传入进行拆分
            int mid = (left + right) / 2;
            //对左边序列进行归并排序
            mergeSort(arr, left, mid);
            //对右边序列进行归并排序
            mergeSort(arr, mid + 1, right);
            //合并两个有序序列
            System.out.println(Arrays.toString(arr));
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        //新建一个临时数组用来保存合并的数据
        int[] tmp = new int[arr.length];
        //左边第一个数的位置
        int pointLeft = left;
        //右边第一个数的位置
        int pointRight = mid + 1;
        int loc = left;
        //两个指针指向左右两个序列的第一个数，然后循环比较
        //哪个小就放入新数组，然后放入的序列指针往后移动，然后再次比较
        while (pointLeft <= mid && pointRight <= right) {
            if (arr[pointLeft] < arr[pointRight]) {
                tmp[loc] = arr[pointLeft];
                pointLeft++;
                loc++;
            } else {
                tmp[loc] = arr[pointRight];
                pointRight++;
                loc++;
            }
        }
        //若左边序列还有剩余，则将其全部拷贝进tmp[]中
        while (pointLeft <= mid) {
            tmp[loc++] = arr[pointLeft++];
        }
        while (pointRight <= right) {
            tmp[loc++] = arr[pointRight++];
        }
        //数组赋值给原数组
        if (right + 1 - left >= 0) System.arraycopy(tmp, left, arr, left, right + 1 - left);
    }

}
