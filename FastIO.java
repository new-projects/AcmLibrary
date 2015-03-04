import java.io.*;
import java.util.*;

class Stream {
	static class InputClass {
		static BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		static StringTokenizer tokenizer = new StringTokenizer("");

		public boolean hasNext() {
			try {
				while (!tokenizer.hasMoreTokens()) {
					String line = reader.readLine();
					if (line == null) return false; // eof
					tokenizer = new StringTokenizer(line);
				}
			} catch (Exception e) {
			}
			return true;
		}

		public String next() {
			String ret = null;
			try {
				ret = hasNext() ? tokenizer.nextToken() : null;
			} catch (Exception e) {
			}
			return ret;
		}

		public String nextLine() {
			String ret = null;
			try {
				ret = reader.readLine();
			} catch (Exception e) {
			}
			return ret;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}

	public static final InputClass in = new InputClass();

	public static final PrintWriter out = new PrintWriter(
			new OutputStreamWriter(System.out));
}

public class FastIO {
	public static void freOpen() {
		final String INPUT = "input.txt";
		final String OUTPUT = "output.txt";
		try {
			System.setIn(new FileInputStream(INPUT));
			System.setOut(new PrintStream(new FileOutputStream(OUTPUT)));
		} catch (Exception e) {
			System.err.println("Error Occurred." + e);
		}
	}
	
	public static void main(String[] args) {
		// freOpen();
		int a = Stream.in.nextInt();
		int b = Stream.in.nextInt();
		Stream.out.println(a + b);
		// remember to flush in the end.
		Stream.out.flush();
	}
}