/**
 * <pre>
 * Description:
 *      斐波那契数列,从第三个数开始等于前两个数相加
 *      输入一个整数n，请你输出斐波那契数列的第n项
 * @author Zepp Deng
 * @date 2021/3/9
 * </pre>
 */
public class FibonacciTest {

    static int[] data = new int[20];

    public static void main(String[] args) {
        System.out.println(fab(6));
        System.out.println(noFab(6));
        //初始化数组全为0
        System.out.println(fab2(6));
    }

    /**
     * @Description:
     *          112358,数论思想,递归
     *          时间复杂度是O(2^n)，空间复杂度T(2^n)
     * @Author Zepp Deng [2021-03-09 11:43]
     * @param n
     * @Return int
     */
    public static int fab(int n) {
        if (n <= 2) return 1;
        return fab(n - 1) + fab(n - 2);
    }

    /**
     * @Description:
     *          使用循环解决，时间复杂度O(n)，所有递归一定能转化为循环
     * @Author Zepp Deng [2021-03-09 11:49] 
     * @param n
     * @Return int
     */
    public static int noFab(int n) {
        if (n <= 2) return 1;
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * @Description:
     *          使用数组缓存中间结果，找到存在的树节点直接返回，不再计算
     *          时间复杂度可以降为O(n)
     * @Author Zepp Deng [2021-03-09 11:53]
     * @param n
     * @Return int
     */
    public static int fab2(int n) {
        if (n <= 2) return 1;
        //找到存在的树节点直接返回，不再计算
        if (data[n]>0){
            return data[n];
        }
        int res = fab2(n-1)+fab2(n-2);
        data[n] = res;
        return res;
    }

}
