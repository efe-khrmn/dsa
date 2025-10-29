import java.util.Comparator;

public class RectangleMax {
    public static <AnyType>
    AnyType findMax(AnyType[] arr, Comparator<? super AnyType> cmp){
        int maxIndex = 0;

        for (int i = 1; i < arr.length; i++){
            if (cmp.compare(arr[i], arr[maxIndex]) > 0){
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }
    static class Rectangle{
        private double width;
        private double height;
        public Rectangle(double width, double height){
            this.width = width;
            this.height = height;
        }
        public double getHeight() {return height;}
        public double getWidth() {return width;}
        public double getArea() {return width * height;}
        public double getPerimeter() {return 2 * (width + height);}

        @Override
        public String toString(){
            return "Rectangle(width: " + width + ", height: " + height + ")";
        }
    }
    static class AreaComparator implements Comparator<Rectangle>{
        @Override
        public int compare(Rectangle r1, Rectangle r2){
            return Double.compare(r1.getArea(), r2.getArea());
        }
    }
    static class PerimeterComparator implements Comparator<Rectangle>{
        @Override
        public int compare(Rectangle r1, Rectangle r2){
            return Double.compare(r1.getPerimeter(), r2.getPerimeter());
        }
    }
    public static void main(String[] args) {
        Rectangle[] rectangles = {
            new Rectangle(3, 4),
            new Rectangle(5, 6),
            new Rectangle(2, 8),
            new Rectangle(7, 3)
        };

        Rectangle maxAreaRect = findMax(rectangles, new AreaComparator());
        System.out.println("Rectangle with maximum area: " + maxAreaRect + " with area: "
                + maxAreaRect.getArea());

        Rectangle maxPerimeterRect = findMax(rectangles, new PerimeterComparator());
        System.out.println("Rectangle with maximum perimeter: " + maxPerimeterRect + " with perimeter: " +
                maxPerimeterRect.getPerimeter());
    }
}
