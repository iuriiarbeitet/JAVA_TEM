import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

/**
 * Описание задания.
 * <p>
 * 1 уровень сложности:     /**
 * * String text = "???";
 * * И вывести на экран все уникальные слова и количество их повторений
 * * отсортировать в порядке убывания.
 * * Так же подсчитать количество всех слов
 * * Ex:
 * * mama - 2
 * * is - 3
 * * i - 3
 * * throw - 1
 */


public class Main {
    public static void main(String[] args) {
        String s = "Java ist eine objektorientierte Programmiersprache und eine eingetragene Marke des Unternehmens Sun Microsystems, welches 2010 von Oracle aufgekauft wurde. Die Programmiersprache ist ein Bestandteil der Java-Technologie – diese besteht grundsätzlich aus dem Java-Entwicklungswerkzeug (JDK) zum Erstellen von Java-Programmen und der Java-Laufzeitumgebung (JRE) zu deren Ausführung. Die Laufzeitumgebung selbst umfasst die virtuelle Maschine (JVM) und die mitgelieferten Bibliotheken. Java als Programmiersprache sollte nicht mit der Java-Technologie gleichgesetzt werden; Java-Laufzeitumgebungen führen Bytecode aus, der sowohl aus der Programmiersprache Java als auch aus anderen Programmiersprachen wie Groovy, Kotlin und Scala kompiliert werden kann. Im Prinzip könnte jede Programmiersprache als Grundlage für Java-Bytecode genutzt werden, meistens existieren aber keine entsprechenden Bytecode-Compiler.\n" +
                "\n" +
                "Die Programmiersprache Java dient innerhalb der Java-Technologie vor allem zum Formulieren von Programmen. Diese liegen zunächst als reiner, menschenverständlicher Text vor, dem sogenannten Quellcode. Dieser Quellcode ist nicht direkt ausführbar; erst der Java-Compiler, der Teil des Entwicklungswerkzeugs ist, übersetzt ihn in den maschinenverständlichen Java-Bytecode. Die Maschine, die diesen Bytecode ausführt, ist jedoch typischerweise virtuell – das heißt, der Code wird meist nicht direkt durch Hardware (etwa einen Mikroprozessor) ausgeführt, sondern durch entsprechende Software auf der Zielplattform.\n" +
                "\n" +
                "Zweck dieser Virtualisierung ist Plattformunabhängigkeit: Das Programm soll ohne weitere Änderung auf jeder Rechnerarchitektur laufen können, wenn dort eine passende Laufzeitumgebung installiert ist. Oracle selbst bietet Laufzeitumgebungen für die Betriebssysteme Linux, macOS, Solaris und Windows an. Andere Hersteller lassen eigene Java-Laufzeitumgebungen für ihre Plattform zertifizieren. Auch in Autos, HiFi-Anlagen und anderen elektronischen Geräten wird Java verwendet.\n" +
                "\n" +
                "Um die Ausführungsgeschwindigkeit zu erhöhen, werden Konzepte wie die Just-in-time-Kompilierung und die Hotspot-Optimierung verwendet. In Bezug auf den eigentlichen Ausführungsvorgang kann die JVM den Bytecode also interpretieren, ihn bei Bedarf jedoch auch kompilieren und optimieren.\n" +
                "\n" +
                "Java ist eine der populärsten Programmiersprachen. In dem seit 2001 veröffentlichten TIOBE-Index lag Java bis 2020, konkurrierend mit C, stets auf den ersten beiden, seit 2021 mit zusätzlicher Konkurrenz von Python, auf den ersten drei Plätzen des Rankings.[4][5] Nach dem RedMonk-Programmiersprachenindex 2019 liegt Java zusammen mit Python auf dem zweiten Platz nach JavaScript.[6][7]";

        String modifiedText = modifyText(s);

        List<String> listStream = Arrays.stream(modifiedText.split(" ")).sorted(((o1, o2) -> o2.compareTo(o1))).toList();

        Map<String, Integer> map = listStream.stream().distinct()
                .collect(Collectors.toMap(s1 -> s1, s1 -> Collections.frequency(listStream, s1)));

        Map<String, Integer> result2 = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(((o1, o2) -> o2.compareTo(o1))))
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

        //listStream.stream().map(x -> map.put(x, Collections.frequency(listStream, x))).toList();
        System.out.println("Count words :  " + map.keySet().size());
        printMap(result2);

    }

    public static void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            String key = pair.getKey();
            Integer value = pair.getValue();
            System.out.println(key + " --> " + value);
        }
    }


    public static String modifyText(String sourceText) {
        String modifiedText = sourceText.replace(",", "");
        modifiedText = modifiedText.replace(".", "");
        modifiedText = modifiedText.replace("!", "");
        modifiedText = modifiedText.replace("?", "");
        modifiedText = modifiedText.replace(";", "");
        modifiedText = modifiedText.replace("-", "");
        modifiedText = modifiedText.replace("[", "");
        modifiedText = modifiedText.replace("]", "");
        modifiedText = modifiedText.replace("(", "");
        modifiedText = modifiedText.replace(")", "");
        modifiedText = modifiedText.toLowerCase();
        return modifiedText;
    }
}
/*.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
//        // for (int i = 0; i < listStream.size(); i++) {map.put(listStream.get(i), Collections.frequency(listStream, listStream.get(i)));}
//      List<String> stringList = Arrays.asList("as", "as", "as", "as", "ass", "asd", "asd", "asd", "asd", "asd", "ass", "ass");
 */