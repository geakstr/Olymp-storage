import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	int[] pi(String s) {
		int n = s.length();
		int[] ret = new int[n];

		for (int i = 1; i < n; i++) {
			int j = ret[i - 1];
			while (j > 0 && s.charAt(j) != s.charAt(i)) {
				j = ret[j - 1];
			}
			if (s.charAt(j) == s.charAt(i)) {
				j++;
				ret[i] = j;
			}
		}

		return ret;
	}

	int[] z(String s) {
		int n = s.length();
		int[] ret = new int[n];

		int l = 0, r = 0;
		for (int i = 1; i < n; i++) {
			if (i <= r) {
				ret[i] = Math.min(r - i + 1, ret[i - l]);
			}
			while (i + ret[i] < n && s.charAt(ret[i]) == s.charAt(i + ret[i])) {
				ret[i]++;
			}
			if (i + ret[i] - 1 > r) {
				l = i;
				r = i + ret[i] - 1;
			}
		}

		return ret;
	}

	void solve() throws IOException {
		String t = ns();
		String p = ns();

		int plen = p.length();

		ArrayList<Integer> idx = new ArrayList<Integer>();
		StringBuilder pb = new StringBuilder();
		for (int i = 0; i < plen; i++)
			if (p.charAt(i) != '?')
				pb.append(p.charAt(i));
			else
				idx.add(pb.length());

		String s = pb + "#" + t;
		int pblen = pb.length();
		int slen = s.length();

		int z[] = z(s);
		int[] a = new int[pblen + 1];

		for (int i = pblen + 1; i < slen; i++)
			a[z[i]]++;
		for (int i = pblen; i > 0; i--)
			a[i - 1] += a[i];
		for (int i = 0; i < idx.size(); i++)
			out.println(a[idx.get(i)]);
	}

	Solution() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new InputStreamReader(System.in));
		// in = new BufferedReader(new FileReader("tests"));
		out = new PrintWriter(new OutputStreamWriter(System.out));
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
		new Solution();
	}
}
