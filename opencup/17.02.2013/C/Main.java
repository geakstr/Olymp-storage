import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	void solve2() throws IOException {
		long h = nl(), w = nl(), k = nl();

		h = k * (h / k);
		w = k * (w / k);

		if (h < k || w < k) {
			out.println("0");
			return;
		}

		long ans = 0;
		if (h == w && h == k)
			ans = 1;
		else if (h > k && w == k)
			ans = h / k;
		else if (w > k && h == k)
			ans = w / k;
		else if (h > k && w > k)
			ans = h * 2 / k + w * 2 / k - 4;

		if (ans < 0) {
			ans = 0;
		}

		out.println(ans);
	}

	void solve() throws IOException {
		int h = ni(), w = ni(), k = ni();
		int ans = 0;

		for (int i = 0; i < h; i += k) {
			for (int j = 0; j < w; j += k) {
				if ((i == 0) || (i > 0 && i < h - 1 && (j == 0 || j == w - k))
						|| (i == h - k)) {
					ans++;
				}
			}
		}

		out.println(ans);
	}

	public Main() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve2();
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
