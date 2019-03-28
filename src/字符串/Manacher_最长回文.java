package 字符串;

import java.util.Scanner;

public class Manacher_最长回文 {
	public static void main(String[] args) {
		Manacher_最长回文 m = new Manacher_最长回文();
		Scanner sc = new Scanner(System.in);
		char s[] = sc.next().toCharArray();
		char s_new[] = new char[2 * s.length + 3];
		int p[] = new int[2 * s.length + 3];
		s_new[0] = '$';
		s_new[1] = '#';
		int j = 2;
		for (int i = 0; i < s.length; i++) {
			s_new[j++] = s[i];
			s_new[j++] = '#';
		}
		s_new[j] = '\0'; // 防止越界
		int len = j; // 新字符串长度
		int max_len = -1; // 最长回文长度
		int id = 0;//最右边界回文的中心点
		int mx = 0;//最右边界
		for (int i = 1; i < len; i++) {
			if (i < mx)
				p[i] = Math.min(p[2 * id - i], mx - i); 
			// 根据回文串的性质，该字符串的回文半径，必定为该点对称点的长和 边界值到该点的值。
			//因为回文两边相同，对称点的回文长必定相同，但不能超过最长的边界，因为那不属于该回文，不予对称点相同。
			else
				p[i] = 1;

			while (s_new[i - p[i]] == s_new[i + p[i]]) // 不需边界判断，因为左有'$',右有'\0'
				p[i]++;//扩展当前的最长回文半径，得到该点的回文半径。
			if (mx < i + p[i]) {//更新当前最大的右边界。进行扩展
				id = i;
				mx = i + p[i];
			}

			max_len = Math.max(max_len, p[i] - 1);//更新最长回文数
		}
		System.out.println(max_len);

	}

}
