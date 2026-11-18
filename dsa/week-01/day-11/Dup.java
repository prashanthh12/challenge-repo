import java.util.HashSet;
class Sol
{
    public boolean isDupp(int []nums)
    {
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            if(set.contains(nums[i]))
            {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
class Dup
{
    public static void main(String args[])
    {
        Sol s=new Sol();
        int []nums={1,2,1,3,4,5,6,7,8,9,10};
        System.out.println(s.isDupp(nums));
    }
}