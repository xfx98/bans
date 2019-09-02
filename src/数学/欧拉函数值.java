
public class 欧拉函数值 {
	public static void main(String[] args) {
		System.out.println(test(100000));
	}
	static int test(int a) {
		if(a==0)
			return 1;
		return test(a-1);
	}
	static long phi(int x) {
		long res = x;
		for (long i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0) {
				while (x % i == 0)
					x /= i;
				res = res / i * (i - 1);
			}
		}
		if (x > 1)
			res = res / x * (x - 1);
		return res;
	}
	static int[] make_phi() {//筛法
		int N = 1000005;
		int prime[] = new int[N], phi[] = new int[N], cnt = 0;
		int n = 1000000;
		boolean vis[] = new boolean[N];
		vis[0] = vis[1] = true;
		for (int i = 2; i <= n; i++) {
			if (!vis[i]) {
				prime[++cnt] = i;
				phi[i] = i - 1;
			}
			for (int j = 1; j <= cnt && prime[j] * i <= n; j++) {
				vis[i * prime[j]] = true;
				if (i % prime[j] == 0) {
					phi[i * prime[j]] = phi[i] * prime[j];
					break;
				} else
					phi[i * prime[j]] = phi[i] * (prime[j] - 1);
			}
		}
		return phi;
	}
}
