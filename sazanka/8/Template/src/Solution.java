import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	void solve() throws IOException {
		String s = "abababa";
		String p = "aba";

		Hash hashS = new Hash(s);
		Hash hashP = new Hash(p);

		int len = p.length() - 1;
		for (int i = 0; i < s.length() - p.length() + 1; i++) {
			if (hashS.hash(i, i + len) == hashP.hash(0, len)) {
				out.println(i);
			}
		}
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

class Hash {
	int w1, mod1, p1[], h1[];
	int w2, mod2, p2[], h2[];

	public Hash(char s[], int w1, int mod1, int w2, int mod2) {
		this.w1 = w1;
		this.mod1 = mod1;
		this.w2 = w2;
		this.mod2 = mod2;
		int i, n = s.length;
		p1 = new int[n + 1];
		p2 = new int[n + 1];
		for (p1[0] = p2[0] = 1, i = 1; i <= n; ++i) {
			p1[i] = (int) ((long) p1[i - 1] * w1 % mod1);
			p2[i] = (int) ((long) p2[i - 1] * w2 % mod2);
		}
		h1 = new int[n + 1];
		h2 = new int[n + 1];
		for (h1[n - 1] = h2[n - 1] = s[n - 1], i = n - 2; i >= 0; --i) {
			h1[i] = (int) ((1L * h1[i + 1] * w1 + s[i]) % mod1);
			h2[i] = (int) ((1L * h2[i + 1] * w2 + s[i]) % mod2);
		}
	}

	public Hash(char s[]) {
		this(s, 31, 1000000007, 31, 1000000007);
	}

	public Hash(String s) {
		this(s.toCharArray());
	}

	public long hash(int l, int r) {
		return ((h1[l] - 1L * h1[r + 1] * p1[r - l + 1] % mod1 + mod1) % mod1) << 32L
				| ((h2[l] - 1L * h2[r + 1] * p2[r - l + 1] % mod2 + mod2) % mod2);
	}
}