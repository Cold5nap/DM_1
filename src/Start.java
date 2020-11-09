public class Start {
    public static void main(String[] args) {
        int[] arr = {1, 23, 4, 56, 7, 8, 9, -1, -59, 0, 34, -1};
        int[] badArr = badArrContain400Elem();
        Sort sort = new Sort();

        System.out.print("Неотсортированный массив из 12 эл.: ");
        printArr(arr);
        int[] insertionArr = sort.insertionSortArray(arr);
        System.out.print("Отсортированный массив из 12 эл.: ");
        printArr(insertionArr);
        System.out.println("Кол-во операций сравнений: "+sort.getCounter());

        System.out.print("Неотсортированный наихудший массив из 400 эл.: ");
        printArr(badArr);
        int[] badInsertionArr = sort.insertionSortArray(badArr);
        System.out.print("Отсортированный наихудший массив из 400 эл.: ");
        printArr(badInsertionArr);
        System.out.println("Кол-во операций сравнений: "+sort.getCounter());

        System.out.print("Неотсортированный массив из 12 эл.: ");
        printArr(arr);
        int[] binaryInsertionSortArray = sort.binaryInsertionSortArray(arr);
        System.out.print("Отсортированный массив из 12 эл.: ");
        printArr(binaryInsertionSortArray);
        System.out.println("Кол-во операций сравнений: "+sort.getCounter());

        System.out.print("Неотсортированный наихудший массив из 400 эл.: ");
        printArr(badArr);
        int[] badBinaryInsertionArr = sort.binaryInsertionSortArray(badArr);
        System.out.print("Отсортированный наихудший массив из 400 эл.: ");
        printArr(badBinaryInsertionArr);
        System.out.println("Кол-во операций сравнений: "+sort.getCounter());
    }

    private static void printArr(int[] arr) {
        System.out.println();
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    private static int[] badArrContain400Elem() {
        int[] arrBad = new int [400];
        int number =400;
        for (int i=0;i<arrBad.length;i++) {
            arrBad[i]=number;
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
