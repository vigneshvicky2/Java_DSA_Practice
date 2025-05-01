// Problem Statement

// Pranav wants to clockwise rotate a doubly linked list by a specified number of positions. He needs your help to implement a program to achieve this. Given a doubly linked list and an integer representing the number of positions to rotate, write a program to rotate the list clockwise.

// Input format :
// The first line of input consists of an integer n, representing the number of elements in the linked list.

// The second line consists of n space-separated linked list elements.

// The third line consists of an integer k, representing the number of positions to rotate the list.

// Output format :
// The output displays the elements of the doubly linked list after rotating it by k positions.

// Refer to the sample output for the formatting specifications.

// Code constraints :
// In this scenario, given test cases will fall under the following constraints:

// 1 ≤ n ≤ 30

// 1 ≤ elements ≤ 1000

// k < n

// Sample test cases :
// Input 1 :
// 5
// 1 2 3 4 5
// 1
// Output 1 :
// 5 1 2 3 4 
// Input 2 :
// 5
// 10 20 30 40 50
// 3
// Output 2 :
// 30 40 50 10 20 

import java.util.Scanner;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head, tail;

    // Insert at end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Rotate list clockwise by k
    public void rotateClockwise(int k) {
        if (k == 0 || head == null || head.next == null) return;

        // Step 1: Find the tail and total length
        Node temp = head;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        // Connect tail to head to make circular
        tail.next = head;
        head.prev = tail;

        // Step 2: Find new head after rotation
        int move = length - k;
        Node newTail = head;
        for (int i = 1; i < move; i++) {
            newTail = newTail.next;
        }

        Node newHead = newTail.next;

        // Break the circle
        newTail.next = null;
        newHead.prev = null;

        head = newHead;
        tail = newTail;
    }

    // Print list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class Day4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        DoublyLinkedList dll = new DoublyLinkedList();

        for (int i = 0; i < n; i++) {
            dll.insert(sc.nextInt());
        }

        int k = sc.nextInt();

        dll.rotateClockwise(k);
        dll.printList();
    }
}
