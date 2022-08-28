public class Vector {
  public double x, y, z;

  public Vector(double xComponent, double yComponent, double zComponent) {
    this.x = xComponent;
    this.y = yComponent;
    this.z = zComponent;
  }

  public Vector(double mag, double angle_RAD) {
    this.x = mag * Math.cos(angle_RAD);
    this.y = mag * Math.sin(angle_RAD);
    this.z = 0;
  }

  public Vector() {
    double ang = Math.random() * Math.PI * 2;

    this.x = Math.cos(ang) * 1;
    this.y = Math.sin(ang) * 1;
    this.z = 0;
  }

  /*
   * Get Methods
   */
  public double getX() {
    return this.x;
  }

  public double getY() {
    return this.y;
  }

  public double getZ() {
    return this.z;
  }

  /*
   * Copy
   */

  public Vector copy() {
    return new Vector(this.x, this.y, this.z);
  }

  /*
   * Add Methods
   */

  public void add(Vector inputVector) {
    this.x += inputVector.x;
    this.y += inputVector.y;
    this.z += inputVector.z;
  }

  public void add(double x, double y, double z) {
    this.x += x;
    this.y += y;
    this.z += z;
  }

  public void add(double val) {
    this.x += val;
    this.y += val;
    this.z += val;
  }

  /*
   * Subtract
   */

  public void sub(Vector inputVector) {
    this.x -= inputVector.x;
    this.y -= inputVector.y;
    this.z -= inputVector.z;
  }

  public void sub(double x, double y, double z) {
    this.x -= x;
    this.y -= y;
    this.z -= z;
  }

  public void sub(double val) {
    this.x -= val;
    this.y -= val;
    this.z -= val;
  }

  /*
   * Multiply Methods
   */

  public void mult(Vector inputVector) {
    this.x *= inputVector.x;
    this.y *= inputVector.y;
    this.z *= inputVector.z;
  }

  public void mult(double x, double y, double z) {
    this.x *= x;
    this.y *= y;
    this.z *= z;
  }

  public void mult(double val) {
    this.x *= val;
    this.y *= val;
    this.z *= val;
  }

  /*
   * Divide methods
   */

  public void div(Vector inputVector) {
    this.x /= inputVector.x;
    this.y /= inputVector.y;
    this.z /= inputVector.z;
  }

  public void div(double x, double y, double z) {
    this.x /= x;
    this.y /= y;
    this.z /= z;
  }

  public void div(double val) {
    this.x /= val;
    this.y /= val;
    this.z /= val;
  }

  /*
   * Remainder Methods
   */

  public void rem(Vector inputVector) {
    this.x %= inputVector.x;
    this.y %= inputVector.y;
    this.z %= inputVector.z;
  }

  public void rem(double x, double y, double z) {
    this.x %= x;
    this.y %= y;
    this.z %= z;
  }

  public void rem(double val) {
    this.x %= val;
    this.y %= val;
    this.z %= val;
  }

  /*
   * Dot Product Method
   */

  public static double dot(Vector v1, Vector v2) {
    return (v1.x * v2.x) + (v1.y * v2.y) + (v1.z * v2.z);
  }

  /*
   * Cross Product Method
   */

  public static Vector cross(Vector v1, Vector v2) {
    double newX = v1.y * v2.z - v1.z * v2.y;
    double newY = v1.z * v2.x - v1.x * v2.z;
    double newZ = v1.x * v2.y - v1.y * v2.x;

    return new Vector(newX, newY, newZ);
  }

  /*
   * Magnitude Meth
   */

  public double mag() {
    return Math.sqrt(x * x + y * y + z * z);
  }

  public double magSq() {
    return x * x + y * y + z * z;
  }

  /*
   * Distance methods
   */

  public double dist(Vector inputVector) {
    return Math.sqrt((x - inputVector.x) * (x - inputVector.x) +
        (y - inputVector.y) * (y - inputVector.y) +
        (z - inputVector.z) * (z - inputVector.z));
  }

  public static double dist(Vector v1, Vector v2) {
    return Math.sqrt((v1.x - v2.x) * (v1.x - v2.x) +
        (v1.y - v2.y) * (v1.y - v2.y) +
        (v1.z - v2.z) * (v1.z - v2.z));
  }

  /*
   * Normalize Method
   */

  public void normalize() {
    double mag = this.mag();

    this.x = this.x / mag;
    this.y = this.y / mag;
    this.z = this.z / mag;
  }

  /*
   * Equivalency Check Methods
   */

  public boolean equals(double x, double y) {
    return this.x == x && this.y == y && this.z == this.z;
  }

  public boolean equals(Vector inputVector) {
    return this.x == inputVector.x && this.y == inputVector.y;
  }

  /*
   * Heading methods
   */

  public double heading() {
    double result = Math.atan2(this.y, this.x);

    if (this.x < 0)
      result += Math.PI;

    return result;
  }

  public void setHeading(double angle_RAD) {
    double mag = Math.sqrt(this.x * this.x + this.y * this.y);

    this.x = mag * Math.cos(this.x);
    this.y = mag * Math.sin(this.y);
  }

  /*
   * Rotate Method
   */

  public void rotate(double angle_RAD) {
    double currentAngle_RAD = this.heading();
    currentAngle_RAD += angle_RAD;

    this.setHeading(currentAngle_RAD);
  }

  /*
   * Angle Between Method
   */

  public static double angleBetween(Vector v1, Vector v2) {
    double mag1 = v1.mag();
    double mag2 = v2.mag();
    double dot = Vector.dot(v1, v2);

    return Math.acos(dot / (mag1 * mag2));
  }

  /*
   * To String Method
   */

  public String toString() {
    return String.format("Vector [%.4f, %.4f, %.4f]", this.x, this.y, this.z);
  }

}
