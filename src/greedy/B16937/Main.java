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
 * title : 두 스티커
 * @author tempcru
 * 
 * 1. 문제 요약
 * - H * W 공간에 N개의 사각스티커중 2개를 골라서 붙인다
 * - 스티커는 겹칠 수 없고 H * W 공간을 넘어가서는 안된다
 * - 스티커를 회전하는 것은 가능하다.
 * - 스티커 2개를 붙일 수 없으면 0, 있다면 최대 스티커 넓이를 출력
 * 
 * 2. 문제 풀이
 * - 최대 H * W는 100 * 100 이다 
 * - 스티커를 어떻게 붙이던 중요하진않고 붙일 수 있냐 없냐만 중요하다
 * - 스티커는 겹칠 수 없으므로 스티커 넓이 연산은 R * C 로 가능하다
 * - MAX_AREA = Max(Ri * Ci + Rj * Cj)
 * 
 * - 스티커를 붙일 수 있는지 판단은 두 시티커를 수평으로 붙여보고 수직으로 붙여보면된다.
 * - 모든 스티커는 회전 할 수 있다는 것을 가정해야한다 
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
			stickers[i][2] = stickers[i][0] * stickers[i][1]; // 넓이
		}
		
		MAX_AREA = 0;
		
		calcMaxArea();
		
		System.out.println(MAX_AREA);
	}
	
	private static void calcMaxArea() {
		for(int i = 0; i < stickers.length; i++) {
			for(int j = i + 1; j < stickers.length; j++) {
				if(i == j) continue;
				if(isCanStick(stickers[i], stickers[j])) { // 붙일 수 있다면
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





