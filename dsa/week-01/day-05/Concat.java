import java.util.Arrays;
class Sol
{
    public int[] conCat(int[] nums)
    {
        int n=nums.length;
        int[] ans=new int[2*n];
        for(int i=0;i<n;i++)
        {
            ans[i]=nums[i];
            ans[i+n]=nums[i];
        }
        return ans;
    }
}
class Concat
{
    public static void main(String[] args)
    {
        Sol s=new Sol();
        int[] no={1,2,1};
        int[] r=s.conCat(no);
        System.out.println("Concated:"+Arrays.toString(r));

    }
}