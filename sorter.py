

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
    insertion_sort(arr, 5)
    for i in range(5):
        print(arr[i])

if __name__=="__main__":
    main()
    


