package me.char321.nexcavate.structure.piece;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class SlimefunItemStructurePiece implements StructurePiece {
    private String string;
    private SlimefunItem item;

    public SlimefunItemStructurePiece(String string) {
        this.string = string;
    }

    public SlimefunItemStructurePiece(SlimefunItem item) {
        this.item = item;
    }

    @Override
    public boolean isValid(Block b) {
        load();
        SlimefunItem sfitem = BlockStorage.check(b);
        return item.equals(sfitem);
    }

    @Override
    public ItemStack getDisplay() {
        load();
        return item.getItem();
    }

    private void load() {
        if (item == null && string != null) {
            item = SlimefunItem.getById(string);
            string = null;
        }
    }
}
