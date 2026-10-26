package me.char321.nexcavate.items;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ItemStacks {
    public static final ItemStack RESEARCH_TABLE = new CustomItemStack(Material.CARTOGRAPHY_TABLE, "&eEstación de investigación de la civilización", "&7Le permite investigar elementos básicos.");
    public static final ItemStack RESEARCH_LAB = new CustomItemStack(Material.FLETCHING_TABLE, "&eLaboratorio de investigación de civilizaciones", "&7Le permite investigar elementos avanzados.");

    public static final ItemStack REDISCOVERY_PICKAXE = new SlimefunItemStack("NE_REDISCOVERY_PICKAXE", Material.WOODEN_PICKAXE, "&epico arqueológico", im -> {
        im.setLore(List.of(ChatColor.GRAY + "Herramientas básicas para extraer piezas antiguas."));
        im.addEnchant(Enchantment.UNBREAKING, 2, false);
        im.addEnchant(Enchantment.EFFICIENCY, 1, false);
    });
    public static final ItemStack PART_DRILL = new SlimefunItemStack("NE_PART_DRILL", Material.DIAMOND_PICKAXE, "&cbroca arqueológica", im -> {
        im.setLore(List.of(ChatColor.GRAY + "Herramientas avanzadas para extraer piezas antiguas"));
        im.addEnchant(Enchantment.UNBREAKING, 3, false);
        im.addEnchant(Enchantment.EFFICIENCY, 5, false);
        im.addEnchant(Enchantment.MENDING, 1, false);
    });

    public static final ItemStack BLACKSTONE_CAST = new SlimefunItemStack("NE_BLACKSTONE_CAST", Material.CAULDRON, "&emaquina de extraccion de piedra negra", "&7Extraer magma automáticamente", "&7Cuando se activa, se puede lanzar a la piedra negra de forma indefinida.", "&7Debe colocarse en la fuente de magma en el fondo.", "", LoreBuilder.powerPerSecond(24));
    public static final ItemStack PART_EXTRACTOR = new SlimefunItemStack("NE_PART_EXTRACTOR", Material.RED_NETHER_BRICKS, "&emáquina de extracción de piezas", "&7Extrayendo lentamente piezas antiguas de piedra negra", "", "&7Debe colocarse en el Nether", "", LoreBuilder.powerPerSecond(12));
    public static final ItemStack PART_EXTRACTOR_2 = new SlimefunItemStack("NE_PART_EXTRACTOR_2", Material.CHISELED_NETHER_BRICKS, "&dMáquina de extracción de piezas avanzada", "&7Extraiga piezas antiguas de Blackstone más rápido", "", "&7Debe colocarse en el Nether", "", LoreBuilder.powerPerSecond(24));

    public static final ItemStack ITEM_HOLDER = new SlimefunItemStack("NE_ITEM_HOLDER", Material.CYAN_STAINED_GLASS, "&fSoporte de piezas", "&7Sujeta una pieza para el montaje", "&7Lo que dejes en el soporte lo usa la maquina de montaje.");

    public static final ItemStack BASIC_ASSEMBLER = new CustomItemStack(Material.CHISELED_QUARTZ_BLOCK, "&eMaquina de montaje basica", "&7Monta piezas dentro de un area de 3x3x3 bloques");
    public static final ItemStack ADVANCED_ASSEMBLER = new CustomItemStack(Material.QUARTZ_PILLAR, "&dMáquina de montaje avanzada", "&7Monta piezas dentro de un area de 4x4x4 bloques", "&8Sólo funciona en el Nether");

    public static final ItemStack ANCIENT_PART = new SlimefunItemStack("NE_ANCIENT_PART", Material.NETHER_BRICK, "&epartes antiguas", "&7Reliquias de civilizaciones antiguas.");
    public static final ItemStack UPGRADE_CORE = new SlimefunItemStack("NE_UPGRADE_CORE", Material.TARGET, "&eNúcleo de actualización antiguo", "&7Productos sobrantes de la civilización avanzada.");

    public static final ItemStack CIVILIZATION_CORE = new SlimefunItemStack("NE_CIVILIZATION_CORE", Material.CONDUIT, "&bnúcleo de civilización", "&dGuarda objetos de la antigua civilizacion del Nether.", "&dsolía despertar &kasdfg hijklmn &dcivilización");

    public static class Menu {
        public static final ItemStack BLACK = new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, " ");
    }
}
