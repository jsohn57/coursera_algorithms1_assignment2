import java.util.Iterator;


public class RandomizedQueueTest {
	public static void main(String[] args) {
		RandomizedQueue<String> rq = new RandomizedQueue<String>();
		/*
		rq.enqueue("hello ");
		printQueue(rq);
		rq.enqueue("there ");
		printQueue(rq);
		rq.enqueue("my name is ");
		printQueue(rq);
		rq.enqueue("jung hoon");
		printQueue(rq);
		StdOut.println("Dequeued Item = " + rq.dequeue());
		printQueue(rq);
		StdOut.println("Sampled Item = " + rq.sample());
		printQueue(rq);
		StdOut.println("Dequeued Item = " + rq.dequeue());
		printQueue(rq);
		StdOut.println("Dequeued Item = " + rq.dequeue());
		printQueue(rq);
		StdOut.println("Dequeued Item = " + rq.dequeue());
		printQueue(rq);
		StdOut.println("Dequeued Item = " + rq.dequeue());
		printQueue(rq);
		*/
		String input = "A B C D ";
		int startIdx = input.indexOf("C");
		int endIdx = input.indexOf(' ', startIdx);
		
		input = input.substring(0, startIdx).concat(input.substring(endIdx+1, input.length()));
		StdOut.println("result = " + input);
	}
	
	public static void printQueue(RandomizedQueue<String> q){
		Iterator<String> it = q.iterator();
		while(it.hasNext()){
			StdOut.print(it.next());
			StdOut.print(" --> ");
		}
		StdOut.print(q.size());
		StdOut.println();
	}
}
