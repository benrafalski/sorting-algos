public class Sorter {

  public static void main(String[] args) {
    int[] arr = { 4, 6, 3, 65, 10 };
    // insertion_sort(arr);
    quick_sort(arr, 0, 4);

    for (int i = 0; i < 5; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void insertion_sort(int[] array) {
    int i, key, j;
    for (i = 1; i < array.length; i++) {
      key = array[i];
      j = i - 1;

      while (j >= 0 && array[j] > key) {
        array[j + 1] = array[j];
        j = j - 1;
      }
      array[j + 1] = key;
    }
  }

  public static int partition(int[] a, int low, int high) {
    int pivot = a[high];
    int i = (low - 1);
    for (int j = low; j <= high - 1; j++) {
      if (a[j] < pivot) {
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

  public static void quick_sort(int[] a, int low, int high) {
    if (low < high) {
      int pi = partition(a, low, high);
      quick_sort(a, low, pi - 1);
      quick_sort(a, pi + 1, high);
    }
  }
}
