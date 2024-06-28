package exercise;

// BEGIN
public class Segment {
    private final Point beginPoint;
    private final Point endPoint;

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {
        int newX = (beginPoint.getX() + endPoint.getX()) / 2;
        int newY = (beginPoint.getY() + endPoint.getY()) / 2;
        return new Point(newX, newY);
    }
}
// END
