package divide_conquer.B1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1802
 * title : 종이접기
 * @author tempcru
 * 
 * 문제 
 * - 종이를 절반씩 N번 접으면 2^N - 1 만큼의 접은자국이 생긴다.
 * - 접히는 방향에 따라 out / in 이 존재한다. 
 * - out / in 을 0/1 값으로 주어질때 접을 수 있는지 출력하라
 * 
 * 풀이 
 * - 1. 주어진 비트배열을 반으로 나눠 두개 배열로 만든다.
 * - 2. 만들어진 두개 배열의 모든 bit는 서로 다른 값이어야한다.
 * - 3. 2번을 만족하면 다시 반 나눠진 bit배열을 가지고 다시 1번을 반복한다.
 * - 4. 비트 배열의 길이가 1이 될때 까지 반복한다.
 */
public class Main {

	static boolean result;
	
	static int T;
	
	static final String YES = "YES";
	static final String NO = "NO";
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("./src/divide_conquer/B1802/sample_data"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		T = Integer.parseInt(br.readLine().trim());
		
		char[] text;
		
		for(int i = 0; i < T; i++) {
			
			
			
			
			if(result) {
				System.out.println(YES);
			}else {
				System.out.println(NO);
			}
		}
	}

}
