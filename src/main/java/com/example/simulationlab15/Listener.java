package main.java.com.example.simulationlab15;

import java.text.DecimalFormat;

import static java.lang.Thread.sleep;

public class Listener {

    public static void main(String[] args) throws InterruptedException {
        Weather weather = new Weather();
        printProbabilities(weather.getChState());

        while (true) {
            sleep(1000);
            weather.simulateWeather();
            printWeather(weather);
        }
    }

    private static void printProbabilities(double[] probabilities) {
        System.out.println("Вероятности: ");
        System.out.println("Пасмурно: " + probabilities[0] / 1000.0);
        System.out.println("Ясно: " + probabilities[1] / 1000.0);
        System.out.println("Облачно: " + probabilities[2] / 1000.0 + "\n");
    }

    private static void printWeather(Weather weather) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        System.out.println("\nДень: " + decimalFormat.format(weather.getDay()) + "\n" +
                "Погода: " + weather.getState() + "\n");
    }
}
