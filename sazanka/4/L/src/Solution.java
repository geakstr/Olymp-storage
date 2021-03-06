import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	void solve() throws IOException {
		StringBuilder s = new StringBuilder(in.readLine());
		StringBuilder ans = new StringBuilder();

		int n = s.length();

		for (int i = 0; i < n;) {
			char ch = s.charAt(i);
			ans.append(ch);
			boolean check = false;
			i++;
			while (i < n && ch == s.charAt(i)) {
				check = true;
				i++;
			}
			if (check) {
				ans.append(ch);
			}
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
