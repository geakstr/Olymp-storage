import java.util.*;
import java.io.*;
import java.math.BigInteger;

import static java.lang.Math.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	boolean[] prime;

	void sieve() throws IOException {
		int n = 100;
		prime = new boolean[n + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for (int i = 2; i <= n; ++i)
			if (prime[i])
				if (i * 1L * i <= n)
					for (int j = i * i; j <= n; j += i)
						prime[j] = false;
	}

	void solve() throws IOException {
		BigInteger nBig = new BigInteger(ns());
		int n = 0;
		if (nBig.compareTo(new BigInteger("100")) > 0) {
			n = 100;
		} else {
			n = Integer.valueOf(nBig.toString());
		}

		sieve();
		String ans = "";
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (prime[i]
					&& nBig.mod(new BigInteger(String.valueOf(i))).equals(
							BigInteger.ZERO)) {
				cnt++;
				ans = ans + i + " ";
			}
		}
		ans = cnt + "\n" + ans;
		out.println(ans);
	}

	public Main() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
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

	Integer ni() throws IOException {
		return Integer.valueOf(ns());
	}

	Double nd() throws IOException {
		return Double.valueOf(ns());
	}

	Long nl() throws IOException {
		return Long.valueOf(ns());
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}
}
