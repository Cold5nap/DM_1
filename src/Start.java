import java.io.PrintStream;

public class Start {
    private static final PrintStream so = System.out;

    public static void main(String[] args) {
        int[] randArr = {1, 23, 4, 56, 7, 8, 9, -1, -59, 0, 34, -1};
        int[] goodArrForQuick = {4, 1, 3, 2, 6, 5};
        int[] goodArrMerge = {18, 19, 20, 21, 22, 23, 24, 25, 10, 11, 12, 13, 14, 15, 16, 17};
        int[] badArrMerge = {10, 12, 14, 16, 18, 20, 22, 24, 11, 13, 15, 17, 19, 21, 23, 25};
        int[] badArrForQuick = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 2, 5, 1, 6, 3, 7, 0, 8, 4, 9};
        int[] arrVikipedia = {3, 7, 8, 5, 2, 1, 9, 5, 4};
        int[] badArr = badArrContain12Elem();
        int[] goodArr = goodArrContain12Elem();

        Sort sort = new Sort();

        so.println("_______________БЫСТРАЯ СОРТИРОВКА__________________");

        so.println("Лучший случай(в массиве правый и левый подмассивы при каждом делении равны) O(n log2 n):");
        so.print("Исходный:");
        printArr(randArr);
        so.print("Отсортированный:");
        printArr(sort.quickSort(randArr));
        so.println("Кол-во сравнений: " + sort.getCounter());
        so.println();

        so.println("Средний случай(случайный массив) O(n log n):");
        so.print("Исходный:");
        printArr(randArr);
        so.print("Отсортированный:");
        printArr(sort.quickSort(randArr));
        so.println("Кол-во сравнений: " + sort.getCounter());
        so.println();

        so.println("Худший случай(элементы упорядочены, тогда подмассивы будет n-1) O(n^2):");
        so.print("Исходный:");
        printArr(badArr);
        so.print("Отсортированный:");
        printArr(sort.quickSort(badArr));
        so.println("Кол-во сравнений: " + sort.getCounter());

        so.println("____________Сортировка слиянием_____________");
        so.println("Сложность всех алгоритмов O(n log n)");
        so.println();

        so.println("Лучший случай");
        so.print("Исходный:");
        printArr(goodArrMerge);
        so.print("Отсортированный:");
        printArr(sort.mergeSort(goodArrMerge));
        so.println("Кол-во сравнений: " + sort.getCounter());
        so.println();

        so.println("Средний случай");
        so.print("Исходный:");
        printArr(randArr);
        so.print("Отсортированный:");
        printArr(sort.mergeSort(randArr));
        so.println("Кол-во сравнений: " + sort.getCounter());
        so.println();

