public class Driver {
    public static void main(String[] args){
        int[] arr = {4,6,3,65,10};
        // Sorter sorter = new Sorter(arr);
        // sorter.quick_sort(arr, 0, 4);
        quick_sort(arr, 0, 4);

        for(int i = 0; i < 5; i++){
            System.out.println(arr[i]);
        }
    }

    static public int partition(int[] a, int low, int high){
        int pivot = a[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++)
        {
            if (a[j] < pivot)
            {
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[i + 1];
        a[i + 1] = a[high];
        a[high] = t;
        return (i + 1);

    }

    static public void quick_sort(int[] a, int low, int high){
        System.out.print("here\n");
        int[] arr = a;
        if (low < high)
        {
            int pi = partition(arr, low, high);
            quick_sort(arr, low, pi - 1);
            quick_sort(arr, pi + 1, high);
        }
    }
}
