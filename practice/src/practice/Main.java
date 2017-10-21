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
		
		//String out = String_prb.CompressString("aaaaaaaaaaaaaabbcccccccccccccd");
		//out = String_prb.DecompressString(out);
		//List_prb.test_list_string();
		//BST.test();
		GeneralGraph.main();
	}

}
