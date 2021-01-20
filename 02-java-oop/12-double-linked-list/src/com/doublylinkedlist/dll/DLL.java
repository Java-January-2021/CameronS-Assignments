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
    public Node popEnd() {
    	if(this.head == null) {
    		System.out.println("List is empty.");
    	}
    	Node popped = this.tail;
    	Node nextToLastNode = this.tail.previous;
    	nextToLastNode.next = null;
    	this.tail = nextToLastNode;
    	return popped;
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
    public Node popFront() {
    	if(this.head == null) {
    		System.out.println("List is empty.");
    	}
    	Node popped = this.head;
    	Node secondNode = this.head.next;
    	secondNode.previous = null;
    	this.head = secondNode;
    	return popped;
    }
    public void printValuesForward() {
        Node current = this.head;
        while(current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
    public boolean containsValue(int value) {
    	if(this.head == null) {
    		System.out.println("List is empty.");
    	}
    	Node current = this.head;
        while(current != null) {
        	if(current.value == value) {
        		return true;
        	}
        	current = current.next;
        }
        return false;
    }
    public int size() {
    	if(this.head == null) {
    		System.out.println("List is empty.");
    	}
    	int size = 0;
    	Node current = this.head;
    	while(current != null) {
    		size += 1;
    		current = current.next;
    	}
    	System.out.println("List size: "+size);
    	return size;
    }
    public void popNodeValue(Integer input) {
    	if(this.head == null) {
    		System.out.println("List is empty.");
    	}
    	else if(this.head.value.equals(input)) {
    		popFront();
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
    public void pushBeforeNode (Node newNode, Node input) {
    	if(this.head == null) {
    		System.out.println("List is empty.");
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
