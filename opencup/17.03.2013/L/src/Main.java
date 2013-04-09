import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	String rev(String s) {
		String ret = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			ret += s.charAt(i);
		}
		return ret;
	}

	void solve() throws IOException {
		int c = ni();
		String ans = "";
		for (int i = 0; i < c; i++) {
			String a = ns(), b = ns();
			if (a.length() != b.length()) {
				ans += "Case #" + (i + 1) + ": NO\n";
				continue;
			}
			if (a.equals(b)) {
				ans += "Case #" + (i + 1) + ": YES\n";
				continue;
			}
			int len = a.length();
			boolean check = false;
			//out.println("a : " + a);
			for (int j = 0; j < len; j++) {
				String t = b.substring(0, j);
				String s = b.substring(j, len);
				String r = s + t;
				//out.println(" b1 : " + r);
				if (a.equals(r)) {
					check = true;
					ans += "Case #" + (i + 1) + ": YES\n";
					break;
				}
				t = b.substring(len - j, len);
				s = b.substring(0, len - j);
				r = t + s;
				r = rev(r);
				//out.println(" b2 : " + r);
				if (a.equals(r)) {
					check = true;
					ans += "Case #" + (i + 1) + ": YES\n";
					break;
				}
			}
			if (!check) {
				ans += "Case #" + (i + 1) + ": NO\n";
				continue;
			}
		}

		out.println(ans.trim());
	}

	public Main() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		in.close();
		out.close();
	}

	String ns() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		return st.nextToken();
	}

	Integer ni() throws IOException {
		return Integer.valueOf(ns());
	}

	Double nd() throws IOException {
		return Double.valueOf(ns());
	}

	Long nl() throws IOException {
		return Long.valueOf(ns());
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}
}
