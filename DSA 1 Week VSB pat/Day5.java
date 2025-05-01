// Problem Statement
// Imagine a circular conveyor belt where each container has an ID number, and the sum of its digits reflects specific traits. Your task is to remove all containers with an even-digit sum, leaving only those with an odd-digit sum to proceed. The conveyor belt is modelled as a circular linked list, where each node represents a container. 

// You need to efficiently filter out these nodes while preserving the circular structure.

// Example

// Input: 

// 9 11 34 6 13 21

// Output:

// 9 34 21 

// Explanation: 

// The circular linked list contains

// 9: 9 

// 11: 11 = 1+1 = 2 

// 34: 34 = 3+4 = 7 

// 6: 6  

// 13: 13 = 1+3 = 4 

// 21: 21 = 2+1 = 3 

// Here, the digit sum for nodes containing 11, 6, and 13 are even. Hence, these nodes are deleted and the remaining nodes are printed.

// Input format :
// The first line of input consists of an integer N, representing the number of elements in the circular linked list.

// The second line consists of N space-separated positive integers, each denoting an element in the circular linked list.

// Output format :
// The output prints the elements of the modified circular linked list after removing nodes with even digit sums.

// Refer to the sample output for formatting specifications.

// Code constraints :
// The given test cases fall under the following specifications:

// 1 ≤ N ≤ 30

// 1 ≤ elements ≤ 100

// Sample test cases :
// Input 1 :
// 6
// 9 11 34 6 13 21
// Output 1 :
// 9 34 21 
// Input 2 :
// 5
// 34 56 78 92 36
// Output 2 :
// 34 56 78 92 36 

import java.util.Scanner;

// Structure for a node in the linked list
class Node {
    int data;
    Node next;

    Node(int value) {
        this.data = value;
        this.next = null;
    }
}

// Main class containing the methods
class CircularLinkedList {

    // Function to insert a new node at the end of the linked list
    static void insert(Node[] head, int value) {
        Node newNode = new Node(value);

        if (head[0] == null) {
            head[0] = newNode;
            newNode.next = head[0];  // Circular link
        } else {
            Node temp = head[0];
            while (temp.next != head[0]) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head[0];  // Circular link
        }
    }

    static void removeEvenDigitSumNodes(Node[] headArray) {
        Node head = headArray[0];

        Node dummy = new Node(-1);
        dummy.next = head;
        Node prev = dummy;
        Node cur = head;
        boolean firstpass = true;

        do {
            if (iseven(cur.data)) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
            if (head == prev.next) firstpass = false;
        } while (cur != head || firstpass);

        headArray[0] = dummy.next;
    }

    static boolean iseven(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum % 2 == 0;
    }

    static void display(Node head) {
        if (head == null) return;

        Node temp = head;
        System.out.print(temp.data + " ");
        temp = temp.next;
        while (temp != head) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}

public class Day5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node[] head = new Node[1];
        int n = scanner.nextInt();

        for (int i = 0; i < n; ++i) {
            int value = scanner.nextInt();
            CircularLinkedList.insert(head, value);
        }

        CircularLinkedList.removeEvenDigitSumNodes(head);
        CircularLinkedList.display(head[0]);
        scanner.close();
    }
}
