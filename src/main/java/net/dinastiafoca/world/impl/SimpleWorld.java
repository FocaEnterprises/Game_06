package net.dinastiafoca.world.impl;

import net.dinastiafoca.window.renderer.Renderer;
import net.dinastiafoca.world.Dimension;
import net.dinastiafoca.world.World;

import java.util.Arrays;

public class SimpleWorld implements World
{
  private final Dimension[] dimensions = new Dimension[3];

  private final int WIDTH;
  private final int HEIGHT;

  private Dimension currentDimension;

  public SimpleWorld(int width, int height) {
    this.WIDTH = width;
    this.HEIGHT = height;

    dimensions[0] = new OverworldDimension(this);
    dimensions[1] = new NetherDimension(this);
    dimensions[2] = new TheEndDimension(this);

    currentDimension = dimensions[0];
  }

  @Override
  public void update() {
    getCurrentDimension().update();
  }

  @Override
  public void render(Renderer renderer) {
    getCurrentDimension().render(renderer);
  }

  @Override
  public Dimension[] getDimensions() {
    return Arrays.copyOf(dimensions, dimensions.length);
  }

  @Override
  public Dimension getCurrentDimension() {
    return currentDimension;
  }

  @Override
  public void setCurrentDimension(int index) {
    this.currentDimension = dimensions[index];
  }

  @Override
  public int getWidth() {
    return WIDTH;
  }

  @Override
  public int getHeight() {
    return HEIGHT;
  }
}
