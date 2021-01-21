package net.dinastiafoca.window;

public class Camera
{
  public int x;
  public int y;

  public void set(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void setClamp(int x, int y, int maxX, int maxY) {
    set(
      clamp(x, 0, maxX),
      clamp(y, 0, maxY)
    );
  }

  public int translateX(int x) {
    return x - this.x;
  }

  public int translateY(int y) {
    return y - this.y;
  }

  public static int clamp(int current, int min, int max) {
    if(current < min)
      current = min;

    if(current > max)
      current = max;

    return current;
  }
}
