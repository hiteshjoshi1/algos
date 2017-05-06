package com.hitesh.learn.ds.old;

public class MatrixMultiplication
{

	public static int [] [] a = new int [][]{{1,2,3},{3,4,5},{3,9,1}};
	public static int [] [] b = new int [] [] {{7,8,1},{1,5,9},{4,2,0}};
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
	int res[] [] =multiplySqMatrix(a, b);
	for(int i =0; i<res.length; i++)
	{
		for( int j = 0; j<res.length;j++)
		{
			//System.out.println(" ------i, j  "+ i +"  "+j);
			System.out.println(res[i][j]);
		}
	}

	}

	public static int[][] multiplySqMatrix(int a[][], int b [] [])
	{
		int c [][]= new int[a.length][a.length];
		//System.out.println(c.length+ "  "+ c[0].length );
		
		for(int i= 0;i<a.length; i++)
		{
			for(int j = 0; j<a.length; j++)
			{
				c[i][j]= c[i][j]+0;			
				for(int k = 0; k<c.length;k++)
				{
					//System.out.println("C-- "+c[i][j]);
					//System.out.println("i "+i +" J "+ j +" K "+ k);
					System.out.println("c["+i+"]["+j+"] = c["+i+"]["+j+"]"+" +a["+j+"]["+k+"]* b["+k+"]["+j+"]");
				c[i][j]= c[i][j]+a[i][k]*b[k][j];
				}
				
			}
			
		}
		return c;
		
	}
}
