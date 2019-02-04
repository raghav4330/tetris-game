package tetris;

class node
{
   shape s;
   Board b;
   node next;
   node()
   {}
   node(shape ss,Board bb,boolean getnewmatrix)
   {
      s=new shape();
	  s.getshape(ss);
      
	  if(getnewmatrix==true)
	  {
	  b=new Board(bb.maxrow,bb.maxcol);
      b.getBoard(bb);
	  }
	  else
	  b=bb;

	  this.next=null;
   }
   
    node(node nn)
	{
	   s=nn.s;
	   b=nn.b;
	   this.next=null;
	}
}
 
class stack
{
	node uhead,rhead;
	
	stack()
	{
	uhead=null;
	rhead=null;
	}
	
	Board return_Board()
	{
	return uhead.b;
	}
	
	boolean checked_repitition(shape ss)
	{
	   int k=1;
	   for(int i=0;i<4;i++)
	   {
         if(uhead.s.x[i][0]==ss.x[i][0] && uhead.s.x[i][1]==ss.x[i][1])
         {}
         else
         k=0;
	   }
	   if(k==0)
	   return false;
	   else
	   return true;
	   
    }
	
	void push(shape ss,Board bb,boolean getnewmatrix)
	{
	
	if(uhead==null)
       {
	   node temp=new node(ss,bb,getnewmatrix);
		   uhead=temp;
		   temp.next=null;
	   }
	   else
	   {
       if(checked_repitition(ss)==false)
	   {
	   node temp=new node(ss,bb,getnewmatrix);
	   temp.next=uhead;
	   uhead=temp;
	   }
	  }
	 
	}


    node undo()
	{
	    node n=uhead;
		if(n==null)
		{
		//addinredo(n);
		return n;
		}
		
		uhead=uhead.next;
		addinredo(n);
		return n;
	}
	
    void addinredo(node n)
	{

	   node temp=new node(n);
	   if(rhead==null)
	   {
	   rhead=temp;
	   temp.next=null;
	   }
	   else
	   temp.next=rhead;
	   rhead=temp;
	   
	}
	
	node redo()
	{

	   node n=rhead;
		if(n==null)
		return n;
		
		rhead=rhead.next;
		return n;
	}
	
}
	


