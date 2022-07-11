package graph_theory.B2098;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2098
 * title : 외판원 순회
 * @author tempcru
 * 
 * 유명한 문제, 비트마스킹과 BFS의 조화
 */
public class Main {

	static int N; // [2, 16]
	static int[][] graph; // Cost Matrix 
	static int allVisited;
	private static int[][] vis; // 방문여부
	
	private static final int INF = (int) (1e9); // 무한대 값 처리
	
	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("./src/graph_theory/B2098/sample_data"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		// 1. Read 도시의 수
		N = Integer.parseInt(br.readLine().trim());
		allVisited = (1 << N) - 1;
		
		// 2. 도시 Cost Matrix
		graph = new int[N][N];
		vis = new int[16][allVisited]; // int[도시][비트마스크]
		

		// 3. Read 도시 Cost
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
		// 0번째 마을에서 시작하고 0번째 마을
		System.out.println(dfs(0, 1));
	}
	
	public static int dfs(int cur, int visit) {
			
			//  10000000000000000 
			//- 00000000000000001 
			//= 01111111111111111
			//= 모든마을을 방문했다면
			if (visit == allVisited) {
				//모든마을 방문하고 시작 마을로 방문할 수 없다면 0
				//갈 수 있다면 map[cur][0] 리턴
	            return graph[cur][0] == 0 ? INF : graph[cur][0];
	        }
		
			//이미 방문했다면 return, 중복제거
			if (vis[cur][visit] != -1) {
	            return vis[cur][visit];
	        }
			vis[cur][visit] = INF; //방문처리
			
			int next;
			for(int i = 0; i < N; i++) {// DFS 돌리기
				
				// 1번도시 : 0000 0000 0000 0001
				// 2번도시 : 0000 0000 0000 0010
				next = 1 << i;
				if (graph[cur][i] != 0 
				&& ((visit & next) == 0)) {
					vis[cur][visit] = Math.min(vis[cur][visit], dfs(i, (visit | next)) + graph[cur][i]);
				}
			}
			
			return vis[cur][visit];
		}

}
