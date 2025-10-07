package ass64;

import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a month (name, abbreviation, or number): ");
        String monthInput = input.nextLine().trim();

        System.out.print("Enter a year: ");
        int year = input.nextInt();

        int month = getMonthNumber(monthInput);
        if (month == -1) {
            System.out.println("Invalid month input.");
            return;
        }

        int days = getDaysInMonth(month, year);
        System.out.println("There are " + days + " days in " + getMonthName(month) + " " + year + ".");

        input.close();
    }

    // Convert user input to month number (1–12)
    public static int getMonthNumber(String monthInput) {
        monthInput = monthInput.toLowerCase();

        switch (monthInput) {
            case "1": case "january": case "jan.": case "jan": return 1;
            case "2": case "february": case "feb.": case "feb": return 2;
            case "3": case "march": case "mar.": case "mar": return 3;
            case "4": case "april": case "apr.": case "apr": return 4;
            case "5": case "may": return 5;
            case "6": case "june": case "jun": return 6;
            case "7": case "july": case "jul": return 7;
            case "8": case "august": case "aug.": case "aug": return 8;
            case "9": case "september": case "sept.": case "sep": return 9;
            case "10": case "october": case "oct.": case "oct": return 10;
            case "11": case "november": case "nov.": case "nov": return 11;
            case "12": case "december": case "dec.": case "dec": return 12;
            default: return -1;
        }
    }

    // Get number of days in that month (consider leap years)
    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if (isLeapYear(year)) return 29;
                else return 28;
            default:
                return 0;
        }
    }

    // Check if a year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Convert month number back to full month name
    public static String getMonthName(int month) {
        String[] names = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return names[month - 1];
    }
}

