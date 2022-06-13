package B1720;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1720
 * title : Ÿ���ڵ�
 * @author tempcru
 * 
 * - 1793�� Ÿ�ϸ� ���� ���׷��̵� ���� ����
 * - �¿� ��Ī�� ���, �ߺ��� �����϶�� ����
 * - �¿� ��Ī�� ���� ó���� Ȧ��, ¦���� ������ Ǭ��
 * - ������Ī�� ����� ���� Ÿ���̶�� �����غ���
 * - ���� = (��ü Ÿ�� ���� - ������Ī)/2 + ������Ī
 * - ��üŸ�ϰ������� ���� ��Ī�� ��츦 ���� ��� �Ϲ����� �¿��Ī�̹Ƿ� 2�� �����ش�
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
