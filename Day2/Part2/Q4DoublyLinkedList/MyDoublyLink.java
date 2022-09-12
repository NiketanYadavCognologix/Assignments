package com.cognologix.Day2.Part2.Q4DoublyLinkedList;


public class MyDoublyLink<xyz> {

	xyz data;
	Node<xyz> head;
	Node<xyz> tail;
	
	void add(xyz data)
	{
		if(head==null)
		{
			head=new Node<xyz>(data);
			tail=head;
		}
		else
			
			
		{
			Node<xyz> obj=new Node<xyz>(data);
			tail.next=obj;
			obj.prev=tail;
			tail=obj;
		}
	}
	
	void printfrd()
	{
		Node<xyz> temp=head;
		
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	
	void printbck()
	{
		Node <xyz> temp=tail;
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp=temp.prev;
		}
		
	}
	
//*************************************************************
	
	boolean contains(xyz data)
	{
		Node<xyz> temp=head;
		
		while(temp!=null)
		{
			if(temp.data==data)
				return true;
			temp=temp.next;
		}
		return false;
	}
	
//************************************************************
	
	int size()
	{
		Node<xyz> temp=head;
		int index=0;
		while(temp!=null)
		{
			index++;
			temp=temp.next;
		}
		return index;
		
	}
	
//************************************************************
	
	int indexOf(xyz data)
	{
		Node<xyz> temp=head;
		int index=0;
		while(temp!=null)
		{
			if(temp.data==data)
			{
				return index;
			}
			temp=temp.next;
			index++;
		}
		throw new IndexOutOfBoundsException();
			
	}
	
//**********************************************************
	
	int lastIndexOf(xyz data)
	{
		Node<xyz> temp=head;
		int index=0;
		int p=-1;
		while(temp!=null)
		{
			if(temp.data==data)
			{
				p=index;
			}
			temp=temp.next;
			index++;
		}
		return p;
		
	}
	
//********************************************************
	
	xyz get(int i)
	{
		if(i<0)
			throw new IndexOutOfBoundsException();

		Node<xyz> temp=head;
		int index=0;
		while(temp!=null)
		{
			if(index==i)
				 return temp.data;
			temp=temp.next;
			index++;
		}
		throw new IndexOutOfBoundsException();
	}
	
//***********************************************************
	
	void set(int i,xyz data)
	{
		if(i<0)
			throw new IndexOutOfBoundsException();
		
		Node<xyz> temp=head;
		int index=0;
		
		while(temp!=null)
		{
			if(index==i)
			{
				temp.data=data;
				return;
			}
			temp=temp.next;
			index++;
			
		}
		
		throw new IndexOutOfBoundsException();
	}
	
//******************************************************************
	
	public String toString()
	{
		Node<xyz> temp=head;
		String s="";
		while(temp!=null)
		{
			s=s+temp.data+" ";
			temp=temp.next;
		}
		return s;
	}
	
//*********************************************************
	
	Object[] toAray()
	{
		Node<xyz> temp=head;
		Object [] b=new Object[size()];
		int index=0;
		while(temp!=null)
		{
			b[index]= temp.data;
			index++;
			
			temp=temp.next;
		}
		return b;
	}
	
//**********************************************************
	
	void remove(int i)
	{
		if(i<0)
			throw new IndexOutOfBoundsException();
		if(i==0)
		{
			head=head.next;
			head.prev=null;
			return;
		}
		Node<xyz> temp=head;
		int index=0;
		
		while(temp!=null)
		{
			if(index==i-1)
			{
				
				if(temp.next==null)
					throw new IndexOutOfBoundsException();
				if(temp.next.next==null)
				{
					temp.next=null;
					tail=temp;
					return;
				}
				else 
				{
					temp.next=temp.next.next;
					temp.next.prev=temp;
					return;
				}
			}
			temp=temp.next;
			index++;
		}
		throw new IndexOutOfBoundsException();
	}
	
//*************************************************************
	
	void add(int i,xyz data)
	{
		if(i<0)
			throw new IndexOutOfBoundsException();
		if(i==0)
		{
			Node<xyz> obj=new Node<>(data);
			obj.next=head;
			head.prev=obj;
			head=obj;
			return;
		}
		Node<xyz> temp=head;
		
		int index=0;
		
		while(temp!=null)
		{
			if(index==i-1)
			{
					if(temp.next==null)
						throw new IndexOutOfBoundsException();
				Node<xyz> obj =new Node<>(data);
				temp.next.prev=obj;
				obj.next=temp.next;
				obj.prev=temp;
				temp.next=obj;
				return;
				
			}
					
			temp=temp.next;
			index++;
		}
		throw new IndexOutOfBoundsException();
	}
}