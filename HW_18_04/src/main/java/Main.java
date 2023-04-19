import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        String s = "Wuppertal ist mit 354.572 Einwohnern (31. Dezember 2021)[2] die größte Stadt und das Industrie-, Wirtschafts-, Bildungs- und Kulturzentrum des Bergischen Landes im Westen Deutschlands. Die Großstadt liegt südlich des Ruhrgebiets im Regierungsbezirk Düsseldorf und ist als siebzehntgrößte Stadt Deutschlands eines der Oberzentren des Landes Nordrhein-Westfalen.\n" +
                "\n" + "Erste urkundliche Erwähnungen von Siedlungen stammen aus dem mittleren 11. Jahrhundert. Über viele Jahrhunderte war das heutige Stadtgebiet durch unterschiedliche Herrschaftsgebiete geteilt. Bis ins 19. Jahrhundert entwickelte sich die Region zu einem Zentrum der deutschen und europäischen Frühindustrialisierung; vor allem die Textilindustrie bescherte der Region Reichtum und Wachstum. Die Stadt wurde zum 1. August 1929 durch Vereinigung der kreisfreien Städte Elberfeld (Großstadt seit etwa 1883) und Barmen (Großstadt seit etwa 1884) sowie der Städte Ronsdorf, Cronenberg und Vohwinkel unter dem Namen Barmen-Elberfeld als kreisfreie Stadt gegründet und im Jahr 1930 in Wuppertal umbenannt[3][4]; diese Namensvergabe brachte die geografische Lage der Städte Barmen und Elberfeld im Tal der Wupper zum Ausdruck.\n" +
                "\n" + "Im Nationalsozialismus war die Stadt ein wichtiges Zentrum sowohl der NSDAP als auch des Widerstands, sowohl der Gewerkschaften und politischen Opposition als auch der Kirchen, was nicht zuletzt die Barmer Erklärung zum Ausdruck brachte. Durch weitreichende Zerstörungen im Zweiten Weltkrieg nahm die Bedeutung der Stadt ab.\n" +
                "\n" + "Die Topografie wird durch das Tal der Wupper geprägt, die sich rund 20 km durch das Stadtgebiet windet" +
                "und deren steile Hänge oft bewaldet sind. Auf den nördlichen und südlichen Hochflächen gelegene Stadtteile gehen in die Wiesen und Wälder des Bergischen Landes über und machen Wuppertal, zusammen mit weitläufigen Grün- und Waldflächen wie etwa dem Barmer Wald, Scharpenacken oder Staatsforst Burgholz, zu einer Großstadt im Grünen. Als Wiege der Industrialisierung in Deutschland [5] ist die Stadt zugleich reich an großen Villenvierteln und Wohnhäusern aus der Gründerzeit: Etwa 4500 Baudenkmale befinden sich im Stadtgebiet.\n" +
                "\n" + "Neben der seit 1901 bestehenden Schwebebahn ist die Universitätsstadt bekannt für das international renommierte Tanztheater Wuppertal Pina Bausch und das Wuppertal Institut für Klima, Umwelt, Energie, den Zoologischen Garten, die Historische Stadthalle, das Sinfonieorchester Wuppertal, das Von der Heydt-Museum für bildende Kunst, das Historische Zentrum mit dem Engels-Haus, den Skulpturenpark Waldfrieden, weitreichende Parkanlagen und Wälder mit Deutschlands größtem Arboretum im Staatsforst Burgholz und die größte Konfessionsvielfalt Deutschlands.\n" +
                "\n" + "Bekannte Wuppertaler Sportvereine sind der ehemalige Fußball-Erstligist und UEFA-Cup-Teilnehmer Wuppertaler SV und der Handballbundesligist Bergischer HC, hinzu kommen Bundesligisten in weiteren Sportarten mit zahlreichen nationalen und internationalen Titeln.\n" +
                "\n" + "Darüber hinaus sind durch Geburt oder Wirken zahlreiche Persönlichkeiten mit der Stadt verbunden, so etwa Pina Bausch, Friedrich Bayer, Gerhard Domagk, Friedrich Engels, Hans-Dietrich Genscher, Else Lasker-Schüler, Johannes Rau oder Hans Wolfgang Singer.";

        String modifiedText = modifyText(s);

        Map<String, Integer> map = new TreeMap<>(((o1, o2) -> o2.compareTo(o1)));

        List<String> listStream = Arrays.stream(modifiedText.split(" ")).toList();

        listStream.stream().map(x -> map.put(x, Collections.frequency(listStream, x))).toList();

        // for (int i = 0; i < listStream.size(); i++) {map.put(listStream.get(i), Collections.frequency(listStream, listStream.get(i)));}

        for (Map.Entry<String, Integer> pair: map.entrySet()){
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

