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

    public void partition(){


    }

    public void quick_sort(){

        
    }



}