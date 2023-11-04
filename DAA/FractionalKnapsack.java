import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Item {
    int weight;
    int value;

    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class FractionalKnapsack {
    public static double fractionalKnapsack(int W, Item[] items) {
        Arrays.sort(items, Comparator.comparingDouble(item -> (double) item.value / item.weight));

        double totalValue = 0.0;
        int remainingCapacity = W;

        for (int i = items.length - 1; i >= 0; i--) {
            if (remainingCapacity <= 0) {
                break;
            }

            int currentWeight = Math.min(remainingCapacity, items[i].weight);
            totalValue += (double) currentWeight * items[i].value / items[i].weight;
            remainingCapacity -= currentWeight;
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        Item[] items = new Item[n];

        System.out.println("Enter the weight and value of each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Weight for item " + (i + 1) + ": ");
            int weight = scanner.nextInt();
            System.out.print("Value for item " + (i + 1) + ": ");
            int value = scanner.nextInt();
            items[i] = new Item(weight, value);
        }

        System.out.print("Enter the maximum weight (W) of the knapsack: ");
        int W = scanner.nextInt();

        double maxTotalValue = fractionalKnapsack(W, items);
        System.out.println("Maximum Total Value achieved with this knapsack: " + maxTotalValue);
    }
}
