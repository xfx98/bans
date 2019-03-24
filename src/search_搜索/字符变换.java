package search_搜索;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
//给定变换的开始、末尾和变换规则若干，判断能否在十步以内，由开始转变为末尾
public class 字符变换 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, ArrayList<String>> hm = new HashMap<>();
		String beg = sc.next();
		String end = sc.next();
		HashSet<String> use = new HashSet<>();
		while (sc.hasNext()) {
			String a = sc.next();
			String b = sc.next();

			ArrayList<String> al = hm.get(a);
			if (al != null) {
				al.add(b);
			} else {
				ArrayList<String> te = new ArrayList<>();
				te.add(b);
				hm.put(a, te);
			}
		}

		Set<String> hs = hm.keySet();
		Queue<String> q = new LinkedList<>();
		q.add(beg);
		use.add(beg);
		int ci = 0;
		int next = 0;
		int now = 1;
		boolean flag = false;
		while (!q.isEmpty()) {
			String s = q.poll();
			now--;
			if (s.equals(end)) {
				flag = true;
				break;
			}
			for (String str : hs) {
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == str.charAt(0)) {
						boolean test = true;
						for (int j = 0; j < str.length(); j++) {
							if (i+j>=s.length()||s.charAt(i + j) != str.charAt(j)) {
								test = false;
							}
						}
						if (test) {
							ArrayList<String> re = hm.get(str);
							for (String string : re) {
								String temp = s.substring(0, i) + string + s.substring(i + str.length(), s.length());
								if(!use.contains(temp)) {
									q.add(temp);
									use.add(temp);
									next++;
								}
							}
						}
					}
				}
			}
			if (now <= 0) {
				now = next;
				ci++;
				if (ci > 10) {
					break;
				}
				next = 0;
			}
		}
		if (flag) {
			System.out.print(ci);
		} else {
			System.out.print("NO ANSWER!");
		}

	}
}