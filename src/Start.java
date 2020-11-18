import java.io.PrintStream;

public class Start {
    private static final PrintStream so = System.out;

    public static void main(String[] args) {
        int[] arr = {1, 23, 4, 56, 7, 8, 9, -1, -59, 0, 34, -1};
        int[] badArr = badArrContain12Elem();
        int[] goodArr = goodArrContain12Elem();

        Sort sort = new Sort();

        int[] bubbleSort = sort.bubbleSort(arr);
        System.out.print("Неотсортированный массив из 12 эл.: ");
        printArr(arr);
        System.out.print("Отсортированный массив из 12 эл.: ");
        printArr(bubbleSort);
        System.out.println("Кол-во операций сравнений: " + sort.getCounter()+"\n");

        System.out.print("Неотсортированный наихудший вариант из 12 эл.: ");
        printArr(badArr);
        int[] badBubbleSort = sort.bubbleSort(badArr);
        System.out.print("Отсортированный наихудший вариант из 12 эл.: ");
        printArr(badBubbleSort);
        System.out.println("Кол-во операций сравнений: " + sort.getCounter()+"\n");

        System.out.print("Неотсортированный наилудший вариант из 12 эл.: ");
        printArr(goodArr);
        int[] goodBubbleSort = sort.bubbleSort(goodArr);
        System.out.print("Отсортированный наилудший вариант из 12 эл.: ");
        printArr(goodBubbleSort);
        System.out.println("Кол-во операций сравнений: " + sort.getCounter()+"\n");

        so.println("\n"+"---------------Сортировка Шелла---------------"+"\n");

        int[] shellSort = sort.shellSort(arr);
        System.out.print("Неотсортированный массив из 12 эл.: ");
        printArr(arr);
        System.out.print("Отсортированный массив из 12 эл.: ");
        printArr(shellSort);
        System.out.println("Кол-во операций сравнений: " + sort.getCounter()+"\n");

        System.out.print("Неотсортированный наихудший вариант из 12 эл.: ");
        printArr(badArr);
        int[] badShellSort = sort.insertionSortArray(badArr);
        System.out.print("Отсортированный наихудший вариант из 12 эл.: ");
        printArr(badShellSort);
        System.out.println("Кол-во операций сравнений: " + sort.getCounter()+"\n");

        System.out.print("Неотсортированный наилудший вариант из 12 эл.: ");
        printArr(goodArr);
        int[] goodShellSort = sort.shellSort(goodArr);
        System.out.print("Отсортированный наилудший вариант из 12 эл.: ");
        printArr(goodShellSort);
        System.out.println("Кол-во операций сравнений: " + sort.getCounter()+"\n");


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

    private static void printArr(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static int[] goodArrContain12Elem() {
        int[] arrBad = new int[12];
        for (int i = 1; i < arrBad.length; i++) {
            arrBad[i] = i;
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
