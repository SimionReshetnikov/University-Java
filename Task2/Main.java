public class Main
{
    public static void main(String[] args)
    {
        Date date = new Date(11, 10, 2023);
        System.out.println("Дата: " + date);
        System.out.println("Високосный год: " + date.isLeapYear());
        System.out.println("Timestamp: " + date.convertToTimestamp());
        System.out.println("Форматированная дата (dd-MM-yyyy): " + date.format("dd-MM-yyyy"));
        System.out.println("Форматированная дата (yyyy.MM.dd): " + date.format("yyyy.MM.dd"));

        // Создаем объект TimeDate
        TimeDate timeDate = new TimeDate(11, 10, 2023, 14, 30, 45);
        System.out.println("\nДата и время: " + timeDate);
        System.out.println("Timestamp: " + timeDate.convertToTimestamp());
        System.out.println("Форматированная дата и время (dd/MM/yyyy HH:mm:ss): " + timeDate.format("dd/MM/yyyy HH:mm:ss"));

        // Модификация времени
        timeDate.modifyTime(18, 45, 0);
        System.out.println("\nМодифицированное время: " + timeDate);
        System.out.println("Новый timestamp: " + timeDate.convertToTimestamp());
    }
}

