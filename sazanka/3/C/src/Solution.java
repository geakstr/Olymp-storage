import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	int[] prefix(String s) {
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
		String s = ns();
		int[] prefix = prefix(s);

		for (int i = 0; i < s.length(); i++) {
			out.print(prefix[i] + " ");
		}
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
