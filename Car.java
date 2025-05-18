package name;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Car {
    private static int totalCars = 0;
    public static final int MAX_SPEED = 300;

    private final String brand;
    private final String model;
    private final Engine engine;

    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.engine = new Engine(horsePower);
        totalCars++;
    }

    public void printInfo() {
        System.out.println("Марка: " + brand);
        System.out.println("Модель: " + model);
        System.out.println("Мощность двигателя: " + engine.Power() + " л.с.");
    }

    public static int getTotalCars() {
        return totalCars;
    }
        public record Engine(int Power) {
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите марку автомобиля: ");
            String brand = scanner.nextLine();

            System.out.print("Введите модель автомобиля: ");
            String model = scanner.nextLine();

            System.out.print("Введите мощность двигателя: ");
            int power = scanner.nextInt();

            if (power <= 0) {
                throw new IllegalArgumentException("Мощность двигателя не может быть отрицательна");
            }

            Car car = new Car(brand, model, power);
            System.out.println("\nИнформация о созданном автомобиле:");
            car.printInfo();

            System.out.println("\nМаксимальная скорость: " + Car.MAX_SPEED + " км/ч");
            System.out.println("Всего создано машин: " + Car.getTotalCars());

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: введите корректное число для мощности");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            System.out.println("Завершено");
        }
    }
}