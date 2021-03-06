import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	int[] p(String s) {
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
		int n = ni();

		int z[] = new int[n];

		for (int i = 0; i < n; i++) {
			z[i] = ni();
		}

		int p[] = new int[n * 2];
		for (int i = 1; i < n; i++) {
			p[i + z[i] - 1] = Math.max(p[i + z[i] - 1], z[i]);
		}

		for (int i = n - 1; i >= 0; i--) {
			p[i] = Math.max(p[i + 1] - 1, p[i]);
		}

		for (int i = 0; i < n; i++) {
			out.print(p[i] + " ");
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
