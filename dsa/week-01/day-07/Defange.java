class Sol
{
    public String defange(String address)
    {
        String result="";
        for(int i=0;i<address.length();i++)
        {
            if(address.charAt(i)=='.')
            {
                result=result+"[.]";
            }
            else
            {
                result=result+address.charAt(i);
            }
        }
        return result;
    }
}
class Defange
{
    public static void main(String[] args)
    {
        Sol sl=new Sol();
        String st="1.1.1.1";
        System.out.println("Defanged:"+sl.defange(st));
    }
}