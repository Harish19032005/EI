package app;


import java.util.Scanner;

public class PositiveInput {
public int readPositiveInt(Scanner sc, String message) {
    int value;
    do {
        System.out.print(message);
        value = sc.nextInt();
    } while (value <= 0);
    return value;
}
public int readPositiveIntWithZero(Scanner sc, String message) {
    int value;
    do {
        System.out.print(message);
        value = sc.nextInt();
    } while (value < 0);
    return value;
}
}
