import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	void solve() throws IOException {
		int x = ni(), y = ni(), d = ni();

		int ans = 0;
		double r = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

		if (d > r) {
			ans = 2;
		} else {
			r = Math.ceil(r);
			ans = (int) Math.ceil(r / d);
		}
		out.println(ans);
	}

	public Main() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new InputStreamReader(System.in));
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
