package B3078;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/3078
 * title : 좋은 친구
 * @author tempcru
 * 
 * N, 30만
 * K, 30만
 * 글자수 20자
 * 
 * K 를 기준으로 글자수 Sum 배열 만들고 슬라이딩 윈도우 하듯이 전체 탐색
 */
public class Main {

	static long result;
	static int N, K;
	static int[] names;
	static int[] count;
	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("./src/B3078/sample_data"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		names = new int[N];
		count = new int[21];
		
		for(int i = 0; i< N; i++) {
			names[i] = br.readLine().trim().length();
		}
	
		// 최초 K만큼 Sum 배열 반영
		for (int i = 0; i <= K; i++) {
			if (i >= N) {
				break;
			}
			count[names[i]]++;
		}
		
		for (int i = 0; i < N; i++) {
			result += count[names[i]] - 1;
			if(i + K + 1 < N) {
				//i + K 번째 단어 Sum 추가
				count[names[i+K+1]]++;
			}
			//i 번째 단어 Sum에서 제외
			count[names[i]]--;
		}
		
		System.out.println(result);
	}

}
