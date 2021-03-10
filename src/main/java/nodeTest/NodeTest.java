package nodeTest;

import java.util.Stack;

/**
 * <pre>
 * Description:
 *      单向链表反转与约瑟夫问题
 * @author Zepp Deng
 * @date 2021/3/9
 * </pre>
 */
public class NodeTest {

    public static void main(String... strings) {
        DataChain chain = new DataChain(10);
        printChain(chain.getHead());
        DataNode dataNode1 = reverse1(chain.getHead());
        printChain(dataNode1);
        DataNode dataNode2 = reverse2(dataNode1);
        printChain(dataNode2);
        DataNode dataNode3 = reverse3(dataNode2);
        printChain(dataNode3);
        count(41);
    }

    /**
     * @Description:
     *         初始化单向链表
     * @Author Zepp Deng [2021-03-09 10:55]
     */
    public static class DataChain {
        private DataNode head;

        public DataNode getHead() {
            return head;
        }

        public void setHead(DataNode head) {
            this.head = head;
        }

        public DataChain(int size) {
            DataNode head = new DataNode(0);
            DataNode cur = head;
            for (int i = 1; i < size; i++) {
                DataNode tmp = new DataNode(i);
                cur.setNext(tmp);
                cur = tmp;
            }
            this.head = head;
        }
    }

    /**
     * @Description:
     *          构造单向链表node
     * @Author Zepp Deng [2021-03-09 10:51] 
     */
    public static class DataNode {

        private int data;
        private DataNode next;

        public int getData() {
            return data;
        }
        public void setData(int data) {
            this.data = data;
        }
        public DataNode getNext() {
            return next;
        }
        public void setNext(DataNode next) {
            this.next = next;
        }
        public DataNode(int data) {
            this.data = data;
        }
    }

    /**
     * @Description:
     *          打印链表内容
     * @Author Zepp Deng [2021-03-09 10:52]
     * @param head
     */
    public static void printChain(DataNode head) {
        StringBuilder sb = new StringBuilder();
        DataNode cur = head;
        sb.append(cur.getData());
        while (null != cur.getNext()) {
            sb.append(" -> ");
            sb.append(cur.getNext().getData());
            cur = cur.getNext();
        }
        System.out.println(sb.toString());
    }

    /**
     * @Description:
     *          递归实现链表反转
     *          递归都在java栈中进行，需要考虑jdk支持的栈的深度
     *          在jdk1.8.0_91版本中，当上述链表长度大于12000则会出现StackOverFlowError错
     * @Author Zepp Deng [2021-03-09 10:57]
     * @param head
     * @Return DataNode
     */
    public static DataNode reverse1(DataNode head) {
        if (null == head || null == head.getNext())
            return head;
        DataNode revHead = reverse1(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return revHead;
    }

    /**
     * @Description:
     *          遍历实链表反转
     *          最好的方法是采用遍历
     * @Author Zepp Deng [2021-03-09 10:58]
     * @param head
     * @Return DataNode
     */
    public static DataNode reverse2(DataNode head) {
        if (null == head || null == head.getNext())
            return head;
        DataNode pre = head;
        DataNode cur = head.getNext();
        while (null != cur.getNext()) {
            DataNode tmp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = tmp;
        }
        cur.setNext(pre);
        head.setNext(null);
        return cur;
    }

    /**
     * @Description:
     *          利用栈先进后出实现，效率较低
     * @Author Zepp Deng [2021-03-09 11:06]
     * @param head
     * @Return DataNode
     */
    public static DataNode reverse3(DataNode head) {
        Stack<DataNode> stack = new Stack<>();
        for (DataNode node = head; null != node; node = node.getNext()) {
            stack.add(node);
        }
        DataNode reHead = stack.pop();
        DataNode cur = reHead;
        while(!stack.isEmpty()){
            cur.setNext(stack.pop());
            cur = cur.getNext();
            cur.setNext(null);
        }
        return reHead;
    }

    /**
     * @Description:
     *          链表解决约瑟夫问题
     * @Author Zepp Deng [2021-03-09 11:28]
     * @param n
     */
    public static void count(int n) {
        //数到3出局，中间间隔两个人
        int k = 3;
        //头结点不存储数据
        DataNode head = new DataNode(n);
        DataNode cur = head;
        //循环构造这个链表
        for (int i = 1; i <= n; i++) {
            DataNode node = new DataNode(i);
            cur.next = node;
            cur = node;
        }
        //链表有数据的部分首尾相连形成一个环。
        cur.next = head.next;
        //统计开始的时候，刨去头结点，然后从第一个有数据的结点开始报数
        DataNode p = head.next;
        //循环退出的条件是最后只剩一个结点，也就是这个结点的下一个结点是它本身
        while (p.next != p) {
            //正常报数的遍历逻辑
            for (int i = 1; i < k - 1; i++) {
                p = p.next;
            }
            //当数到3的时候，出局
            System.out.print(p.next.data + "->");
            p.next = p.next.next;
            p = p.next;
        }
        //最后剩下的一个结点
        System.out.println("(left:" + p.data + ")");
    }

}
