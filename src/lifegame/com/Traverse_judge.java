package lifegame.com;

public class Traverse_judge{
	int x;
	int y;
	public Traverse_judge(int x1,int y1){
		x=x1;
		y=y1;
	}
	public int get_x(){
		return x;
	}
	
	public int get_y(){
		return y;
	}
	
	public int judge(int[][] a,int i1,int j1) {
		int count=0;
		
		for(int i=i1-1;i<=i1+1;i++) {
			for(int j=j1-1;j<=j1+1;j++) {
				if(i==i1&&j==j1) {
					continue;
				}
				if(a[i][j]==1) {
					count++;
				}
			}
		}
		
		if(a[i1][j1]==0&&count==3)
			return 1;
		else if(a[i1][j1]==1&&(count==2||count==3))
			return 1;
		else
			return 0;
	}

	public int[][] traverse(int [][] a) {
		int [][] newchessboard=new int[x][y];
		for(int i=1;i<x-2;i++) {
			for(int j=1;j<y-2;j++) {
				newchessboard[i][j] = judge(a,i,j);
			}
		}
		return newchessboard;
	}
}
