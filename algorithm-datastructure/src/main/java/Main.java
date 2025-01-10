import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int[][] arr;
	public static int n;
	public static int m;
	public static int result = 0;

	// 행복한 수열은 연속하여 m개 이상의 동일한 원소가 나오는 순간이 존재하는 수열이다.
	// 행마다 나오는 n개의 수열과 열마다 나오는 n개의 수열 총 2n 개의 수열이 존재한다.
	// 행복한 수열의 개수를 세시오.
	public static void main(String[] args) throws Exception {
		input();

		for(int i = 1; i <= n; i++) {
			if(countRow(i) >= m ) {
				result++;
			}

			if(countCol(i) >= m ) {
				result++;
			}
		}
		
		System.out.println(result);
	}

	// row번째 행에서 가장긴 연속으로 나오는 숫자의 개수를 센다.
	public static int countRow(int row) {
		int max = 1;
		int cur = 1;

		for(int i = 2; i <= n; i++) {
			if(arr[row][i] == arr[row][i-1]) {
				cur++;
			} else {
				max = Math.max(max, cur);
				cur = 1;
			}
		}

		return Math.max(max, cur);
	}

	public static int countCol(int col) {
		int max = 1;
		int cur = 1;

		for(int i = 2; i <= n; i++) {
			if(arr[i][col] == arr[i-1][col]) {
				cur++;
			} else {
				max = Math.max(max, cur);
				cur = 1;
			}
		}

		return Math.max(max, cur);
	}

	public static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+1][n+1];

		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			for(int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}