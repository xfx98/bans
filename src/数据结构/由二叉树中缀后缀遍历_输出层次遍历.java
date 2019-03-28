package 数据结构;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 由二叉树中缀后缀遍历_输出层次遍历 {
	static StreamTokenizer st = new StreamTokenizer(new BufferedInputStream(System.in));

	static int out[] = new int[32];
	static int next = 0;

	static int hx[] = new int[32];
	static int zx[] = new int[32];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = nextNum();
		for (int i = 0; i < N; i++) {
			hx[i] = nextNum();
		}
		for (int i = 0; i < N; i++) {
			zx[i] = nextNum();
		}
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, N, 0, N));
		while (!q.isEmpty()) {
			Node n = q.poll();
			int t = hx[n.hr - 1];
			out[next++] = hx[n.hr - 1];
			for (int i = n.zl; i < n.zr; i++) {
				if (zx[i] == hx[n.hr - 1]) {
					if (i > n.zl) {
						q.add(new Node(n.zl, i, n.hl, n.hl + (i - n.zl)));// 左子树进队
					}
					if (i < n.zr - 1) {
						q.add(new Node(i + 1, n.zr, n.hr - (n.zr - i), n.hr - 1)); // 右子树进队
					}
					break;
				}
			}
		}
		System.out.print(out[0]);
		for (int i = 1; i < N; i++)
			System.out.print(" " + out[i]);

	}

	private static int nextNum() {
		try {
			st.nextToken();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (int) st.nval;

	}
}

class Node {
	int zl;
	int zr;
	int hl;
	int hr;

	/**
	 * @param zl 中序数组左索引
	 * @param zr 中序数组右索引
	 * @param hl 后序数组左索引
	 * @param hr 后序数组右索引
	 */
	public Node(int zl, int zr, int hl, int hr) {
		this.zl = zl;
		this.zr = zr;
		this.hl = hl;
		this.hr = hr;
	}

	@Override
	public String toString() {
		return "Node [zl=" + zl + ", zr=" + zr + ", hl=" + hl + ", hr=" + hr + "]";
	}
}
