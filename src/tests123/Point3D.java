package tests123;

public class Point3D extends Point2D {
    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;

    }

    @Override
    public String toString() {
        return super.x + "," + super.y + "," + z;
    }
}
