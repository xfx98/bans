package 数学;

import java.util.Scanner;

public class 分数相加 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		fs ans = new fs(sc.next());
		while (--n > 0) {
			ans.add(new fs(sc.next()));
		}
		System.out.println(ans);
	}
}

class fs {
	long fz;
	long fm;

	public fs(String s) {
		String te[] = s.split("/");
		this.fz = Integer.parseInt(te[0]);
		this.fm = Integer.parseInt(te[1]);
	}

	public void add(fs add) {
		long fm = this.fm * add.fm;
		long fz = this.fz * add.fm + this.fm * add.fz;
		long g = gcd(fz, fm);
		this.fz = fz / g;
		this.fm = fm / g;
	}

	public static long gcd(long a, long b) {
		a = Math.abs(a);
		b = Math.abs(b);
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);

	}

	@Override
	public String toString() {
		if (fm == 1) {
			return fz + "";
		}
		if (fz > fm) {
			return fz / fm + " " + (fz % fm) + "/" + fm;
		}
		return fz + "/" + fm;
	}

}