package tetris;

import java.util.Random;
import java.io.*;
enum shapes
{
   I,O,Z,S,T,L,J
}
//enum.values()[index]

class shape implements Serializable
{
int type,form,x[][]=new int[4][2];
char value;


shape()
{}

void getshape(shape ss)
{
   //shape s;
   type=ss.type;
   form=ss.form;
   for(int i=0;i<4;i++)
   {
      x[i][0]=ss.x[i][0];
	  x[i][1]=ss.x[i][1];
   }
   //return s;
}

int getval()
{
   Random rand = new Random();
   int rand_int1 = rand.nextInt(7);
   return  rand_int1; 
}

void getshape(int C)
{
int sh=getval();
shapes ch=shapes.values()[sh];

 switch(ch)
  {                                
 case I:                           
   x[0][0]=1; x[0][1]=(C/2)-1; x[1][0]=2; x[1][1]=(C/2)-1; x[2][0]=3;  x[2][1]=(C/2)-1; x[3][0]=4; x[3][1]=(C/2)-1;
   type=0;
   form=0;
   break;                          
                                   
 case O:                           
   x[0][0]=1; x[0][1]=(C/2)-1; x[1][0]=1; x[1][1]=C/2; x[2][0]=2;  x[2][1]=C/2; x[3][0]=2; x[3][1]=(C/2)-1;
   type=1;
   form=0;   
   break;                          
                                   
  case S:                          
   x[0][0]=1; x[0][1]=(C/2)-1; x[1][0]=2; x[1][1]=(C/2)-1; x[2][0]=2;  x[2][1]=C/2; x[3][0]=3; x[3][1]=C/2;
   type=3;
   form=0;
   break;                          
                                   
   case Z:                         
   x[0][0]=1; x[0][1]=C/2; x[1][0]=2; x[1][1]=C/2; x[2][0]=2;  x[2][1]=(C/2)-1; x[3][0]=3; x[3][1]=(C/2)-1;
   type=2;
   form=0;
   break;                          
                                   
   case T:                                                                                                                        
   x[0][0]=1; x[0][1]=C/2; x[1][0]=2; x[1][1]=C/2; x[2][0]=3;  x[2][1]=C/2; x[3][0]=2; x[3][1]=(C/2)-1;
   type=4;
   form=0;
   break;                          
                                   
   case L:                         
   x[0][0]=1; x[0][1]=(C/2)-1; x[1][0]=2; x[1][1]=(C/2)-1; x[2][0]=3;  x[2][1]=(C/2)-1; x[3][0]=3; x[3][1]=C/2;
   type=5;
   form=0;
   break;                          
                                   
   case J:                         
   x[0][0]=1; x[0][1]=C/2; x[1][0]=2; x[1][1]=C/2; x[2][0]=3;  x[2][1]=C/2; x[3][0]=3; x[3][1]=(C/2)-1;
   type=6;
   form=0;
   break;
  } 
 }
 
 void moveright(Board b)
 {
 int a,e;
     for(int i=0;i<4;i++)
	 {
	 a=x[i][1]+1;
	 e=x[i][0];
	 if(b.board[e][a]=='*' || b.board[e][a]=='O' || b.board[e][a]=='#')
	 return;
	 }
	 for(int i=0;i<4;i++)
	 {
	 x[i][1]++;
	 }
 }
 
  void moveleft(Board b)
 {
 int a,e;
 
      for(int i=0;i<4;i++)
	 {
	 a=x[i][1]-1;
	 e=x[i][0];
	if(b.board[e][a]=='*' || b.board[e][a]=='O' || b.board[e][a]=='#')
	 return;
	 }
	 for(int i=0;i<4;i++)
	 {
	 x[i][1]--;
	 }
 }
 
  void rotateclockwise(point p,Board b)
  {
   int t=form,m=0,n;
   for(int i=0;i<4;i++)
	 {
	     
		 System.out.println(p.a[t][i][0]+" "+p.a[t][i][1]);
	 }
     for(int i=0;i<4;i++)
	 {
	     m=x[i][0]+p.a[t][i][0];
		 n=x[i][1]+p.a[t][i][1];
		 if(b.board[m][n]=='O' || b.board[m][n]=='*')
		 return;
	}
	for(int i=0;i<4;i++)
	 {
	     x[i][0]+=p.a[t][i][0];
		 x[i][1]+=p.a[t][i][1];
	 }
			 
			 form++;
			 if(form==4)
			 form=0;
   }
 
 
 
  void rotateanticlockwise(point p,Board b)
 {
  int t=form-1,m,n;
  if(t==-1)
  t=3;
     for(int i=0;i<4;i++)
	 {
	     m=x[i][0]-p.a[t][i][0];
		 n=x[i][1]-p.a[t][i][1];
		 if(b.board[m][n]=='O' || b.board[m][n]=='*')
		 return;
	}
	for(int i=0;i<4;i++)
	 {
	     x[i][0]-=p.a[t][i][0];
		 x[i][1]-=p.a[t][i][1];
	 }
			 
			 form--;
			 if(form==-1)
			 form=3;
   }
  
  
  boolean movedown(Board b)
  {
  int a,e;
     for(int i=0;i<4;i++)
	 {
	 a=x[i][0]+1;
	 e=x[i][1];
	 if(b.board[a][e]=='*' || b.board[a][e]=='O' || b.board[a][e]=='#')
	 return false;
     }
	 
	 for(int i=0;i<4;i++)
	 {
	 x[i][0]++;
     }
	 return true;
 
  }
  
}
   
   
   
  