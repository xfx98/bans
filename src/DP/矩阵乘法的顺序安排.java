package DP;

public class ����˷���˳���� {
	public static void main(String[] args) {
		int c[] = {50,10,40,30,5};
		long m[][] = new long[c.length][c.length];
		int lastChang[][] = new int[c.length][c.length];
		optMatrix(c, m, lastChang);
		System.out.println(1);
	}
	/**
	 * 
	 * @param c[0]Ϊ1�������� c ���о�������
	 * @param m[i][k] ��i�˵�j��Ҫ���г˷����ٴ���
	 * @param lastChang ���һ�θı��iֵ
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
