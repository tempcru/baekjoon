package graph_theory.B2098;

import java.util.Iterator;

public class Random2098 {

	public static void main(String[] args) {

		int N = 16;
		System.out.println(N);
		StringBuffer sb;
		for (int i = 0; i < N; i++) {
			sb = new StringBuffer();
			for (int j = 0; j < N; j++) {
				sb.append((int)((Math.random()*1000001)%1));
				sb.append(" ");
			}
			System.out.println(sb.toString());
		}
	}

}
