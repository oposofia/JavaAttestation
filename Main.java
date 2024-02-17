package Attestation;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Notebook note1 = new Notebook();
        note1.ozu = 8;
        note1.hardDisk = 256;
        note1.os = "Windows 10";
        note1.colour = "Grey";

        Notebook note2 = new Notebook();
        note2.ozu = 16;
        note2.hardDisk = 512;
        note2.os = "Windows 11";
        note2.colour = "Blue";

        Notebook note3 = new Notebook();
        note3.ozu = 16;
        note3.hardDisk = 256;
        note3.os = "Linux";
        note3.colour = "Black";

        Notebook note4 = new Notebook();
        note4.ozu = 4;
        note4.hardDisk = 128;
        note4.os = "Windows 10";
        note4.colour = "Grey";

        Notebook note5 = new Notebook();
        note5.ozu = 32;
        note5.hardDisk = 1024;
        note5.os = "macOS";
        note5.colour = "White";

        Notebook note6 = new Notebook();
        note6.ozu = 32;
        note6.hardDisk = 256;
        note6.os = "Windows 11";
        note6.colour = "White";

        Notebook note7 = new Notebook();
        note7.ozu = 16;
        note7.hardDisk = 256;
        note7.os = "Linux";
        note7.colour = "Black";

        Notebook note8 = new Notebook();
        note8.ozu = 32;
        note8.hardDisk = 1024;
        note8.os = "Windows 10";
        note8.colour = "Grey";

        Notebook note9 = new Notebook();
        note9.ozu = 8;
        note9.hardDisk = 128;
        note9.os = "Linux";
        note9.colour = "Blue";

        Notebook note10 = new Notebook();
        note10.ozu = 4;
        note10.hardDisk = 64;
        note10.os = "Windows 10";
        note10.colour = "Black";

        Set<Notebook> notes = new HashSet<>();
        notes.add(note1);
        notes.add(note2);
        notes.add(note3);
        notes.add(note4);
        notes.add(note5);
        notes.add(note6);
        notes.add(note7);
        notes.add(note8);
        notes.add(note9);
        notes.add(note10);

        int count;
        Set<Notebook> setFilter = new HashSet<>();
        Map<Integer,Set<Notebook>> map = new HashMap<>();
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите цифру, соответствующую необходимому критерию:");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет ");
            System.out.println("5 - Поиск");
            count = Integer.parseInt(scanner.nextLine());
            if (count == 1){
                System.out.println("Введите минимальное значение ОЗУ:");
                int ozu = Integer.parseInt(scanner.nextLine());
                setFilter = filterAsOzu(notes,ozu);
                map.put(count, setFilter);

            }
            if (count == 2){
                System.out.println("Введите минимальное значение объема ЖД:");
                int hardDisk = Integer.parseInt(scanner.nextLine());
                setFilter = filterAsHadrDisk(notes,hardDisk);
                map.put(count, setFilter);
            }
            if (count == 3){
                System.out.println("Допустимые значения ввода: ");
                System.out.println("- Window 10;");
                System.out.println("- Window 11;");
                System.out.println("- Linux;");
                System.out.println("- macOS");
                String os = scanner.nextLine();
                setFilter = filterAsOs(notes,os);
                map.put(count, setFilter);
            }
            if (count == 4){
                System.out.println("Допустимые значения ввода: ");
                System.out.println("- Grey;");
                System.out.println("- Blue;");
                System.out.println("- Black;");
                System.out.println("- White");
                String colour = scanner.nextLine();
                setFilter = filterAsColous(notes,colour);
                map.put(count, setFilter);

            }
        } while (count != 5);

        Set<Notebook> filteredNotes = new HashSet<>(notes);

        for (int key: map.keySet()){

            filteredNotes.retainAll(map.get(key));

        }
        if (filteredNotes.isEmpty()){
            System.out.println("По заданным параметров ноутбуков не найдено");
        } else{
            System.out.println("По вашим запросом найдены следующие ноутбуки:");
            printSet(filteredNotes);
        }
    }


    static Set<Notebook> filterAsOzu(Set<Notebook> notes, int ozu){
        Set<Notebook> set = new HashSet<>();
        for (Notebook note: notes){
            if (note.ozu >= ozu){
                set.add(note);
            }
        }
        return set;
    }

    static Set<Notebook> filterAsHadrDisk(Set<Notebook> notes, int hardDisk){
        Set<Notebook> set = new HashSet<>();
        for (Notebook note: notes){
            if (note.hardDisk >= hardDisk){
                set.add(note);
            }
        }
        return set;
    }

    static Set<Notebook> filterAsOs(Set<Notebook> notes, String os){
        Set<Notebook> set = new HashSet<>();
        for (Notebook note: notes){
            if (note.os.equals(os)){
                set.add(note);
            }
        }
        return set;
    }

    static Set<Notebook> filterAsColous(Set<Notebook> notes, String colour){
        Set<Notebook> set = new HashSet<>();
        for (Notebook note: notes){
            if (note.colour.equals(colour)){
                set.add(note);
            }
        }
        return set;
    }

    private static void printSet(Set<Notebook> set) {
        for (Notebook note: set) {
            System.out.println(note);
        }
    }

}
