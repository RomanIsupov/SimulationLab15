package main.java.com.example.simulationlab15;

import java.util.concurrent.ThreadLocalRandom;

public class Weather {
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();
    private static final String[] states = new String[] {"Ясно", "Облачно", "Пасмурно"};
    private final double[][] transitionsMatrix = new double[][]{
            {-0.4, 0.3, 0.1},
            {0.4, -0.8, 0.4},
            {0.1, 0.4, -0.5}
    };
    private final double[] chState = new double[] {0.0, 0.0, 0.0};
    private double day = 0.0;
    private int currentStateNumber = 0;

    {
        for (int i = 0; i < 1000; i++) {
            double ch = random.nextDouble();
            for (int j = 0; j < 3; j++) {
                if (j != currentStateNumber) {
                    ch -= transitionsMatrix[currentStateNumber][j] / transitionsMatrix[currentStateNumber][currentStateNumber];
                }
                if (ch >= 1.0) {
                    currentStateNumber = j;
                    break;
                }
            }
            chState[currentStateNumber]++;
        }
    }

    public void simulateWeather() {
        double time = 0.0;
        double ch = random.nextDouble();
        for (int i = 0; i < 3; i++) {
            if (i != currentStateNumber) {
                ch -= transitionsMatrix[currentStateNumber][i] / transitionsMatrix[currentStateNumber][currentStateNumber];
            }
            if (ch >= 1) {
                currentStateNumber = i;
                time = random.nextDouble() / (-transitionsMatrix[currentStateNumber][currentStateNumber]);
                break;
            }
        }
        day += time;
    }

    public String getState() {
        return states[currentStateNumber];
    }

    public double getDay() {
        return day;
    }

    public double[] getChState() {
        return chState;
    }
}
