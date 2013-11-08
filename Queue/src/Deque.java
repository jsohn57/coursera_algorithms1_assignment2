import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int size;
	
	private class Node{
		Node previous;
		Item item;
		Node next;
	}
	
	public Deque(){
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	public boolean isEmpty(){
		return (size == 0);
	}
	
	public int size(){
		return size;
	}
	
	public void addFirst(Item item) throws NullPointerException {
		// null item addition
		if(item == null){
			throw new NullPointerException();
		}
		Node oldFirst = this.first;
		this.first = new Node();
		this.first.previous = null;
		this.first.item = item;
		this.first.next = oldFirst;
		
		if(this.size++ == 0){
			// in the case of an empty queue oldFirst == null && last = first
			this.last = this.first;
		}
		else{
			// it is the non-empty queue case so the oldFirst != null...
			oldFirst.previous = this.first;			
		}
	}
	
	public void addLast(Item item) throws NullPointerException {
		// null item addition
		if(item == null){
			throw new NullPointerException();
		}
		Node oldLast = this.last;
		this.last = new Node();
		this.last.previous = oldLast;
		this.last.item = item;
		this.last.next = null;
		
		if(this.size++ == 0){
			// in the case of an empty queue oldLast == null && first = last
			this.first = this.last;
		}
		else{
			// it is the non-empty queue case so the oldLst != null...
			oldLast.next = this.last;			
		}
	}
	
	public Item removeFirst() throws NoSuchElementException {
		if(this.isEmpty()){
			throw new NoSuchElementException();
		}
		Node oldFirst = this.first;
		this.first = this.first.next;
		if(first != null){
			this.first.previous = null;
		}
		if(this.size-- < 2){
			this.last = this.first;
		}
		return oldFirst.item;
	}
	
	public Item removeLast(){
		if(this.isEmpty()){
			throw new NoSuchElementException();
		}
		Node oldLast = this.last;
		this.last = oldLast.previous;
		if(last != null){
			this.last.next = null;
		}
		if(this.size-- < 2){
			this.first = this.last;
		}
		return oldLast.item;
	}
	
	public Iterator<Item> iterator(){
		
		// *** anonymous class object that implements Iterator interface ***
		// anonymous class is used to create an instance of class that either IMPLEMENTS INTERFACE
		// or EXTENDS ANOTHER CLASS
		Iterator<Item> it = new Iterator<Item>(){

			private Node current = first;
			@Override
			public boolean hasNext() {
				return (current != null);
			}

			@Override
			public Item next() throws NoSuchElementException {
				if(!hasNext()){
					throw new NoSuchElementException();
				}
				Item result = current.item;
				current = current.next;
				return result;
			}

			@Override
			public void remove() throws UnsupportedOperationException{
				throw new UnsupportedOperationException();
			}
		};
		return it;
	}
}