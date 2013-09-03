import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	void solve() throws IOException {
		int n = ni();
		BigInteger x = new BigInteger(ns());

		BigInteger ans = BigInteger.ZERO;

		for (int i = 0; i < n; i++) {
			BigInteger l = new BigInteger(ns());
			BigInteger r = new BigInteger(ns());
			BigInteger tmp = r.subtract(l).add(BigInteger.ONE);
			
			ans = ans.or(tmp);
			out.println(ans);
		}

		out.println(ans);
	}

	Main() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new OutputStreamWriter(System.out));
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
