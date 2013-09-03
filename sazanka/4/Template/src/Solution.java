import java.io.*;
import java.util.*;

public class Solution {
	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	// class Node {
	// int c;
	// Node p;
	// Node lnk;
	// Node[] nxt;
	// boolean end;
	//
	// Node() {
	// this.c = 0;
	// this.p = null;
	// this.lnk = null;
	// this.nxt = null;
	// this.end = false;
	// }
	//
	// Node(int c, Node p, Node lnk, Node[] nxt, boolean end) {
	// this.c = c;
	// this.p = p;
	// this.lnk = lnk;
	// this.nxt = nxt;
	// this.end = end;
	// }
	// }
	//
	// void addWord(String s, Node v, int pos) {
	// if (pos == s.length()) {
	// v.end = true;
	// return;
	// }
	// int c = s.charAt(pos) - 'a';
	// if (v.nxt[c] == null) {
	// Node child = new Node();
	// child.p = v;
	// child.c = c;
	// v.nxt[c] = child;
	// }
	// addWord(s, v.nxt[c], pos + 1);
	// }

	void solve() throws IOException {
		Tree tree = new Tree();
		tree.addWord("ababc");
		tree.addWord("abca");
		tree.addWord("baba");
		tree.addWord("bcc");
		tree.printSorted(tree.root, "");
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

class Tree {
	static class Node {
		Map<Character, Node> child = new TreeMap<Character, Node>();
		boolean end;
	}

	Node root = new Node();

	void addWord(String s) {
		Node v = root;
		for (char ch : s.toCharArray()) {
			if (!v.child.containsKey(ch)) {
				v.child.put(ch, new Node());
			}
			v = v.child.get(ch);
		}
		v.end = true;
	}

	void printSorted(Node node, String s) {
		for (Character ch : node.child.keySet()) {
			System.out.println(ch);
			if(node.child.get(ch).child.size() > 1) System.out.println("--");
			printSorted(node.child.get(ch), s + ch);
		}
		if (node.end) {
			System.out.println("==");
		}
	}
}