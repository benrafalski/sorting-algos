public class Sorter {

  public static void main(String[] args) {
    int[] arr = { 4, 6, 3, 65, 10 };
    // insertion_sort(arr);
    // quick_sort(arr, 0, 4);
    // merge_sort(arr, 0, 4);
    // bubble_sort(arr, 5);
    selection_sort(arr, 5);
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

  public static void merge(
    int arr[],
    final int left,
    final int mid,
    final int right
  ) {
    final var subOne = mid - left + 1;
    final var subTwo = right - mid;

    int[] leftArr = new int[subOne], rightArr = new int[subTwo];

    for (var i = 0; i < subOne; i++) {
      leftArr[i] = arr[left + i];
    }
    for (var j = 0; j < subTwo; j++) {
      rightArr[j] = arr[mid + 1 + j];
    }

    int  indexOfSubOne = 0, indexOfSubTwo = 0, indexOfMerge = left;
    while (indexOfSubOne < subOne && indexOfSubTwo < subTwo) {
      if (leftArr[indexOfSubOne] <= rightArr[indexOfSubTwo]) {
        arr[indexOfMerge] = leftArr[indexOfSubOne];
        indexOfSubOne++;
      } else {
        arr[indexOfMerge] = rightArr[indexOfSubTwo];
        indexOfSubTwo++;
      }
      indexOfMerge++;
    }
    while (indexOfSubOne < subOne) {
      arr[indexOfMerge] = leftArr[indexOfSubOne];
      indexOfSubOne++;
      indexOfMerge++;
    }

    while (indexOfSubTwo < subTwo) {
      arr[indexOfMerge] = rightArr[indexOfSubTwo];
      indexOfSubTwo++;
      indexOfMerge++;
    }
  }

  public static void merge_sort(int arr[], final int begin, final int end) {
    if (begin >= end) {
      return;
    }
    var mid = begin + (end - begin) / 2;
    merge_sort(arr, begin, mid);
    merge_sort(arr, mid + 1, end);
    merge(arr, begin, mid, end);
  }


  public static void bubble_sort(int arr[], int n)
  {
      for (int i = 0; i < n - 1; i++)
      {
          for (int j = 0; j < n - i - 1; j++)
          {
              if (arr[j] > arr[j + 1])
              {
                  int t = arr[j];
                  arr[j] = arr[j + 1];
                  arr[j + 1] = t;
              }
          }
      }
  }

  public static void selection_sort(int arr[], int n)
  {
      for (int i = 0; i < n - 1; i++)
      {
          int min_index = i;
          for (int j = i + 1; j < n; j++)
          {
              if (arr[j] < arr[min_index])
              {
                  min_index = j;
              }
          }
          int t = arr[min_index];
          arr[min_index] = arr[i];
          arr[i] = t;
      }
  }
}
