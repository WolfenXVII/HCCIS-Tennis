package info.hccis.entity;

import info.hccis.util.CisUtility;

import java.util.Scanner;

public class Lesson {

    public static final String PROMPT_NUMBER_IN_GROUP = "How many are in the group (1,2,3,4)";
    public static final String PROMPT_MEMBER = "Are you a member (Y/N)?";
    public static final String PROMPT_NUMBER_HOURS = "How many hours do you want for your lesson?";
    public static final String WELCOME = "Welcome to the CIS Tennis Program";

    private int rate;
    private String member;
    private int groupSize;
    private int numberOfHours;
    private double cost;
    private boolean isMember;

    public static void showWelcomeMessage() {
        CisUtility.display(WELCOME);

    }

    public void getInformation() {
        groupSize = CisUtility.getInputInt(PROMPT_NUMBER_IN_GROUP);
        boolean validGroupSize = (groupSize >= 1 && groupSize <= 4);
        while (!validGroupSize) {
            CisUtility.display("Invalid group size");
            groupSize = CisUtility.getInputInt(PROMPT_NUMBER_IN_GROUP);
            validGroupSize = (groupSize >= 1 && groupSize <= 4);
        }

        member = CisUtility.getInputString(PROMPT_MEMBER);
        boolean isMember;
        isMember = member.equalsIgnoreCase("Y");

        numberOfHours = CisUtility.getInputInt(PROMPT_NUMBER_HOURS);
        boolean validHours = (numberOfHours >= 1 && numberOfHours <= 5);
        while (!validHours) {
            CisUtility.display("Invalid number of hours. Please enter a number between 1 and 5");
            numberOfHours = CisUtility.getInputInt(PROMPT_NUMBER_HOURS);
            validHours = (numberOfHours >= 1 && numberOfHours <= 5);
        }


    }


    public double getTotal() {
        if (isMember) {
            switch (groupSize) {
                case 1 -> rate = 55;
                case 2 -> rate = 30;
                case 3 -> rate = 21;
                default -> rate = 16;
            }
        }else {
            switch (groupSize) {
                case 1 -> rate = 60;
                case 2 -> rate = 33;
                case 3 -> rate = 23;
                case 4 -> rate = 18;
            }
    }

    cost =rate *numberOfHours;
        return cost;
}


    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void display() {
        System.out.println(toString());
    }


    public String toString() {
        return "Lesson details - \nGroup size: " + groupSize + " \nMember: " + member + " \nRate: $" + rate + "/hour \nCost: $" + cost;
    }

}
