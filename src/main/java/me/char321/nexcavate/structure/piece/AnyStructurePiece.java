package me.char321.nexcavate.structure.piece;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class AnyStructurePiece implements StructurePiece {
    private static final ItemStack DISPLAY = new CustomItemStack(Material.STRUCTURE_VOID, "Anything", "&7Any block (including air) can be used in this place.");

    @Override
    public boolean isValid(Block b) {
        return true;
    }

    @Override
    public ItemStack getDisplay() {
        return DISPLAY;
    }
}
