
// Problem Statement

// You are working on a student database system for a school. The system maintains student records using a Singly Linked List. Each student is represented by a unique roll number consisting of four digits. The student records are added to the front of the list.

// Write a program that creates a function that efficiently deletes all student records whose roll number starts with a given prefix.
// Example
// Input:
// 5
// 1001
// 2001
// 1002
// 3001
// 4001
// 10

// Output:
// Roll: 4001
// Roll: 3001
// Roll: 2001

// Explanation:
// The linked list is constructed as follows:
// Insert 1001: 1001 -> nullptr
// Insert 2001: 2001 -> 1001 -> nullptr
// Insert 1002: 1002 -> 2001 -> 1001 -> nullptr
// Insert 3001: 3001 -> 1002 -> 2001 -> 1001 -> nullptr
// Insert 4001: 4001 -> 3001 -> 1002 -> 2001 -> 1001 -> nullptr

// The program then reads the prefix "10" for deletion. Roll numbers 1001, 1002, and 2001 start with the prefix "10", so these records are deleted, resulting in the final output: 4001, 3001, 2001.

// Note: Array implementations will not be supported.

// Input format :
// The first line contains an integer n, representing the number of student records in the list.

// The next n lines each contain n student's roll numbers as a string in each line.

// The last line contains a string, str representing the prefix of the roll number.

// Output format :
// After deleting all records whose roll number starts with the specified prefix, the output prints the updated list of student records.

// Each line should contain a student's record in the format: "Roll: XXXX", where 'XXXX' is the four-digit roll number.

// Refer to the sample outputs for the formatting specifications.

// Code constraints :
// 1 ≤ n ≤ 10

// The roll number is a string of exactly four digits (e.g., "1234").

// Sample test cases :
// Input 1 :
// 5
// 1001
// 2001
// 1002
// 3001
// 4001
// 10
// Output 1 :
// Roll: 4001
// Roll: 3001
// Roll: 2001
// Input 2 :
// 3
// 1501
// 1502
// 1403
// 15
// Output 2 :
// Roll: 1403
// Input 3 :
// 4
// 1234
// 3456
// 7890
// 4987
// 21
// Output 3 :
// Roll: 4987
// Roll: 7890
// Roll: 3456
// Roll: 1234
import java.util.Scanner;

class Node {
    String roll;
    Node next;

    Node(String roll) {
        this.roll = roll;
        this.next = null;
    }
}

class StudentList {
    private Node head;

    // Insert at front
    public void insertFront(String roll) {
        Node newNode = new Node(roll);
        newNode.next = head;
        head = newNode;
    }

    // Delete nodes starting with given prefix
    public void deleteByPrefix(String prefix) {
        // Handle head nodes
        while (head != null && head.roll.startsWith(prefix)) {
            head = head.next;
        }

        Node current = head;
        while (current != null && current.next != null) {
            if (current.next.roll.startsWith(prefix)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    // Display final list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println("Roll: " + current.roll);
            current = current.next;
        }
    }
}

public class Day1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        StudentList list = new StudentList();

        for (int i = 0; i < n; i++) {
            String roll = sc.nextLine().trim();
            list.insertFront(roll);
        }

        String prefix = sc.nextLine().trim();
        list.deleteByPrefix(prefix);
        list.display();
    }
}