        so.println("Худший случай");
        so.print("Исходный:");
        printArr(badArr);
        so.print("Отсортированный:");
        printArr(sort.mergeSort(badArr));
        so.println("Кол-во сравнений: " + sort.getCounter());
    }

    private static void shell(int[] arr, int[] badArr, int[] goodArr) {
        Sort sort = new Sort();
        int[] bubbleSort = sort.bubbleSort(arr);
        System.out.print("Неотсортированный массив из 12 эл.: ");
        printArr(arr);
        System.out.print("Отсортированный массив из 12 эл.: ");
        printArr(bubbleSort);
        System.out.println("Кол-во операций сравнений: " + sort.getCounter() + "\n");

        System.out.print("Неотсортированный наихудший вариант из 12 эл.: ");
        printArr(badArr);
        int[] badBubbleSort = sort.bubbleSort(badArr);
        System.out.print("Отсортированный наихудший вариант из 12 эл.: ");
        printArr(badBubbleSort);
        System.out.println("Кол-во операций сравнений: " + sort.getCounter() + "\n");

        System.out.print("Неотсортированный наилудший вариант из 12 эл.: ");
        printArr(goodArr);
        int[] goodBubbleSort = sort.bubbleSort(goodArr);
        System.out.print("Отсортированный наилудший вариант из 12 эл.: ");
        printArr(goodBubbleSort);
        System.out.println("Кол-во операций сравнений: " + sort.getCounter() + "\n");

        so.println("\n" + "---------------Сортировка Шелла---------------" + "\n");

        int[] shellSort = sort.hellsort(arr);
        System.out.print("Неотсортированный массив из 12 эл.: ");
        printArr(arr);
        System.out.print("Отсортированный массив из 12 эл.: ");
        printArr(shellSort);
        System.out.println("Кол-во операций сравнений: " + sort.getCounter() + "\n");

        System.out.print("Неотсортированный наихудший вариант из 12 эл.: ");
        printArr(badArr);
        int[] badShellSort = sort.hellsort(badArr);
        System.out.print("Отсортированный наихудший вариант из 12 эл.: ");
        printArr(badShellSort);
        System.out.println("Кол-во операций сравнений: " + sort.getCounter() + "\n");

        System.out.print("Неотсортированный наилудший вариант из 12 эл.: ");
        printArr(goodArr);
        int[] goodShellSort = sort.hellsort(goodArr);
        System.out.print("Отсортированный наилудший вариант из 12 эл.: ");
        printArr(goodShellSort);
        System.out.println("Кол-во операций сравнений: " + sort.getCounter() + "\n");

    }

    private static void insertion(int[] arr, int[] badArr) {
        Sort sort = new Sort();
        System.out.print("Неотсортированный массив из 12 эл.: ");
        printArr(arr);
        int[] insertionArr = sort.insertionSortArray(arr);
        System.out.print("Отсортированный массив из 12 эл.: ");
        printArr(insertionArr);
        System.out.println("Кол-во операций сравнений: " + sort.getCounter());

        System.out.print("Неотсортированный наихудший массив из 400 эл.: ");
        printArr(badArr);
        int[] badInsertionArr = sort.insertionSortArray(badArr);
        System.out.print("Отсортированный наихудший массив из 400 эл.: ");
        printArr(badInsertionArr);
        System.out.println("Кол-во операций сравнений: " + sort.getCounter());

        System.out.print("Неотсортированный массив из 12 эл.: ");
        printArr(arr);
        int[] binaryInsertionSortArray = sort.binaryInsertionSortArray(arr);
        System.out.print("Отсортированный массив из 12 эл.: ");
        printArr(binaryInsertionSortArray);
        System.out.println("Кол-во операций сравнений: " + sort.getCounter());

        System.out.print("Неотсортированный наихудший массив из 400 эл.: ");
        printArr(badArr);
        int[] badBinaryInsertionArr = sort.binaryInsertionSortArray(badArr);
        System.out.print("Отсортированный наихудший массив из 400 эл.: ");
        printArr(badBinaryInsertionArr);
        System.out.println("Кол-во операций сравнений: " + sort.getCounter());
    }

    public static void printArr(int[] arr) {
        System.out.println();
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    private static int[] goodArrContain12Elem() {
        int[] arrBad = new int[12];
        for (int i = 1; i < arrBad.length + 1; i++) {
            arrBad[i - 1] = i;
        }
        return arrBad;
    }

    private static int[] badArrContain12Elem() {
        int[] arrBad = new int[12];
        int number = 12;
        for (int i = 0; i < arrBad.length; i++) {
            arrBad[i] = number;
            number--;
        }
        return arrBad;
    }

    /*
    private void binaryFind() {
        //12 length

        int[] arr = {1, 23, 4, 56, 7, 8, 9, -1, -59, 0, 34, -1};


        System.out.println("Binary search: Element = "+56);
        Finder finder = new Finder(arr);
        System.out.println("Binary search:");
        finder.binaryFindIndex(56);
        System.out.println("Linear search: Element = "+56);
        finder.findIndex(56);
        System.out.println();

        System.out.println("Binary search: Element = "+-1);
        System.out.println("Binary search:");
        finder.binaryFindIndex(-1);
        System.out.println("Linear search: Element = "+-1);
        finder.findIndex(-1);
        System.out.println();

        System.out.println("Binary search: Element = "+999);
        System.out.println("Binary search:");
        finder.binaryFindIndex(999);
        System.out.println("Linear search: Element = "+999);
        finder.findIndex(999);
        System.out.println();

        System.out.println("Binary search: Element = "+999);
        Finder badEvent= new Finder(arrBad);
        System.out.println("Binary search:");
        badEvent.binaryFindIndex(999);
        System.out.println("Linear search: Element = "+999);
        badEvent.findIndex(999);
        System.out.println();

        System.out.println("Binary search: Element = "+18);
        badEvent.binaryFindIndex(18);
        System.out.println();
        System.out.println("Linear search: Element = "+18);
        badEvent.findIndex(18);
        System.out.println();

        System.out.println("Binary search: Element = "+-1);
        badEvent.binaryFindIndex(-1);
        System.out.println();
        System.out.println("Linear search: Element = "+-1);
        badEvent.findIndex(-1);
        System.out.println();
    }

         */
}
