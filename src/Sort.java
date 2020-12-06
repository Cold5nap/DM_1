import java.util.Arrays;

public class Sort {
    private int counter;
    private int[] arr;

    public Sort() {
    }

    // Проходим по элементам массива смотрим,
    // больше ли они предыдущих, если надо, меняем элементы из сравниваемой пары
    // каждый раз.(левая часть сортируется)
    //Сравнивается с каждым предыдущим элементом.

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //Сортировка вставками хороша для маленьких массивов
    public int[] insertionSortArray(int[] array) {
        counter = 0;
        int[] arr = new int[array.length];
        System.arraycopy(array, 0, arr, 0, arr.length);
        if (arr.length == 1) return arr;

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                counter++;
            }

        }
        return arr;
    }

    //подходит лучше для большого кол-ва элементов в массиве
    public int[] binaryInsertionSortArray(int[] array) {
        if (array.length == 1) return array;
        counter = 0;
        int[] arr = new int[array.length];
        System.arraycopy(array, 0, arr, 0, arr.length);

        for (int i = 1; i < arr.length; i++) {
            int left = 0;
            int right = i;
            int mid = (left + right) / 2;
            while (left <= right) // пока левая граница не "перескочит" правую
            {
                mid = (left + right) / 2; // ищем середину отрезка
                if (arr[i] < arr[mid])     // если искомое ключевое поле меньше найденной середины
                    right = mid - 1;  // смещаем правую границу, продолжим поиск в левой части
                else                  // иначе
                    left = mid + 1;   // смещаем левую границу, продолжим поиск в правой части
                counter++;
            }
            //сдвигаем
            for (int j = i; j > mid; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }

        }
        return arr;
    }

    // меняет элементы из пары проходя по все за цикл
//Этот способ упорядочивает весьма шустро,
// O(n2) – его наихудшая сложность.
// В среднем по времени имеем O(n log n),
// а лучшая даже, не поверите, O(n).
    public int[] bubbleSort(int[] arr) {
        counter = 0;
        int[] a = newArray(arr);
        boolean isReplacement;

        while (true) {
            isReplacement = false;

            for (int i = 1; i < a.length; i++) {
                counter++;
                if (a[i] < a[i - 1]) {
                    isReplacement = true;
                    int temp = a[i - 1];
                    a[i - 1] = a[i];
                    a[i] = temp;

                }
            }
            if (!isReplacement) {
                return a;
            }
        }
    }

    private int increment(int[] inc, int size) {
        int p1, p2, p3, s;

        p1 = p2 = p3 = 1;
        s = -1;

        do {
            if (++s % 2 != 0) {
                inc[s] = 8 * p1 - 6 * p2 + 1;
            } else {
                inc[s] = 9 * p1 - 9 * p3 + 1;
                p2 *= 2;
                p3 *= 2;
            }
            p1 *= 2;
        } while (3 * inc[s] < size);

        return s > 0 ? --s : 0;
    }

    /*
    приращение - расстояние между сортируемыми элементами, в зависимости от прохода.
    В конце приращение всегда равно единице - метод завершается обычной сортировкой вставками,
    но именно последовательность приращений определяет рост эффективности.

    При использовании таких приращений среднее количество операций: O(n^7/6),
    в худшем случае - порядка O(n^4/3).
    луд - O(n log2 n)
    Автор приращения Р.Седжвик.
     */
    public int[] shellSort(int[] arr) {
        counter = 0;
        int[] a = newArray(arr);

        int inc;
        int i;
        int j;
        int s;
        int[] seq = new int[40];
        s = increment(seq, a.length);
        while (s >= 0) {
            inc = seq[s--];

            for (i = inc; i < a.length; i++) {
                int temp = a[i];
                counter++;
                for (j = i - inc; (j >= 0) && (a[j] > temp); j -= inc) {
                    a[j + inc] = a[j];
                    if (j == i - inc) counter--;
                    counter++;
                }
                a[j + inc] = temp;
            }
        }



        /*int counter1 = 0;
        for (int step = a.length / 2; step > 0; step /= 2) {
            for (int i = step; i < a.length ; i++) {
            counter1++;
                for (int j = i - step; j >= 0 && a[j] > a[j + step] ; j -= step) {
                    if (j==i-step)counter1--;
                    int x = a[j];
                    a[j] = a[j + step];
                    a[j + step] = x;
                    counter1++;
                }
            }
        }
        counter=counter1;
*/

        return a;
    }

    public int[] hellsort(int[] array1) {
        counter = 0;
        int[] array = newArray(array1);
        int h = 1;
        while (h * 3 < array.length)
            h = h * 3 + 1;

        while (h >= 1) {
            hSort(array, h);
            h = h / 3;
        }
        return array;
    }

    private void hSort(int[] array, int h) {
        int length = array.length;
        for (int i = h; i < length; i++) {
            for (int j = i; j >= h; j = j - h) {
                counter++;
                if (array[j] < array[j - h])
                    swap(array, j, j - h);
                else
                    break;
            }
        }
    }

    public void swap(int i, int j) {
        //if (i <= arr.length && j >= 0) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        //}
    }

    public int[] quickSort(int[] array) {
        counter = 0;
        arr = newArray(array);

            recursionQuickSort2(0, arr.length - 1);
        return arr;
    }

    private void recursionQuickSort2(int start, int end) {
        int right = end, left = start;
        int pivot = arr[left];//опорный element

        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
                counter += 1;
            }
            while (arr[right] > pivot) {
                right--;
                counter += 1;
            }

            if (left <= right) {
                //counter += 1;
                swap(left++, right--);
            }
        }

        if (start < right)
            recursionQuickSort2(start, right);
        if (end > left)
            recursionQuickSort2(left, end);
    }


    public int[] mergeSort(int[] array) {
        counter = 0;
        int[] a = new int[array.length];
        System.arraycopy(array, 0, a, 0, array.length);
        mergeSort(a, 0, a.length-1);

        return a;
    }


    private void mergeSort(int[] a, int lo, int hi) {

        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid + 1, hi);

        int[] buf = Arrays.copyOf(a, a.length);
        if (hi + 1 - lo >= 0)
            System.arraycopy(a, lo, buf, lo, hi + 1 - lo);

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            counter++;
            if (i > mid) {
                a[k] = buf[j];
                j++;
            } else if (j > hi) {
                a[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                a[k] = buf[j];
                j++;
            } else {
                a[k] = buf[i];
                i++;
            }
        }
    }



    private int[] newArray(int[] array) {
        int[] arr = new int[array.length];
        System.arraycopy(array, 0, arr, 0, arr.length);
        return arr;
    }

    public int getCounter() {
        return counter;
    }
}
