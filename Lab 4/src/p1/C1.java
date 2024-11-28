package p1;

public class C1 {
    public static String f1 = "Статическое поле класса C1";
    static {
        System.out.println("Класс C1 загружен в память");
    }
}
