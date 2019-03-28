package �ַ���;

import java.util.Scanner;

public class Manacher_����� {
	public static void main(String[] args) {
		Manacher_����� m = new Manacher_�����();
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
		s_new[j] = '\0'; // ��ֹԽ��
		int len = j; // ���ַ�������
		int max_len = -1; // ����ĳ���
		int id = 0;//���ұ߽���ĵ����ĵ�
		int mx = 0;//���ұ߽�
		for (int i = 1; i < len; i++) {
			if (i < mx)
				p[i] = Math.min(p[2 * id - i], mx - i); 
			// ���ݻ��Ĵ������ʣ����ַ����Ļ��İ뾶���ض�Ϊ�õ�ԳƵ�ĳ��� �߽�ֵ���õ��ֵ��
			//��Ϊ����������ͬ���ԳƵ�Ļ��ĳ��ض���ͬ�������ܳ�����ı߽磬��Ϊ�ǲ����ڸû��ģ�����ԳƵ���ͬ��
			else
				p[i] = 1;

			while (s_new[i - p[i]] == s_new[i + p[i]]) // ����߽��жϣ���Ϊ����'$',����'\0'
				p[i]++;//��չ��ǰ������İ뾶���õ��õ�Ļ��İ뾶��
			if (mx < i + p[i]) {//���µ�ǰ�����ұ߽硣������չ
				id = i;
				mx = i + p[i];
			}

			max_len = Math.max(max_len, p[i] - 1);//�����������
		}
		System.out.println(max_len);

	}

}
