package 图论;

import java.util.Scanner;

//dijkstra最短路模版,从start到各点
public class Dijkstra {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int start = 0;
		int[] dij = dijkstra(sc, n, k, start);
		for (int i = 0; i < n; i++) {
			System.out.print(dij[i] + " ");
		}

	}

	private static int[] dijkstra(Scanner sc, int n, int k, int start) {
		int t[][] = new int[n][n];
		int dij[] = new int[n];
		for (int i = 0; i < n; i++) {
			dij[i] = Integer.MAX_VALUE;
		}
		dij[start] = 0;
		boolean used[] = new boolean[n];
		for (int i = 0; i < k; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			t[x][y] = sc.nextInt();
		}
		int begin = start;
		while (true) {
			used[begin] = true;
			for (int i = 0; i < dij.length; i++) {
				if (t[begin][i] != 0 && t[begin][i] + dij[begin] < dij[i]) {
					dij[i] = t[begin][i] + dij[begin];
				}
			}
			begin = start;
			for (int i = 0; i < n; i++) {
				if (!used[i] && (begin == 0 || dij[begin] > dij[i])) {
					begin = i;
				}
			}
			if (begin == start) {
				break;
			}
		}
		return dij;
	}
}

class Node implements Comparable {
	int i, d;

	public Node(int i, int d) {
		this.i = i;
		this.d = d;
	}

	@Override
	public int compareTo(Object o) {
		Node a = (Node) o;
		return this.d - a.d;
	}
}
/*
 * 11 21 0 1 1 0 4 4 0 7 6 4 1 3 7 4 2 7 5 1 7 8 6 1 5 2 1 2 2 4 5 3 2 3 2 5 3 2
 * 5 6 3 5 9 3 3 10 4 6 3 1 6 10 3 9 6 1 9 10 4 8 5 2 8 9 6
 * 
 */