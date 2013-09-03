import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	class Pair {
		String g;
		String s;

		Pair(String g, String s) {
			this.g = g;
			this.s = s;
		}
	}

	ArrayList<ArrayList<Integer>> genSubsets(int n) {
		n = (1 << n);
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			int a = i, j = 1;
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			while (a > 0) {
				if (a % 2 == 1)
					tmp.add(j - 1);
				j++;
				a /= 2;
			}
			ret.add(tmp);
		}
		return ret;
	}

	Pair[] arr;
	int n;
	int m;

	void solve() throws IOException {
		n = ni();
		m = ni();
		arr = new Pair[n];

		String[] g = new String[n];
		for (int i = 0; i < n; i++)
			g[i] = ns();
		for (int i = 0; i < n; i++)
			arr[i] = new Pair(g[i], ns());
		Arrays.sort(arr, new Comparator<Pair>() {
			@Override
			public int compare(Pair a, Pair b) {
				return a.g.compareTo(b.g);
			}
		});

		ArrayList<ArrayList<Integer>> subsets = genSubsets(n);

		Collections.sort(subsets, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {

				int asize = a.size();
				int bsize = b.size();

				int[] sA = new int[m];
				for (int i = 0; i < asize; i++) {
					String song = arr[a.get(i)].s;
					for (int j = 0; j < song.length(); j++)
						if (song.charAt(j) == 'Y')
							sA[j] = 1;
				}
				int songsA = 0;
				for (int i = 0; i < m; i++)
					if (sA[i] == 1)
						songsA++;

				int[] sB = new int[m];
				for (int i = 0; i < bsize; i++) {
					String song = arr[b.get(i)].s;
					for (int j = 0; j < song.length(); j++)
						if (song.charAt(j) == 'Y')
							sB[j] = 1;
				}
				int songsB = 0;
				for (int i = 0; i < m; i++)
					if (sB[i] == 1)
						songsB++;

				if (songsA != songsB)
					return songsB - songsA;

				if (asize != bsize)
					return asize - bsize;

				for (int i = 0; i < asize; i++) {
					if (arr[a.get(i)].g.compareTo(arr[b.get(i)].g) != 0)
						return arr[a.get(i)].g.compareTo(arr[b.get(i)].g);
				}

				return 0;
			}
		});

		out.println(subsets.get(0).size());
		for (int j = 0; j < subsets.get(0).size(); j++) {
			out.println(arr[subsets.get(0).get(j)].g);
		}

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