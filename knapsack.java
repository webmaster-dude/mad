package knapsack;
public class Knapsack {
    void Knapsack(int capacity, int n, int profit[], int weight[], double x[])
    {
        int i;
        double totalProfit = 0.0;
        int remaining = capacity;
        for(i = 0; i < n; i++)
            x[i] = 0.0;
        for(i = 0; i < n; i++)
        {
            if(weight[i] <= remaining)
            {
                x[i] = 1.0;
                totalProfit += profit[i];
                remaining -= weight[i];
            }
            else
                break;
        }
        if(i < n)
        {
            x[i] = (double) remaining / weight[i];
            totalProfit += x[i] * profit[i];
        }
        System.out.println("Fractions of items taken:");
        for(i = 0; i < n; i++)
            System.out.println("Item[" + i + "] = " + x[i]);
        System.out.println("Maximum profit = " + totalProfit);
    }
    public static void main(String[] args)
    {
        int n = 7;
        int m = 15;
        int[] weight = {2, 3, 5, 7, 3, 4, 2};
        int[] profit = {20, 15, 20, 21, 6, 6, 2};
        double[] x = new double[n];
        Knapsack k = new Knapsack();
        k.Knapsack(m, n, profit, weight, x);
    }
}
