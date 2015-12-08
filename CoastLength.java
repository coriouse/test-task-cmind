


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CoastLength {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] field = null;
		int count = 0;
		Integer str = 0;
		while (sc.hasNextLine()) {
			String val = sc.nextLine();
			if (count == 0) {
				String[] size = val.split(" ");
				field = new int[Integer.parseInt(size[0])][Integer.parseInt(size[1])];
				count++;
			} else {
				for(int i = 0;i<field[0].length;i++) {
					field[str][i] = val.charAt(i) - '0';
				}
				str++;
			}
		}
		sc.close();
		CoastLength m = new CoastLength();
		System.out.println(m.calculate(field));

	}

	public int calculate(int[][] field) {
		int currow = 0;
		int curcol = 0;
		int totalrow = field.length - 1;
		int totalcol = field[0].length - 1;
		for (curcol = 0; curcol <= totalcol; curcol++) {
			if (field[0][curcol] == 0) {
				wave(field, 0, curcol);
			}
		}
		for (currow = 1; currow <= totalrow; currow++) {
			if (field[currow][totalcol] == 0) {
				wave(field, currow, totalcol);
			}
		}
		for (curcol = totalcol - 1; curcol >= 0; curcol--) {
			if (field[totalrow][curcol] == 0) {
				wave(field, totalrow, curcol);
			}
		}
		for (currow = totalrow - 1; currow > 0; currow--) {
			if (field[currow][0] == 0) {
				wave(field, currow, 0);
			}
		}
		return count(field);
	}

	public void wave(int[][] field, int str, int col) {
		Queue<Integer[]> queue = new LinkedList<>();
		field[str][col] = 3;
		queue.add(new Integer[] { str, col });
		while (!queue.isEmpty()) {
			Integer[] point = queue.poll();
			foundPointsAround(field, point[0], point[1], queue);
		}
	}

	public void foundPointsAround(int[][] field, int str, int col, Queue<Integer[]> queue) {
		if (col < field[0].length - 1) {
			if (field[str][col + 1] == 0) {
				field[str][col + 1] = 3;
				queue.add(new Integer[] { str, col + 1 });
			}
		}
		if (col > 0) {
			if (field[str][col - 1] == 0) {
				field[str][col - 1] = 3;
				queue.add(new Integer[] { str, col - 1 });
			}
		}
		if (str < field.length - 1) {
			if (field[str + 1][col] == 0) {
				field[str + 1][col] = 3;
				queue.add(new Integer[] { str + 1, col });
			}
		}
		if (str > 0) {
			if (field[str - 1][col] == 0) {
				field[str - 1][col] = 3;
				queue.add(new Integer[] { str - 1, col });
			}
		}
	}

	public int count(int[][] f) {
		int sum = 0;
		for (int i = 0; i < f.length; i++) {
			for (int j = 0; j < f[0].length; j++) {
				if (f[i][j] != 1)
					continue;
				if (j > 0) {
					if (f[i][j - 1] == 3) {
						sum++;
					}
				}
				if (j == 0) {
					sum++;
				}
				if (j < f[0].length - 1) {
					if (f[i][j + 1] == 3) {
						sum++;
					}
				}
				if (j == f[0].length - 1) {
					sum++;
				}
				if (i < f.length - 1) {
					if (f[i + 1][j] == 3) {
						sum++;
					}
				}
				if (i == f.length - 1) {
					sum++;
				}
				if (i > 0) {
					if (f[i - 1][j] == 3) {
						sum++;
					}
				}
				if (i == 0) {
					sum++;
				}
			}
		}
		return sum;
	}
}
