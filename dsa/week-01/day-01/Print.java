import java.util.Scanner;
class Print
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String name="Prashanth";
        int age=22;
        System.out.println("Enter a number:");
        int num=sc.nextInt();
        System.out.println("Name:"+name);
        System.out.println("Age:"+age);
        System.out.println("Dobuled num:"+num*2);
    }
}