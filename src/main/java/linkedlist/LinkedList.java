package linkedlist;

/**
 * @author: yuegc
 * @Date: 2021/5/26 11:58
 * @Description: 查找链表中倒数第n个元素
 */
public class LinkedList {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private static Node buildLinkedList(int[] array) {
        Node head = new Node(array[0]);
        Node next = head;
        for (int i = 1; i < array.length; i++) {
            Node node = new Node(array[i]);
            next.next = node;
            next = node;
        }
        return head;
    }

    private static int findNNode(Node head, int n) {
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < n - 1; i++) {
            p2 = p2.next;
            if (p2 == null) {
                throw new IllegalArgumentException("超过链表长度");
            }
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1.data;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,5,8,1,4,9,7,6,2,0};
        Node head = buildLinkedList(array);
        int data = findNNode(head, 2);
        System.out.println(data);
    }
}
