import java.util.Iterator;


public class Subset {
	public static void main(String[] args) {
		RandomizedQueue<String> rq = new RandomizedQueue<String>();
		int K = Integer.parseInt(args[0]);
		int N = 0;
		String input = "";
		while(!StdIn.isEmpty()){
			input = StdIn.readString();
			if(N < K){
				rq.enqueue(input);
			}
			else{
				if(StdRandom.bernoulli(((double)K)/N)){
					rq.dequeue();
					rq.enqueue(input);
				}
			}
			N++;
		}
		Iterator<String> it = rq.iterator();
		while(it.hasNext()){
			StdOut.println(it.next());
		}
		// p(uniform probability over N) = 1/N
		// p = (1/K : uniform probability p in the queue)*(X : uniform probability when inserting) 
		// ==> X = p*K = K/N
		/*
		StdOut.println("inputProb = " + inputProb);
		int index = 0;
		int count = 0;
		while(count < K){
			
			// when N becomes less than K, we should put all the remaining objects into the queue
			if(N <= K){
				inputProb = 1.0;
			}

			String s = "";
			String result = "";
			char c;
			
			// find the strings separated by the spaces
			while(!((c = input.charAt(index)) == ' ')){
				s += c;
				index++;
			}
			index++;			
			if(StdRandom.bernoulli(inputProb)){
				rq.enqueue(s);
			}
			s = "";
			StdOut.println("size = " + rq.size());
			
			// when index >= 2*N, it means another runs to put the numbers into the randomized queue is required
			// when rq.size() == K it means one iteration is finished so that we can dequeue the object
			if((index >= 2*N) || (rq.size() == K)){
				if(rq.size() == K){
					result = rq.dequeue();
					
					// print the object
					StdOut.println(result);
					
					// calculate the string object that has to be removed from the whole string
					int startIdx = input.indexOf(result);
					int endIdx = input.indexOf(' ', startIdx);
					
					input = input.substring(0, startIdx).concat(input.substring(endIdx+1, input.length()));
					count++;
					
					// when N becomes equal to K it is time to break out and dequeue everything in the queue
					// : *** the queue supposed to be full ***
					if(N <= K){
						break;
					}
					
					// substring object is removed so that number of object we should consider also decreases
					// uniform probability changes from 1/N --> 1/(N-1)
					N--;
				}
				index = 0;
				rq = new RandomizedQueue<String>();
			}
		}
		
		// dequeue and print the remaining substring object in the queue
		for(int i = count; i < K; i++){
			StdOut.println(rq.dequeue());
		}
		*/
	}
}
