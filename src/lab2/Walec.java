package lab2;
public class Walec {
    private float radius;
    private float height;


    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public Walec (float radius, float height) {
        this.radius = radius;
        this.height = height;
    }

    public Walec (){

    };

    public double calculateLateralArea() {
        return 2 * Math.PI * this.radius * this.height;
    }

    public double calculateBaseArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public double calculateTotalArea () {
        return this.calculateLateralArea () + 2 * calculateBaseArea();
    }

    public double calculateVolume () {
        return this.calculateBaseArea() * this.height;
    }

}