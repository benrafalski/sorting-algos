#include <iostream>
#include <ctime>

using namespace std;

#define SIZE 10

int *random_arr();
void print(int arr[]);
void insertion_sort(int arr[], int n);
int partition(int arr[], int low, int high);
void quick_sort(int arr[], int low, int high);

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

int main()
{
    int *arr = random_arr();
    print(arr);
    // insertion_sort(arr, SIZE);
    quick_sort(arr, 0, SIZE - 1);
    print(arr);

    return 0;
}