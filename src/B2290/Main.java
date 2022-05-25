package B2290;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2290 title : LCD Test
 * 
 * @author tempcru
 * 
 *         길이가 s인 문자를 '-'와 '|'를 이용해서 출력하기 단순 구현 문제,사실 모든 문자 다 만들어놓으면된다 숫자 하나당
 *         커봐야 1만 정도고 모든 숫자 해봐야 10만이기 때문에 다만들어놔도 돌아갈 것 같다
 *
 */
public class Main {

	// S : [1, 10]
	static int S;
	static char[] num_char;
	static int[] num;

	static boolean[][] dot;

	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("./src/B2290/sample_data"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		S = Integer.parseInt(st.nextToken());
		num_char = st.nextToken().toCharArray();

		num = new int[num_char.length];
		
		for (int i = 0; i < num_char.length; i++) {
			num[i] = Integer.parseInt(Character.toString(num_char[i]));
		}
		
		// 전체 사이즈
		// 세로 = 3 + 2 * S
		// 가로 = num.length * (2 + S)

		dot = new boolean[10][8];

		makeDot();

		StringBuffer sb = new StringBuffer();

		String dash = "";
		String dash_none = "";

		for (int i = 0; i < S; i++) {
			dash += "-";
			dash_none += " ";
		}

		int i = 0;
		for (int j = 0; j < num.length; j++) {
			i = num[j];
			sb.append(" ");
			if (dot[i][1]) {
				sb.append(dash);
			} else {
				sb.append(dash_none);
			}
			sb.append("  ");
		}
		
		System.out.println(sb.toString());
		sb = new StringBuffer();
		
		for (int j = 0; j < num.length; j++) {
			i = num[j];
			if(dot[i][2]) {
				sb.append("|");
			} else {
				sb.append(" ");
			}
			
			sb.append(dash_none);
			
			if(dot[i][3]) {
				sb.append("|");
			} else {
				sb.append(" ");
			}
			
			sb.append(" ");
		}
		
		for (int j = 0; j < S; j++) { 
			System.out.println(sb.toString()); 
		}
		
		sb = new StringBuffer();

		for (int j = 0; j < num.length; j++) {
			i = num[j];
			sb.append(" ");
			if (dot[i][4]) {
				sb.append(dash);
			} else {
				sb.append(dash_none);
			}
			sb.append("  ");
		}
		
		System.out.println(sb.toString());
		sb = new StringBuffer();
 
		for (int j = 0; j < num.length; j++) {
			i = num[j];
			if(dot[i][5]) {
				sb.append("|");
			} else {
				sb.append(" ");
			}
			sb.append(dash_none);
			if(dot[i][6]) {
				sb.append("|");
			} else {
				sb.append(" ");
			}
			sb.append(" ");
		}
		
		for (int j = 0; j < S; j++) { 
			System.out.println(sb.toString()); 
		}
		
		sb = new StringBuffer();

		for (int j = 0; j < num.length; j++) {
			i = num[j];
			sb.append(" ");
			if (dot[i][7]) {
				sb.append(dash);
			} else {
				sb.append(dash_none);
			}
			sb.append("  ");
		}
		
		System.out.println(sb.toString()); 
	}

	private static void makeDot() {

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 8; j++) {
				dot[i][j] = false;
			}
		}

		// 1
		// 2 3
		// 4
		// 5 6
		// 7

		// 0
		dot[0][1] = true;
		dot[0][2] = true;
		dot[0][3] = true;
		dot[0][5] = true;
		dot[0][6] = true;
		dot[0][7] = true;

		// 1
		dot[1][3] = true;
		dot[1][6] = true;

		// 2
		dot[2][1] = true;
		dot[2][3] = true;
		dot[2][4] = true;
		dot[2][5] = true;
		dot[2][7] = true;

		// 3
		dot[3][1] = true;
		dot[3][3] = true;
		dot[3][4] = true;
		dot[3][6] = true;
		dot[3][7] = true;

		// 4
		dot[4][2] = true;
		dot[4][3] = true;
		dot[4][4] = true;
		dot[4][6] = true;

		// 5
		dot[5][1] = true;
		dot[5][2] = true;
		dot[5][4] = true;
		dot[5][6] = true;
		dot[5][7] = true;

		// 6
		dot[6][1] = true;
		dot[6][2] = true;
		dot[6][4] = true;
		dot[6][5] = true;
		dot[6][6] = true;
		dot[6][7] = true;

		// 7
		dot[7][1] = true;
		dot[7][3] = true;
		dot[7][6] = true;

		// 8
		dot[8][1] = true;
		dot[8][2] = true;
		dot[8][3] = true;
		dot[8][4] = true;
		dot[8][5] = true;
		dot[8][6] = true;
		dot[8][7] = true;

		// 9
		dot[9][1] = true;
		dot[9][2] = true;
		dot[9][3] = true;
		dot[9][4] = true;
		dot[9][6] = true;
		dot[9][7] = true;

	}

}
