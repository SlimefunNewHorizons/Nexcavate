package me.char321.nexcavate.items.tools;

import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ToolUseHandler;
import me.char321.nexcavate.items.Items;
import me.char321.nexcavate.items.tools.loot.LootTable;
import me.char321.nexcavate.slimefun.NEItem;
import org.bukkit.inventory.ItemStack;

public class RediscoveryPickaxe extends NEItem {
    private final LootTable lootTable;

    public RediscoveryPickaxe(ItemStack item, String id, RecipeType type, ItemStack[] recipe, LootTable table) {
        super(item, id, type, recipe);
        this.lootTable = table;
        addItemHandler((ToolUseHandler) (e, tool, fortune, drops) -> {
            ItemStack drop = lootTable.poll(e.getBlock().getType());
            if (drop != null) {
                drops.add(drop);
            }
        });
    }

    public RediscoveryPickaxe(ItemStack item, String id, LootTable lootTable) {
        this(item, id, Items.DUMMY_TYPE, new ItemStack[9], lootTable);
    }
}
