import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	void solve() throws IOException {
		char[] s = in.readLine().toCharArray();
		Set<Character> set = new HashSet<Character>();

		int n = s.length;
		for (int i = 0; i < n; i++) {
			int j = i;
			StringBuilder tmp = new StringBuilder();
			while (j < n && s[i] == s[j]) {
				tmp.append(s[j++]);
			}
			i = j - 1;
			if (set.contains(tmp.toString().charAt(0))) {
				out.println("NO");
				return;
			}
			set.add(tmp.toString().charAt(0));
			//out.println(tmp);
		}
		out.println("YES");

	}

	Solution() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new InputStreamReader(System.in));
		//in = new BufferedReader(new FileReader("in"));
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
