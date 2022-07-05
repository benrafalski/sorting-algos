#include <iostream>
#include <ctime>

using namespace std;

#define SIZE 10

int *random_arr();
void print(int arr[]);
void insertion_sort(int arr[], int n);
int partition(int arr[], int low, int high)

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

void print(int arr[]){
    cout << "[";
    for(int i = 0; i < SIZE; i++){
        if(i == SIZE -1){
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




int main()
{
    int * arr = random_arr();
    print(arr);
    insertion_sort(arr, SIZE);
    print(arr);



    return 0;
}