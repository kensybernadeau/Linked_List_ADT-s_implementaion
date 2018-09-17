package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import linkedLists.LinkedList;

public class SLFLList<E> implements LinkedList<E>{

	private SNode<E> first, last; 
	private int length; 
	
	//constructor 
	public SLFLList() { 
		first = last = null; 
		length=0;
	}
	
	
	public void addFirstNode(Node<E> nuevo) {
		// TODO Auto-generated method stub
		
		if (length == 0){
		((SNode<E>) nuevo).setNext(first);
		 last = (SNode<E>) nuevo;
		 first = (SNode<E>) nuevo;
		}
		else{
		((SNode<E>) nuevo).setNext(first);
		 first = (SNode<E>) nuevo;
		}
		length++;
			
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		// TODO Auto-generated method stub
		SNode<E> prevNode = (SNode<E>) target;
		SNode<E> nextNode = (SNode<E>) nuevo;
		
		if(prevNode== last){
		
			(prevNode).setNext(nextNode);
			last= nextNode;
			nextNode.setNext(null);	
		}
		else{
		
		(nextNode).setNext(prevNode.getNext());
		(prevNode).setNext(nextNode);
		}
		length ++;
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		// TODO Auto-generated method stub
		if(target==first)  {
			this.addFirstNode(nuevo); 
			
			
		}
	
		else{
			
		Node<E> prevNode = findNodePrevTo(target);
		
		this.addNodeAfter(prevNode, nuevo);
		}
		
	}
	
	
	private Node<E> findNodePrevTo( Node<E> target){
		
		if(target==first) return null;
		else{
		
		SNode<E> prev = first;
		while(prev != null && prev.getNext() != target)
           prev = prev.getNext();		
		return prev;
		}
	}

	public Node<E> getFirstNode() throws NodeOutOfBoundsException {
		// TODO Auto-generated method stub
		if(first==null) throw new NodeOutOfBoundsException("getFirstNode() : linked list is empty..."); 
		
		return first;
	}

	public Node<E> getLastNode() throws NodeOutOfBoundsException {
		// TODO Auto-generated method stub
		if(last==null) throw new NodeOutOfBoundsException("getlastNode() : linked list is empty..."); 
		
		return last;
	}

	public Node<E> getNodeAfter(Node<E> target) throws NodeOutOfBoundsException {
		// TODO Auto-generated method stub
		SNode<E> aNode = ((SNode<E>) target).getNext();
		if(aNode== null) throw new NodeOutOfBoundsException("getNextNode(...) : target is the last node."); 
		
			return aNode;
	}

	public Node<E> getNodeBefore(Node<E> target)throws NodeOutOfBoundsException {
		// TODO Auto-generated method stub
		
		if (target == first) throw new NodeOutOfBoundsException("getNodeBefore(...) : target is the first node."); 
			
		return findNodePrevTo(target);
	}

	public int length() {
		// TODO Auto-generated method stub
		return length;
	}

	public void removeNode(Node<E> target) {
		// TODO Auto-generated method stub
		
		if(target==first){
			SNode<E> ntr = (SNode<E>) target;
			first= ntr.getNext();
			ntr.setNext(null);
			
			
		}
		
		
		else{	
		
		SNode<E> prevNode = (SNode<E>) findNodePrevTo(target);
		(prevNode).setNext(((SNode<E>) target).getNext());
	    
			
		}
		 ((SNode<E>) target).setNext(null);
	     length--;
	}
	
	public Node<E> createNewNode() {
		return new SNode<E>();
	}


	///////////////////////////////////////////////////
	// private and static inner class that defines the 
	// type of node that this list implementation uses
	private static class SNode<T> implements Node<T> {
		private T element; 
		private SNode<T> next; 
		public SNode() { 
			element = null; 
			next = null; 
		}
		public SNode(T data, SNode<T> next) { 
			this.element = data; 
			this.next = next; 
		}
		public SNode(T data)  { 
			this.element = data; 
			next = null; 
		}
		public T getElement() {
			return element;
		}
		public void setElement(T data) {
			this.element = data;
		}
		public SNode<T> getNext() {
			return next;
		}
		public void setNext(SNode<T> next) {
			this.next = next;
		}
	}

}