public class Sort {
    private int counter;

    public Sort() {
    }

    // Проходим по элементам массива смотрим,
    // больше ли они предыдущих, если надо, меняем элементы из сравниваемой пары
    // каждый раз.(левая часть сортируется)
    //Сравнивается с каждым предыдущим элементом.

    //Сортировка вставками хороша для маленьких массивов
    public int[] insertionSortArray(int[] array) {
        counter = 0;
        int[] arr = new int[array.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = array[i];
        }
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
        for (int i = 0; i < arr.length; i++) {
            arr[i] = array[i];
        }

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
    Автор приращения Р.Седжвик.
     */
    public int[] shellSort(int[] arr) {
        counter = 0;
        int[] a = newArray(arr);

        int inc, i, j, s, seq[] = new int[40];
        s = increment(seq, a.length);
        while (s >= 0) {
            inc = seq[s--];

            for (i = inc; i < a.length; i++) {
                int temp = a[i];
                for (j = i - inc; (j >= 0) && (a[j] > temp); j -= inc) {
                    a[j + inc] = a[j];
                    counter++;
                }
                a[j + inc] = temp;
            }
        }
        /*
        for (int step = a.length / 2; step > 0; step /= 2) {
            for (int i = step; i < a.length ; i++) {
                for (int j = i - step; j >= 0 && a[j] > a[j + step] ; j -= step) {
                    int x = a[j];
                    a[j] = a[j + step];
                    a[j + step] = x;
                    counter++;
                }
            }
        }

         */
        return a;
    }

    private int[] newArray(int[] array) {
        int[] arr = new int[array.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = array[i];
        }
        return arr;
    }

    public int getCounter() {
        return counter;
    }
}
