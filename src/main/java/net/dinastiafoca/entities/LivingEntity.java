package net.dinastiafoca.entities;

public abstract class LivingEntity extends Entity {
    protected int life;
    protected int maxLife;

    public LivingEntity(int x, int y, int life, int maxLife) {
        super(x, y);
        this.life = life;
        this.maxLife = maxLife;
    }

    public LivingEntity(int x, int y, int maxLife) {
        this(x, y, maxLife, maxLife);
    }
}
