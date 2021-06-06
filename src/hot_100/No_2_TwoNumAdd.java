package hot_100;

/**
 * 2. 两数相加 中等  @link https://leetcode-cn.com/problems/add-two-numbers/
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * 示例 1： 输入：l1 = [2,4,3], l2 = [5,6,4] 输出：[7,0,8] 解释：342 + 465 = 807.
 * 示例 2： 输入：l1 = [0], l2 = [0]         输出：[0]
 * 示例 3： 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] 输出：[8,9,9,9,0,0,0,1]
 */
public class No_2_TwoNumAdd {
    public static void main(String[] args) {
        System.out.println(addTwoNuM(ListNode.createListNode(2, 4, 3), ListNode.createListNode(5, 6, 4)));
        System.out.println(addTwoNuM(ListNode.createListNode(9, 9, 9), ListNode.createListNode(9, 9, 9)));
        System.out.println(addTwoNuM(null, null));
    }

    private static ListNode addTwoNuM(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode resultNode = null;
        ListNode resultHeaderNode = null;
        boolean isNeedPlusOne = false;
        while (!(temp1 == null && temp2 == null && !isNeedPlusOne)) {
            int val = (temp1 == null ? 0 : temp1.val) + (temp2 == null ? 0 : temp2.val) + (isNeedPlusOne ? 1 : 0);
            isNeedPlusOne = val >= 10;
            val = val >= 10 ? (val - 10) : val;
            ListNode node = new ListNode(val);
            if (resultNode == null) {
                resultNode = node;
                resultHeaderNode = resultNode;
            } else {
                resultNode.next = node;
                resultNode = resultNode.next;
            }
            temp2 = temp2 == null ? null : temp2.next;
            temp1 = temp1 == null ? null : temp1.next;
        }
        return resultHeaderNode;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode h = this;
            sb.append(h.val);
            while (true) {
                if (h.next != null) {
                    h = h.next;
                    sb.append(h.val);
                } else {
                    break;
                }
            }
            return sb.toString();
        }

        private static ListNode createListNode(int... nums) {
            ListNode headerNode = null;
            ListNode prevNode = null;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (prevNode == null) {
                    prevNode = new ListNode(num);
                    headerNode = prevNode;
                } else {
                    prevNode.next = new ListNode(num);
                    prevNode = prevNode.next;
                }
            }
            return headerNode;
        }
    }
}
