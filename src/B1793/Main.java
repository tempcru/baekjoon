package B1793;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1793
 * title : 타일링
 * @author tempcru
 * 
 * 2×n 직사각형을 2×1과 2×2 타일로 채우는 방법의 수 구하기
 */
public class Main {

	// N : [0, 250]
	static int N;
	static BigInteger[] dp;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("./src/B1793/sample_data"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		// dp 연산
		dp = new BigInteger[251];
		
		// dp[0] = 1;
		// dp[1] = 1;
		// dp[2] = dp[1] + (dp[0] * 2) = 3
		// dp[3] = dp[2] + (dp[1] * 2) = 5
		
		dp[0] = BigInteger.ONE;
		dp[1] = BigInteger.ONE;
		
		for(int i = 2; i < dp.length; i++) {
			dp[i] = dp[i-1].add(dp[i-2].multiply(BigInteger.valueOf(2)));
		}
		
		String temp;
		while (true) {
			try {
				temp = br.readLine().trim();
			} catch (Exception e) { 
				break;
			}
			N = Integer.parseInt(temp);
			System.out.println(dp[N]);
		}
	}

}
