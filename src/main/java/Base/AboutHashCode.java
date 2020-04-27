package Base;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author xiaoran
 * @date 2020/04/27
 */
public class AboutHashCode {
    public static void main(String[] args) {
        Point point1 = new Point(1,2);
        Point point2 = new Point(1,2);

        Set set =new HashSet<Point>();

        set.add(point1);
        set.add(point2);

        set.stream().forEach(e-> System.out.println(e.toString()));
        System.out.println(point1.equals(point2));
    }
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}