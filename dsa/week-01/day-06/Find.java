import java.util.Arrays;
class Sol
{
    public int findNum(int[] nums)
    {
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            int num=nums[i];
            int digits=0;
            while(num>0)
            {
                num=num/10;
                digits++;
            }
            if(digits%2==0)
            {
                count++;
            }

        }
        return count;
    }
}
class Find
{
    public static void main(String[] args)
    {
        Sol sl=new Sol();
        int [] no={12,467,874,6734};
        int r=sl.findNum(no);
        System.out.println("Counts:"+r);
    }
}