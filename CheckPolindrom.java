import java.util.*;

public class CheckPolindrom {
    public static void main(String[] args) {

        checkListPolindrom(generatorString( "ABCDE", 100));
        checkStrPolindr("madam");
        //"ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    }

    public static  List<String> generatorString (String s, int quantityWords){
        Random random = new Random();
       List<String> listGenerString = new ArrayList<>();

        for (int i = 0; i < quantityWords; i++) {
            StringBuffer sb = new StringBuffer(s.length());
            for (int j = 0; j < s.length(); j++) {
               sb.append(s.charAt(random.nextInt(s.length())));
              }
            listGenerString.add(sb.toString());
        }
        return listGenerString;
    }

    public static void checkListPolindrom (List<String> stringList){
        for (int i = 0; i < stringList.size(); i++) {
          checkStrPolindr(stringList.get(i));
        }
    }
    public static void checkStrPolindr(String str) {
        List<Character> characters = new LinkedList<>();
        for (char c : str.toUpperCase().toCharArray()) {
            characters.add(c);
        }
        System.out.println(characters);
        System.out.println(isPolindrom(characters));
    }

    public static boolean isPolindrom(List<Character> charLinkedList) {
        boolean isRight = false;
        int count = 0;
        ListIterator<Character> listIterator1 = charLinkedList.listIterator(0);
        ListIterator<Character> listIterator2 = charLinkedList.listIterator(charLinkedList.size());
        for (int i = 0; i < charLinkedList.size()/2; i++) {
            if (listIterator1.next() == listIterator2.previous()) count++;
        }
        if (count == charLinkedList.size()/2) isRight = true;
        else isRight = false;

        return isRight;
    }
}
