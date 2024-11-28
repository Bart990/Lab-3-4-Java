import java.util.*;

abstract class Figure implements Comparable<Figure> {
    public abstract double getArea();

    @Override
    public int compareTo(Figure other) {
        return Double.compare(this.getArea(), other.getArea());
    }

    @Override
    public String toString() {
        return "Figure{area=" + getArea() + "}";
    }
}

class Circle extends Figure {
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Переопределение equals и hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Circle)) return false;
        Circle circle = (Circle) obj;
        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}

class Rectangle extends Figure {
    int width;
    int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    // Переопределение equals и hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Rectangle)) return false;
        Rectangle rect = (Rectangle) obj;
        return width == rect.width && height == rect.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}


public class Main {
    public static void main(String[] args) {
        // Заполнение HashSet
        Set<Figure> figureSet = new HashSet<>();
        figureSet.add(new Circle(5));
        figureSet.add(new Circle(5)); // Дублирующийся объект
        figureSet.add(new Rectangle(5, 3));
        figureSet.add(new Rectangle(3, 5)); // Не дублируется, так как размеры различаются
        figureSet.add(new Circle(4));

        // Вывод HashSet
        System.out.println("Коллекция HashSet:");
        for (Figure figure : figureSet) {
            System.out.println(figure);
        }

        // Сортировка через TreeSet
        Set<Figure> sortedSet = new TreeSet<>(figureSet);

        // Вывод отсортированного TreeSet
        System.out.println("\nКоллекция TreeSet (сортировка по площади):");
        for (Figure figure : sortedSet) {
            System.out.println(figure);
        }
    }
}
