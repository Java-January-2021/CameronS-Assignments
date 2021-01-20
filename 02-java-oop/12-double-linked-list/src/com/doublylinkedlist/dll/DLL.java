package com.doublylinkedlist.dll;

public class DLL {
	public Node head;
    public Node tail;
    
    public DLL() {
        this.head = null;
        this.tail = null;
    }
    public void pushEnd(Node newNode) {
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        Node lastNode = this.tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        this.tail = newNode;
    }
    public void deleteEnd() {
    	if(this.head == null) {
    		return;
    	}
    	Node nextToLastNode = this.tail.previous;
    	nextToLastNode.next = null;
    	this.tail = nextToLastNode;
    }
    public void pushFront(Node newNode) {
    	if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
    	Node firstNode = this.head;
    	firstNode.previous = newNode;
    	newNode.next = firstNode;
    	this.head = newNode;
    }
    public void deleteFront() {
    	if(this.head == null) {
    		return;
    	}
    	Node secondNode = this.head.next;
    	secondNode.previous = null;
    	this.head = secondNode;
    }
    public void printValuesForward() {
        Node current = this.head;
        while(current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
    public void deleteNodeValue(Integer input) {
    	if(this.head == null) {
    		return;
    	}
    	else if(this.head.value.equals(input)) {
    		deleteFront();
    	}
    	else {
    	Node current = this.head;
    	while(current != null && current.value != input) {
    		current = current.next;
    	}
    	current.next.previous = current.previous;
    	current.previous.next = current.next;
    	}
    }
    public void insertBeforeNode (Node newNode, Node input) {
    	if(this.head == null) {
    		return;
    	}
    	Node current = this.head;
    	while(current != null && current.next != input) {
    		current = current.next;
    	}
    	Node temp = current.next;
    	current.next = newNode;
    	newNode.previous = current;
    	newNode.next = temp;
    	temp.previous = newNode;
	}
    public void printValuesReverse() {
    	 Node current = this.tail;
    	 while(current != null){
    		 System.out.println(current.value);
    		 current = current.previous;
    	 }
    }
}
