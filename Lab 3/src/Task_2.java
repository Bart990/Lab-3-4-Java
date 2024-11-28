import java.io.*;

class Flight {
    int number;
    String name;

    public Flight(int flightNumber, String flightName) {
        this.number = flightNumber;
        this.name = flightName;
    }

    public void saveToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Flight Number: " + number + "\n");
            writer.write("Flight Name: " + name + "\n");
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Flight flight = new Flight(123, "FlightName");
        flight.saveToFile("flight.txt");
        System.out.println("Объект сохранен в файл flight.txt");
    }
}
