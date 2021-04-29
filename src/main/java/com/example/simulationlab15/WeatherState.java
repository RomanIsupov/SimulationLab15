package main.java.com.example.simulationlab15;

public enum WeatherState {
    Sunny(0),
    Foggy(1),
    Rainy(2);

    private final int number;

    private WeatherState(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static WeatherState fromInteger(int x) {
        return switch (x) {
            case 0 -> Sunny;
            case 1 -> Foggy;
            case 2 -> Rainy;
            default -> null;
        };
    }
}
