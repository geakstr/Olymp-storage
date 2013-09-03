import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	void solve() throws IOException {
		int n = ni();

		int[] c = new int[n];
		for (int i = 0; i < n; i++)
			c[i] = ni();

		int m = ni();
		int[] p = new int[m];
		for (int i = 0; i < m; i++)
			p[i] = ni();

		for (int i = 0, pi = 0; i < n && pi < m; i++)
			if (p[pi] <= c[i])
				c[i--] -= p[pi++];

		int ans = 0;
		for (int i = 0; i < n; i++)
			ans += c[i];
		out.println(ans);
	}

	Solution() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new InputStreamReader(System.in));
		// in = new BufferedReader(new FileReader("tests"));
		out = new PrintWriter(new OutputStreamWriter(System.out));
		// out = new PrintWriter("out");
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