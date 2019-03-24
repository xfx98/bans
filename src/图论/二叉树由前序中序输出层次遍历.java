import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {//输出二叉树的镜像层次遍历，镜像是所有左子树和右子树交换的结果
	static StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));

	static int bc[];

	public static void main(String[] args) {
		int n = nextInt();
		int q[] = new int[n+1];
		int z[] = new int[n+1];
		for(int i = 0;i<n;i++) {
			z[i] = nextInt();
		}
		for(int i = 0;i<n;i++) {
			q[i] = nextInt();
		}
		int c[] = new int[n+1];
		Queue<Node> que = new LinkedList<Node>();
		que.add(new Node(0, n, 0, n));
		int cont = 0;
		while(!que.isEmpty()) {
			Node te = que.poll();
			c[cont++] = q[te.ql];
			for(int i = te.zl;i<te.zr;i++) {
				if(z[i]==q[te.ql]) {
					if(i<te.zr-1) {
						que.add(new Node(i-te.zl+te.ql+1, te.qr, i+1, te.zr));						
					}
					if(i>te.zl) {
						que.add(new Node(te.ql+1, i-te.zl+te.ql, te.zl, i));
					}
					
					break;
				}
			}
		}
		System.out.print(c[0]);
		for(int i = 1;i<n;i++) {
			System.out.print(" "+c[i]);
		}
	}

	static int nextInt() {
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
class Node{
	int ql;
	int qr;
	int zl;
	int zr;
	public Node(int ql, int qr, int zl, int zr) {
		this.ql = ql;
		this.qr = qr;
		this.zl = zl;
		this.zr = zr;
	}
	@Override
	public String toString() {
		return "Node [ql=" + ql + ", qr=" + qr + ", zl=" + zl + ", zr=" + zr + "]";
	}
	
}

