public class Main {
    public static void main(String[] args) {
        // 1. Создание и использование даты
        Date today = new Date(15, 6, 2023);
        System.out.println("Today: " + today);

        // 2. Использование переменной invalidDate
        Date invalidDate = null;
        try {
            invalidDate = new Date(31, 4, 2023);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating date: " + e.getMessage());
        }
        System.out.println("Invalid date test: " + (invalidDate == null ? "failed" : "unexpected"));

        // 3. Использование updateDate()
        today.updateDate(20, 6, 2023);
        System.out.println("Updated date: " + today);

        // 4. Демонстрация других методов
        System.out.println("Day of week: " + today.getDayOfWeek());
    }
}