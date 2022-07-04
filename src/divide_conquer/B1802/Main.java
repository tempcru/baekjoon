package divide_conquer.B1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1802
 * title : ��������
 * @author tempcru
 * 
 * ���� 
 * - ���̸� ���ݾ� N�� ������ 2^N - 1 ��ŭ�� �����ڱ��� �����.
 * - ������ ���⿡ ���� out / in �� �����Ѵ�. 
 * - out / in �� 0/1 ������ �־����� ���� �� �ִ��� ����϶�
 * 
 * Ǯ�� 
 * - 1. �־��� ��Ʈ�迭�� ������ ���� �ΰ� �迭�� �����.
 * - 2. ������� �ΰ� �迭�� ��� bit�� ���� �ٸ� ���̾���Ѵ�.
 * - 3. 2���� �����ϸ� �ٽ� �� ������ bit�迭�� ������ �ٽ� 1���� �ݺ��Ѵ�.
 * - 4. ��Ʈ �迭�� ���̰� 1�� �ɶ� ���� �ݺ��Ѵ�.
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
