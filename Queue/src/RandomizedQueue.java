import java.util.Iterator;


public class RandomizedQueue<Item> implements Iterable<Item> {

	private int headIndex;
	private int tailIndex;
	private int capacity;
	private int count;
	private int [] indexQueue;
	private Item[] queue;
	
	public RandomizedQueue(){
		this.headIndex = 0;
		this.tailIndex = 0;
		this.count = 0;
		
		// initial capacity = 1
		this.capacity = 1;
		
		// we cannot make the Generic array directly so we create the object array and cast it
		queue = (Item [])new Object[capacity];
	}
	
	public boolean isEmpty(){
		return (count == 0);
	}
	
	public int size(){
		return count;
	}
	
	public void resize(){
		
	}
	
	public void enqueue(Item item){
		
	}
	
	public Item dequeue(){
		
	}
	
	public Item sample(){
		
	}
	
	@Override
	public Iterator<Item> iterator() {
		
		// *** Anonymous class object that implements Iterator interface ***
		// Anonymous class is used to create an instance of class that either IMPLEMENTS INTERFACE
		// or EXTENDS ANOTHER CLASS
		Iterator<Item> it = new Iterator<Item>(){

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Item next() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}			
		};
		return it;
	}
	
}
