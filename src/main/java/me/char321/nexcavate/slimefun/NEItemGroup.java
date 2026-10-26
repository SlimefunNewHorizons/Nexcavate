package me.char321.nexcavate.slimefun;

import io.github.thebusybiscuit.slimefun4.api.items.groups.FlexItemGroup;
import io.github.thebusybiscuit.slimefun4.api.player.PlayerProfile;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideMode;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.char321.nexcavate.Nexcavate;
import me.char321.nexcavate.gui.NEGUI;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

public class NEItemGroup extends FlexItemGroup {
    public static void init() {
        ItemStack groupitem = new CustomItemStack(Material.BLACKSTONE, "&5Renacimiento de la civilización", "&7Comienza tu viaje para reconstruir la civilización.");
        NEItemGroup group = new NEItemGroup(Nexcavate.key("nexcavate"), groupitem);
        group.register(Nexcavate.instance());
    }

    protected NEItemGroup(NamespacedKey key, ItemStack item) {
        super(key, item);
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean isVisible(Player p, PlayerProfile profile, SlimefunGuideMode layout) {
        return true;
    }

    @Override
    public void open(Player p, PlayerProfile profile, SlimefunGuideMode layout) {
        NEGUI.openResearchScreen(p, 0);
    }
}
