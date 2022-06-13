package B1720;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1720
 * title : 타일코드
 * @author tempcru
 * 
 * - 1793번 타일링 문제 업그레이드 버전 문제
 * - 좌우 대칭인 경우, 중복을 제거하라는 문제
 * - 좌우 대칭에 대한 처리를 홀수, 짝수로 나눠서 푼다
 * - 완전대칭을 뒤집어도 같은 타일이라고 정의해본다
 * - 정답 = (전체 타일 갯수 - 완전대칭)/2 + 완전대칭
 * - 전체타일갯수에서 완전 대칭인 경우를 빼면 모두 일반적인 좌우대칭이므로 2로 나눠준다
 *
 */
public class Main {

	static int N;
	static long result;
	
	static long DP[];
	static long DP2[]; 
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("./src/B1720/sample_data"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		N = Integer.parseInt(br.readLine().trim());
		 
		
		DP = new long[31];
		DP2 = new long[31]; 
		
		DP[0] = 1;
		DP[1] = 1;
		DP[2] = 3;
		
		DP2[0] = 1;
		DP2[1] = 1;
		DP2[2] = 3;
		
		for (int i = 3; i <= N; i++) {
			DP[i] = DP[i-2]*2 + DP[i-1];
			
			if(i%2 == 0) { // even
				DP2[i] = DP[(i-2)/2]*2 + DP[i/2]; 
			}else { // odd
				DP2[i] = DP[(i-1)/2];
			}
		}
		result = (DP[N] - DP2[N])/2 + DP2[N];
		
		System.out.println(result);
	}

}
