class Sol
{
    public int findJew(String stones,String jewels)
    {
        int count=0;
        for(int i=0;i<stones.length();i++)
        {
            for(int j=0;j<jewels.length();j++)
            {
                if(stones.charAt(i)==jewels.charAt(j))
                {
                    count++;
                }
            }
        }
        return count;
    }
}
class Jew
{
    public static void main(String[] args)
    {
        Sol sl=new Sol();
        String st="aBCbvAAja";
        String jeww="aA";
        System.out.println("Jewels in Stones:"+sl.findJew(st,jeww));
    }
}