import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class A {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	int n, x = 0;
	int xa[], ya[];
	ArrayList<Integer>[] g;

	void draw(int v, int p, int y) {
		xa[v] = x;
		ya[v] = y;
		for (int u : g[v]) {
			if (u != p) {
				draw(u, v, y + 1);
				x++;
			}
		}
	}

	void solve() throws IOException {
		n = ni();
		g = new ArrayList[n];
		xa = new int[n];
		ya = new int[n];
		for (int i = 0; i < n; i++) {
			g[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < n - 1; i++) {
			int v = ni() - 1;
			int u = ni() - 1;
			g[v].add(u);
			g[u].add(v);
		}
		draw(0, -1, 0);
		for (int i = 0; i < n; i++) {
			out.println(xa[i] + " " + ya[i]);
		}
	}

	public A() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new InputStreamReader(new FileInputStream(
				"input.txt")));
		out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(
				"output.txt")));
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

	public static void main(String[] args) throws IOException {
		new A();
	}
}
