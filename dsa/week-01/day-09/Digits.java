class Solution{
    public int addDig(int x)
    {
        while(x>10)
        {
            int sum=0;
            while(x>0)
            {
                sum+=x%10;
                x=x/10;

            }
            x=sum;
        }
        return x;
        
    }
}
class Digits
{
    public static void main(String args[])
    {
        Solution s=new Solution();
        int x=38;
        System.out.println(s.addDig(x));
    }
}