import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import static java.lang.Math.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	int n;
	Point[] points;

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

	}

	void solve() throws IOException {
		n = ni();
		points = new Point[n];
		for (int i = 0; i < n; i++) {
			points[i] = new Point(ni(), ni());
		}

		int ans = 0;
		for (int base = 0; base < n; base++) {
			Point basePoint = points[base];
			HashMap<Point, Integer> map = new HashMap<Main.Point, Integer>();
			for (int i = 0; i < n; i++) {
				if (i != base) {
					int nx = points[i].x - basePoint.x;
					int ny = points[i].y - basePoint.y;
					int gcd = gcd(nx, ny);
					Point np = new Point(nx / gcd, ny / gcd);
					updateMap(map, np);
				}
			}
			for (Integer value : map.values()) {
				ans = max(ans, value);
			}
		}

		out.println(ans + 1);
	}

	void updateMap(Map<Point, Integer> map, Point p) {
		if (map.containsKey(p)) {
			map.put(p, map.get(p) + 1);
		} else {
			map.put(p, 1);
		}
	}

	int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	public Main() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new InputStreamReader(new FileInputStream(
				"input.txt")));
		out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(
				"output.txt")));
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

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new Main();
	}

}
