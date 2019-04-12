package 数据结构;

public class 树状数组 {
	static int A[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
	static int MAX_N = A.length;
	static int BIT[] = new int[MAX_N + 1];

	static int lowbit(int x) {
		return x & (-x);
	}

	static void build() {
		for (int i = 1; i <= MAX_N; i++) {
			BIT[i] = A[i - 1];
			for (int j = i - 2; j >= i - lowbit(i); j--)
				BIT[i] += A[j];
		}
	}

	static void edit(int i, int delta) {
		for (int j = i; j <= MAX_N; j += lowbit(j))
			BIT[j] += delta;
	}

	static int sum(int k) {
		int ans = 0;
		for (int i = k; i > 0; i -= lowbit(i))
			ans += BIT[i];
		return ans;
	}

	public static void main(String[] args) {
		build();
		System.out.println(sum(6));
		edit(3, 3);
		System.out.println(sum(7));
	}

}
