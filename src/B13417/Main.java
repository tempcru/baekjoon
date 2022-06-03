package B13417;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13417
 * title : 카드 문자열 Silver III
 * @author tempcru
 */
public class Main {

	static int T;
	
	// Count of card [1, 1000]
	static int N;

	static String result;
	static char word;
	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("./src/B13417/sample_data"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 0; tc < T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			
			word = st.nextToken().charAt(0);
			result = Character.toString(word);
			
			char new_word;
			for(int i = 1; i < N; i++) {
				new_word = st.nextToken().charAt(0); 
				if(word >= new_word) {
					word = new_word;
					result = Character.toString(new_word) + result; 
				} else {
					result = result + Character.toString(new_word);
				}
			}
			
			System.out.println(result);
		}
	}

}
