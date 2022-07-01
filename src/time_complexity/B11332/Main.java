package time_complexity.B11332;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11332
 * title : 시간초과
 * @author tempcru
 */
public class Main {

	static int C; //입력 수, [1, 100]
	static String S; // 시간복잡도 문자열
	static int N; // 입력 최대 범위, [1, 1000000]
	static int T; // 테스트 케이스의 수, [1, 10]
	static int L; // 제한시간, [1, 10]
	
	static final String pass = "May Pass.";
	static final String timeout = "TLE!";
	static final int cpu_clock = 100000000; 
	
	static boolean result; // 통과여부
	
	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("./src/B11332/sample_data"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		C = Integer.parseInt(br.readLine().trim());
		
		StringTokenizer st;
		
		for(int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine().trim());
			
			S = st.nextToken();
			N = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			checkTimeComplexcity();
		}
	}

	private static void checkTimeComplexcity() {

		double caseTime = (L * cpu_clock) / T;
		result = true;
		long temp;
		switch (S) {
		
			case "O(N)":
				if(caseTime >= N) {
					result = true;
				} else {
					result = false;
				}
				break;
				
			case "O(N^2)":
				if((caseTime / N) >= N) {
					result = true;
				} else {
					result = false;
				}
				break;
				
			case "O(N^3)":
				if(((caseTime / N) /N) >= N) {
					result = true;
				} else {
					result = false;
				}
				break;
				
			case "O(2^N)":
				temp = 1;
				for(int i = 0; i < N; i++) {
					temp = temp << 1;
					if(temp > caseTime) {
						result = false;
						break;
					}
				}
				break;
				
			case "O(N!)":
				temp = 1;
				for(int i = 2; i <= N; i++) {
					temp = temp * i;
					if(temp > caseTime) {
						result = false;
						break;
					}
				}
				break;
			default:
				break;
		}
		
		if(result) { // Pass
			System.out.println(pass);
		}else { // tle
			System.out.println(timeout);
		}
	}
}
