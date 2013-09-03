import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	boolean[][] a;
	int n, m, i, j, dir;

	boolean next() {
		if (dir == 0) {
			if (j + 1 < n && !a[i][j + 1])
				return (a[i][++j] = true);
			else if (i - 1 >= 0 && !a[i - 1][j]) {
				dir = 1;
				return (a[--i][j] = true);
			}
		} else if (dir == 1) {
			if (i - 1 >= 0 && !a[i - 1][j])
				return (a[--i][j] = true);
			else if (j - 1 >= 0 && !a[i][j - 1]) {
				dir = 2;
				return (a[i][--j] = true);
			}
		} else if (dir == 2) {
			if (j - 1 >= 0 && !a[i][j - 1])
				return (a[i][--j] = true);
			else if (i + 1 < m && !a[i + 1][j]) {
				dir = 3;
				return (a[++i][j] = true);
			}
		} else if (dir == 3) {
			if (i + 1 < m && !a[i + 1][j])
				return (a[++i][j] = true);
			else if (j + 1 < n && !a[i][j + 1]) {
				dir = 0;
				return (a[i][++j] = true);
			}
		}
		return false;
	}

	void print() {
		for (int u = 0; u < m; u++) {
			for (int o = 0; o < n; o++) {
				if (a[u][o])
					out.print("x");
				else
					out.print("0");
			}
			out.println();
		}
		for (int i = 0; i < n; i++) {
			out.print("-");
		}
		out.println("-");
	}

	void solve() throws IOException {
		n = ni();
		m = ni();
		a = new boolean[m][n];
		i = m - 1;
		a[i][j] = true;

		while (true) {
			// print();
			if (!next()) {
				out.println(j + " " + (m - 1 - i));
				return;
			}
		}
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
