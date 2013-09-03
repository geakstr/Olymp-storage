import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	int[] p(String s) {
		int n = s.length();
		int[] ret = new int[n];

		for (int i = 1; i < n; i++) {
			int j = ret[i - 1];
			while (j > 0 && s.charAt(j) != s.charAt(i)) {
				j = ret[j - 1];
			}
			if (s.charAt(j) == s.charAt(i)) {
				j++;
				ret[i] = j;
			}
		}

		return ret;
	}

	int[] z(String s) {
		int n = s.length();
		int[] ret = new int[n];

		int l = 0, r = 0;
		for (int i = 1; i < n; i++) {
			if (i <= r) {
				ret[i] = Math.min(r - i + 1, ret[i - l]);
			}
			while (i + ret[i] < n && s.charAt(ret[i]) == s.charAt(i + ret[i])) {
				ret[i]++;
			}
			if (i + ret[i] - 1 > r) {
				l = i;
				r = i + ret[i] - 1;
			}
		}

		return ret;
	}

	void solve() throws IOException {
		int n = ni();

		ArrayList<String> arr = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			arr.add(ns());
		}
		Collections.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});

		int ans = 0;
		for (int i = arr.size() - 1; i >= 0; i--) {
			String a = arr.get(i);
			//out.println(a);
			int lastSum = 0;
			for (int j = i; j >= 0; j--) {
				String b = arr.get(j);
				int[] p = p(a + b);
				//out.println("  " + a + "+" + b);
				//out.print("    ");
				int sum = 0;
				for (int k = 0; k < p.length; k++) {
					//out.print(p[k]);
					sum += p[k];
				}
				//out.println();
				if (sum >= lastSum) {
					if (i == j && i == 0) {
						ans++;
						break;
					}
					//out.println(lastSum + " " + sum);
					lastSum = sum;
				} else {
					ans++;
					i = j + 1;
					break;
				}

			}
		}
		out.println(ans);
	}

	Solution() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new InputStreamReader(System.in));
		//in = new BufferedReader(new FileReader("tests"));
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
