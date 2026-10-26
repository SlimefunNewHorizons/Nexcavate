package me.char321.nexcavate.items.misc;

import io.github.thebusybiscuit.slimefun4.implementation.handlers.SimpleBlockBreakHandler;
import me.char321.nexcavate.items.ItemStacks;
import me.char321.nexcavate.slimefun.NEAssembly;
import me.char321.nexcavate.structure.Structure;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class ItemHolder extends NEAssembly {
    private static final int[] BACKGROUND = {0, 1, 2, 6, 7, 8, 9, 10, 11, 15, 16, 17, 18, 19, 20, 24, 25, 26};
    private static final int[] SLOT_BORDER = {3, 4, 5, 12, 14, 21, 22, 23};
    private static final int SLOT = 13;

    public ItemHolder(ItemStack item, String id, Structure structure) {
        super(item, id, structure);
    }

    @Override
    public void preRegister() {
        super.preRegister();

        addItemHandler(new SimpleBlockBreakHandler() {
            @Override
            public void onBlockBreak(@Nonnull Block b) {
                BlockMenu inv = BlockStorage.getInventory(b);

                if (inv != null) {
                    inv.dropItems(b.getLocation(), SLOT);
                }
            }
        });
    }

    @Override
    public void postRegister() {
        super.postRegister();
        new BlockMenuPreset(getId(), getItemName()){

            @Override
            public void init() {
                drawBackground(BACKGROUND);
                drawBackground(ItemStacks.Menu.BLACK, SLOT_BORDER);
            }

            @Override
            public boolean canOpen(@Nonnull Block b, @Nonnull Player p) {
                return true;
            }

            @Override
            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow) {
                return new int[]{SLOT};
            }
        };
    }
}
