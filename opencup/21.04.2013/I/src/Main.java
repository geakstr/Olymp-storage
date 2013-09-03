import java.util.*;
import java.io.*;

public class Main {

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	void solve() throws IOException {
		char[] s = in.readLine().toCharArray();
		int len = s.length;

		out.print(len + " ");
		for (int i = 0; i < s.length; i++) {
			if (s[i] == '>')
				len--;
			else if (s[i] == '<')
				len++;

			out.print(len + " ");
		}
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