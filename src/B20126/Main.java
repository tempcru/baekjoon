package B20126;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/20126
 * title : 교수님의 기말고사
 * @author tempcru
 */
public class Main {

	// N <= 10만
	// M,S <= 10억
	
	static int N,M,S;
    static int[][] exams;
	
	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("./src/B20126/sample_data"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		exams = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			exams[i][0] = Integer.parseInt(st.nextToken());
			exams[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(exams, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) { 
				return o1[0] - o2[0];
			}
		});
		
		System.out.println(search_empty());
		
	}

	private static int search_empty() {
		
		
		int result = -1;
		
		// 0 이전
		int temp = exams[0][0] - M;
		if(temp > -1) {
			return 0;
		}
		
		
		// 0 ~ N-1
		for(int i = 0; i < N-1; i++) { 
			temp = exams[i+1][0] - exams[i][0] - exams[i][1] - M;
			if(temp > -1) {
				result = exams[i][0] + exams[i][1];
				break;
			}
		}
		
		// N-1
		if(result < 0) {
			temp = S - exams[N-1][0] - exams[N-1][1] - M;
			if(temp > -1) {
				result = exams[N-1][0] + exams[N-1][1]; 
			}
		}
		
		return result;
	}

}
