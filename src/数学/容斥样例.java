package ��ѧ;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class �ݳ����� {
	static StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));

	public static void main(String[] args) {
		int t = (int) nextNum();
		int arr[] = { 2, 3, 5, 7, 11, 13, 17, 19 };
		while (t-- > 0) {
			long k = nextNum();
			long q = nextNum();
			long n = nextNum();
			long m = nextNum();
			int tot = 0;
			for (int i = 0; i < 8; i++) {
				if (m >= arr[i])
					++tot;
				else
					break;
			}
			long ans = 0;
			for (int i = 1; i < (1 << tot); i++) { // ö������ // ���е����//��i�����Ʊ�ʾ 1��ʾʹ�õ�������0��ʾ��ʾδʹ�á���������ö�ٳ��������
				long temp = 1;
				int cnt = 0;
				for (int j = 0; j < tot; j++)
					if ((i & (1 << j)) != 0) {
						cnt++;
						temp *= arr[j];
					}
				if ((cnt & 1) != 0)
					ans += n / temp; // ���ż��
				else
					ans -= n / temp;
			}
			ans = n - ans;
			if (k != 0 && ans + k > q) {
				System.out.println("Yes");
			} else {
				System.out.println("QAQ");
			}
		}
	}

	private static long nextNum() {
		try {
			st.nextToken();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (long) st.nval;

	}
}
