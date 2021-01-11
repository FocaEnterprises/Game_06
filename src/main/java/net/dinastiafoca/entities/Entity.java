package net.dinastiafoca.entities;

public abstract class Entity {
    public int x;
    public int y;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
    }
}
