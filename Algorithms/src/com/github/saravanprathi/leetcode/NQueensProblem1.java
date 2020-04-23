package com.github.saravanprathi.leetcode;

public class NQueensProblem1 {

	class Position{
		int row,col;
		Position(int row,int col){
			this.row=row;
			this.col=col;
		}
	}
	
	public static void main(String[] args) {
		int n=6;
		NQueensProblem1 np=new NQueensProblem1();
		Position[] positions=new Position[n];
		boolean isit=np.solveNQueensProblem(n,positions,0);
		if(isit) {
			for(Position p:positions) {
				System.out.println(p.row+"-"+p.col);
				
			}
		}
	}

	private boolean solveNQueensProblem(int n, Position[] positions,int row) {
		// TODO Auto-generated method stub
		if(n==row) {
			return true;
		}
		for(int col=0;col<n;col++) {
			boolean safe=true;
			for(int i=0;i<row;i++) {
				if(positions[i].col==col || positions[i].row==row || positions[i].row-positions[i].col==row-col || positions[i].row+positions[i].col==row+col) {
					safe=false;
					break;
				}
			}
			if(safe) {
				positions[row]=new Position(row,col);
				if(solveNQueensProblem(n,positions,row+1))
				return true;
			}
		}
		return false;
	}
}
