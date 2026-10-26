package me.char321.nexcavate.util;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import me.char321.nexcavate.Nexcavate;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.BoundingBox;

import java.util.ArrayList;

public class Utils {
    public static void runWithDelay(long period, Runnable... runnables) {
        long currentDelay = 0;
        for (Runnable runnable : runnables) {
            Bukkit.getScheduler().runTaskLater(Nexcavate.instance(), runnable, currentDelay);
            currentDelay += period;
        }
    }

    public static ItemStack getItem(String id) {
        if(id == null || id.equals("AIR") || id.equals("null")) {
            return null;
        }

        SlimefunItem item = SlimefunItem.getById(id);
        if(item != null) {
            return item.getItem();
        }

        Material material = Material.getMaterial(id);
        if(material != null) {
            return new ItemStack(material);
        }

        throw new IllegalArgumentException();
    }

    /**
     * break a block and call the slimefun item handler if applicable by pretending it is exploded
     * will also delete dropped items if asked to
     *
     * @param block block to remove
     * @param removeItems if dropped items should be removed
     */
    public static void removeBlock(Block block, boolean removeItems) {
        SlimefunItem sfItem = BlockStorage.check(block);

        if (sfItem != null && !sfItem.useVanillaBlockBreaking()) {
            sfItem.callItemHandler(BlockBreakHandler.class, handler -> handler.onExplode(block, new ArrayList<>()));
            if (removeItems) {
                BoundingBox bbox = block.getBoundingBox();
                World world = block.getWorld();
                Bukkit.getScheduler().runTaskLater(Nexcavate.instance(), () -> world.getNearbyEntities(bbox).stream().filter(e -> e instanceof Item).forEach(Entity::remove), 1L);
            }
            BlockStorage.clearBlockInfo(block);
        }

        block.setType(Material.AIR);
    }

    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    /**
     * appends strings to an item's lore
     *
     * @param strings the strings of lore to append
     * @return the itemmeta of the item
     */
    public static ItemMeta appendLore(ItemStack item, String... strings) {
        ItemMeta im = item.getItemMeta();
        ArrayList<String> lore = im.hasLore() ? new ArrayList<>(im.getLore()) : new ArrayList<>();
        for (String string : strings) {
            lore.add(color(string));
        }
        im.setLore(lore);
        item.setItemMeta(im);
        return im;
    }
}
