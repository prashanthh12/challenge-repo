class Sol
{
    public boolean isAn(String s,String t)
    {
        if(s.length()!=t.length())
        {
            return false;
        }
        int count[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;

        }
        for(int i=0;i<26;i++)
        {
            if(count[i]!=0)
            {
                return false;
            }
        }
        return true;
    }
}
class Val
{
    public static void main(String args[])
    {
        Sol s=new Sol();
        String s1="anagram";
        String s2="nagaram";
        System.out.println(s.isAn(s1,s2));
    }
}