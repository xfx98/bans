package DP;
import java.util.Scanner;
//给定一个数组取从两端取数字，求先手和后手的取值和
public class 取数游戏 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int array[] = new int[n + 1];
		int sum[] = new int[n + 1];
		int gain[][] = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			array[i] = sc.nextInt();
			sum[i] += sum[i - 1] + array[i];
			gain[i][i] = array[i];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n-i+1; j++) {
				gain[j][j+i] = sum[j+i] - sum[j-1] - Math.min(gain[j+1][j+i], gain[j][j+i-1]);
			}

		}
		System.out.println(gain[1][n] + " " + (sum[n] - gain[1][n]));

	}
}
