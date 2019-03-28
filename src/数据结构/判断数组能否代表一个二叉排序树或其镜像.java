package 数据结构;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class 判断数组能否代表一个二叉排序树或其镜像 {

	static StreamTokenizer st = new StreamTokenizer(new BufferedInputStream(System.in));

	static int out[] = new int[1005];// 后序遍历结果
	static int next;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = nextNum();
		next = N;
		if (N == 0) {
			System.out.println("YES");
			return;
		}
		int arr[] = new int[1005];
		for (int i = 0; i < N; i++) {
			arr[i] = nextNum();
		}
		if (build(arr, 0, N, true, arr[0])) {
			System.out.println("YES");
			System.out.print(out[0]);
			for (int i = 1; i < N; i++) {
				System.out.print(" " + out[i]);
			}
		} else {
			next = N;
			if (buildjx(arr, 0, N, true, arr[0])) {
				System.out.println("YES");
				System.out.print(out[0]);
				for (int i = 1; i < N; i++) {
					System.out.print(" " + out[i]);
				}
			} else {
				System.out.println("NO");

			}
		}
	}

	/**
	 *  判断能否代表二叉排序树 
	 * @param arr 二叉树组
	 * @param l 左起始
	 * @param r 有终点
	 * @param lr 代表该树是左节点还是右节点，true为左节点 
	 * @param preRoot 为该树父节点
	 * @return 判断结果
	 */
	private static boolean build(int arr[], int l, int r, boolean lr, int preRoot) {
		if (l >= r) {
			return true;
		}
		int root = arr[l];
		out[--next] = root;// 存储其根
		if (lr) {
			for (int i = l + 1; i < r; i++) {
				if (root <= arr[i]) {// 当出现大于等于该根的时候，可认为剩余的为右子树
					// 后根遍历中有子树根节点后出所以先递归右节点，再递归左节点
					return build(arr, i, r, false, root) && build(arr, l + 1, i, true, root);
				}
			}
		} else {
			for (int i = l + 1; i < r; i++) {// 由于右子树都大于等于根，出现小于的时候，必然不能代表二叉树
				if (arr[i] < preRoot) {
					return false;
				}
			}
			for (int i = l + 1; i < r; i++) {
				if (root <= arr[i]) {
					return build(arr, i, r, false, root) && build(arr, l + 1, i, true, root);
				}
			}
		}
		return build(arr, l + 1, r, true, root);
	}

	/**
	 *  判断能否代表二叉排序树 和判断是否代表二叉排序树基本相同，只是变了下符号
	 * @param arr 二叉树组
	 * @param l 左起始
	 * @param r 有终点
	 * @param lr 代表该树是左节点还是右节点，true为左节点 
	 * @param preRoot 为该树父节点
	 * @return 判断结果
	 */
	private static boolean buildjx(int arr[], int l, int r, boolean lr, int preRoot) {
		if (l >= r) {
			return true;
		}
		int root = arr[l];
		out[--next] = root;
		if (lr) {
			for (int i = l + 1; i < r; i++) {
				if (root > arr[i]) {
					return buildjx(arr, i, r, false, root) && buildjx(arr, l + 1, i, true, root);
				}
			}
		} else {
			for (int i = l + 1; i < r; i++) {
				if (arr[i] > preRoot) {
					return false;
				}
			}
			for (int i = l + 1; i < r; i++) {
				if (root > arr[i]) {
					return buildjx(arr, i, r, false, root) && buildjx(arr, l + 1, i, true, root);
				}
			}
		}
		return buildjx(arr, l + 1, r, true, root);
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
