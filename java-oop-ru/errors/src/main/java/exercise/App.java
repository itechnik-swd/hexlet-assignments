package exercise;

// BEGIN
class App {
    public static void printSquare(Circle circle) throws NegativeRadiusException {
        int square = (int) circle.getSquare();
        System.out.println(square);
        System.out.println("Вычисление окончено");
    }
}
// END
