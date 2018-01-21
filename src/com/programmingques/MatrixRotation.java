package com.programmingques;

public class MatrixRotation {


	int [][] mat = {{2,3,4,5},
					{6,7,8,9},
					{10,11,12,13},
					{14,15,16,17}};

	public void rotation(int l, int m, int Row, int Col)
	{
		int si,sj,i,t,f;
		si = l;
		sj = m;

		t = mat[l][m];

		for(i=l+1;i<=Row;i++)
		{
			f = mat[i][m];
			mat[i][m] = t;
			t = f;
		}
		l++;
		for(i=m+1;i<=Col;i++)
		{
			f = mat[Row][i];
			mat[Row][i] = t;
			t = f;
		}
		m++;
		if(l-1 < Row)
		{
			for(i=Row-1;i>=l-1;i--)
			{
				f = mat[i][Col];
				mat[i][Col] = t;
				t = f;
			}
		}
		Col--;
		if(m-1 < Col)
		{
			for(i=Col;i>=m;i--)
			{
				f = mat[l-1][i];
				mat[l-1][i] = t;
				t = f;
			}                         
		}
		Row--;
		mat[si][sj] = t;
		return;
	}
	
	public static void main(String[] args) {
		
		MatrixRotation mr = new MatrixRotation();
		int l,m,Row,Col;
		int r=4,c=4,numberRotation=2;
		int i,j,f;
		l = 0;
		m = 0;
		Row = r-1;
		Col = c-1;
		while(l < Row && m < Col)
		{
			int rot = 2*(Row-l)+2*(Col-m);
			f = numberRotation%rot;
			for(i=1;i<=f;i++)
			{
				mr.rotation(l,m,Row,Col);
			}
			l++;
			m++;
			Row--;
			Col--;
		}     
		for(i=0;i<r;i++)
		{
			for(j=0;j<c;j++)
			{
				System.out.print(mr.mat[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
