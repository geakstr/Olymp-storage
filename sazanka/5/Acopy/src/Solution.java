import java.io.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	boolean isChar(char s) {
		if (s == 'Z')
			return true;
		for (char i = 'A'; i != 'Z'; i++) {
			if (s == i) {
				return true;
			}
		}
		return false;
	}

	void solve() throws IOException {
		int n = ni();

		ArrayList<String> ans = new ArrayList<String>();
		for (int i = 0; i < n; i++)
			ans.add(ns());

		Collections.sort(ans, new Compar());

		for (int i = 0; i < ans.size(); i++) {
			out.println(ans.get(i));
		}
	}

	class Compar implements Comparator<String> {
		boolean isChar(char s) {
			if (s == 'Z')
				return true;
			for (char i = 'A'; i != 'Z'; i++) {
				if (s == i) {
					return true;
				}
			}
			return false;
		}

		@Override
		public int compare(String a, String b) {
			if (a.length() != b.length())
				return a.length() - b.length();

			int cnta = 0;
			int cntb = 0;
			for (char ch : a.toCharArray()) {
				if (!isChar(ch)) {
					cnta += ch - 48;
				}
			}

			for (char ch : b.toCharArray()) {
				if (!isChar(ch)) {
					cntb += ch - 48;
				}
			}

			if (cnta != cntb) {
				return cnta - cntb;
			}

			ArrayList<String> tmp = new ArrayList<String>();
			tmp.add(a);
			tmp.add(b);
			Collections.sort(tmp);

			if (tmp.get(0).equals(a)) {
				return -1;
			}
			return 1;
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