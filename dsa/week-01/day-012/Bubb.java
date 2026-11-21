import java.util.Arrays;
class Sol
{
    public int[] isSort(int[] arr)
    {
        int n=arr.length;
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }
}
class Bubb
{
    public static void main(String[] args)
    {
        Sol sort=new Sol();
        int arr[]={5,3,8,2,4};
        int[] bubbs=sort.isSort(arr);
        System.out.println("Sorted Array:" + Arrays.toString(bubbs));
    }
}