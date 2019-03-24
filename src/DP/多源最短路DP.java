package DP;

public class 多源最短路DP {

	/**
	 * 
	 * @param a 图的邻接矩阵 a[i][i] = 0
	 * @param d 最短路径值，初始0
	 * @param path 实际路径可以通过它计算
	 */
	public static void allPairs(int a[][], int d[][], int path[][]) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				d[i][j] = a[i][j];
				path[i][j] = -1;
			}
		}
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (d[i][k] + d[k][j] < d[i][j]) {
						d[i][j] = d[i][k] + d[k][j];
						path[i][j] = k;
					}
				}
			}
		}
	}
}
