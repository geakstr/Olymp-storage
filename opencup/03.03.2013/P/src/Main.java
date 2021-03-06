import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	int ans = 0, a, b, A, B;

	void solve() throws IOException {
		a = ni();
		b = ni();
		A = ni();
		B = ni();

		if (a == b && a == A && a == B && a == 0) {
			out.println("1");
			return;
		}
		out.println("1");
		boolean sums[] = new boolean[100000000];
		Arrays.fill(sums, false);
		int x = 0;
		while (true) {
			if (x >= A && x <= B && !sums[x]) {
				ans++;
				sums[x] = true;
			} else if (x > B || a == 0) {
				break;
			}
			x += a;
		}

		x = 0;
		while (true) {
			if (x >= A && x <= B && !sums[x]) {
				ans++;
				sums[x] = true;
			} else if (x > B || b == 0) {
				break;
			}
			x += b;
		}
		

		if (a != 0 && b != 0) {
			x = 0;
			int cnt = 1;
			int cnt2 = 0;
			int lastSum = 0, rightSum = 0;
			while (lastSum <= B) {
				if (lastSum >= A && lastSum <= B && !sums[lastSum]) {
					ans++;
					sums[lastSum] = true;
				}
				lastSum += a;
				if (cnt == 1) {
					rightSum = lastSum;
					while (rightSum <= B) {
						rightSum += b;
						cnt2++;
						if (rightSum >= A && rightSum <= B && !sums[rightSum]) {
							ans++;
							sums[rightSum] = true;
						}
					}
				} else {
					if (cnt2 > 0)
						rightSum = rightSum - (b * cnt);
					x = lastSum + rightSum;

					while (x <= B) {
						if (x >= A && x <= B && !sums[x]) {
							ans++;
							sums[x] = true;
						}
						x += a;
					}
				}
				cnt2--;
				cnt++;

			}
		}

		out.println(ans);
	}

	public Main() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new OutputStreamWriter(System.out));
		solve();
		in.close();
		out.close();
	}

	String ns() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}

	Integer ni() throws IOException {
		return Integer.valueOf(ns());
	}

	Double nd() throws IOException {
		return Double.valueOf(ns());
	}

	Long nl() throws IOException {
		return Long.valueOf(ns());
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}

}
