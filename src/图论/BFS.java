package 图论;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int start = 0;
		int t[][] = new int[n][n];
		boolean used[] = new boolean[n];

		for (int i = 0; i < k; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			t[x][y] = sc.nextInt();
		}
		bfs(t, used, start);
	}

	private static void bfs(int[][] t, boolean used[], int begin) {//从begin广度优先遍历图

		Queue<Integer> q = new LinkedList<>();
		q.add(begin);
		System.out.print(begin+" ");
		used[begin] = true;
		while (!q.isEmpty()) {
			begin = q.poll();
			for (int i = 0; i < t.length; i++) {
				if (t[begin][i] != 0 && !used[i]) {
					q.add(i);
					used[i] = true;
					System.out.print(i+" ");
				}
			}
		}
	}
}
