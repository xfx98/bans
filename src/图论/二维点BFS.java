package Í¼ÂÛ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ¶þÎ¬µãBFS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] ar = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < m; j++) {
				ar[i][j] = (s.charAt(j) == '.' ? 1 : 0);
			}
		}
		int sum = 0;
		Queue<point> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if(ar[i][0]==1) {
				q.add(new point(i,0 ));
				ar[i][0] = 0;
				sum++;
			}
			if(ar[i][m-1] == 1) {
				q.add(new point(i,m-1));
				ar[i][m-1] = 0;
				sum++;
			}
		}
		for (int i = 0; i < m; i++) {
			if(ar[0][i]==1) {
				q.add(new point(0, i));
				ar[0][i] = 0;
				sum++;
			}
			if(ar[n-1][i] == 1) {
				q.add(new point(n-1, i));
				ar[n-1][i] = 0;
				sum++;
			}
		}
		while (!q.isEmpty()) {
			point p = q.poll();
			if(p.x-1>0&&ar[p.x-1][p.y]==1) {
				sum++;
				q.add(new point(p.x-1, p.y));
				ar[p.x-1][p.y] = 0;
			}
			if(p.y-1>0&&ar[p.x][p.y-1]==1) {
				sum++;
				q.add(new point(p.x, p.y-1));
				ar[p.x][p.y-1] = 0;
			}
			if(p.x+1<n&&ar[p.x+1][p.y]==1) {
				sum++;
				q.add(new point(p.x+1, p.y));
				ar[p.x+1][p.y] = 0;
			}
			if(p.y+1<m&&ar[p.x][p.y+1]==1) {
				sum++;
				q.add(new point(p.x, p.y+1));
				ar[p.x][p.y+1] = 0;
			}
		}
		System.out.println(m*n-sum);
	}
}
class point{
	int x,y;
	public point(int x,int y) {
		this.x = x;
		this.y = y;
	}
}


