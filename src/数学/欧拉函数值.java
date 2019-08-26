
public class Å·À­º¯ÊýÖµ {
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

	static int[] allphi(int sz) {
		boolean isprime[] = new boolean[sz + 5];
		int prime[] = new int[sz + 5];
		int primesz = 0;
		int phi[] = new int[sz + 5];
		for (int i = 2; i < sz; i++) {
			if (!isprime[i]) {
				phi[i] = i - 1;
				prime[primesz++] = i;
			}
			for (int j = 0; j < primesz && i * prime[i] < sz; j++) {
				prime[i * prime[j]] = 1;
				if(i % prime[j] == 0) {
					phi[i * prime[j]] = phi[i] * phi[prime[j]];
					break;
				}
				phi[i*prime[j]] = phi[i]*(phi[prime[j]] -1);
			}
		}
		return phi;
	}
}
