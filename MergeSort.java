package mergesort;
public class MergeSort {
    void merge(int a[], int low, int mid, int high) {
        int b[] = new int[100];
        int h, i, j, k;
        h = low;
        i = low;
        j = mid + 1;
        while ((h <= mid) && (j <= high)) {
            if (a[h] <= a[j]) {
                b[i] = a[h];
                h = h + 1;
            }
            else {
                b[i] = a[j];
                j = j + 1;
            }
            i = i + 1;
        }
        if (h > mid)
            for (k = j; k <= high; k++) {
                b[i] = a[k];
                i = i + 1;
            }
        else
            for (k = h; k <= mid; k++) {
                b[i] = a[k];
                i = i + 1;
            }
        for (k = low; k <= high; k++)
            a[k] = b[k];
    }
    void mergesort(int a[], int low, int high) {
        int mid;
        if (low < high) {
            mid = (low + high) / 2;
            mergesort(a, low, mid);
            mergesort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }
    void display(int a[], int n) {
        int i;
        for (i = 0; i < n; i++)
            System.out.print(
                "\n Element[" + i + "] = " + a[i]
            );
    }
    public static void main(String args[]) throws Exception {
        MergeSort ms = new MergeSort();
        int[] Elements = {10, 100, 20, 34, 78, 3, 76, 1};
        int i, n;
        n = Elements.length;
        ms.mergesort(Elements, 0, n - 1);
        System.out.println(
            "\n " + n + " Elements after sorting are:"
        );
        ms.display(Elements, n);
    }
}
