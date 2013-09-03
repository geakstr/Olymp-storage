import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	char[] s;
	int n;
	int alph = 256;
	int p[], cnt[], c[];
	int cls;

	void buildSuffixArray() {
		p = new int[n + 100];
		cnt = new int[n + alph + 100];
		c = new int[n + 100];

		for (int i = 0; i < n; i++)
			cnt[s[i]]++;
		for (int i = 1; i < alph; i++)
			cnt[i] += cnt[i - 1];
		for (int i = 0; i < n; i++) {
			p[cnt[s[i]] - 1] = i;
			cnt[s[i]]--;
		}

		cls = 1;
		c[p[0]] = 0;
		for (int i = 1; i < n; i++) {
			if (s[p[i]] != s[p[i - 1]])
				cls++;
			c[p[i]] = cls - 1;
		}
		out.print("c on stage 0:");
		for (int i = 0; i < n; i++) {
			out.print(" " + c[i]);
		}
		out.println();
		int pn[] = new int[n + 100];
		int cn[] = new int[n + 100];
		int idx = 1;
		for (int h = 0; (1 << h) < n; h++) {
			for (int i = 0; i < n; i++) {
				pn[i] = p[i] - (1 << h);
				if (pn[i] < 0)
					pn[i] += n;
			}
			for (int i = 0; i < n; i++)
				cnt[i] = 0;
			for (int i = 0; i < n; i++)
				cnt[c[i]]++;
			for (int i = 1; i < cls; i++)
				cnt[i] += cnt[i - 1];
			for (int i = n - 1; i >= 0; i--) {
				p[--cnt[c[pn[i]]]] = pn[i];
			}
			cn[p[0]] = 0;
			cls = 1;
			for (int i = 1; i < n; i++) {
				int mid1 = (p[i] + (1 << h)) % n;
				int mid2 = (p[i - 1] + (1 << h)) % n;
				if (c[p[i]] != c[p[i - 1]] || c[mid1] != c[mid2])
					cls++;
				cn[p[i]] = cls - 1;
			}
			for (int i = 0; i < n; i++)
				c[i] = cn[i];

			out.print("c on stage " + idx + ":");
			idx++;
			for (int i = 0; i < n; i++) {
				out.print(" " + c[i]);
			}
			out.println();
		}

	}

	void solve() throws IOException {
		String ns = in.readLine();

		s = ns.toCharArray();
		n = ns.length();

		buildSuffixArray();

		out.print("p :");
		for (int i = 0; i < n; i++) {
			out.print(" " + p[i]);
		}
		out.println();
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