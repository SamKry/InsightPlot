public class App {
    public static void main(String[] args) throws Exception {
        // Sample sensor data
        double[][] allSensorData = { { 23.4, 25.1, 26.5, 28.2, 30.1, 31.5, 33.2, 34.9, 36.5, 38.2 },
                { 10.2, 12.1, 13.9, 16.2, 18.5, 20.3, 23.1, 26.4, 28.9, 31.2 },
                { 45.6, 42.3, 39.8, 36.7, 34.1, 30.9, 28.2, 25.5, 22.8, 19.6 },
                { 18.9, 22.3, 17.1, 23.8, 21.4, 27.6, 19.5, 25.1, 26.3, 13 },
                { 10.5, 8.7, 6.9, 4.8, 2.6, 0.1, -2.4, -4.9, -7.3, -9.8 },
                { 15.2, 12.8, 13.9, 11.2, 14.5, 10.3, 13.8, 15.1, 13.2, 16.4 },
                { 3.1, -1.9, 2.5, -0.8, 4.2, -2.7, 5.6, -3.2, 6.4, -2.1 },
                { 20, 25, 30, 35, 40, 45, 50, 55, 60, 50, 20, 0 } };

        for (double[] sensorData : allSensorData) {

            // Number of data points
            int n = sensorData.length;

            // Calculate the sum of time and sensor data
            double sumTime = 0;
            double sumData = 0;
            for (int i = 0; i < n; i++) {
                sumTime += i;
                sumData += sensorData[i];
            }

            // Calculate the mean of time and sensor data
            double meanTime = sumTime / n;
            double meanData = sumData / n;

            // Calculate the slope (rate of change)
            double numerator = 0;
            double denominator = 0;
            for (int i = 0; i < n; i++) {
                numerator += (i - meanTime) * (sensorData[i] - meanData);
                denominator += Math.pow(i - meanTime, 2);
            }
            double slope = numerator / denominator;
            double intercept = meanData - slope * meanTime;

            // Interpret the slope
            if (slope > 0) {
                System.out.println("The sensor data is rising over time.");
            } else if (slope < 0) {
                System.out.println("The sensor data is falling over time.");
            } else {
                System.out.println("The sensor data has no trend.");
            }

            // Display the rate of change
            System.out.println("Rate of change: " + slope);

            // for (int i = 0; i < n; i++) {
            // System.out.println(i + "," + sensorData[i] + "," + (slope * i + intercept));
            // }
        }
    }
}
