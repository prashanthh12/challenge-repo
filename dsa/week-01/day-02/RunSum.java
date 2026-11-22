class Sol
{
    public int subtract(int n)
    {
        int product=1;
        int sum=0;
        while(n>0)
        {
            int digits=n%10;
            product=product*digits;
            sum=sum+digits;
            n=n/10;
            
        }
        
        return product-sum;
    }
}
class RunSum
{
    public static void main(String[] args)
    {
        Sol s=new Sol();
        int num=234;
        int res=s.subtract(num);
        System.out.println("Result:"+res);
    }
}