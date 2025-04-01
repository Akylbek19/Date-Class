public class Main {
    public static void main(String[] args) {

        Date today = new Date(15, 6, 2023);
        System.out.println("Today: " + today);


        Date invalidDate = null;
        try {
            invalidDate = new Date(31, 4, 2023);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating date: " + e.getMessage());
        }
        System.out.println("Invalid date test: " + (invalidDate == null ? "failed" : "unexpected"));


        today.updateDate(20, 6, 2023);
        System.out.println("Updated date: " + today);


        System.out.println("Day of week: " + today.getDayOfWeek());
    }
}