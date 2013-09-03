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
		p = new int[n];
		cnt = new int[n >= alph ? n : alph];
		c = new int[n];

		for (int i = 0; i < n; i++)
			cnt[s[i]]++;
		for (int i = 1; i < alph; i++)
			cnt[i] += cnt[i - 1];
		for (int i = 0; i < n; i++)
			p[--cnt[s[i]]] = i;

		cls = 1;
		c[p[0]] = 0;
		for (int i = 1; i < n; i++) {
			if (s[p[i]] != s[p[i - 1]])
				cls++;
			c[p[i]] = cls - 1;
		}

		int pn[] = new int[n];
		int cn[] = new int[n];
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
			for (int i = n - 1; i >= 0; i--)
				p[--cnt[c[pn[i]]]] = pn[i];

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

			if (cls >= n)
				break;
		}
	}

	void solve() throws IOException {
		String ns = in.readLine();
		int k = ni();

		s = ns.toCharArray();
		n = ns.length();

		buildSuffixArray();


		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (i == 0 || c[p[i]] != c[p[i - 1]]) {
				ans++;
			}
			if (ans == k) {
				out.println(ns.substring(p[i]) + ns.substring(0, p[i]));
				return;
			}
		}
		out.println("IMPOSSIBLE");
	}

	Solution() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new InputStreamReader(System.in));
		// in = new BufferedReader(new FileReader("in"));
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
		new Solution();
	}
}