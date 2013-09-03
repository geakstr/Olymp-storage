import java.io.*;
import java.util.*;

class tree {
	int szt;
	char[] s;
	node[] t;

	tree(String s) {
		this.s = s.toCharArray();
		this.t = new node[this.s.length * 2 + 1];
		for (int i = 0; i < t.length; i++) {
			this.t[i] = new node();
		}
		this.szt = 0;
		this.t[0] = new node(0, 0, 0);
		this.t[0].link = 0;
		make_tree();
	}

	class node {
		int l;
		int r;
		int par;
		int link;
		Map<Character, Integer> next;

		node(int l, int r, int par) {
			this.l = l;
			this.r = r;
			this.par = par;
			this.link = -1;
			this.next = new HashMap<Character, Integer>();
		}

		node() {
			this(-1, -1, -1);
		}
	}

	class position {
		int v, l;

		position(int v, int l) {
			this.v = v;
			this.l = l;
		}
	}

	void make_2() {
		for (int i = 0; i < s.length; i++) {
			position ptr = new position(0, 0);
			for (int j = i; j < s.length; j++) {
				position nptr = go(ptr, s[j]);
				if (nptr.v == 1) {
					int mid = split(ptr);
					add(mid, j, s.length);
					break;
				}
				ptr = nptr;
			}
		}
	}

	void make_tree() {
		this.szt = 1;
		position ptr = new position(0, 0);
		for (int i = 0; i < s.length; i++) {
			ptr = movei(ptr, i);
		}
	}

	int len(int w) {
		return t[w].r - t[w].l;
	}

	position go(position ptr, char c) {
		int v = ptr.v;
		int up = ptr.l;

		if (up != 0)
			return s[t[v].r - up] == c ? new position(v, up - 1)
					: new position(-1, -1);
		int w = t[v].next.containsKey(c) ? t[v].next.get(c) : -1;
		return w != -1 ? new position(w, len(w) - 1) : new position(-1, -1);
	}

	int add(int par, int l, int r) {
		node nv = new node(par, l, r);
		t[par].next.put(s[l], szt);
		t[szt] = nv;
		return szt++;
	}

	int split(position pos) {
		int v = pos.v;
		int up = pos.l;
		int down = len(v) - up;
		if (up == 0)
			return v;
		if (down == 0)
			return t[v].par;
		int mid = add(t[v].par, t[v].l, t[v].l + down);

		t[v].par = mid;
		t[v].l += down;
		t[mid].next.put(s[t[v].l], v);
		return mid;
	}

	position movei(position ptr, int i) {
		while (true) {
			position nptr = go(ptr, s[i]);
			if (nptr.v != -1)
				return nptr;
			int mid = split(ptr);
			add(mid, i, s.length);
			ptr = new position(link(mid), 0);
			if (mid == 0)
				return ptr;
		}
	}

	int link(int v) {
		System.out.println(v);
		if (t[v].link == -1) {
			int k = (t[v].par == 0) ? 1 : 0;
			t[v].link = split(fast_go(link(t[v].par), t[v].l + k, t[v].r));
		}
		return t[v].link;
	}

	position fast_go(int v, int l, int r) {
		if (l == r)
			return new position(v, 0);
		while (true) {
			v = t[v].next.get(s[l]);
			if (len(v) >= r - l)
				return new position(v, len(v) - r + l);
			l += len(v);
		}
	}
}

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	void solve() throws IOException {
		String s = "xaaxaa";
		tree t = new tree(s);

	}

	Solution() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new InputStreamReader(System.in));
		// in = new BufferedReader(new FileReader("in"));
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
