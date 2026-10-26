package me.char321.nexcavate.gui;

import io.github.thebusybiscuit.slimefun4.api.player.PlayerProfile;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuide;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.char321.nexcavate.Nexcavate;
import me.char321.nexcavate.items.ItemStacks;
import me.char321.nexcavate.research.Research;
import me.char321.nexcavate.slimefun.NEAssembly;
import me.char321.nexcavate.slimefun.NEStructure;
import me.char321.nexcavate.structure.Structure;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NEGUI {
    private static final Map<UUID, NEScreens> inventories = new HashMap<>();

    public static void init() {
        Bukkit.getPluginManager().registerEvents(new NEGUIListener(), Nexcavate.instance());
    }

    public static void openResearchScreen(Player p) {
        NEScreens neScreens = inventories.computeIfAbsent(p.getUniqueId(), NEScreens::new);
        ResearchScreenHandler handler = neScreens.researchScreen;
        handler.refresh();
        p.openInventory(handler.getInventory());
    }

    public static void openResearchScreen(Player p, int tier) {
        NEScreens neScreens = inventories.computeIfAbsent(p.getUniqueId(), NEScreens::new);
        ResearchScreenHandler handler = neScreens.researchScreen;
        handler.refresh(tier);
        p.openInventory(handler.getInventory());
    }

    public static void openStructure(Player p, Structure structure, ItemStack display) {
        NEScreens neScreens = inventories.computeIfAbsent(p.getUniqueId(), NEScreens::new);
        StructureScreenHandler handler;
        switch (structure.size) {
            case 3:
                handler = neScreens.structureScreen3;
                break;
            case 4:
                handler = neScreens.structureScreen4;
                break;
            case 5:
                handler = neScreens.structureScreen5;
                break;
            case 6:
                handler = neScreens.structureScreen6;
                break;
            default:
                throw new IllegalArgumentException("Tried to open structure with invalid size!");
        }
        handler.setStructure(structure, display);
        p.openInventory(handler.getInventory());
    }

    public static void openRecipe(Player player, Research research) {
        if (research.getItem() instanceof NEStructure neStructure) {
            openStructure(player, neStructure.getStructure(), new CustomItemStack(Material.STRUCTURE_BLOCK, "&5Estructura", "&7Construye en el mundo todas las capas tal y como se muestran aqui"));
        } else if (research.getItem() instanceof NEAssembly neAssembly) {
            openStructure(player, neAssembly.getStructure(), new CustomItemStack(ItemStacks.BASIC_ASSEMBLER, "&5Montaje", "&7Coloca todas las capas de piezas en la maquina de montaje", "&7y activala para montar el objeto."));
        } else {
            //fallback
            PlayerProfile.get(player, profile -> {
                SlimefunGuide.displayItem(profile, research.getItem(), false);
            });
        }
    }
}
