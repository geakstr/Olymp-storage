import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	int watt(int num) {
		String s = String.valueOf(num);

		int a = Integer.bitCount(s.charAt(0) - 48);
		if (s.length() == 1) {
			return a;
		}
		return a + Integer.bitCount(s.charAt(1) - 48);
	}

	void solve() throws IOException {
		String l = ns();
		String r = ns();

		String[] la = l.split(":");

		int h1 = Integer.valueOf(la[0]);
		int m1 = Integer.valueOf(la[1]);
		int s1 = Integer.valueOf(la[2]);

		double ans = watt(h1) + watt(m1) + watt(s1);
		if (!l.equals(r)) {
			String[] ra = r.split(":");
			int h2 = Integer.valueOf(ra[0]);
			int m2 = Integer.valueOf(ra[1]);
			int s2 = Integer.valueOf(ra[2]);
			while (h1 != h2 || m1 != m2 || s1 != s2) {
				if (s1 == 59) {
					s1 = 0;
					if (m1 == 59) {
						m1 = 0;
						if (h1 == 12) {
							h1 = 1;
						} else {
							h1++;
						}
					} else {
						m1++;
					}
				} else {
					s1++;
				}
				ans += watt(h1) + watt(m1) + watt(s1);
			}
		}

		out.printf("%.10f", ans / 1000.0 / 3600.0);
	}

	Solution() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new OutputStreamWriter(System.out));
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

	int ni() throws IOException {
		return Integer.valueOf(ns());
	}

	double nd() throws IOException {
		return Double.valueOf(ns());
	}

	long nl() throws IOException {
		return Long.valueOf(ns());
	}

	public static void main(String[] args) throws IOException {
		new Solution();
	}
}
