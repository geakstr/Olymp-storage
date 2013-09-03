import java.util.*;
import java.io.*;

public class Main {

	BufferedReader in;
	StringTokenizer st;

	String solve() throws IOException {
		String s = ns();

		if (s.charAt(0) != '-')
			return s;

		s = s.substring(1);

		if (s.length() == 2) {
			int min = Math.min((int) s.charAt(0) - 48, (int) s.charAt(1) - 48);

			min = min != 0 ? min * -1 : min;

			return String.valueOf(min);
		}

		int min = Integer.valueOf(s);

		for (int i = 1; i < s.length(); i++) {
			int tmp = Integer.valueOf(s.substring(0, i) + s.substring(i + 1));

			min = tmp < min ? tmp : min;
		}

		return String.valueOf(min * -1);
	}

	Main() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(solve());
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
