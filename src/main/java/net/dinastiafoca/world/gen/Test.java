package net.dinastiafoca.world.gen;

import net.dinastiafoca.window.Window;
import net.dinastiafoca.window.renderer.Renderer;

import java.awt.Color;
import java.util.Random;

public class Test
{
  public static void main(String[] args) throws Exception
  {
    Random rand = new Random();
    ImprovedNoise noise = new ImprovedNoise(rand.nextDouble());
    Window win = new Window.WindowBuilder().setTitle("Noise").setWidth(720).setHeight(460).build();
    Renderer renderer = new Renderer(win);

    while(true) {
      noise.setSeed(rand.nextDouble());
      renderer.begin();
      renderer.setColor(Color.RED);

      for(int i = 0; i < win.getWidth(); i++) {
        int a = (int) (noise.noise(i, 200) * 10);
        renderer.drawLine(i, 200 + a, i, 200 + a);
      }

      renderer.end();
      Thread.sleep(50);
    }
  }
}
