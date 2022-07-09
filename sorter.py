
def bubble_sort(arr, n):
    for i in range(n-1):
        for j in range(n - i - 1):
            if arr[j] > arr[j + 1]:
                t = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = t

def merge(arr, LEFT, MID, RIGHT):

    SUB_ONE = MID - LEFT + 1
    SUB_TWO = RIGHT - MID

    leftArr = [0] * SUB_ONE
    rightArr = [0] * SUB_TWO

    for i in range(SUB_ONE):
        leftArr[i] = arr[LEFT + i]
    
    for i in range(SUB_TWO):
        rightArr[i] = arr[MID+ 1 + i]

    indexOfSubOne = 0
    indexOfSubTwo = 0
    indexOfMerge = LEFT
    while indexOfSubOne < SUB_ONE and indexOfSubTwo < SUB_TWO:
        if leftArr[indexOfSubOne] <= rightArr[indexOfSubTwo]:
            arr[indexOfMerge] = leftArr[indexOfSubOne]
            indexOfSubOne = indexOfSubOne + 1
        else:
            arr[indexOfMerge] = rightArr[indexOfSubTwo]
            indexOfSubTwo = indexOfSubTwo + 1
        indexOfMerge = indexOfMerge + 1

    while indexOfSubOne < SUB_ONE:
        arr[indexOfMerge] = leftArr[indexOfSubOne]
        indexOfSubOne = indexOfSubOne + 1
        indexOfMerge = indexOfMerge + 1

    while indexOfSubTwo < SUB_TWO:
        arr[indexOfMerge] = rightArr[indexOfSubTwo]
        indexOfSubTwo = indexOfSubTwo + 1
        indexOfMerge = indexOfMerge + 1
    
def merge_sort(arr, BEGIN, END):
    if BEGIN >= END:
        return
    mid = BEGIN + (END - BEGIN) / 2
    merge_sort(arr, BEGIN, mid)
    merge_sort(arr, mid + 1, END)
    merge(arr, BEGIN, mid, END)

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
    print(arr)
    # insertion_sort(arr, 5)
    # quick_sort(arr, 0, 4)
    # merge_sort(arr, 0, 4)
    bubble_sort(arr, 5)
    print(arr)

if __name__=="__main__":
    main()
    


