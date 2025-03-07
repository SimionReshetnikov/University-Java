import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Date {
    protected int day;
    protected int month;
    protected int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    ///Проверка весоконсый ли год.
    /// Возвращает true, если год весокосный
    /// Возвращает false, если нет
    public boolean isLeapYear()
    {
        if(year % 4 == 0)
        {
            if(year % 100 == 0)
            {
                return year % 400 == 0;
            }
            else
            {
                return true;
            }
        }
        return false;
    }

    /// Метод преобразует дату в формат Tinestamp
    public long convertToTimestamp()
    {
        LocalDate date = LocalDate.of(year, month, day);
        LocalDateTime dateTime = date.atStartOfDay();
        ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.systemDefault());

        return zonedDateTime.toInstant().toEpochMilli();
    }

    /// Метод преобразования строки в нужный формат
    /// Вывод может быть в формате 0,0,0 или 0-0-0 и тд.
    public String format(String pattern)
    {
        LocalDate date = LocalDate.of(year, month, day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    /// Преобразование даты в строку
    @Override
    public String toString()
    {
        return String.format("%s-%s-%s", day, month, year);
    }
}
