import java.util.List;
import java.util.ArrayList;
class Sol
{
    public List<String> fizzBuzz(int n)
    {
        List<String> ans=new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            if(i%3==0 && i%5==0)
            {
                ans.add("FizzBuzz");
            }
            else if(i%3==0)
            {
                ans.add("Fizz");
            }
            else if(i%5==0)
            {
                ans.add("Buzz");
            }
            else
            {
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }
}
class Fizz
{
    public static void main(String[] args)
    {
        Sol s=new Sol();
        int no=15;
        List<String> st=s.fizzBuzz(no);
        System.out.println("List:"+st);
    }
}