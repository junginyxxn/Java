import java.io.*;
import java.util.*;

public class Solution_1249_보급로_윤정인 {

	static class Node {
		int r;
		int c;
		int weight;

		Node(int r, int c, int weight) {
			this.r = r;
			this.c = c;
			this.weight = weight;
		}
	}

	static int[][] map;
	static int[][] distance;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++)
					map[i][j] = str.charAt(j) - '0';
			}

			findRoute();
			sb.append("#" + tc).append(" " + distance[N - 1][N - 1]).append('\n');
		}

		System.out.print(sb);
	}

	private static void findRoute() {

		int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		boolean[][] visited = new boolean[N][N];
		distance = new int[N][N];
		PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);

		for (int i = 0; i < N; i++)
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		distance[0][0] = 0;

		pq.offer(new Node(0, 0, 0));

		while (!pq.isEmpty()) {

			Node p = pq.poll();

			int r = p.r;
			int c = p.c;

			if (visited[r][c])
				continue;

			visited[r][c] = true;

			if (r == N - 1 && c == N - 1)
				break;

			for (int d = 0; d < 4; d++) {
				int nr = r + delta[d][0];
				int nc = c + delta[d][1];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;

				if (visited[nr][nc])
					continue;

				if (distance[nr][nc] <= (distance[r][c] + map[nr][nc]))
					continue;
				
				distance[nr][nc] = distance[r][c] + map[nr][nc];
				pq.offer(new Node(nr, nc, distance[nr][nc]));
			}
		}
	}
}