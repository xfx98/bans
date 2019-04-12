package ���ݽṹ;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class �߶��� extends xds {
	static StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));

	public static void main(String[] args) {
		sc = new Scanner(System.in);
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

	static int nextNum() {
		try {
			st.nextToken();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (int) st.nval;
	}

	static int nextInt() {
		return 0;
	}
}

class xds {
	static Scanner sc;

	// �ڵ�����������
	static void push_down(int rt, int len, int lazy[], int tree[]) {
		tree[rt << 1] += lazy[rt] * (len - (len >> 1));
		lazy[rt << 1] += lazy[rt];
		tree[rt << 1 | 1] += lazy[rt] * (len >> 1);
		lazy[rt << 1 | 1] += lazy[rt];
		lazy[rt] = 0;
	}

	// �ڵ�����������,�������������ֵ, ������ֵ����Ҫ���Գ���, ���Բ���Ҫ���ݲ���len��
	void push_down(int rt, int lazy[], int tree[]) {
		tree[rt << 1] += lazy[rt];
		lazy[rt << 1] += lazy[rt];
		tree[rt << 1 | 1] += lazy[rt];
		lazy[rt << 1 | 1] += lazy[rt];
		lazy[rt] = 0;
	}

	/* ����������� */
	static void push_upSum(int rt, int tree[]) {
		tree[rt] = tree[rt << 1] + tree[rt << 1 | 1];
	}

	/* �������������ֵ */
	static void push_upMax(int rt, int tree[]) {
		tree[rt] = Math.max(tree[rt << 1], tree[rt << 1 | 1]);
	}

	static void updateOnly(int p, int delta, int n, int tree[]) {// �����������
		updateOnly(p, delta, 1, 1, n, tree);
	}

	static void updateOnly(int p, int delta, int rt, int l, int r, int tree[]) {// ִ��
		if (l == r) {
			tree[rt] += delta;
			while (rt > 1) {
				rt >>= 1;
				tree[rt] += delta;
			}
			return;
		}
		int m = (l + r) >> 1;
		if (p <= m)
			updateOnly(p, delta, rt << 1, l, m, tree);
		else
			updateOnly(p, delta, rt << 1 | 1, m + 1, r, tree);

	}

	// �ɶθ���, ��Ҫ�õ�lazy��������ʱ��Ч��
	static void update(int L, int R, int delta, int n, int lazy[], int tree[]) {
		update(L, R, delta, 1, 1, n, lazy, tree);
	}

	static void update(int L, int R, int delta, int rt, int l, int r, int lazy[], int tree[]) {
		if (L <= l && r <= R) {
			tree[rt] += delta * (r - l + 1);
			lazy[rt] += delta;
			return;
		}
		if (lazy[rt] != 0)
			push_down(rt, r - l + 1, lazy, tree);// �����������
		int m = (l + r) >> 1;
		if (L <= m)
			update(L, R, delta, rt << 1, l, m, lazy, tree);
		if (R > m)
			update(L, R, delta, rt << 1 | 1, m + 1, r, lazy, tree);
		push_upSum(rt, tree);// ����������ģ��˴����
	}
	// �����ѯ����
	static int find(int L, int R, int n, int tree[]) {
		return find(L, R, 1, 1, n, tree);
	}

	static int find(int L, int R, int rt, int l, int r, int tree[]) {
		if (L <= l && r <= R)
			return tree[rt];
		int m = (l + r) >> 1, ret = 0;
		if (L <= m)
			ret += find(L, R, rt << 1, l, m, tree);
		if (R > m)
			ret += find(L, R, rt << 1 | 1, m + 1, r, tree);
		return ret;
	}

	static void buildTree(int rt, int l, int r, int tree[]) {// ����
		if (l == r) {
			tree[rt] = sc.nextInt();
			return;
		}
		int m = (l + r) >> 1;
		buildTree(rt << 1, l, m, tree);
		buildTree(rt << 1 | 1, m + 1, r, tree);
		tree[rt] = tree[rt << 1] + tree[rt << 1 | 1];
	}
}