public class FinancialForecasting {

    // Method to calculate growth rate based on past data
    public static double calculateGrowthRate(double[] pastData) {
        double totalGrowthRate = 0.0;
        int n = pastData.length;

        for (int i = 1; i < n; i++) {
            totalGrowthRate += (pastData[i] - pastData[i - 1]) / pastData[i - 1];
        }

        return totalGrowthRate / (n - 1);
    }

    // Recursive method to predict the future value
    public static double predictFutureValue(double currentValue, double growthRate, int periods) {
        if (periods == 0) {
            return currentValue;
        }
        double nextValue = currentValue * (1 + growthRate);
        return predictFutureValue(nextValue, growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double[] pastData = {100, 110, 121, 133.1};
        double growthRate = calculateGrowthRate(pastData);

        int periods = 5;  // Number of future periods to predict
        double currentValue = pastData[pastData.length - 1];  // Last known value

        double futureValue = predictFutureValue(currentValue, growthRate, periods);
        System.out.println("Predicted future value: " + futureValue);
    }
}
