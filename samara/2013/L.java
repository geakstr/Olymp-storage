package pack;

import java.util.*;
import java.io.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	void solve() throws IOException {
		int n = ni(), u = ni();

		if (u >= n) {
			out.println(-1);
			return;
		}

		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = ni();
		}

		Arrays.sort(a);

		out.println(a[u]);
	}

	public Main() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new FileReader("input.txt"));
		out = new PrintWriter("output.txt");
		solve();
		in.close();
		out.close();
	}

	String ns() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
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
		new Main();
	}

}
