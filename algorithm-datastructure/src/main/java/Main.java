import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int n;
	public static int[][] blocks;
	public static int r;
	public static int c;
	public static final int EMPTY = 0;

	public static void main(String[] args) throws Exception {
		input();
		bomb();
		shift();
		printArr();
	}

	public static void shift() {
		int[][] temp = new int[n+1][n+1];

		for(int col = 1; col <= n; col++) {
			int tempRow = n;

			for(int row = n; row >= 1; row--) {
				if(blocks[row][col] != EMPTY) {
					temp[tempRow--][col] = blocks[row][col];
				}
			}
		}
		blocks = temp;
	}

	public static void bomb() {
		int distance = blocks[r][c] - 1;
		blocks[r][c] = EMPTY;

		int startRow = Math.max(r - distance, 1);
		int endRow = Math.min(r + distance, n);
		// 상하 방향으로 폭발
		for(int i = startRow; i <= endRow; i++) {
			blocks[i][c] = EMPTY;
		}
		// 좌우 방향으로 폭발
		int startCol = Math.max(c - distance, 1);
		int endCol = Math.min(c + distance, n);
		for(int i = startCol; i <= endCol; i++) {
			blocks[r][i] = EMPTY;
		}
	}

	public static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		blocks = new int[n+1][n+1];

		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				blocks[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
	}

	public static void printArr() {
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				System.out.print(blocks[i][j] + " ");
			}
			System.out.println();
		}
	}
}

