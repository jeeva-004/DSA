import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Main {

    static boolean detectCycle(ListNode head) {
        ListNode rabit = head;
        ListNode totoys = head;
        while (rabit != null && rabit.next != null) {
            rabit = rabit.next.next;
            totoys = totoys.next;
            if (rabit == totoys)
                return true;
        }
        return false;
    }

    static ListNode returnCycleStart(ListNode head) {
        ListNode rabit = head;
        ListNode totoys = head;

        while (rabit != null && rabit.next != null) {
            rabit = rabit.next.next;
            totoys = totoys.next;
            if (rabit == totoys) {
                totoys = head;
                while (totoys != rabit) {
                    totoys = totoys.next;
                    rabit = rabit.next;
                }
                return totoys;
            }
        }

        return null;
    }

    static void removeCycle(ListNode head) {
        ListNode rabit = head;
        ListNode totoys = head;
        while (rabit != null && rabit.next != null) {
            rabit = rabit.next.next;
            totoys = totoys.next;
            ListNode previous = null;
            if (rabit == totoys) {
                totoys = head;
                while (totoys != rabit) {
                    previous = rabit;
                    rabit = rabit.next;
                    totoys = totoys.next;
                }
                previous.next = null;
            }
        }
    }

    public static void main(String[] args) {

    }
}
