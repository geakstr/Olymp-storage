import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	void solve() throws IOException {

	}

	public Main() throws IOException {
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
