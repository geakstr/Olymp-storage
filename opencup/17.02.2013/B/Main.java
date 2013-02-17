import java.util.*;
import java.io.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	int t, c;
	long[] a;

	void solve() throws IOException {
		t = ni();
		c = ni();
		a = new long[t];
		Arrays.fill(a, 0L);

		int start = t / 2;
		for (long i = 0; i < c; i++)
			for (int j = 0; j < t; j++) {
				int tj = ni() - 1;
				if (j > start - 1)
					a[tj] |= (1L << (long) i);
			}

		for (int i = 0; i < t; i++)
			for (int j = i + 1; j < t; j++)
				if ((a[i] ^ a[j]) == 0L) {
					out.println("NO");
					return;
				}

		out.println("YES");
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