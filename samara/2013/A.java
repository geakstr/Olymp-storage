package pack;

import java.util.*;
import java.io.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	void solve() throws IOException {
		int n = ni();

		Set<String> s11 = new HashSet<String>();
		Set<String> s12 = new HashSet<String>();
		Set<String> s13 = new HashSet<String>();

		Set<String> s21 = new HashSet<String>();
		Set<String> s22 = new HashSet<String>();
		Set<String> s23 = new HashSet<String>();

		for (int i = 0; i < n; i++) {
			String one = ns(), two = ns(), three = ns();

			String opr = ns();

			if (opr.equals(one))
				s21.add(one);
			else if (opr.equals(two))
				s22.add(two);
			else
				s23.add(three);

			if (!s21.contains(one))
				s11.add(one);
			else
				s11.remove(one);

			if (!s22.contains(two))
				s12.add(two);
			else
				s12.remove(two);

			if (!s23.contains(three))
				s13.add(three);
			else
				s13.remove(three);

			out.println(s11.size() + " " + s12.size() + " " + s13.size());
		}

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
