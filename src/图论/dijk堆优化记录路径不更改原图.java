package 图论;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.PriorityQueue;
import java.util.Scanner;

public class dijk堆优化记录路径不更改原图 {//有点问题
	static StreamTokenizer st = new StreamTokenizer(new BufferedInputStream(System.in));

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tu[][] = new int[505][505];
		for (int i = 0; i < 505; i++) {
			for(int j = 0;j<505;j++) {
				tu[i][j]=-1;
			}
		}
		int N = nextNum();
		int M = nextNum();
		int S = nextNum();
		int D = nextNum();
		int ni[] = new int[N];
		for (int i = 0; i < N; i++) {
			ni[i] = nextNum();
		}
		for (int i = 0; i < M; i++) {
			tu[nextNum()][nextNum()] = nextNum();
		}
		boolean used[] = new boolean[505];
		PriorityQueue<Code> pq = new PriorityQueue<>();
		pq.add(new Code(1, 0,S));
		pq.peek().lj[0] = S;
		Code ans = new Code(999, 9999999, D);
		while (!pq.isEmpty()) {
			Code c = pq.poll();
			if(used[c.cs]) {
				continue;
			}
			used[c.cs] = true;
			if(c.cs==D) {
				if(c.min<ans.min) {
					ans = c;					
				}
				continue;
			}
			for (int i = 0; i < N; i++) {
				if (tu[c.cs][i] != -1 && c.cs != i && !used[i]) {
					Code te = new Code(c.length+1,c.min+tu[c.cs][i],i);
					for(int j = 0;j<c.length;j++) {
						te.lj[j] = c.lj[j];
					}
					te.lj[te.length-1] = i;
					pq.add(te);
				}
			}
		}
		int jy = 0;
		for (int i = 0;i<ans.length;i++) {
			jy+=ni[ans.lj[i]];
		}
		
		System.out.println(ans.length-1+" "+jy);
		for (int i = 0;i<ans.length-1;i++) {
			System.out.print(ans.lj[i]+" ");
		}
		System.out.print(ans.lj[ans.length-1]);
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

class Code implements Comparable<Code> {
	int lj[] = new int[505];//路径
	int length = 0;//路径长度
	int min = 0;//最短距离
	int cs;//当前位置


	public Code(int length, int min, int cs) {
		this.length = length;
		this.min = min;
		this.cs = cs;
	}


	@Override
	public int compareTo(Code o) {
		return min - o.min;
	}

}