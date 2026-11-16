class Solution{
    public boolean isThree(int x)
    {
        int count=0;
        for(int i=1;i<=x;i++)
        {
            if(x%i==0) 
            {
                count++;
            }
        }
        return count==3;
    }
}class ThreeDiv
{
    public static void main(String args[])
    {
        Solution s=new Solution();
        int x=4;
        System.out.println(s.isThree(x));
    }
}