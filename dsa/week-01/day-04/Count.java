class Solution
{
    public int numStep(int num)
    {
        int steps=0;
        while(num>0)
        {
            if(num%2==0)
            {
                num=num/2;
            }
            else
            {
                num=num-1;
            }
            steps+=1;
        }
        return steps;
    }
}
class Count
{
    public static void main(String[] args)
    {
        Solution s=new Solution();
        int no=14;
        System.out.println("Count:"+s.numStep(no));
    }
}