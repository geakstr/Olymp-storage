import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	void solve() throws IOException {
		int n = ni();

		Map<String, Integer> m = new HashMap<String, Integer>();

		int prevS = ni() * ni();
		String prevColor = ns();
		m.put(prevColor, prevS);
		for (int i = 1; i < n; i++) {
			int curS = ni() * ni();
			String curColor = ns();

			if (curColor.equals(prevColor)) {
				prevColor = curColor;
				prevS = curS;
				continue;
			}

			if (m.containsKey(curColor)) {
				m.put(curColor, m.get(curColor) + curS);
			} else {
				m.put(curColor, curS);
			}

			m.put(prevColor, m.get(prevColor) - curS);

			prevColor = curColor;
			prevS = curS;
		}

		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (Map.Entry<String, Integer> el : m.entrySet()) {
			arr.add(el.getValue());
		}
		Collections.sort(arr);
		out.println(arr.get(arr.size() - 1));
	}

	Solution() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new InputStreamReader(System.in));
		// in = new BufferedReader(new FileReader("tests"));
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