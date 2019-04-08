package 图论;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 最小生成树之Prim {//复杂的O(E+VlogV)
	static StreamTokenizer st = new StreamTokenizer(new BufferedInputStream(System.in));

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();//代表节点个数
			if(n==0)return;
			int len = sc.nextInt();// 边个数
			PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
			boolean has[] = new boolean[n + 1];//树中是否有该节点
			ArrayList<ArrayList<Edge>> al = new ArrayList<ArrayList<Edge>>();
			for (int i = 0; i <= n; i++) {
				al.add(new ArrayList<Edge>());
			}
			boolean use[] = new boolean[len + 1];//边是否用过
			for (int i = 1; i <= len; i++) {
				Edge Edge = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt(), i);
				al.get(Edge.x).add(Edge);
				al.get(Edge.y).add(Edge);
			}
			has[1] = true;
			int flag = 1;
			for (Edge b : al.get(1)) {
				pq.add(b);
				use[b.id] = true;
			}

			long ans = 0;
			while (!pq.isEmpty()) {
				Edge te = pq.poll();
				if (has[te.x] && has[te.y]) {
					continue;
				} else if (has[te.x]) {
					flag++;
					ans += te.h;
					has[te.y] = true;
					for (Edge Edge : al.get(te.y)) {
						if ((has[Edge.x] && has[Edge.y]) || use[Edge.id]) {
							continue;
						} else {
							pq.add(Edge);
							if (Edge.id != 0) {
								use[Edge.id] = true;
							}
						}
					}
				} else {
					flag++;
					ans += te.h;
					has[te.x] = true;
					for (Edge Edge : al.get(te.x)) {
						if ((has[Edge.x] && has[Edge.y]) || use[Edge.id]) {
							continue;
						} else {
							pq.add(Edge);
							if (Edge.id != 0) {
								use[Edge.id] = true;
							}
						}
					}
				}
				if (flag >= n) {
					break;
				}
			}
			System.out.println(ans);
		}
	}

	private static long quick(long m, long n, long mod) {
		if (n == 0)
			return 1;
		if ((n) == 1) {
			return m;
		}
		if ((n & 1) == 0) {
			return quick(m * m % mod, n >> 1, mod) % mod;
		} else
			return m * quick(m * m % mod, n >> 1, mod) % mod;
	}

	private static int nextNum() {
		try {
			st.nextToken();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (int) st.nval;

	}

	static String next() {
		try {
			st.nextToken();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return st.sval;
	}
}

class Edge implements Comparable<Edge> {//边
	int x;
	int y;
	int h;
	int id;

	public Edge(int x, int y, int h, int id) {
		super();
		this.x = x;
		this.y = y;
		this.h = h;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Edge [x=" + x + ", y=" + y + ", h=" + h + "]";
	}

	@Override
	public int compareTo(Edge o) {

		return h - o.h;//
	}

}