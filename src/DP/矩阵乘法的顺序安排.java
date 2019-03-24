package DP;

public class 矩阵乘法的顺序安排 {
	public static void main(String[] args) {
		int c[] = {50,10,40,30,5};
		long m[][] = new long[c.length][c.length];
		int lastChang[][] = new int[c.length][c.length];
		optMatrix(c, m, lastChang);
		System.out.println(1);
	}
	/**
	 * 
	 * @param c[0]为1矩阵行数 c 所有矩阵列数
	 * @param m[i][k] 从i乘到j需要运行乘法最少次数
	 * @param lastChang 最后一次改变的i值
	 */
	public static void optMatrix(int c[], long m[][],int lastChang[][]) {
		int n = c.length - 1;
		for(int left = 1; left <= n; left++)
			m[left][left] = 0;
		for(int k = 1; k<n;k++) {
			for(int left = 1; left<=n-k;left++) {
				int right = left + k;
				m[left][right] = Integer.MAX_VALUE;
				for(int i = left; i < right; i++) {
					long thisCost = m[left][i] + m[i+1][right]+c[left-1]*c[i]*c[right];
					if(thisCost < m[left][right]) {
						m[left][right] = thisCost;
						lastChang[left][right] = i;
					}
				}
			}
		}

	}
	
}
