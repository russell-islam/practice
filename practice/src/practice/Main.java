package practice;

public class Main {
	static void test_matrix()
	{
int[][] mat = Matrix.get2DMatrix(4, 4);
		
		Matrix.print_2d_matrix(mat, 4, 4);
		System.out.println("----------------");
		Matrix.print_rotate(mat, 4, 4);
	}

	public static void main(String[] args) {
		
		System.out.println(Math_prb.find_sqrt(Integer.MAX_VALUE));
	}

}
