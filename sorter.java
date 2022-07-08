public class Sorter {

    int[] array;
    int size;

    public Sorter(int[] arr){
        this.array = arr;
        this.size = arr.length;
    }

    public void insertion_sort()
    {
        int i, key, j;
        for (i = 1; i < size; i++)
        {
            key = array[i];
            j = i - 1;

            while (j >= 0 && array[j] > key)
            {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    static public int partition(int[] a, int high, int low){
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