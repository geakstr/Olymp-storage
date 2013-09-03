import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	int[] p(StringBuilder s) {
		int n = s.length();
		int[] ret = new int[n];

		for (int i = 1; i < n; i++) {
			int j = ret[i - 1];
			while (j > 0 && s.charAt(j) != s.charAt(i)) {
				j = ret[j - 1];
			}
			if (s.charAt(j) == s.charAt(i)) {
				j++;
				ret[i] = j;
			}
		}

		return ret;
	}

	void solve() throws IOException {
		StringBuilder s = new StringBuilder(ns());

		int len = s.length();

		StringBuilder tmp = new StringBuilder();
		for (int i = len - 1; i >= 0; i--) {
			tmp.append(s.charAt(i));
		}
		s.append(tmp);

		int p[] = p(s);

		out.println(Math.min(len, p[2 * len - 1]));

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
