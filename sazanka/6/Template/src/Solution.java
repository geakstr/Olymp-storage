import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	char[] s;
	int n;
	int alph = 256;
	int p[], cnt[], c[], lcp[];
	String suff[], pref[];

	void getAllSuff(String s) {
		suff = new String[n];
		for (int i = 0; i < n; i++) {
			suff[i] = s.substring(p[i]);
		}
	}

	void getAllPref(String s) {
		pref = new String[n];
		for (int i = 0; i < n; i++) {
			pref[i] = s.substring(0, p[i]);
		}
	}

	void buildSuffixArray() {
		p = new int[n];
		cnt = new int[alph];
		c = new int[n];

		for (int i = 0; i < n; i++)
			cnt[s[i]]++;
		for (int i = 1; i < alph; i++)
			cnt[i] += cnt[i - 1];
		for (int i = 0; i < n; i++) {
			p[cnt[s[i]] - 1] = i;
			cnt[s[i]]--;
		}

		int cls = 1;
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
			for (int i = 0; i < cls; i++)
				cnt[i] = 0;
			for (int i = 0; i < n; i++)
				cnt[c[pn[i]]]++;
			for (int i = 1; i < cls; i++)
				cnt[i] += cnt[i - 1];
			for (int i = n - 1; i >= 0; i--) {
				p[cnt[c[pn[i]]] - 1] = pn[i];
				cnt[c[pn[i]]]--;
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
			if (cls >= n) {
				break;
			}
		}
	}

	void buildLcp() {
		lcp = new int[n];
		int r[] = new int[n];
		for (int i = 0; i < n; i++) {
			r[p[i]] = i;
		}
		int l = 0;
		for (int i = 0; i < n; i++) {
			l = Math.max(0, l - 1);
			int j = r[i];
			if (j + 1 < n) {
				while (s[i + l] == s[p[j + 1] + l]) {
					l++;
				}
				lcp[j] = l;
			}
		}
	}

	void solve() throws IOException {
		String ns = ns();
		String np = ns();

		s = ns.toCharArray();
		n = s.length;

		buildSuffixArray();

		getAllSuff(ns);
		Set<Integer> a = new HashSet<Integer>();
		int idx = 0;
		for (int i = 0; i < n; i++) {
			if (suff[i].length() >= np.length()) {
				if (ns.substring(p[i], p[i] + np.length()).equals(np)) {
					a.add(p[i]);
				}
			}
		}

		for (Integer el : a) {
			out.println(el);
		}
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