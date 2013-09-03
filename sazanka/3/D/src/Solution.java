import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	int[] z(String s) {
		int n = s.length();
		int[] ret = new int[n];

		int l = 0, r = 0;
		for (int i = 1; i < n; i++) {
			if (i <= r) {
				ret[i] = Math.min(r - i + 1, ret[i - l]);
			}
			while (i + ret[i] < n && s.charAt(ret[i]) == s.charAt(i + ret[i])) {
				ret[i]++;
			}
			if (i + ret[i] - 1 > r) {
				l = i;
				r = i + ret[i] - 1;
			}
		}

		return ret;
	}

	void solve() throws IOException {
		String s = ns();
		int[] z = z(s);

		for (int i = 0; i < s.length(); i++) {
			out.print(z[i] + " ");
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
