import java.util.Arrays;
class Sol
{
    public int[] shuffle(int[]num,int n)
    {
        int[] ans=new int[2*n];
        for(int i=0;i<n;i++)
        {
            ans[2*i]=num[i];
            ans[2*i+1]=num[i+n];
        }
        return ans;

    }
}
class ArrayShuffle
{
    public static void main(String[] args)
    {
        Sol s=new Sol();
        int size=3;
        int no[]={1,4,6,7,3,8};
        int [] r=s.shuffle(no,size);
        System.out.println("Shuffled array:"+Arrays.toString(r));
    }
}