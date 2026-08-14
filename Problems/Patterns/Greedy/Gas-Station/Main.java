public class Main {

    static int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, initialGas = 0, totalGas = 0, totalCost = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            initialGas += gas[i] - cost[i];

            if (initialGas < 0) {
                start = i + 1;
                initialGas = 0;
            }
        }

        return totalGas<totalCost? -1 : start;
    }

    public static void main(String[] args) {
        int[] gas = { 3, 1, 1 }, cost = { 1, 2, 2 };

        System.out.print(canCompleteCircuit(gas, cost));
    }
}
