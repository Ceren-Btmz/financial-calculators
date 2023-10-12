package com.pluralsight;

import java.text.NumberFormat;
import java.util.Scanner;

public class Calculators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, User! We offer a variety of calculators including " +
                "a mortgage calculator, a future value calculator and a present value calculator.");
        System.out.println("What were you interested in using?");
        String calculator = scanner.nextLine();

        if (calculator.equalsIgnoreCase("Mortgage")) {
            System.out.println("Principal: ");
            double principal = scanner.nextDouble();

            System.out.println("Annual Interest Rate: ");
            double annualInterest = scanner.nextDouble();
            double monthlyInterest = annualInterest / 100 / 12;

            System.out.println("Period (Years): ");
            int years = scanner.nextInt();
            int numberOfPayments = years * 12;
            double mathMortgage = Math.pow(1 + monthlyInterest, numberOfPayments);

            double monthlyPayments = principal * (monthlyInterest * mathMortgage / (mathMortgage - 1));

            double totalInterest = (monthlyPayments * numberOfPayments) - principal;

            String monthlyPaymentFormatted = NumberFormat.getCurrencyInstance().format(monthlyPayments);

            System.out.println("Your monthly payment is: " + monthlyPaymentFormatted + " "
                    + "\nYour total interest is: " + totalInterest);

        }

        if (calculator.equalsIgnoreCase("Future Value")) {
            System.out.println("Deposit amount: $");
            double deposit = scanner.nextDouble();

            System.out.println("Annual Interest Rate: ");
            double annualInterest = scanner.nextDouble();
            double monthlyInterest = annualInterest / (100 * 12);

            System.out.println("Period (Years): ");
            int numberOfYears = scanner.nextInt();
            int years = numberOfYears * 12;

            double futureValue = deposit * Math.pow(1 + monthlyInterest, years);

            System.out.println("Your interest earned is: " + (futureValue - deposit));
            System.out.println("Your future value is: " + futureValue);

        }
    }
}
