#include <iostream>
#include <ctime>

using namespace std;

int *random_arr();
void insertion_sort(int arr[], int n);

int *random_arr()
{
    static int a[20];
    srand((unsigned)time(NULL));
    for (int i = 0; i < 10; ++i)
    {
        a[i] = rand();
    }
    return a;
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

int main()
{

    return 0;
}