package net.dinastiafoca.world.gen;

import net.dinastiafoca.window.Window;
import net.dinastiafoca.window.renderer.Renderer;

import java.awt.Color;
import java.util.Random;

public class Test
{
  private static final double FEATURE_SIZE = 24;

  public static void main(String[] args) throws Exception
  {
    OpenSimplexNoise noise = new OpenSimplexNoise();
    Window win = new Window.WindowBuilder().setTitle("Noise").setWidth(800).setHeight(600).build();
    Renderer renderer = new Renderer(win);

    double[] blocks = new double[win.getWidth()];

    int seed = 0;

    while(true) {
      int blockSize = 1;

      double height;
      int maxHeight = 50;
      int resolution = 5;

      for (int xx = 0; xx < blocks.length; xx++) {
        height = maxHeight * (1 + noise.eval((xx + seed) / Math.sqrt(win.getWidth() * resolution), seed) / 2);
        blocks[xx] = Math.floor(height);
      }

      seed++;
      renderer.begin();

      renderer.setColor(Color.red);
      for (int xx = 0; xx < blocks.length; xx++) {
        renderer.fillRect(
                xx * blockSize,
                (int)((win.getHeight() / 2 - blockSize / 2) + blocks[xx] * blockSize),
                blockSize,
                blockSize);
      }
      
      renderer.end();
      Thread.sleep(400);
    }
  }
}
