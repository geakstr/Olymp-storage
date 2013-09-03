import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	Map<String, Integer> m = new HashMap<String, Integer>();

	void solve() throws IOException {
		String txt = in.readLine();
		String search = ns();
		String type = ns();
		int n = ni();

		txt = txt.substring(n);

		for (int i = 0; i < txt.length(); i++) {
			for (int j = txt.length(); j > i; j--) {
				String tmp = txt.substring(i, j);
				if (!m.containsKey(tmp)) {
					m.put(tmp, i);
				}
			}
		}
//		for (Map.Entry<String, Integer> entry : m.entrySet()) {
//			out.println(entry.getKey() + " " + entry.getValue());
//		}
		

		if (type.equals("N")) {
			if (m.containsKey(search)) {
				out.println((m.get(search) + n));
			} else {
				out.println("-1");
			}
			return;
		} else {
			if (txt.equals(search.trim())) {
				out.println((0 + n));
				return;
			}
			if (m.containsKey(search + " ") && m.get(search + " ") == 0) {
				out.println((0 + n));
				return;
			}
			if (m.containsKey(" " + search + " ")) {
				out.println((m.get(" " + search + " ") + n + 1));
				return;
			}
			if (m.containsKey(" " + search)
					&& (m.get(" " + search) == (txt.length() - search.length() - 1))) {
				out.println((m.get(" " + search) + n + 1));
				return;
			}
			if (m.containsKey(search)
					&& (m.get(search) == (txt.length() - search.length() - 1))) {
				out.println((m.get(search) + n + 1));
				return;
			}
		}
		out.println("-1");
	}

	Solution() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new InputStreamReader(System.in));
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
