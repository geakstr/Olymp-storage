import java.util.*;
import java.io.*;
import java.math.BigInteger;

import static java.lang.Math.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	void solve() throws IOException {
		long k = nl(), r = nl(), n = nl();
		long ans = 0;
		for (int i = 0; i < n; i++) {
			int num = ni();
			if (num == k) {
				ans += r;
				continue;
			}
			if (num > k) {
				ans += (r * 2);
				continue;
			}
			if (num < k) {
				ans += (r - (k - num));
				continue;
			}
		}
		
		out.println(ans);
	}

	public Main() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
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

	Integer ni() throws IOException {
		return Integer.valueOf(ns());
	}

	Double nd() throws IOException {
		return Double.valueOf(ns());
	}

	Long nl() throws IOException {
		return Long.valueOf(ns());
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}
}
