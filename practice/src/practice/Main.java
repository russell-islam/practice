package practice;

public class Main {
	static void test_matrix()
	{
		int[][] mat = Matrix.get2DMatrix(4, 4);
		
		Matrix.print_2d_matrix(mat, 4, 4);
		System.out.println("----------------");
		Matrix.print_rotate(mat, 4, 4);
	}
	static int Multiply(int a, int b)
	{
		if (a == 0 || b ==0)
			return 0;
		int result = 0;
		int tt = b;
		while(b > 0)
		{
			if ( b % 2 != 0)
				result = result + a;
			a = a * 2;
			b = b / 2;
		}
		return result;
	}
	public static void main(String[] args) {
		
		//String out = String_prb.CompressString("aaaaaaaaaaaaaabbcccccccccccccd");
		//out = String_prb.DecompressString(out);
		//List_prb.test_list_string();
		//int res = Multiply(10, 15);
		//System.out.println(res);
		//GeneralGraph.main();
		//DynamicProgramming.test();
		//String_prb.test();
		//SortingUtil.test();
		//Array_prb.test();
		//LinkList.test();
		IntegerProblem.test();
		//GeneralGraph.main();
		//String_prb.test();
		//Math_prb.test();
		//StackQueueTest.test();
		//BST.test();
	}

}
