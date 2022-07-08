#include <iostream>
#include <ctime>

using namespace std;

#define SIZE 10

int *random_arr();
void print(int arr[]);

void insertion_sort(int arr[], int n);

int partition(int arr[], int low, int high);
void quick_sort(int arr[], int low, int high);

void merge(int arr[], int const left, int const mid, int const right);
void merge_sort(int arr[], int const begin, int const end);

void bubble_sort(int arr[], int n);

void selection_sort(int arr[], int n);

int *random_arr()
{
    static int a[SIZE];
    int max = 100, min = 0;
    int range = max - min + 1;

    srand((unsigned)time(NULL));
    for (int i = 0; i < SIZE; ++i)
    {
        a[i] = rand() % range + min;
    }
    return a;
}

void print(int arr[])
{
    cout << "[";
    for (int i = 0; i < SIZE; i++)
    {
        if (i == SIZE - 1)
        {
            cout << arr[i] << "]\n";
            return;
        }
        cout << arr[i] << ", ";
    }
}

void insertion_sort(int arr[], int n)
{
    int i, key, j;
    for (i = 1; i < n; i++)
    {
        key = arr[i];
        j = i - 1;

        while (j >= 0 && arr[j] > key)
        {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
}

int partition(int arr[], int low, int high)
{
    int pivot = arr[high];
    int i = (low - 1);
    for (int j = low; j <= high - 1; j++)
    {
        if (arr[j] < pivot)
        {
            i++;
            int t = *&arr[i];
            *&arr[i] = *&arr[j];
            *&arr[j] = t;
        }
    }
    int t = *&arr[i + 1];
    *&arr[i + 1] = *&arr[high];
    *&arr[high] = t;
    return (i + 1);
}

void quick_sort(int arr[], int low, int high)
{
    if (low < high)
    {
        int pi = partition(arr, low, high);

        quick_sort(arr, low, pi - 1);
        quick_sort(arr, pi + 1, high);
    }
}

void merge(int arr[], int const left, int const mid, int const right)
{
    auto const subOne = mid - left + 1;
    auto const subTwo = right - mid;

    auto *leftArr = new int[subOne], *rightArr = new int[subTwo];

    for (auto i = 0; i < subOne; i++)
    {
        leftArr[i] = arr[left + i];
    }
    for (auto j = 0; j < subTwo; j++)
    {
        rightArr[j] = arr[mid + 1 + j];
    }

    auto indexOfSubOne = 0, indexOfSubTwo = 0;
    int indexOfMerge = left;
    while (indexOfSubOne < subOne && indexOfSubTwo < subTwo)
    {
        if (leftArr[indexOfSubOne] <= rightArr[indexOfSubTwo])
        {
            arr[indexOfMerge] = leftArr[indexOfSubOne];
            indexOfSubOne++;
        }
        else
        {
            arr[indexOfMerge] = rightArr[indexOfSubTwo];
            indexOfSubTwo++;
        }
        indexOfMerge++;
    }
    while (indexOfSubOne < subOne)
    {
        arr[indexOfMerge] = leftArr[indexOfSubOne];
        indexOfSubOne++;
        indexOfMerge++;
    }

    while (indexOfSubTwo < subTwo)
    {
        arr[indexOfMerge] = rightArr[indexOfSubTwo];
        indexOfSubTwo++;
        indexOfMerge++;
    }
}

void merge_sort(int arr[], int const begin, int const end)
{
    if (begin >= end)
    {
        return;
    }
    auto mid = begin + (end - begin) / 2;
    merge_sort(arr, begin, mid);
    merge_sort(arr, mid + 1, end);
    merge(arr, begin, mid, end);
}

void bubble_sort(int arr[], int n)
{
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = 0; j < n - i - 1; j++)
        {
            if (arr[j] > arr[j + 1])
            {
                int t = *&arr[j];
                *&arr[j] = *&arr[j + 1];
                *&arr[j + 1] = t;
            }
        }
    }
}

void selection_sort(int arr[], int n)
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
        int t = *&arr[min_index];
        *&arr[min_index] = *&arr[i];
        *&arr[i] = t;
    }
}

int main()
{
    int *arr = random_arr();
    print(arr);
    // insertion_sort(arr, SIZE);
    quick_sort(arr, 0, SIZE - 1);
    // merge_sort(arr, 0, SIZE - 1);
    // bubble_sort(arr, SIZE);
    // selection_sort(arr, SIZE);
    print(arr);

    return 0;
}