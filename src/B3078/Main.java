package B3078;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/3078
 * title : ���� ģ��
 * @author tempcru
 * 
 * N, 30��
 * K, 30��
 * ���ڼ� 20��
 * 
 * K �� �������� ���ڼ� Sum �迭 ����� �����̵� ������ �ϵ��� ��ü Ž��
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
	
		// ���� K��ŭ Sum �迭 �ݿ�
		for (int i = 0; i <= K; i++) {
			if (i >= N) {
				break;
			}
			count[names[i]]++;
		}
		
		for (int i = 0; i < N; i++) {
			result += count[names[i]] - 1;
			if(i + K + 1 < N) {
				//i + K ��° �ܾ� Sum �߰�
				count[names[i+K+1]]++;
			}
			//i ��° �ܾ� Sum���� ����
			count[names[i]]--;
		}
		
		System.out.println(result);
	}

}
