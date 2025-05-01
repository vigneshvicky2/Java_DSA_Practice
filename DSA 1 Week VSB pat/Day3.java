// Problem Statement

// Tom is a software developer working on a project where he has to check if a doubly linked list is a palindrome. He needs to write a program to solve this problem. Write a program to help Tom check if a given doubly linked list is a palindrome or not.

// Input format :
// The first line consists of an integer N, representing the number of elements in the linked list.

// The second line consists of N space-separated integers representing the linked list elements.

// Output format :
// The first line of output displays the elements of the doubly linked list in forward order, separated by spaces.

// The second line of output displays the elements of the doubly linked list in reverse order, separated by spaces.

// The third line prints:

// "The doubly linked list is a palindrome" if the list reads the same forward and backward.
// "The doubly linked list is not a palindrome" if the list does not match when reversed.
// Refer to the sample output for the formatting specifications.

// Code constraints :
// In this scenario, the test cases fall under the following constraints:

// 2 ≤ N ≤ 20

// -100 ≤ elements ≤ 100

// Sample test cases :
// Input 1 :
// 5
// 1 2 3 2 1
// Output 1 :
// 1 2 3 2 1 
// 1 2 3 2 1 
// The doubly linked list is a palindrome
// Input 2 :
// 5
// 1 2 3 4 5
// Output 2 :
// 1 2 3 4 5 
// 5 4 3 2 1 
// The doubly linked list is not a palindrome
// Input 3 :
// 6
// -1 -2 -3 -3 -2 -1
// Output 3 :
// -1 -2 -3 -3 -2 -1 
// -1 -2 -3 -3 -2 -1 
// The doubly linked list is a palindrome

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

    // Print forward
    public void printForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Print reverse
    public void printReverse() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    // Check if palindrome
    public boolean isPalindrome() {
        Node left = head;
        Node right = tail;

        while (left != null && right != null && left != right && right.next != left) {
            if (left.data != right.data)
                return false;
            left = left.next;
            right = right.prev;
        }
        return true;
    }
}

public class Day3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        DoublyLinkedList dll = new DoublyLinkedList();

        for (int i = 0; i < n; i++) {
            dll.insert(sc.nextInt());
        }

        dll.printForward();
        dll.printReverse();

        if (dll.isPalindrome()) {
            System.out.println("The doubly linked list is a palindrome");
        } else {
            System.out.println("The doubly linked list is not a palindrome");
        }
    }
}
