package 图论;
import java.util.Scanner;
import java.util.Stack;

public class DFS {
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
		dfs(t,used,start);
	}

	private static void dfs(int[][] t, boolean used[], int begin) {//从begin深度优先遍历图
			System.out.print(begin + " ");
			used[begin] = true;
			for (int i = 0; i < t.length; i++) {
				if (t[begin][i] != 0 && !used[i]) {
					dfs(t, used, i);
				}
			}
	}
}
