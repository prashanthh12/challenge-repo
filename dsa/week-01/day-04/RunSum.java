import java.util.Arrays;
class Sol
{
    public int[] runSum(int[] nums)
    {
        for(int i=1;i<nums.length;i++)
        {
            nums[i]=nums[i]+nums[i-1];
        }
        return nums;
    }
}
class RunSum
{
    public static void main(String[] args)
    {
        Sol s=new Sol();
        int[] no={1,3,5,7};
        int[] r=s.runSum(no);
        System.out.println("Sum:"+Arrays.toString(r));

    }
}