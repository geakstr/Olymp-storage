import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	void solve() throws IOException {
		while (in.ready()) {
			String s = in.readLine();
			s += s;
			char[] ch = s.toCharArray();
			int n = s.length(), i = 0, ans = 0;
			while (i < n / 2) {
				ans = i;
				int j = i + 1, k = i;
				while (j < n && ch[k] <= ch[j])
					k = (ch[k] < ch[j++] ? i : k + 1);
				while (i <= k)
					i += j - k;
			}
			out.println(s.substring(ans, ans + n / 2));
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