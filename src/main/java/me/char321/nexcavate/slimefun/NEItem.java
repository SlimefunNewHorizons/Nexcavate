package me.char321.nexcavate.slimefun;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.char321.nexcavate.Nexcavate;
import me.char321.nexcavate.items.Items;
import org.bukkit.inventory.ItemStack;

public class NEItem extends SlimefunItem {
    public NEItem(ItemStack item, String id) {
        super(Items.DUMMY_GROUP, item, id, Items.DUMMY_TYPE, new ItemStack[9]);
    }

    public NEItem(ItemStack item, String id, ItemStack[] recipe) {
        super(Items.DUMMY_GROUP, item, id, Items.DUMMY_TYPE, recipe);
    }

    public NEItem(ItemStack item, String id, RecipeType recipeType, ItemStack[] recipe) {
        super(Items.DUMMY_GROUP, item, id, recipeType, recipe);
    }

    public void register() {
        register(Nexcavate.instance());
    }
}
