package com.company;

import java.rmi.UnexpectedException;
import java.util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random rand = new Random();


    public static void main(String[] args) {
        while(true) {
            System.out.println(
                    """
                            #0 EXIT
                            #1 Steve Jobs quote.
                            #2 Percent from number
                            #3 Combine digits
                            #4 Swap digits
                            #5 Time of the year
                            #6 Meters to ...
                            #7 Odd numbers
                            #8 Multiplication tables
                            #9 Array
                            #10 Array v2
                            #11 Line
                            #12 Sort
                            """);
            var choice = scanner.nextInt();
            if(choice == 0) return;
            switch (choice) {
                case 1 -> task1();
                case 2 -> task2();
                case 3 -> task3();
                case 4 -> task4();
                case 5 -> task5();
                case 6 -> task6();
                case 7 -> task7();
                case 8 -> task8();
                case 9 -> task9();
                case 10 -> task10();
                case 11 -> task11();
                case 12-> task12();
                default -> System.out.println("Wrong input");
            }
        }
    }

    private static void task1()
    {
        System.out.println(
                """
                        "Your time is limited, so
                        \tdon’t waste it
                        \t\t living someone else’s life"
                        \t\t\tSteve Jobs
                        """);

    }

    private static void task2()
    {
        System.out.print("Value: ");
        var value = scanner.nextDouble();
        System.out.print("Percentage: ");
        var percentage = scanner.nextDouble();
        System.out.println(value + " % " + percentage + " = " + value * percentage / 100);
    }

    private static void task3()
    {
        int result = 0;
        try {
            for (int i = 0; i < 3; i++) {
                boolean wrongInput;
                do {
                    String text;
                    switch (i) {
                        case 0 -> text = "First";
                        case 1 -> text = "Second";
                        case 2 -> text = "Third";
                        default-> throw new UnexpectedException("Unknown number");
                    }
                    System.out.print(text + " digit: ");
                    var digit = scanner.nextInt();

                    wrongInput = true;

                    if(digit < 0) System.out.print("Number must be >= 0");
                    else if(digit >= 10) System.out.print("Number must single digit");
                    else wrongInput = false;

                    result += digit * Math.pow(10, i);

                } while (wrongInput);
            }
        }
        catch (UnexpectedException exception)
        {
            System.out.println("Error occurred: " + exception);
            return;
        }
        System.out.println("Result: " + result);
    }

    private static void task4()
    {
        int input;
        while(true) {
            input = scanner.nextInt();
            if(input >= 100_000 && input <= 999_999)
            {
                break;
            }
            else
            {
                System.out.println("Length of number is not 6");
            }
        }
        var result = (input % 100 * 10_000) + ( input % 10_000 - input % 100) + input / 10000;
        System.out.println("Result: " + result);
    }

    private static void task5()
    {
        var input = scanner.nextInt();
        switch (input)
        {
            case 12,1,2 -> System.out.println("Winter");
            case 3,4,5 -> System.out.println("Spring");
            case 6,7,8 -> System.out.println("Summer");
            case 9,10,11 -> System.out.println("Autumn");
            default -> System.out.println("Wrong month");
        }
    }

    private static void task6()
    {
        System.out.print("Meters: ");
        var meters = scanner.nextFloat();
        System.out.print("""
                To:
                #1 miles
                #2 yards
                #3 inches
                """);
        var choice = scanner.nextInt();
        switch (choice)
        {
            case 1 -> System.out.println("Miles: " + (meters * 0.000621371));
            case 2 -> System.out.println("Yards: " + (meters * 1.09361));
            case 3 -> System.out.println("Inches: " + (meters * 39.3701));
            default -> System.out.println("Wrong input");
        }
    }

    private static void task7()
    {
        System.out.print("From: ");
        var from = scanner.nextInt();
        System.out.print("To: ");
        var to = scanner.nextInt();
        if(to < from)
        {
            var temp = to;
            to = from;
            from = temp;
        }
        from += from % 2 - 1;
        for (int i = from; i <= to; i+= 2) {
            System.out.println(i);
        }
    }

    private static void task8()
    {
        System.out.print("From: ");
        var from = scanner.nextInt();
        System.out.print("To: ");
        var to = scanner.nextInt();
        if(to < from)
        {
            var temp = to;
            to = from;
            from = temp;
        }

        for (int i = from; i <= to; i++) {
            System.out.println(i);
            for (int j = 0; j < 10; j++) {
                System.out.print(i + " * " + j + " = " + (i * j));
                System.out.print(", ");
            }
            System.out.println();
        }
    }

    private static int randomInRange(int from, int to) {
        return rand.nextInt(to - from + 1) + from;
    }

    private static void task9()
    {
        final int size = 100;
        final int minValue = -10;
        final int maxValue = 10;
        var arr = new int[size];

        arr[0] = randomInRange(minValue, maxValue);


        var max = arr[0];
        var min = arr[0];

        var negativeCount = 0;
        var positiveCount = 0;
        var zeroCount = 0;

        for (int i = 1; i < size; i++) {
            arr[i] = randomInRange(minValue, maxValue);
            if(arr[i] > max) max = arr[i];
            if(arr[i] < min) min = arr[i];
            if(arr[i] < 0) negativeCount++;
            if(arr[i] >= 0) positiveCount++;
            if(arr[i] == 0) zeroCount++;
        }
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Negative: " + negativeCount);
        System.out.println("Positive: " + positiveCount);
        System.out.println("Zero: " + zeroCount);
    }

    private static void task10()
    {
        final int size = 100;
        final int minValue = -10;
        final int maxValue = 10;
        var arr = new int[size];

        arr[0] = randomInRange(minValue, maxValue);


        var even = new LinkedList<Integer>();
        var odd = new LinkedList<Integer>();
        var negative = new LinkedList<Integer>();
        var positive = new LinkedList<Integer>();

        for (int i = 1; i < size; i++) {
            arr[i] = randomInRange(minValue, maxValue);
            if(arr[i] % 2 == 1) odd.add(arr[i]);
            if(arr[i] % 2 == 0) even.add(arr[i]);
            if(arr[i] < 0) negative.add(arr[i]);
            if(arr[i] >= 0) positive.add(arr[i]);
        }
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        System.out.println("Negative: " + negative);
        System.out.println("Positive: " + positive);
    }

    private static void task11()
    {
        System.out.print("Horizontal(h) or Vertical(v): ");
        var str = scanner.nextLine();
        if(Objects.equals(str, ""))
        {
            str = scanner.nextLine();
        }

        System.out.print("Length: ");
        var length = scanner.nextInt();

        System.out.print("Char: ");
        scanner.nextLine();
        var character = scanner.nextLine();
        if(Objects.equals(character, ""))
        {
            character = scanner.nextLine();
        }
        line(Objects.equals(str, "h"), length, character.charAt(0));
    }

    private static void line(boolean horizontal, int length, char character)
    {
        for (int i = 0; i < length; i++) {
            if(horizontal) System.out.print(character);
            if(!horizontal || i == length - 1) System.out.println(character);
        }
    }

    private static void task12()
    {
        System.out.print("Increasing (i) or decreasing (d)");
        var direction = scanner.nextLine();
        if(Objects.equals(direction, ""))
        {
            direction = scanner.nextLine();
        }
        final int size = 100;
        final int minValue = -10;
        final int maxValue = 10;
        var arr = new Integer[size];

        for (int i = 0; i < size; i++) {
            arr[i] = randomInRange(minValue, maxValue);
        }

        Comparator<Integer> comparator;

        if(Objects.equals(direction, "i")) comparator = Comparator.naturalOrder();
        else comparator = Comparator.reverseOrder();
        Arrays.sort(arr, comparator);
        System.out.println(Arrays.toString(arr));
    }
}
