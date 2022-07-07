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

    public int partition(int high, int low){
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++)
        {
            if (array[j] < pivot)
            {
                i++;
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }
        int t = array[i + 1];
        array[i + 1] = array[high];
        array[high] = t;
        return (i + 1);

    }

    public void quick_sort(int low, int high){
        if (low < high)
        {
            int pi = partition(low, high);
            quick_sort(low, pi - 1);
            quick_sort(pi + 1, high);
        }
    }



}