import java.util.Arrays;
class Sol
{
    public int[] isSort(int[] arr)
    {
        int n=arr.length;
        for(int i=0;i<n-1;i++)
        {
            int min=i;
            for(int j=i+1;j<n;j++)
            {
                if(arr[j]<arr[min])
                {
                    min=j;
                }

            }
            int temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
        return arr;
    }
}
class Sel
{
    public static void main(String[] args)
    {
        Sol sort=new Sol();
        int arr[]={5,3,8,2,4};
        int[] sels=sort.isSort(arr);
        
        System.out.println("Sorted Array:" + Arrays.toString(sels));
    }
}