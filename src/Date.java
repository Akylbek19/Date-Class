public class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new IllegalArgumentException("Invalid date: " + day + "/" + month + "/" + year);
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean isValidDate(int day, int month, int year) {
        if (year < 1 || month < 1 || month > 12 || day < 1) {
            return false;
        }

        int maxDays = switch (month) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear(year) ? 29 : 28;
            default -> 31;
        };

        return day <= maxDays;
    }

    private boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
    }

    public void updateDate(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new IllegalArgumentException("Invalid date for update: " + day + "/" + month + "/" + year);
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getDayOfWeek() {
        int m = month;
        int y = year;
        if (m < 3) {
            m += 12;
            y--;
        }
        int h = (day + (13*(m + 1))/5 + y + y/4 - y/100 + y/400) % 7;
        String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        return days[h];
    }

    public int calculateDifference(Date other) {
        if (other == null) {
            throw new IllegalArgumentException("Other date cannot be null");
        }
        return Math.abs(this.toDays() - other.toDays());
    }

    private int toDays() {
        int totalDays = day;
        for (int m = 1; m < month; m++) {
            totalDays += getDaysInMonth(m, year);
        }
        for (int y = 1; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }
        return totalDays;
    }

    private int getDaysInMonth(int month, int year) {
        return switch (month) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear(year) ? 29 : 28;
            default -> 31;
        };
    }

    public void printDate() {
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        System.out.println(monthNames[month - 1] + " " + day + ", " + year);
    }

    @Override
    public int compareTo(Date other) {
        if (this.year != other.year) {
            return Integer.compare(this.year, other.year);
        }
        if (this.month != other.month) {
            return Integer.compare(this.month, other.month);
        }
        return Integer.compare(this.day, other.day);
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }
}