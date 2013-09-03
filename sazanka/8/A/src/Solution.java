import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	void solve() throws IOException {
		while (in.ready()) {
			char[] s = in.readLine().toCharArray();
			int n = s.length;

			int[] d1 = new int[n], d2 = new int[n];
			for (int i = 0, l = 0, r = -1; i < n; i++) {
				int k = (i > r ? 1 : min(d1[l + r - i], r - i));
				while (i - k >= 0 && i + k < n && s[i - k] == s[i + k])
					k++;
				if (i + k - 1 > r) {
					l = i - k + 1;
					r = i + k - 1;
				}
				d1[i] = k;
				out.print(k + " ");
			}
			out.println();
			for (int i = 0, l = 0, r = -1; i < n; i++) {
				int k = (l > r ? 0 : min(d2[l + r - i + 1], r - i + 1));
				while (i - k - 1 >= 0 && i + k < n && s[i - k - 1] == s[i + k])
					k++;
				if (i + k - 1 > r) {
					l = i - k;
					r = i + k - 1;
				}
				d2[i] = k;
				out.print(k + " ");
			}

			out.println();
		}
	}

	Solution() throws IOException {
		Locale.setDefault(Locale.US);
		// in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("in"));
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