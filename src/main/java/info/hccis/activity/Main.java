package info.hccis.activity;

import info.hccis.entity.Lesson;

import java.util.Scanner;

public class Main {
    private static double totalSoFar = 0;

    public static final String MENU = """

            Main Menu
            1 – Add a Lesson
            2 – Show total since program start
            0 – Exit""";

    public static void main(String[] args) {

        //Display welcome message to the user
        Lesson.showWelcomeMessage();

        String option;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println(MENU);
            option = input.nextLine();
            switch (option) {
                case "1" -> addLesson();
                case "2" -> showTotalOfAll();
                case "0" -> System.out.println("Goodbye");
                default -> System.out.println("Invalid option");
            }
        } while (!option.equalsIgnoreCase("0"));

    }

    /**
     * Allow the user to add a new lesson.
     *
     * @author NS
     * @since 20221205
     */
    public static void addLesson() {
        Lesson lesson = new Lesson();
        lesson.getInformation();
        lesson.getTotal();
        lesson.display();
        totalSoFar += lesson.getTotal();
    }

    public static void showTotalOfAll() {
        System.out.println("Total so far: $" + totalSoFar);
    }
}


