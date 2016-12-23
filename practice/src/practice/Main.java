package practice;

public class Main {

	public static void main(String[] args) {
		int[][] mat = Matrix.get2DMatrix(3, 3);
		
		Matrix.print_2d_matrix(mat, 3, 3);
		Matrix.print_rotate(mat, 3, 3);

	}

}
