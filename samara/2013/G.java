package pack;

import java.util.*;
import java.io.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	class Pair implements Comparable<Pair> {
		int idx, num;

		Pair(int idx, int num) {
			this.idx = idx;
			this.num = num;
		}

		@Override
		public int compareTo(Pair arg0) {
			if (arg0.num == this.num)
				return 0;

			return arg0.num > this.num ? -1 : 1;
		}
	}

	void solve() throws IOException {

		int n = ni();
		List<Pair> a = new ArrayList<Pair>();

		for (int i = 0; i < n; i++) {
			a.add(new Pair(i + 1, ni()));
		}

		Collections.sort(a);

		long xor = Long.MAX_VALUE;

		class Pair1 {
			int a, b;

			Pair1(int a, int b) {
				this.a = a;
				this.b = b;
			}

			public void setA(int a) {
				this.a = a;
			}

			public void setB(int b) {
				this.b = b;
			}

		}
		Pair1 ans = new Pair1(-1, -1);
		for (int i = 0; i < n - 1; i++) {
			long tmpxor = a.get(i).num ^ a.get(i + 1).num;
			if (tmpxor < xor) {
				xor = tmpxor;
				ans.setA(a.get(i).idx);
				ans.setB(a.get(i + 1).idx);
			}
		}

		out.println(ans.a + " " + ans.b);
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