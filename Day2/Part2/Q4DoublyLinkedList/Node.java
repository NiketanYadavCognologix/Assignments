package com.cognologix.Day2.Part2.Q4DoublyLinkedList;


public class Node<xyz> {
	
	xyz data;
	Node<xyz> next;
	Node<xyz> prev;
	
	Node(xyz data)
	{
		this.data=data;
		// here no need to initialize next & prev because of they intitialized by default
	}

}