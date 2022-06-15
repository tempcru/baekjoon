package B1826;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1826
 * title : 연료 채우기
 * @author tempcru
 */
public class Main {

	static int result;
	static int N, L, P;
	static int oil[][];
	
	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("./src/B1826/sample_data"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		N = Integer.parseInt(br.readLine().trim());
		
		oil = new int[N+1][2];
		result = 0;
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			oil[i][0] = Integer.parseInt(st.nextToken());
			oil[i][1] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine().trim());
		L = Integer.parseInt(st.nextToken()); // Dest
		P = Integer.parseInt(st.nextToken()); // init oil
		
		oil[N][0] = L;
		oil[N][1] = 0;
		
		Arrays.sort(oil, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) { 
				return o1[0] - o2[0];
			}
		});
		 
		PriorityQueue pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});
		
		int[] temp;
		for (int i = 0; i <= N; i++) {
			// 주유소에 갈 수 있으면 PQ 추가
			if (P >= oil[i][0]) {
				pq.add(oil[i]);
			} else if(!pq.isEmpty()){ // 갈수 없는 주유소면, PQ에서 Poll 하여 기름 충전
				P += ((int[]) pq.poll())[1];
				result++;
				i--;	
			}else {
				result = -1;
				break;
			}			
		}
		
		System.out.println(result);
	}

}