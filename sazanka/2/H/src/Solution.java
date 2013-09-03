import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	int ans = 0;

	void solve() throws IOException {
		int n = ni();

		int a[] = new int[n];
		Set<Integer> set = new HashSet<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		int summ = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			a[i] = ni();
			set.add(a[i]);
			summ += a[i];

			if (map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i]) + 1);
			} else {
				map.put(a[i], 1);
			}

			if (max < a[i])
				max = a[i];
			if (min > a[i])
				min = a[i];
		}
		if (set.size() > 2) {
			out.println(-1);
			return;
		}
		if (summ == 0) {
			out.println(0);
			return;
		}
		if (set.size() == 1) {
			if (a[0] + 1 == n) {
				out.println(n);
			} else {
				out.println(-1);
			}
			return;
		}
		if (max - min != 1) {
			out.println(-1);
			return;
		}
		if (max == map.get(min)) {
			out.println(max);
		} else {
			out.println(-1);
		}

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
