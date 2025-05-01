// Problem Statement

// In modern operating systems, multiple applications run concurrently and are managed efficiently. A Circular Linked List (CLL) is an effective data structure that can be used to organize and iterate over these running applications in a cyclic manner.

// Write a program to implement a Circular Linked List that stores the names of currently running applications. The program should accept application names as input and allow iteration over them. If no applications are provided, it should indicate that there are no running applications.

// Input format :
// The input consists of multiple lines, where each line contains the name of an application.

// The input process continues until the user enters 'exit', signaling the end of the input.

// Refer to the sample input for a better understanding.

// Output format :
// The first line of output prints "Circular Linked List - Running Applications"

// If applications were added:

// The next line prints "Running Applications:"
// Followed by each application name on a new line in the order they were added.
// If no applications were added before typing exit:

// It directly prints "No applications to iterate."


// Refer to the sample output for formatting specifications.

// Code constraints :
// The given test cases fall under the following constraints:

// Each application name is a string with a maximum length of 100 characters.

// Sample test cases :
// Input 1 :
// Microsoft Office Suite
// Adobe Creative Cloud
// Google Chrome
// Mozilla Firefox
// VLC Media Player
// Skype
// exit
// Output 1 :
// Circular Linked List - Running Applications

// Running Applications:
// Microsoft Office Suite
// Adobe Creative Cloud
// Google Chrome
// Mozilla Firefox
// VLC Media Player
// Skype
// Input 2 :
// exit
// Output 2 :
// Circular Linked List - Running Applications

// No applications to iterate.

import java.util.Scanner;

// Node structure for Circular Linked List
class Node {
    String appName;
    Node next;

    Node(String appName) {
        this.appName = appName;
        this.next = null;
    }
}

// Circular Linked List Class
class CircularLinkedList {
    Node head = null;

    // Method to add application to Circular Linked List
    public void addApplication(String appName) {
        Node newNode = new Node(appName);

        if (head == null) {
            head = newNode;
            newNode.next = head;  // Circular link
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;  // Circular link
        }
    }

    // Method to display all applications in the Circular Linked List
    public void displayApplications() {
        if (head == null) {
            System.out.println("No applications to iterate.");
        } else {
            System.out.println("Running Applications:");
            Node temp = head;
            do {
                System.out.println(temp.appName);
                temp = temp.next;
            } while (temp != head);
        }
    }
}

public class Day6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularLinkedList appList = new CircularLinkedList();

        System.out.println("Circular Linked List - Running Applications");
        while (true) {
            String appName = scanner.nextLine().trim();

            if (appName.equalsIgnoreCase("exit")) {
                break;
            } else {
                appList.addApplication(appName);
            }
        }

        appList.displayApplications();
        scanner.close();
    }
}
