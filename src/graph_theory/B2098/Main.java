package graph_theory.B2098;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2098
 * title : ���ǿ� ��ȸ
 * @author tempcru
 * 
 * ������ ����, ��Ʈ����ŷ�� BFS�� ��ȭ
 */
public class Main {

	static int N; // [2, 16]
	static int[][] graph; // Cost Matrix 
	static int allVisited;
	private static int[][] vis; // �湮����
	
	private static final int INF = (int) (1e9); // ���Ѵ� �� ó��
	
	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("./src/graph_theory/B2098/sample_data"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		// 1. Read ������ ��
		N = Integer.parseInt(br.readLine().trim());
		allVisited = (1 << N) - 1;
		
		// 2. ���� Cost Matrix
		graph = new int[N][N];
		vis = new int[16][allVisited]; // int[����][��Ʈ����ũ]
		

		// 3. Read ���� Cost
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(vis[i], -1);
        }
		
		// 0, 0000 0000 0000 0001 
		// 0��° �������� �����ϰ� 0��° ����
		System.out.println(dfs(0, 1));
	}
	
	public static int dfs(int cur, int visit) {
			
			//  10000000000000000 
			//- 00000000000000001 
			//= 01111111111111111
			//= ��縶���� �湮�ߴٸ�
			if (visit == allVisited) {
				//��縶�� �湮�ϰ� ���� ������ �湮�� �� ���ٸ� 0
				//�� �� �ִٸ� map[cur][0] ����
	            return graph[cur][0] == 0 ? INF : graph[cur][0];
	        }
		
			//�̹� �湮�ߴٸ� return, �ߺ�����
			if (vis[cur][visit] != -1) {
	            return vis[cur][visit];
	        }
			vis[cur][visit] = INF; //�湮ó��
			
			int next;
			for(int i = 0; i < N; i++) {// DFS ������
				
				// 1������ : 0000 0000 0000 0001
				// 2������ : 0000 0000 0000 0010
				next = 1 << i;
				if (graph[cur][i] != 0 
				&& ((visit & next) == 0)) {
					vis[cur][visit] = Math.min(vis[cur][visit], dfs(i, (visit | next)) + graph[cur][i]);
				}
			}
			
			return vis[cur][visit];
		}

}
