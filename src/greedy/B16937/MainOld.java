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
public class MainOld {

	static int MAX_AREA;
	static int H, W, N; // [1, 100]
	static List<Sticker> stickers = new ArrayList<Sticker>();
	
	public static void main(String[] args) throws Exception {

		// 1. Input Sample Data 
//		System.setIn(new FileInputStream("./src/greedy/B16937/sample_data"));
		
		// 2. Read values
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine().trim());
		
		int r, c;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			stickers.add(new Sticker(i, r, c));
		}
		
		MAX_AREA = 0;
		
		calcMaxArea();
		
		System.out.println(MAX_AREA);
	}
	
	private static void calcMaxArea() {
		Sticker a;
		Sticker b;
		int area;
		for(int i = 0; i < stickers.size(); i++) {
			a = stickers.get(i);
			for(int j = i; j < stickers.size(); j++) {
				if(i == j) continue;
				b = stickers.get(j); 
				if(isCanStick(a, b)) { // ���� �� �ִٸ�
					area = a.area + b.area;
					MAX_AREA = Math.max(MAX_AREA, area);
				}
			}
		}
	}

	private static boolean isCanStick(Sticker a, Sticker b) {
		if((a.R + b.R) <= H && Math.max(a.C, b.C) <= W) return true;
		if((a.R + b.C) <= H && Math.max(a.C, b.R) <= W) return true;
		if((a.C + b.R) <= H && Math.max(a.R, b.C) <= W) return true;
		if((a.C + b.C) <= H && Math.max(a.R, b.R) <= W) return true;
		if((a.R + b.R) <= W && Math.max(a.C, b.C) <= H) return true;
		if((a.R + b.C) <= W && Math.max(a.C, b.R) <= H) return true;
		if((a.C + b.R) <= W && Math.max(a.R, b.C) <= H) return true;
		if((a.C + b.C) <= W && Math.max(a.R, b.R) <= H) return true;
		return false;
	}

	static class Sticker {

		int index;
		int R;
		int C;
		int area;
		
		public Sticker() {
			
		}
		
		public Sticker(int index, int r, int c) {
			this.index = index;
			this.R = r;
			this.C = c;
			this.area = r * c;
		}
	}
	
}





