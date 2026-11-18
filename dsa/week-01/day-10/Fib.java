class Sol
{
    public int fib(int n)
    {
        if(n==0 ||n==1)
        {
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
}
class Fib
{
    public static void main(String[] args)
    {
        Sol s=new Sol();
        System.out.println(s.fib(8));
    }
}