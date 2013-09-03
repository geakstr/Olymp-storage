import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	void solve() throws IOException {
		String t = ns();
		String p = ns();

		int tlen = t.length();
		int plen = p.length();

		ArrayList<String> parr = new ArrayList<String>();
		Map<String, Integer> tmap = new HashMap<String, Integer>();

		StringBuilder tmpPstr = new StringBuilder();
		for (int i = 0; i < p.length(); i++) {
			StringBuilder tmp = new StringBuilder();
			while (i < p.length() && p.charAt(i) != '?') {
				tmp.append(p.charAt(i));
				i++;
			}
			tmpPstr.append(tmp);
			parr.add(tmpPstr.toString());
		}
		if (p.charAt(plen - 1) != '?') {
			parr.remove(parr.size() - 1);
		}

		int len = 1;
		while (len <= tlen) {
			for (int i = 0; i < t.length() - len + 1; i++) {
				String tmp = t.substring(i, i + len);
				if (tmap.containsKey(tmp)) {
					tmap.put(tmp, tmap.get(tmp) + 1);
				} else {
					tmap.put(tmp, 1);
				}
			}
			len++;
		}

		for (String pstr : parr) {
			if (tmap.containsKey(pstr))
				out.println(tmap.get(pstr));
			else
				out.println(0);
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