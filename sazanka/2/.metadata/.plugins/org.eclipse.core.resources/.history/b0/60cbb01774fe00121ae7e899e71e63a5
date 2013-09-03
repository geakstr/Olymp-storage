//import java.io.*;
//import java.util.*;
//
//public class Solution {
//	BufferedReader in;
//	StringTokenizer st;
//	PrintWriter out;
//
//	Map<String, Integer> m = new HashMap<String, Integer>();
//
//	void solve() throws IOException {
//		String txt = in.readLine();
//		String search = ns();
//		String type = ns();
//		int n = ni();
//
//		if (type.equals("N")) {
//			out.println(txt.indexOf(search, n));
//			return;
//		} else {
//
//			if (txt.trim().equals(search)) {
//				out.println(txt.indexOf(search, n));
//				return;
//			}
//
//			int idx = txt.indexOf(search + " ", n);
//
//			if (idx != -1) {
//				if (idx == 0) {
//					out.println(txt.indexOf(search + " ", n));
//					return;
//				}
//				if (txt.charAt(idx - 1) == ' ') {
//					out.println(txt.indexOf(search + " ", n));
//					return;
//				}
//			}
//
//			txt += " ";
//			idx = txt.indexOf(" " + search + " ", n);
//
//			int len = txt.length();
//			for (int i = txt.length() - 1; i >= 0; i--) {
//
//				if (txt.charAt(i) != ' ') {
//					break;
//				}
//				len = i;
//			}
//			txt = txt.substring(0, len);
//			if (idx != -1) {
//				if (idx + search.length() + 1 == txt.length()) {
//					out.println(idx + 1);
//					return;
//				}
//				len = idx + search.length() + 1;
//				if (len < txt.length() && txt.charAt(len) == ' ') {
//					out.println(idx + 1);
//					return;
//				}
//			}
//		}
//		out.println("-1");
//	}
//
//	Solution() throws IOException {
//		Locale.setDefault(Locale.US);
//		in = new BufferedReader(new InputStreamReader(System.in));
//		out = new PrintWriter(new OutputStreamWriter(System.out));
//		solve();
//		in.close();
//		out.close();
//	}
//
//	String ns() throws IOException {
//		while (st == null || !st.hasMoreTokens()) {
//			st = new StringTokenizer(in.readLine());
//		}
//		return st.nextToken();
//	}
//
//	int ni() throws IOException {
//		return Integer.valueOf(ns());
//	}
//
//	double nd() throws IOException {
//		return Double.valueOf(ns());
//	}
//
//	long nl() throws IOException {
//		return Long.valueOf(ns());
//	}
//
//	public static void main(String[] args) throws IOException {
//		new Solution();
//	}
//}


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

		int idx
		if (type.equals("N")) {
			out.println(txt.indexOf(search, n));
			return;
		} else {
			txt = " " + txt + " ";
			int idx = txt.indexOf(" " + search + " ");
		}
		out.println(idx);
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

