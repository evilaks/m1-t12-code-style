import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double result = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(result, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double Scale = Math.pow(10, places); // переменную Scale лучше переименовать в scale
        return Math.round(value * Scale) / Scale;
    }

    void calculateDeposit() { // имена переменных и методов указаны просто и понятно, замечаний нет
        int period;
        int userChoice;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        userChoice = scanner.nextInt();
        double result = 0;
        if (userChoice == 1) {
            result = calculateSimplePercent(amount, 0.06, period);
        } else if (userChoice == 2) {
            result = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }
}
