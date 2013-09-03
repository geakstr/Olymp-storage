import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	void solve() throws IOException {
		String s = ns();
		int len = s.length();

		if (len < 3) {
			out.println("No");
			return;
		}

		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < len; i++) {
			set.add(s.charAt(i));
		}

		if (set.size() == 2 && len % 2 == 0) {
			boolean check = false;
			for (int i = 1; i < len; i++) {
				if (s.charAt(i) == s.charAt(i - 1)) {
					check = true;
					break;
				}
			}
			if (!check) {
				out.println("No");
				return;
			}
		}

		if (set.size() >= 2) {
			out.println("Yes");
			return;
		}

		out.println("No");
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
