import java.io.*;
import java.util.*;

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
		Map<Integer, ArrayList<String>> m = new HashMap<Integer, ArrayList<String>>();

		for (int i = 0; i < n; i++) {
			String s = ns();
			int cnt = 0;
			for (char ch : s.toCharArray()) {
				if (!isChar(ch)) {
					cnt += ch - 48;
				}
			}
			if (m.containsKey(cnt)) {
				ArrayList<String> tmp = m.get(cnt);
				tmp.add(s);
				Collections.sort(tmp);
				m.put(cnt, tmp);
			} else {
				ArrayList<String> tmp = new ArrayList<String>();
				tmp.add(s);
				Collections.sort(tmp);
				m.put(cnt, tmp);
			}
		}

		for (Map.Entry<Integer, ArrayList<String>> entry : m.entrySet()) {
			for (int i = 0; i < entry.getValue().size(); i++) {
				out.println(entry.getValue().get(i));
			}
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