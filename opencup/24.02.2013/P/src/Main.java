import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer sttok;

	static class State {
		int length;
		int link;
		int endpos;
		int[] next = new int[256];
		{
			Arrays.fill(next, -1);
		}
		List<Integer> ilink = new ArrayList<Integer>(0);
	};

	State[] st;
	int size = 0;
	int last = 0;
	int lastp = 0;

	void saExtend(char c) {
		int nlast = size++;
		st[nlast] = new State();
		st[nlast].length = st[last].length + 1;
		st[nlast].endpos = st[last].length;
		int p;
		for (p = last; p != -1 && st[p].next[c] == -1; p = st[p].link) {
			st[p].next[c] = nlast;
		}
		if (p == -1) {
			st[nlast].link = 0;
		} else {
			int q = st[p].next[c];
			if (st[p].length + 1 == st[q].length)
				st[nlast].link = q;
			else {
				int clone = size++;
				st[clone] = new State();
				st[clone].length = st[p].length + 1;
				st[clone].next = st[q].next.clone();
				st[clone].link = st[q].link;
				for (; p != -1 && st[p].next[c] != -1 && st[p].next[c] == q; p = st[p].link)
					st[p].next[c] = clone;
				st[q].link = clone;
				st[nlast].link = clone;
				st[clone].endpos = -1;
			}
		}
		last = nlast;
	}

	public void buildSA(String s) {
		int n = s.length();
		st = new State[Math.max(2, 2 * n - 1)];
		st[0] = new State();
		st[0].link = -1;
		st[0].endpos = -1;
		last = 0;
		size = 1;
		for (char x : s.toCharArray()) {
			saExtend(x);
		}
		for (int i = 1; i < size; i++) {
			st[st[i].link].ilink.add(i);
		}
	}

	public String lcs(String a, String b) {
		buildSA(a);
		int p = 0;
		lastp = 0;
		int len = 0;
		int best = 0;
		int bestpos = -1;
		for (int i = 0; i < b.length(); ++i) {
			char cur = b.charAt(i);
			if (st[p].next[cur] == -1) {
				for (; p != -1 && st[p].next[cur] == -1; p = st[p].link) {
				}
				if (p == -1) {
					p = 0;
					len = 0;
					continue;
				}
				len = st[p].length;
			}
			++len;
			p = st[p].next[cur];
			if (best < len) {
				best = len;
				bestpos = i;
				lastp = p;
			}
		}
		return b.substring(bestpos - best + 1, bestpos + 1);
	}

	public int[] occurrences(String needle, String haystack) {
		String common = lcs(haystack, needle);
		if (!common.equals(needle))
			return new int[0];
		List<Integer> list = new ArrayList<Integer>();
		dfs(lastp, needle.length(), list);
		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++)
			res[i] = list.get(i);
		Arrays.sort(res);
		return res;
	}

	void dfs(int p, int len, List<Integer> list) {
		if (st[p].endpos != -1 || p == 0)
			list.add(st[p].endpos - len + 1);
		for (int x : st[p].ilink)
			dfs(x, len, list);
	}

	void solve() throws IOException {
		String s = ns();
		buildSA(s);

		for (State state : st) {
			if (state != null) {
				out.println(state.length + " " + state.link + " "
						+ state.endpos);
				for (int j = 0; j < state.next.length; j++)
					out.print(state.next[j] + " ");
				out.println();
			}
		}
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
		while (sttok == null || !sttok.hasMoreTokens()) {
			sttok = new StringTokenizer(in.readLine());
		}
		return sttok.nextToken();
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
