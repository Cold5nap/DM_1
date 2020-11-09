import java.util.Arrays;

public class Finder {
    private int[] arr;

    public Finder(int[] arr) {
        this.arr = arr;
    }

    public int findIndex(int element) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" Index="+i);
            if (element == arr[i]) {
                System.out.println();
                System.out.println("Find index="+i);
                return i;
            }

        }
        System.out.println("Element not found!");
        return -1;
    }

    private int[] sortedArr() {
        int[] sortedArr = arr;
        Arrays.sort(sortedArr);
        return sortedArr;
    }

    public int binaryFindIndex(int elem) {
        System.out.println("Sorted arr: ");
        int[] sArr = sortedArr();
        int operationNumber=0;
        int left = 0; // задаем левую и правую границы поиска
        int right = arr.length - 1;
        int search = -1; // найденный индекс элемента равен -1 (элемент не найден)
        while (left <= right) // пока левая граница не "перескочит" правую
        {
            int mid = (left + right) / 2; // ищем середину отрезка
            if (elem == sArr[mid]) {  // если ключевое поле равно искомому
                search = mid;     // мы нашли требуемый элемент,
                break;            // выходим из цикла
            }
            if (elem < sArr[mid])     // если искомое ключевое поле меньше найденной середины
                right = mid - 1;  // смещаем правую границу, продолжим поиск в левой части
            else                  // иначе
                left = mid + 1;   // смещаем левую границу, продолжим поиск в правой части
        }
        if (search == -1) {
            System.out.println("Элемент не найден!\n");
        return -1;}
        else {
            return search;
        }
    }
}
