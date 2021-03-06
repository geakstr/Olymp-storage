import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution2 {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	String getSongBit(String s) {
		String ret = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'Y') {
				ret += "1";
			} else {
				ret += "0";
			}
		}
		return ret;
	}

	class Pair {
		String g;
		BigInteger s;
		int idx;

		Pair(String g, BigInteger s) {
			this.g = g;
			this.s = s;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((g == null) ? 0 : g.hashCode());
			result = prime * result + ((s == null) ? 0 : s.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (g == null) {
				if (other.g != null)
					return false;
			} else if (!g.equals(other.g))
				return false;
			if (s == null) {
				if (other.s != null)
					return false;
			} else if (!s.equals(other.s))
				return false;
			return true;
		}

		private Solution2 getOuterType() {
			return Solution2.this;
		}
	}

	class Compare implements Comparator<Pair> {
		@Override
		public int compare(Pair a, Pair b) {
			if (a.g.length() != b.g.length()) {
				return b.g.length() - a.g.length();
			}
			return a.g.compareTo(b.g);
		}
	}

	void gen(int n, int k, int i) {
		if (i == k) {
			for (int j = 0; j < k; j++) {

			}
		}
	}

	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

	void genSubsets(int n) {
		int i = 0, a = 0, j = 0;

		n = (1 << n);
		for (i = 0; i < n; i++) {
			a = i;
			j = 1;
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			while (a > 0) {
				if (a % 2 == 1) {
					tmp.add(j);
					out.print(j);
				}
				j++;
				a /= 2;
			}
			out.println();
			ans.add(tmp);
		}
	}

	void solve() throws IOException {
		int n = ni();
		int m = ni();
		Pair[] a = new Pair[n];

		genSubsets(n);

		String[] g = new String[n];
		for (int i = 0; i < n; i++)
			g[i] = ns();
		ArrayList<Pair> tmp = new ArrayList<Pair>();
		for (int i = 0; i < n; i++)
			tmp.add(new Pair(g[i], new BigInteger(getSongBit(ns()))));
		Collections.sort(tmp, new Compare());
		for (int i = 0; i < n; i++)
			a[i] = tmp.get(i);

		int max = Integer.MIN_VALUE;
		int idx = 0;
		int cnt = Integer.MAX_VALUE;
		for (int i = 0; i < ans.size(); i++) {
			ArrayList<Integer> row = ans.get(i);
			int size = row.size();

			int[] xor = new int[m];
			if (size > 1) {
				for (int j = 1; j < size; j++) {
					String one = a[row.get(j) - 1].s.toString();
					String two = a[row.get(j - 1) - 1].s.toString();
					for (int k = 0; k < m; k++) {
						if (one.length() < m) {
							one = "0" + one;
						}
						if (two.length() < m) {
							two = "0" + two;
						}
					}
					for (int k = 0; k < m; k++) {
						if (one.charAt(k) == '1' || two.charAt(k) == '1') {
							xor[k] = 1;
						}
					}
				}
			} else if (size == 1) {
				String one = a[row.get(0) - 1].s.toString();
				for (int k = 0; k < m; k++) {
					if (one.length() < m) {
						one = "0" + one;
					}
				}
				for (int k = 0; k < m; k++) {
					if (one.charAt(k) == '1') {
						xor[k] = 1;
					}
				}
			}
			int summ = 0;
			for (int j = 0; j < m; j++) {
				summ += xor[j];
			}
			if (max < summ) {
				if (summ == m) {
					if (size < cnt) {
						max = summ;
						idx = i;
					}
				} else {
					max = summ;
					idx = i;
				}
			}
		}
		out.println(ans.get(idx).size());
		for (int i = 0; i < ans.get(idx).size(); i++) {
			out.println(a[ans.get(idx).get(i) - 1].g);
		}

	}

	Solution2() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new InputStreamReader(System.in));
		// in = new BufferedReader(new FileReader("tests"));
		out = new PrintWriter(new OutputStreamWriter(System.out));
		// out = new PrintWriter("out");
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
		new Solution2();
	}
}