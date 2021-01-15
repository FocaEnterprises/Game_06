package net.dinastiafoca.window;

public class Camera
{
  public int x;
  public int y;

  public void set(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int translateX(int x) {
    return x - this.x;
  }

  public int translateY(int y) {
    return y - this.y;
  }
}
