package B17124;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/17124
 * title : 두 개의 배열
 * @author tempcru
 * 
 * 두개의 배열이 주어진다
 * 모든 A 배열의 숫자를 새로운 값으로 변경한다
 * 변경기준은 A배열의 숫자와 가장근접한 B배열의 숫자로 변경한다
 * 
 * A배열의 길이가 100만이고 10개TC를 2초안에 통과해야하므로
 * O(NlogM) 혹은 O(N+M) 시간복잡도로 해결한다
 * 
 * B배열을 정렬한후 이분탐색으로 해결하거나
 * A,B배열 정렬한 후 two pointer 개념으로 해결가능할 것 같다.
 */
public class Main {

	// T : [1, 10]
	static int T;
	static long result;
	
	// N, M : [1, 100만]
	static int N, M;
	static int A[];
	static int B[];
	
	
	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("./src/B17124/sample_data"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			A = new int[N];
			B = new int[M];
			
			// read A
			st = new StringTokenizer(br.readLine().trim());
			for(int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			// read B
			st = new StringTokenizer(br.readLine().trim());
			for(int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			//B 정렬
			Arrays.sort(B);
			
			result = 0;
			int l_index = 0;
			int u_index = 0;
			for(int i = 0; i < N; i++) {
				u_index = Arrays.binarySearch(B, A[i]);
				
				if(u_index < 0) {
					u_index = (u_index + 1) * (-1) ;
				}
				
				if(u_index >= M ) {
					u_index--;
				}
				
				if (u_index > 0) {
					l_index = u_index - 1;
				}
				
				result += getMatchedNumber(A[i], l_index, u_index);
				
			}
			
			System.out.println(result);
			
		}
	}


	private static long getMatchedNumber(int target, int l_index, int u_index) {

		int dif_l = Math.abs(target - B[l_index]);
		int dif_u = Math.abs(target - B[u_index]);
		
		if (dif_l > dif_u) {
			return B[u_index];
		} else  {
			return B[l_index];
		}
	}

}
