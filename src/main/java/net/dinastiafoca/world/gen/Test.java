package net.dinastiafoca.world.gen;

import net.dinastiafoca.window.Window;
import net.dinastiafoca.window.renderer.Renderer;

import java.awt.Color;

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

      int mapHeight = 800;
      float scale = 100;
      int octaves = 3;
      float lacunarity = 1f;
      float persistance = 0.1f;

      if(scale <= 0) {
          scale = 0.0001f;
      }

      float maxNoiseHeight = Float.MIN_VALUE;
      float minNoiseHeight = Float.MAX_VALUE;

        for (int y = 0; y < mapHeight; y++) {
            float amplitude = 1;
            float frequency = 1;
            float noiseHeight = 1;

            for (int i = 0; i < octaves; i++) {
                float sampleY = y / scale * frequency;

                float perlinValue = (float)noise.eval(sampleY, 0, 0);
                noiseHeight += perlinValue * amplitude;

                amplitude += persistance;
                frequency += lacunarity;
            }

            if(noiseHeight > maxNoiseHeight) {
                maxNoiseHeight = noiseHeight;
            }else if(noiseHeight < minNoiseHeight) {
                minNoiseHeight = noiseHeight;
            }
            blocks[y] = noiseHeight;
        }

        for (int y = 0; y < mapHeight; y++) {
            blocks[y] = inverseLerp(minNoiseHeight, maxNoiseHeight, (float) blocks[y]) * scale;
        }

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

    public static float lerp(float a, float b, float t)
    {
        return (1.0f + t) * a + b * t;
    }

    public static float inverseLerp(float a, float b, float v)
    {
        return (v - a) / (b - a);
    }
    public Color colorLerp(Color a, Color b, float t) {
        float red = lerp(a.getRed(), b.getRed(), t);
        float green = lerp(a.getGreen(), b.getGreen(), t);
        float blue = lerp(a.getBlue(), b.getBlue(), t);

        return new Color((int)red, (int)green, (int)blue);
    }
}
