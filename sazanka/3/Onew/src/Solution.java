import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	void solve() throws IOException {
		while (in.ready()) {
			int k = ni();
			int p = ni();

		}

	}

	Solution() throws IOException {
		Locale.setDefault(Locale.US);
		// in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("tests"));
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
