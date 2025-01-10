import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int[][] arr;
	public static int n;

	public static void main(String[] args) throws Exception {
		input();

	}

	public static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];

		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			for(int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}


}