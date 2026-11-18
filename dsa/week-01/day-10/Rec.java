class Sol
{
    public void rec(int n)
    {
        if(n==0)
        {
            return ;
        } 
        
        rec(n-1);
        System.out.println(n);
        
        
    }
}
class Rec
{
    public static void main(String args[])
    {
        Sol s=new Sol();
       s.rec(7);
    }
}