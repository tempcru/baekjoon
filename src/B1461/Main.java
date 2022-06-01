package B1461;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1461
 * title : µµ¼­°ü Gold V
 * @author tempcru
 * 
 */
public class Main {

	static long result;
	
	// N, M : [1, 50]
	static int N, M;
	
	static PriorityQueue<Integer> f_book;
	static PriorityQueue<Integer> b_book;
	
	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("./src/B1461/sample_data"));
//		7 2
//		-37 2 -6 -39 -29 11 -28
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Comparator comp_max = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		};
		
		f_book = new PriorityQueue<Integer>(comp_max);
		b_book = new PriorityQueue<Integer>(comp_max);
		
		st = new StringTokenizer(br.readLine().trim());
		
		int temp = 0;
		for(int i = 0; i < N; i++) {
			temp = Integer.parseInt(st.nextToken());
			if (temp < 0) {
				temp *= -1;
				f_book.add(temp);
			}else {
				b_book.add(temp);
			}
		}
		
		one_way_case();
		two_way_case();
		
		System.out.println(result);
			
	}

	private static void two_way_case() {
		while (!f_book.isEmpty() || !b_book.isEmpty()) {
			
			if(f_book.isEmpty()) {
				result+= 2 * bbook_peek_poll();
				continue;
			}
			
			if(b_book.isEmpty()) {
				result+= 2 * fbook_peek_poll();
				continue;
			}
			
			if (f_book.peek() > b_book.peek()) {
				result+= 2 * fbook_peek_poll();
				continue;
			} else {
				result+= 2 * bbook_peek_poll();
				continue;
			} 
		}
	}

	private static void one_way_case() {
		if(f_book.isEmpty()) {
			result+= bbook_peek_poll();
		} else if(b_book.isEmpty()) {
			result+= fbook_peek_poll(); 
		} else if (f_book.peek() > b_book.peek()) {
			result += fbook_peek_poll(); 
		} else {
			result += bbook_peek_poll();
		}
	}

	private static long fbook_peek_poll() {
		int peek = f_book.peek();
		for (int i = 0 ; i < M; i++) {
			if(!f_book.isEmpty()) {
				f_book.poll();
			}
		}
		return peek;
	}
	
	private static long bbook_peek_poll() {
		int peek = b_book.peek();
		for (int i = 0 ; i < M; i++) {
			if(!b_book.isEmpty()) {
				b_book.poll();
			}
		}
		return peek;
	}
}
