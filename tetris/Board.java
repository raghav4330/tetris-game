package tetris;
import java.io.*;

public class Board implements Serializable
{
int maxrow,maxcol,mincol,minrow;
char board[][];
int a[];
Board()
{}
Board(int row,int col)
{
   this.maxrow=row;
   this.minrow=0;
   this.maxcol=col;
   this.mincol=0;
   this.board=new char[maxrow][maxcol];
   this.a=new int[maxrow];
}

void getBoard(Board bb)
{
  //Board b;
    for(int i=0;i<maxrow;i++)
	{
	   for(int j=0;j<maxcol;j++)
	   {
	     board[i][j]=bb.board[i][j];
	   }
    }
	//return b;
}

void setBoard()
{
    for(int i=0;i<maxrow;i++)
	{
	   for(int j=0;j<maxcol;j++)
	   {
	      if(j==0||j==maxcol-1||i==maxrow-1||i==0)
		  board[i][j]='*';
		  else
		  board[i][j]=' ';
		}
	}
}

void setvalue(shape s)
{
    for(int i=0;i<4;i++)
	{
	      if(i==1)
		  board[s.x[i][0]][s.x[i][1]]='#';
		  else
	      board[s.x[i][0]][s.x[i][1]]='O';
	}
}

void clearvalue(shape s)
{
    for(int i=0;i<4;i++)
	{
	      board[s.x[i][0]][s.x[i][1]]=' ';
	}
	
}

void checkrowform()
{
    for(int i=1;i<maxrow-1;i++)
	{
	   if(a[i]==(maxcol-2))
	   for(int j=i-1;j>1;j--)
	   {
	     for(int k=1;k<maxcol-1;k++)
	     {
	        board[j+1][k]=board[j][k];
		 }
	   }
	}
}


void printBoard()
{
  for(int i=0;i<maxrow;i++)
     {
	   a[i]=0;
	 }
	 System.out.println("\n\n");

    for(int i=0;i<maxrow;i++)
	{
	   for(int j=0;j<maxcol;j++)
	   {
	   if(board[i][j]=='O' || board[i][j]=='#')
	   a[i]++;
	      System.out.print(board[i][j]);
	   }
	   System.out.print(" "+a[i]);
	   System.out.println();
	}
	System.out.println();
	System.out.println();
	System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
}
} 
