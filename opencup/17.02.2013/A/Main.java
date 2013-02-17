import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	int h, w;
	char[][] a, b;

	void solve() throws IOException {
		h = ni();
		w = ni();
		a = new char[h][w];

		for (int i = 0; i < h; i++) {
			String s = ns();
			for (int k = 0; k < w; k++)
				a[i][k] = s.charAt(k);
		}

		for (int i = 0; i < w; i++) {
			for (int j = h - 1; j >= 0; j--) {
				out.print(a[j][i]);
			}
			out.println();
		}

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
