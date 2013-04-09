package pack;

import java.util.*;
import java.io.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	void solve() throws IOException {
		int d = ni(), n = ni(), m = ni();

		long fin[] = new long[d * n + 100];
		int ansCnt = 0;
		for (int i = 1; i <= d; i++) {
			int a[] = new int[n + 1];
			long sum = 0;
			boolean flag = false;
			for (int j = 1; j <= n; j++) {
				a[j] = ni();
				sum += a[j];
				if (j % m == 0) {
					flag = true;
				}
				if (flag) {
					int idx = j - m + 1;
					fin[idx] += sum;
					sum -= a[idx];
					ansCnt++;
				}
			}
		}

		long max = Long.MIN_VALUE;
		int idx = 0;
		long sum = 0;
		for (int i = 1; i <= ansCnt; i++) {
			if (fin[i] > max) {
				idx = i;
				sum = fin[i];
				max = fin[i];
			}
		}

		out.println(idx + " " + sum);

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