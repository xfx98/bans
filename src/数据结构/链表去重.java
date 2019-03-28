package 数据结构;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class 链表去重 {//给地址、数据、下一地址，去掉重复数据
	static StreamTokenizer st = new StreamTokenizer(new BufferedInputStream(System.in));

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int first = nextNum();
		int N = nextNum();
		boolean use[] = new boolean[10005];
		int del = -1;
		Code adr[] = new Code[100005];
		for (int i = 0; i < N; i++) {
			adr[nextNum()] = new Code(nextNum(), nextNum());
		}
		int now = first;
		int delnow = 0;
		int pre = first;
		while (adr[now].next != -1) {
			if (!use[Math.abs(adr[now].data)]) {
				use[Math.abs(adr[now].data)] = true;
				pre = now;
				now = adr[now].next;
			} else {//判重去除此节点到删除链表
				if (del != -1) {
					adr[delnow].next = now;
					delnow = now;
				} else {
					del = now;
					delnow = del;
				}
				adr[pre].next = adr[now].next;
//				pre = now;
				now = adr[now].next;
				adr[delnow].next = -1;
			}
		}
		if (!use[Math.abs(adr[now].data)]) {
			use[Math.abs(adr[now].data)] = true;
			pre = now;
			now = adr[now].next;
		} else {
			if (del != -1) {
				adr[delnow].next = now;
				delnow = now;
			} else {
				del = now;
				delnow = del;
			}
			adr[pre].next = adr[now].next;
//			pre = now;
			now = adr[now].next;
			adr[delnow].next = -1;
		}
		
		while (adr[first].next != -1) {
			System.out.printf("%05d %d %05d\n", first, adr[first].data, adr[first].next);
			first = adr[first].next;
		}
		System.out.printf("%05d %d -1\n", first, adr[first].data);
		if (del != -1) {
			while (adr[del].next != -1) {
				System.out.printf("%05d %d %05d\n", del, adr[del].data, adr[del].next);
				del = adr[del].next;
			}
			System.out.printf("%05d %d -1\n", del, adr[del].data);
		}
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

class Code {
	int data;
	int next;

	public Code(int data, int next) {
		super();
		this.data = data;
		this.next = next;
	}
}