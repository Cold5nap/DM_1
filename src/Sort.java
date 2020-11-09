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
        for (int i=0;i< arr.length;i++) {
            arr[i] = array[i];
        }
        if (arr.length == 1) return arr;

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
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
        for (int i=0;i< arr.length;i++) {
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
            for (int j = i; j > mid ; j--) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }

        }
        return arr;
    }

    public int getCounter() {
        return counter;
    }
}
