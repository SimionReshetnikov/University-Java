import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeDate extends Date
{
    private int hour;
    private int minute;
    private int second;

    public TimeDate(int day, int month, int year, int hour, int minute, int second)
    {
        super(day, month, year);
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    /// Изменение только часов, минут и секунд в текущей дате
    public void modifyTime(int hour, int minute, int second)
    {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    /// Преобразование даты в строку
    @Override
    public String toString()
    {
        return String.format("%02d.%02d.%04d %02d:%02d:%02d", day, month, year, hour, minute, second);
    }

    /// Метод преобразует дату в формат Tinestamp
    @Override
    public long convertToTimestamp()
    {
        LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, minute, second);
        ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.systemDefault());

        return zonedDateTime.toInstant().toEpochMilli();
    }

    /// Метод преобразования строки в нужный формат
    /// Вывод может быть в формате 0,0,0 0:0:0 или 0-0-0 0-0-0 и тд.
    @Override
    public String format(String pattern) {
        LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, minute, second);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }
}
