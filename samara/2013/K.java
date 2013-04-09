package pack;

import java.util.*;
import java.io.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	void solve() throws IOException {

		int a[] = new int[7];
		for (int i = 0; i < 9; i++) {
			String s = in.readLine();

			int cnt = 0;
			if (i == 0 || i == 4 || i == 8) {
				for (int j = 0; j < s.length(); j++) {
					if (s.charAt(j) == 'x') {
						cnt++;
					}
				}
				switch (i) {
				case 0:
					if (cnt == 24)
						a[0] = 0;
					else if (cnt < 24)
						a[0] = -1;
					else
						a[0] = 1;
					break;
				case 4:
					if (cnt == 21)
						a[3] = 0;
					else if (cnt < 21)
						a[3] = -1;
					else
						a[3] = 1;
					break;
				case 8:
					if (cnt == 21)
						a[6] = 0;
					else if (cnt < 21)
						a[6] = -1;
					else
						a[6] = 1;
					break;
				default:
					break;
				}
			} else {
				if (i == 1) {
					cnt = 0;
					for (int j = 0; j < s.length(); j++) {
						if (s.charAt(j) == 'x') {
							if (j == 0 || j == 6 || j == 12 || j == 18
									|| j == 24 || j == 30 || j == 36 || j == 42
									|| j == 48 || j == 54)
								cnt++;
						}
					}
					if (cnt == 6)
						a[1] = 0;
					else if (cnt < 6)
						a[1] = -1;
					else
						a[i] = 1;

					cnt = 0;
					for (int j = 0; j < s.length(); j++) {
						if (s.charAt(j) == 'x') {
							if (j == 4 || j == 10 || j == 16 || j == 22
									|| j == 28 || j == 34 || j == 40 || j == 46
									|| j == 52 || j == 58)
								cnt++;
						}
					}
					if (cnt == 8)
						a[2] = 0;
					else if (cnt < 8)
						a[2] = -1;
					else
						a[2] = 1;
				} else if (i == 5) {
					cnt = 0;

					for (int j = 0; j < s.length(); j++) {
						if (s.charAt(j) == 'x') {
							if (j == 0 || j == 6 || j == 12 || j == 18
									|| j == 24 || j == 30 || j == 36 || j == 42
									|| j == 48 || j == 54)
								cnt++;
						}
					}
					if (cnt == 4)
						a[4] = 0;
					else if (cnt < 4)
						a[4] = -1;
					else
						a[4] = 1;

					cnt = 0;
					for (int j = 0; j < s.length(); j++) {
						if (s.charAt(j) == 'x') {
							if (j == 4 || j == 10 || j == 16 || j == 22
									|| j == 28 || j == 34 || j == 40 || j == 46
									|| j == 52 || j == 58)
								cnt++;
						}
					}
					if (cnt == 9)
						a[5] = 0;
					else if (cnt < 9)
						a[5] = -1;
					else
						a[5] = 1;
				}
			}

		}

		String b = "";
		for (int i = 0; i < 7; i++) {
			b += a[i] + " ";
		}
		b = b.trim();

		out.println(b);
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