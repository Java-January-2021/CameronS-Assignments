package com.doublylinkedlist.dll;

public class DLLTest {

	public static void main(String[] args) {
		DLL dll = new DLL();
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(50);
        Node n4 = new Node(60);
        Node n5 = new Node(80);
        Node n6 = new Node(100);
        Node n7 = new Node(5);
        Node n8 = new Node(30);
        Node n9 = new Node(25);
        Node n10 = new Node(55);
        
        dll.pushEnd(n1);
        dll.pushEnd(n2);
        dll.pushEnd(n3);
        dll.pushEnd(n4);
        dll.pushEnd(n5);
        dll.pushEnd(n6);
        dll.pushFront(n7);
        dll.deleteEnd();
        dll.deleteFront();
        dll.deleteNodeValue(10);
        dll.printValuesForward();
        dll.insertBeforeNode(n8, n3);
        dll.insertBeforeNode(n9, n8);
        dll.insertBeforeNode(n10, n4);
        dll.printValuesForward();
        dll.printValuesReverse();
	}

}
