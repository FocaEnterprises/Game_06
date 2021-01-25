package net.dinastiafoca.world.blocks;

import net.dinastiafoca.inventory.ItemID;
import net.dinastiafoca.window.renderer.Sprite;
import net.dinastiafoca.window.renderer.Spritesheet;
import net.dinastiafoca.world.Block;

public class GrassBlock extends Block {
    public GrassBlock() {
        super(ItemID.GRASS, Spritesheet.getBlockSprite("grass"));
    }
}
