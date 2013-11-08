
import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue<Item> implements Iterable<Item> {

	private int head;
	private int tail;
	private int capacity;
	private int count;
	private Item[] queue;
	
	@SuppressWarnings("unchecked")
	public RandomizedQueue(){
		this.head = 0;
		this.tail = 0;
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
	
	@SuppressWarnings("unchecked")
	private void resize(int head, int tail, int capacity){
		
		StdOut.println("Resize : head = " + head + " tail = " + tail);
		Item [] tmp = (Item [])new Object[capacity];
		int index = 0;
		for(int i = head; i < tail; i++){
			tmp[index++] = queue[i];
		}
		
		this.head = 0;
		this.tail = index;
		this.capacity = capacity;
		queue = tmp;
	}
	
	public void enqueue(Item item) throws NullPointerException {
		if(item == null){
			throw new NullPointerException();
		}
		if(count == capacity || tail == capacity){
			resize(head, tail, 2*capacity);
		}
		
		StdOut.println("Enqueue : head = " + head + " tail = " + tail);
		queue[tail] = item;
		count++;
		tail++;
	}
	
	@SuppressWarnings("unchecked")
	private void reset(){
		head = 0;
		tail = 0;
		capacity = 1;
		queue = (Item [])new Object[capacity];
	}
	
	public Item dequeue() throws NoSuchElementException {
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		
		StdOut.println("Dequeue : head = " + head + " tail = " + tail);

		int index = StdRandom.uniform(head, tail);
		Item result = queue[index];
		queue[index] = null;
		count--;
		
		// dequeue results 0 items in the queue
		if(isEmpty()){
			reset();
		}
		else 
		{
			// dequeue the first item
			if(index == head){
				head++;
			}
			
			// dequeue the last item
			else if(index == tail-1){
				tail--;
			}
			
			// dequeue the item in the middle which result the empty space in the middle
			// to fill the space, we fill it with the last item
			else{
				queue[index] = queue[tail-1];
				queue[tail-1] = null;
				tail--;
			}
			if((count > 0) && (count == capacity/4)){
				resize(head, tail, count);
			}
		}
		return result;
	}
	
	public Item sample(){
		int index = StdRandom.uniform(head, tail);
		return queue[index];
	}
	
	@Override
	public Iterator<Item> iterator() {
		
		// *** Anonymous class object that implements Iterator interface ***
		// Anonymous class is used to create an instance of class that either IMPLEMENTS INTERFACE
		// or EXTENDS ANOTHER CLASS
		Iterator<Item> it = new Iterator<Item>(){

			private int currentHead = head;
			private int currentTail = tail;
			@Override
			public boolean hasNext() {
				return (currentHead < currentTail);
			}

			@Override
			public Item next() throws NoSuchElementException {
				if(!hasNext()){
					throw new NoSuchElementException();
				}
				Item result = queue[currentHead++];
				return result;
			}

			@Override
			public void remove() throws UnsupportedOperationException {
				throw new UnsupportedOperationException();
			}			
		};
		return it;
	}
	
}
