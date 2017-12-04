public class CGame {	
	public static void main(String []args){
		
		
		int [][] arr = {{0,1,0},{0,1,0},{0,1,0}};//blinker
				/*{{0,0,0,0,0,0},
				{0,0,0,0,0,0},
				{0,0,1,1,1,0},
				{0,1,1,1,0,0},
				{0,0,0,0,0,0},
				{0,0,0,0,0,0}}; //toad
				*/
				/*
				{{0,0,0,0,0,0},
				{0,1,1,0,0,0},
				{0,1,1,0,0,0},
				{0,0,0,1,1,0},
				{0,0,0,1,1,0},
				{0,0,0,0,0,0}};
				*/
				
		
		int rows = arr.length;
		int columns = arr[1].length;
		
		
		System.out.println("rows="+rows +"col="+columns);
		
		//init pattern
		System.out.println("*** Gen :init");
		for(int i=0; i<rows;i++){
			for(int j=0;j<columns;j++){				
				System.out.print(arr[i][j]);
				System.out.print("  ");
			}
			System.out.println("");
		}
		System.out.println("************");
		
	for(int gen=0;gen<3;gen++){	
		int [][] arr2 = new int[rows][columns];
		
		System.out.println("*** Gen :" +gen);
		for(int i=0; i<rows;i++){
			for(int j=0;j<columns;j++){
				arr2[i][j] = checkRule(arr,i,j);
				System.out.print(arr2[i][j]);
				System.out.print("  ");
				
			}
			System.out.println("");
		}
		//copy result back to init arr		
		for(int x=0;x<rows;x++)
		{
			for(int y=0; y<columns;y++)
			{
				arr[x][y] = arr2[x][y];
			}
		}
	}
		
	}
	
public static int checkRule(int [][]arr,int i, int j)
{
	int neig_b = checkNeigh(arr,i, j);
	
	if(arr[i][j]==0 && neig_b==3)
		return 1;	
	else if(arr[i][j]==1 && neig_b<2)
		return 0;
	else if(arr[i][j]==1 && neig_b>3)
		return 0;
	else if(arr[i][j]==1 && (neig_b>=2 || neig_b>=3))
		return 1;
	
	else
		return 0;
}

public static int checkNeigh(int arrs[][], int i, int j)
{
	int neigh =0 ;
	
	if (i==0) //all above
	{
		
		if (j==0)//left column
		{   //same			
			if(arrs[i][j+1]==1) neigh++;
			
			//below			
			if(arrs[i+1][j]==1) neigh++;
			if(arrs[i+1][j+1]==1) neigh++;
			
		}
		else if (j==arrs[1].length-1)//right column
		{   //same			
			if(arrs[i][j-1]==1) neigh++;
			
			//below			
			if(arrs[i+1][j-1]==1) neigh++;
			if(arrs[i+1][j]==1) neigh++;			
		}
		else if(j>0)		
		{	//same
			if(arrs[i][j-1]==1) neigh++;
			if(arrs[i][j+1]==1) neigh++;
			
			//below
			if(arrs[i+1][j-1]==1) neigh++;
			if(arrs[i+1][j]==1) neigh++;
			if(arrs[i+1][j+1]==1) neigh++;
		}
	}
	
	else if (i==arrs.length-1) //all bottom
	{
		
		if (j==0)//left column			
		{   //above			
			if(arrs[i-1][j]==1) neigh++;
			if(arrs[i-1][j+1]==1) neigh++;
			//same			
			if(arrs[i][j+1]==1) neigh++;			
		}
		else if (j==arrs[1].length-1)//right column
		{   //above			
			if(arrs[i-1][j-1]==1) neigh++;
			if(arrs[i-1][j]==1) neigh++;
			//same			
			if(arrs[i][j-1]==1) neigh++;					
		}
		else if(j>0)		
		{	//above
			if(arrs[i-1][j-1]==1) neigh++;
			if(arrs[i-1][j]==1) neigh++;
			if(arrs[i-1][j+1]==1) neigh++;
			//same
			if(arrs[i][j-1]==1) neigh++;
			if(arrs[i][j+1]==1) neigh++;		
			
		}
	}
	
	else if(i>0)
	{	if (j==0)//left column
		{
			//above			
			if(arrs[i-1][j]==1) neigh++;			
			if(arrs[i-1][j+1]==1) neigh++;
			
			//same			
			if(arrs[i][j+1]==1) neigh++;
			
			//below			
			if(arrs[i+1][j]==1) neigh++;
			if(arrs[i+1][j+1]==1) neigh++;
			
		}
		else if (j==arrs[1].length-1)//right column
		{
			//above			
			if(arrs[i-1][j-1]==1) neigh++;			
			if(arrs[i-1][j]==1) neigh++;
			
			//same			
			if(arrs[i][j-1]==1) neigh++;
			
			//below			
			if(arrs[i+1][j-1]==1) neigh++;
			if(arrs[i+1][j]==1) neigh++;			
		}	
		else if(j>0)	
		{
			//above
			if(arrs[i-1][j-1]==1) neigh++;
			if(arrs[i-1][j]==1) neigh++;
			if(arrs[i-1][j+1]==1) neigh++;
			
			//same
			if(arrs[i][j-1]==1) neigh++;
			if(arrs[i][j+1]==1) neigh++;
			
			//below
			if(arrs[i+1][j-1]==1) neigh++;
			if(arrs[i+1][j]==1) neigh++;
			if(arrs[i+1][j+1]==1) neigh++;
		}
		
			
	}	
	return neigh;
	
}
	
}