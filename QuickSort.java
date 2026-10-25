package quicksort;
public class QuickSort {
    int Partition(int a[], int m, int p) {
        int v, i, j;
        i = m;
        j = p;
        v = a[m];
        do {
            do {
                i++;
            }
            while (i < p && a[i] < v);
            do {
                j--;
            }
            while (j >= m && a[j] > v);
            if (i < j) {
                int temp;
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        while (i < j);
        a[m] = a[j];
        a[j] = v;
        return j;
    }
    void quicksort(int a[], int low, int high) {
        int j;
        if (low < high) {
            j = Partition(a, low, high + 1);
            System.out.println(
                "Partitioning element Position is: " + j
            );
            System.out.println(
                "\nLeft Recursive Call - values of : low = "
                + low + " high = " + (j - 1)
            );
            quicksort(a, low, j - 1);
            System.out.println(
                "\nRight Recursive Call - values of : mid = "
                + (j + 1) + " high = " + high
            );
            quicksort(a, j + 1, high);
        }
    }
    void display(int a[], int n) {
        int i;
        for (i = 0; i < n; i++)
            System.out.print(
                "\t Element[" + i + "] = " + a[i]
            );
    }
    public static void main(String args[]) throws Exception {
        QuickSort qs = new QuickSort();
        int[] Elements = {10, 100, 20, 34, 78, 3, 76, 1};
        int i, n;
        n = Elements.length;
        System.out.println(
            "\n Elements before sorting are:"
        );
        qs.display(Elements, n);
        qs.quicksort(Elements, 0, n - 1);
        System.out.println(
            "\n " + n + " Elements after sorting are:"
        );
        qs.display(Elements, n);
    }
}
