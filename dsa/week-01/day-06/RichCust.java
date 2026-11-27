import java.util.Arrays;
class Sol
{
    public int maxWealth(int[][] accounts)
    {
        int mw=0;
        for(int [] acnt:accounts)
        {
            int sum=0;
            for(int value:acnt)
            {
                sum=sum+value;
            }
            if(sum>mw)
            {
                mw=sum;
            }
        }
        return mw;
    }
}
class RichCust
{
    public static void main(String [] args)
    {
        Sol s=new Sol();
        int[][] acnts={{3,6,3},{4,2,6}};
        int r=s.maxWealth(acnts);
        System.out.println("Rich Customer:"+r);
    }
}