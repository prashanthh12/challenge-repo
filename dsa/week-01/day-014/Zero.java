import java.util.Arrays;
class Sol{
    public int[] moveZero(int[]arr)
    {
        int j=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=0)
            {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
        }
        return arr;
    }
}
class Zero
{
    public static void main(String[] args)
    {
        Sol move=new Sol();
        int arr[]={0,1,0,3,12};
        int[]z=move.moveZero(arr);
        System.out.println("Sorted Array:" + Arrays.toString(z));
    }
}