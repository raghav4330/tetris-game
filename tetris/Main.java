package tetris;
import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.Timer; 
import java.util.TimerTask; 


	
class Main implements Serializable
{
Board b,bb;
point p;
shape s;
node n;
stack st;
boolean shapeundoed=false;

   /*static Runtime r = new Runtime.getRuntime();
static void clear() {
try {
          r.exec("cmd /c cls"); 
          } catch (IOException e) {
               e.printStackTrace();
          }
}*/
public boolean move(char ch)
{
  boolean flag=true;

  if(shapeundoed==true && ch!='z' )
  {
  if(ch!='x')
  {
  shapeundoed=false;
  st.rhead=null;
  }
  }
          b.clearvalue(s); 
             if(ch!='z')
			   {
			   st.push(s,bb,false);
			   }
			   
			if(ch=='t')
			{
			    s.rotateclockwise(p,b);
			}
			if(ch=='r')
			{
			    s.rotateanticlockwise(p,b);
			}
			if(ch=='d' || ch==39)
			{
			    s.moveright(b);
			}
			if(ch=='a' || ch==37)
			{
			    s.moveleft(b);
			}
			if(ch=='s')
			{
			    flag=s.movedown(b);
			}
			if(ch=='z')
			{
			    shapeundoed=true;
			    node n=st.undo();
				if(n!=null)
				{
                    s=n.s;
					b=n.b;
				}
		    }
			
			if(ch=='x')
			{
			   node n=st.redo();
			   if(n!=null)
			   {
			   s=n.s;
			   b=n.b;
			   }
			}
			
			   // flag=s.movedown(b);
			   
			    b.setvalue(s);
				//new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
				//clr();
				b.printBoard();
				return flag;
}

public void savegame()
{
	try
	{
	 ObjectOutputStream out = new ObjectOutputStream( new BufferedOutputStream( new FileOutputStream("savetetris.txt")));
    

		out.writeObject(bb);
		out.writeObject(s);
		out.writeObject(p);
	System.out.println("game saved");
      out.flush();
    } catch (IOException ex) {
	    ex.printStackTrace();}
}

public void pausegame()
{
	System.out.println("\n\npress s to save\npress c to close game\npress spacebar to back");
	Scanner ss=new Scanner(System.in);
	char c=ss.next().charAt(0);
	while(c!='v')
	{
		if(c=='s')
			savegame();
		if(c=='c')
			System.exit(0);
		System.out.println("\n\npress s to save\npress c to close game\npress spacebar to back");
		c=ss.next().charAt(0);
	}
	b.printBoard();
}

void loadgame()
{
	try
	{
	    ObjectInputStream in = new ObjectInputStream( new BufferedInputStream( new FileInputStream("savetetris.txt"))) ;
	   
  
	  bb=(Board)in.readObject();
	  b=bb;
	  s=(shape)in.readObject();
	  p=(point)in.readObject();
	}
     catch (Exception ex) {
      ex.printStackTrace();
    }
}

int startmenu()
{
	System.out.println("\n\npress a to start new game\npress b to load game\npress c to close game");
	Scanner ss=new Scanner(System.in);
	char c=ss.next().charAt(0);
	while(true)
	{
		if(c=='a')
			return 1;

		else if(c=='b')
		{
			loadgame();
			return 2;
		}
		else if(c=='c')
			System.exit(0);
	}
}

public static void main(String args[]) throws IOException,InterruptedException
{
   int rows=15,cols=20;
   final Main m=new Main();
   m.b=new Board(rows,cols);
   m.s=new shape();
   m.st=new stack();
   m.n=new node();
   
   int start=m.startmenu();
   
   //point p;
   Scanner ss=new Scanner(System.in);
   
   char k,ch;
   Boolean flag=true,end=true;
   
   if(start!=2)
   m.b.setBoard();

   while(end==true)
   {
		if(start!=2)
		{
			m.s.getshape(cols);
	        m.p=new point(m.s.type);
		}
		start=0;
		
	   flag=end=gameover(m.b,m.s); 
	   
	   m.b.setvalue(m.s);
	   m.st.push(m.s,m.b,true);
	   
	   m.bb=m.st.return_Board();
	   m.bb.clearvalue(m.s);
		
	   m.b.printBoard();
	   //flag=true;
	   
	   while(flag==true)
	   {
	      ch=ss.next().charAt(0);
		  //System.out.println(ch);
		  if(ch=='v')
		  {
			  //System.out.println("hello");
			  m.pausegame();
		  }
		  else
		  flag=m.move(ch);
	   }	  
			    
				m.b.checkrowform();
				m.b.printBoard();
			System.out.println("\n\n");
	 }
}

   static boolean gameover(Board b,shape s)
  {
      for(int i=0;i<4;i++)
	  {
	      if(b.board[s.x[i][0]][s.x[i][1]]=='O' )
           return false;
	  }
	   return true;
  } 
  

/*public static void clr(){
    //Clears Screen in java
    try {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    } catch (IOException  | InterruptedException ex) {}
}*/

	   	  /*Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                m.move('s');
            }
        }, 4000, 4000);*/

} 
 

