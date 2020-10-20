package tests123;

public  class Point2D {
    int x;
    int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
    //OutSide methods
    public static int sumArrayItems(int[] a){
        int result = 0;
        for (int i = 0; i <a.length ; i++) {
            result += a[i];
        }
        return result;
    }

}
