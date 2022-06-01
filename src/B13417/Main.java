package B13417;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13417
 * title : 카드 문자열
 * @author tempcru
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
