
def partition(arr, low, high):
    pivot = arr[high]
    i = (low - 1)
    for j in range(low, high):
        if arr[j] < pivot:
            i = i + 1
            t = arr[i]
            arr[i] = arr[j]
            arr[j] = t
    t = arr[i + 1]
    arr[i + 1] = arr[high]
    arr[high] = t
    return (i + 1)


def quick_sort(arr, low, high):
    if low < high:
        pi = partition(arr, low, high)
        quick_sort(arr, low, pi - 1)
        quick_sort(arr, pi + 1, high)
    


def insertion_sort(arr, n):
    # int i, key, j;
    for i in range(n):
        key = arr[i]
        j = i - 1
        while (j >= 0 and arr[j] > key):
            arr[j + 1] = arr[j]
            j = j - 1
        arr[j + 1] = key


def main():
    arr = [5,3,4,1,8]
    # insertion_sort(arr, 5)
    quick_sort(arr, 0, 4)
    for i in range(5):
        print(arr[i])

if __name__=="__main__":
    main()
    


