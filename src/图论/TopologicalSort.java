package 图论;
import java.util.PriorityQueue;
import java.util.Scanner;
//拓扑排序模版，优先队列版
public class TopologicalSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int t[][] = new int[n][n];
		int rd[] = new int[n];
		
		for (int i = 0; i < k; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			t[x][y] = 1;
			rd[y]++;
		}
		topologicalSort(n, t, rd);
		
	}

	private static void topologicalSort(int n, int[][] t, int[] rd) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < n; i++) {
			if(rd[i] == 0) {
				pq.add(i);
			}
		}
		while(!pq.isEmpty()) {
			int out = pq.poll();
			System.out.print(out+" ");
			for(int i = 0;i<n;i++) {
				if(t[out][i]!=0) {
					rd[i]--;
					if(rd[i]==0) {
						pq.add(i);
					}
				}
			}
		}
	}
}
/*
11 21
0 1
0 4
0 7
4 1
7 4
7 5
7 8
1 5
1 2
4 5
2 3
5 3
5 6
5 9
3 10
6 3
6 10
9 6
9 10
8 5
8 9

*/
