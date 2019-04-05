package 数据结构;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class 线段树_单点修改_区间查询 {
	static StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int t = sc.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = sc.nextInt();
			int sum[] = new int[n * 4 + 5];
			buildTree(1, 1, n, sum);
			System.out.println("Case " + i + ":");
			while (sc.hasNext()) {
				String s = sc.next();

				if (s.charAt(0) == 'A') {
					updateOnly(sc.nextInt(), sc.nextInt(), n, sum);
				} else if (s.charAt(0) == 'S') {
					updateOnly(sc.nextInt(), -sc.nextInt(), n, sum);
				} else if (s.charAt(0) == 'Q') {
					System.out.println(find(sc.nextInt(), sc.nextInt(), n, sum));
				} else {
					break;
				}
			}

		}

	}

	static void updateOnly(int p, int delta, int n, int sum[]) {// 单点更新
		updateOnly(p, delta, 1, 1, n, sum);
	}

	static void updateOnly(int p, int delta, int rt, int l, int r, int sum[]) {
		if (l == r) {
			sum[rt] += delta;
			while (rt > 1) {
				rt >>= 1;
				sum[rt] += delta;
			}
			return;
		}
		int m = (l + r) >> 1;
		if (p <= m)
			updateOnly(p, delta, rt << 1, l, m, sum);
		else
			updateOnly(p, delta, rt << 1 | 1, m + 1, r, sum);

	}

	static int find(int L, int R, int n, int sum[]) {// 区间查询
		return find(L, R, 1, 1, n, sum);
	}

	static int find(int L, int R, int rt, int l, int r, int sum[]) {
		if (L <= l && r <= R)
			return sum[rt];
		int m = (l + r) >> 1, ret = 0;
		if (L <= m)
			ret += find(L, R, rt << 1, l, m, sum);
		if (R > m)
			ret += find(L, R, rt << 1 | 1, m + 1, r, sum);
		return ret;
	}

	static void buildTree(int rt, int l, int r, int sum[]) {// 建树
		if (l == r) {
			sum[rt] = sc.nextInt();
			return;
		}
		int m = (l + r) >> 1;
		buildTree(rt << 1, l, m, sum);
		buildTree(rt << 1 | 1, m + 1, r, sum);
		sum[rt] = sum[rt << 1] + sum[rt << 1 | 1];
	}

	static int nextNum() {
		try {
			st.nextToken();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (int) st.nval;
	}
}
