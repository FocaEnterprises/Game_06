package net.dinastiafoca.world.blocks;

import net.dinastiafoca.window.renderer.Sprite;
import net.dinastiafoca.window.renderer.Spritesheet;
import net.dinastiafoca.world.Block;

public class GrassBlock extends Block {
    public GrassBlock() {
        super(2, Spritesheet.getBlockSprite("grass"));
    }
}
