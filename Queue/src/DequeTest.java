import java.util.Iterator;

public class DequeTest {

	public static void main(String[] args) {
		Deque<String> q = new Deque<String>();
		q.addFirst("hello");
		printQueue(q);
		q.addFirst("my name is");
		printQueue(q);
		q.addFirst("junghoon");
		printQueue(q);
		q.removeLast();
		printQueue(q);
		q.removeLast();
		printQueue(q);
		q.addFirst("hello again");
		printQueue(q);
		q.removeLast();
		printQueue(q);
		q.addLast("young joo");
		printQueue(q);
		q.addFirst("hahaha");
		printQueue(q);
		q.addLast("hohoho");
		printQueue(q);
	}
	

	public static void printQueue(Deque<String> q){
		Iterator<String> it = q.iterator();
		while(it.hasNext()){
			StdOut.print(it.next());
			StdOut.print("-->");
		}
		StdOut.print(q.size());
		StdOut.println();
	}
}