import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	int n = 0;
	int m = 0;
	int l = 0;

	int getI(int i, boolean dir) {
		int lc = l;

		int ans = i;
		if (dir) {
			if (i + lc < n) {
				return i + lc;
			}
			while (true) {
				ans++;
				lc--;
				if (ans == n)
					ans = 0;
				if (lc == 0)
					break;
			}
		} else {

			if (i - lc >= 0) {
				return i - lc;
			}
			while (true) {
				ans--;
				lc--;
				if (ans == -1)
					ans = n - 1;
				if (lc == 0)
					break;
			}
		}

		return ans;
	}

	void solve() throws IOException {
		n = ni();
		m = ni();
		l = ni();

		int[] a = new int[n];

		int ans = 0;
		int i = 0;
		while (true) {
			a[i]++;
			if (a[i] == m) {
				break;
			}
			if (a[i] % 2 == 1) {
				i = getI(i, false);
			} else {
				i = getI(i, true);
			}
			ans++;
		}

		out.println(ans);
	}

	Solution() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new InputStreamReader(System.in));
		// in = new BufferedReader(new FileReader("tests"));
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