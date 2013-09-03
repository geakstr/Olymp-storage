import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	void solve() throws IOException {
		int x = ni(), y = ni(), p = ni();

		int ans = Integer.MAX_VALUE;
		for (int a = 1; a <= 1000; a++) {
			for (int b = 1; b <= 1000; b++) {
				if ((a * x + b * y) % p == 0) {
					if (a + b < ans) {
						ans = a + b;
					}
				}
			}
		}
		out.println(ans);
	}

	Solution() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new InputStreamReader(System.in));
		// in = new BufferedReader(new FileReader("in"));
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
