import java.util.Arrays;
class Sol
{
    public int stock(int[] prices)
    {
        int min=prices[0];
        int maxprofit=0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]<min)
            {
                min=prices[i];
            }
            int profit=prices[i]-min;
            if(profit>maxprofit)
            {
                maxprofit=profit;
            }
        }
        return maxprofit;
    }
}
class Stock
{
    public static void main(String[] args)
    {
        Sol stock=new Sol();
        int prices[]={7,1,5,3,6,4};
        int s=stock.stock(prices);
        System.out.println("Max Profit:" + s);
    }
}