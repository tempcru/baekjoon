package greedy.B16937;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16937
 * title : �� ��ƼĿ
 * @author tempcru
 * 
 * 1. ���� ���
 * - H * W ������ N���� �簢��ƼĿ�� 2���� ��� ���δ�
 * - ��ƼĿ�� ��ĥ �� ���� H * W ������ �Ѿ���� �ȵȴ�
 * - ��ƼĿ�� ȸ���ϴ� ���� �����ϴ�.
 * - ��ƼĿ 2���� ���� �� ������ 0, �ִٸ� �ִ� ��ƼĿ ���̸� ���
 * 
 * 2. ���� Ǯ��
 * - �ִ� H * W�� 100 * 100 �̴� 
 * - ��ƼĿ�� ��� ���̴� �߿������ʰ� ���� �� �ֳ� ���ĸ� �߿��ϴ�
 * - ��ƼĿ�� ��ĥ �� �����Ƿ� ��ƼĿ ���� ������ R * C �� �����ϴ�
 * - MAX_AREA = Max(Ri * Ci + Rj * Cj)
 * 
 * - ��ƼĿ�� ���� �� �ִ��� �Ǵ��� �� ��ƼĿ�� �������� �ٿ����� �������� �ٿ�����ȴ�.
 * - ��� ��ƼĿ�� ȸ�� �� �� �ִٴ� ���� �����ؾ��Ѵ� 
 * 
 */
public class Main {

	static int MAX_AREA;
	static int H, W, N; // [1, 100]
	static int[][] stickers;
	
	public static void main(String[] args) throws Exception {

		// 1. Input Sample Data 
		System.setIn(new FileInputStream("./src/greedy/B16937/sample_data"));
		
		// 2. Read values
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine().trim());
		
		stickers = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()); 
			stickers[i][0] = Integer.parseInt(st.nextToken());
			stickers[i][1] = Integer.parseInt(st.nextToken());
			stickers[i][2] = stickers[i][0] * stickers[i][1]; // ����
		}
		
		MAX_AREA = 0;
		
		calcMaxArea();
		
		System.out.println(MAX_AREA);
	}
	
	private static void calcMaxArea() {
		for(int i = 0; i < stickers.length; i++) {
			for(int j = i + 1; j < stickers.length; j++) {
				if(i == j) continue;
				if(isCanStick(stickers[i], stickers[j])) { // ���� �� �ִٸ�
					MAX_AREA = Math.max(MAX_AREA, stickers[i][2] + stickers[j][2]);
				}
			}
		}
	}

	private static boolean isCanStick(int[] a, int[] b) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				if((a[i] + b[j]) <= H && Math.max(a[(i+1)%2], b[(j+1)%2]) <= W) return true;
				if((a[i] + b[j]) <= W && Math.max(a[(i+1)%2], b[(j+1)%2]) <= H) return true;
			}
		}
		return false;
	}
}





