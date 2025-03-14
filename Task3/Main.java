import java.util.*;
import java.util.stream.Collector;

public class Main
{
    public static void main(String[] args)
    {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 50);
        map.put("banana", 20);
        map.put("cherry", 30);

        System.out.println("Исходный Map: " + map);
        System.out.println("Отсортированный Map по значению: " + sortMapByValue(map));


        Map<String, Integer> map1 = new HashMap<>();
        map1.put("apple", 10);
        map1.put("banana", 20);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("apple", 30);
        map2.put("cherry", 40);

        System.out.println("Map 1: " + map1);
        System.out.println("Map 2: " + map2);
        System.out.println("Результат сложения Map: " + mergeMaps(map1, map2));


        List<String> list = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "banana");

        System.out.println("Список: " + list);
        System.out.println("Повторяющиеся значения: " + findDuplicates(list));


        Set<String> set1 = new HashSet<>(Arrays.asList("apple", "banana", "cherry"));
        Set<String> set2 = new HashSet<>(Arrays.asList("banana", "cherry", "date"));

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Пересечение Set: " + findIntersection(set1, set2));
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortMapByValue(Map<K, V> map)
    {
        List<Map.Entry<K, V>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByValue());

        Map<K, V> sortedMap = new LinkedHashMap<>();

        for(Map.Entry<K, V> entry : entries)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2)
    {
        Map<String, Integer> result = new HashMap<>(map1);

        for(Map.Entry<String, Integer> entry : map2.entrySet())
        {
            String key = entry.getKey();
            Integer value = entry.getValue();

            result.merge(key, value, Integer::sum);
        }

        return result;
    }

    public static <T> List<T> findDuplicates(List<T> list) {
        List<T> duplicates = new ArrayList<>();

        Set<T> seen = new HashSet<>();

        for (T item : list) {
            if (seen.contains(item)) {
                duplicates.add(item);
            } else {
                seen.add(item);
            }
        }

        return duplicates;
    }

    public static <T> Set<T> findIntersection(Set<T> set1, Set<T> set2) {
        Set<T> intersection = new HashSet<>(set1);

        intersection.retainAll(set2);

        return intersection;
    }
}
