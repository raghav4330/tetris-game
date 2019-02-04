
/*package tetris;

class node
{
   shape s;
   Board b;
   node next;
   node()
   {}
   node(shape ss,Board bb)
   {
      s=new shape();
	  s.getshape(ss);

	  b=new Board(bb.maxrow,bb.maxcol);
      b.getBoard(bb);

	  this.next=null;
   }     
}
class stack
{
	node head;
	
	stack()
	{
	head=null;
	}
	
	void push(shape ss,Board bb)
	{


	   node temp=new node(ss,bb);
       if(head==null)
       {
		   head=temp;
		   temp.next=null;
	   }
	   else
	   {
	   temp.next=head;
	   head=temp;
	   }
	   /* for(int i=0;i<4;i++)
	   {
		System.out.println(head.s.x[i][0]+" "+head.s.x[i][1]);
		}
		 for(int i=0;i<head.b.maxrow;i++)
					{
					for(int j=0;j<head.b.maxcol;j++)
					{
						
						System.out.print(head.b.board[i][j]);
					}
					System.out.println();
					}*/
	//}

/*
    node undo()
	{
	    node n=head;
		if(n==null)
		return n;
		
		head=head.next;
		return n;
	}
	
}
*/
	