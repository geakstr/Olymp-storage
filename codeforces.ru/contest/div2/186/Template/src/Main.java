import java.util.*;
import java.io.*;

public class Main {

	BufferedReader in;
	StringTokenizer st;

	void solve() throws IOException {

	}

	Main() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		solve();
		in.close();
	}

	String ns() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}

	int ni() throws IOException {
		return Integer.valueOf(ns());
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}

}
