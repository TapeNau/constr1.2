

public class immutable_example {
    public static void main(String[] args) {
        String original = "example1";

        ImmutableRGB example1 = new ImmutableRGB(24, 32, 40, original);

        System.out.println("Виводимо інформацію об'єкта до зміни значення локальної змінної");
        System.out.println(example1.toString());

        original = "example2";

        System.out.println("Виводимо інформацію об'єкта після зміни значення локальної змінної");
        System.out.println(example1.toString());

        ImmutableRGB example2 = new ImmutableRGB(24, 32, 40, original);

        System.out.println("Виводимо інформацію нового об'єкта після зміни значення локальної змінної");
        System.out.println(example2.toString());
    }
}

