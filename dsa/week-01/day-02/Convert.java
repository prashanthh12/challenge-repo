import java.util.Arrays;
class Sol
{
    public double[] temp(double celsius)
    {
        double k=celsius+273.00;
        double f=celsius*1.80+32.00;

        return new double[]{k,f};
    }
}
class Convert
{
    public static void main(String[] args)
    {
        Sol s=new Sol();
        double temp=36.50;
        double[] r=s.temp(temp);
        System.out.println("result:"+Arrays.toString(r));

    }
}