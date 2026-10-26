package me.char321.nexcavate.items;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.char321.nexcavate.Nexcavate;
import me.char321.nexcavate.items.assemblers.Assembler;
import me.char321.nexcavate.items.machines.BlackstoneCast;
import me.char321.nexcavate.items.machines.PartExtractor;
import me.char321.nexcavate.items.misc.CivilizationCore;
import me.char321.nexcavate.items.misc.ItemHolder;
import me.char321.nexcavate.items.stations.ResearchStation;
import me.char321.nexcavate.items.tools.RediscoveryPickaxe;
import me.char321.nexcavate.items.tools.loot.LootTables;
import me.char321.nexcavate.slimefun.NEAssembly;
import me.char321.nexcavate.slimefun.NEItem;
import me.char321.nexcavate.structure.Structure;
import me.char321.nexcavate.structure.piece.AnyStructurePiece;
import me.char321.nexcavate.structure.piece.StructurePiece;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

import static me.char321.nexcavate.structure.piece.StructurePiece.mat;
import static me.char321.nexcavate.structure.piece.StructurePiece.sf;
import static me.char321.nexcavate.structure.piece.StructurePiece.u;
import static me.char321.nexcavate.structure.piece.StructurePiece.wrap;
import static org.bukkit.Material.AIR;
import static org.bukkit.Material.BASALT;
import static org.bukkit.Material.BLACKSTONE;
import static org.bukkit.Material.BOOKSHELF;
import static org.bukkit.Material.CARTOGRAPHY_TABLE;
import static org.bukkit.Material.CAULDRON;
import static org.bukkit.Material.CHISELED_POLISHED_BLACKSTONE;
import static org.bukkit.Material.CHISELED_QUARTZ_BLOCK;
import static org.bukkit.Material.CONDUIT;
import static org.bukkit.Material.CYAN_STAINED_GLASS;
import static org.bukkit.Material.END_ROD;
import static org.bukkit.Material.FLETCHING_TABLE;
import static org.bukkit.Material.GRAY_STAINED_GLASS;
import static org.bukkit.Material.IRON_BLOCK;
import static org.bukkit.Material.LANTERN;
import static org.bukkit.Material.MAGMA_BLOCK;
import static org.bukkit.Material.NETHERITE_BLOCK;
import static org.bukkit.Material.NETHER_BRICKS;
import static org.bukkit.Material.POLISHED_BLACKSTONE_BRICKS;
import static org.bukkit.Material.POLISHED_BLACKSTONE_BRICK_SLAB;
import static org.bukkit.Material.POLISHED_BLACKSTONE_BRICK_STAIRS;
import static org.bukkit.Material.QUARTZ_PILLAR;
import static org.bukkit.Material.RED_NETHER_BRICKS;
import static org.bukkit.Material.SEA_LANTERN;
import static org.bukkit.Material.SMOOTH_QUARTZ;
import static org.bukkit.Material.SMOOTH_QUARTZ_SLAB;
import static org.bukkit.Material.SMOOTH_QUARTZ_STAIRS;
import static org.bukkit.Material.SOUL_LANTERN;
import static org.bukkit.Material.TARGET;
import static org.bukkit.Material.WHITE_STAINED_GLASS;
import static org.bukkit.Material.WHITE_STAINED_GLASS_PANE;

public class Items {
    public static final ItemGroup DUMMY_GROUP = new ItemGroup(Nexcavate.key("dummy"), new ItemStack(Material.BARRIER)) {
        @Override
        public boolean isHidden(@Nonnull Player p) {
            return true;
        }
    };
    public static final RecipeType DUMMY_TYPE = new RecipeType(Nexcavate.key("invalid"), new CustomItemStack(
            Material.BARRIER,
            "&l&4Recetas actualmente no disponibles!",
            "&7Consulte la receta a través del Escritorio de investigación de civilizaciones."));

    public static ResearchStation RESEARCH_LAB;
    public static ResearchStation RESEARCH_TABLE;

    public static RediscoveryPickaxe REDISCOVERY_PICKAXE;
    public static RediscoveryPickaxe PART_DRILL;

    public static Assembler BASIC_ASSEMBLER;
    public static Assembler ADVANCED_ASSEMBLER;

    public static BlackstoneCast BLACKSTONE_CAST;
    public static PartExtractor PART_EXTRACTOR;
    public static PartExtractor PART_EXTRACTOR_2;

    public static ItemHolder ITEM_HOLDER;

    public static NEItem ANCIENT_PART;
    public static NEAssembly UPGRADE_CORE;

    public static CivilizationCore CIVILIZATION_CORE;

    public static void init() {
        StructurePiece lantern = u(new CustomItemStack(LANTERN, "linterna/Linterna del alma"), mat(LANTERN), mat(SOUL_LANTERN));
        RESEARCH_TABLE = new ResearchStation(ItemStacks.RESEARCH_TABLE, "NE_RESEARCH_TABLE", new Structure(new StructurePiece[][][]{
                {
                        {mat(SMOOTH_QUARTZ), mat(SMOOTH_QUARTZ), mat(SMOOTH_QUARTZ)},
                        {mat(SMOOTH_QUARTZ), mat(NETHERITE_BLOCK), mat(SMOOTH_QUARTZ)},
                        {mat(SMOOTH_QUARTZ_STAIRS), mat(SMOOTH_QUARTZ_STAIRS), mat(SMOOTH_QUARTZ_STAIRS)}
                }, {
                        {mat(BOOKSHELF), mat(CARTOGRAPHY_TABLE), mat(BOOKSHELF)},
                        {mat(END_ROD), mat(AIR), mat(END_ROD)},
                        {mat(AIR), mat(AIR), mat(AIR)}
                }, {
                        {lantern, mat(AIR), lantern},
                        {mat(SMOOTH_QUARTZ_SLAB), mat(AIR), mat(SMOOTH_QUARTZ_SLAB)},
                        {mat(AIR), mat(AIR), mat(AIR)}
                }
        }, new int[]{1, 0, 1}), 1);
        RESEARCH_TABLE.register();

        RESEARCH_LAB = new ResearchStation(ItemStacks.RESEARCH_LAB, "NE_RESEARCH_LAB", new Structure(new StructurePiece[][][]{
                {
                        {mat(SMOOTH_QUARTZ), mat(SMOOTH_QUARTZ), mat(SMOOTH_QUARTZ), mat(SMOOTH_QUARTZ)},
                        {mat(SMOOTH_QUARTZ), mat(NETHERITE_BLOCK), mat(NETHERITE_BLOCK), mat(SMOOTH_QUARTZ)},
                        {mat(SMOOTH_QUARTZ), mat(NETHERITE_BLOCK), mat(NETHERITE_BLOCK), mat(SMOOTH_QUARTZ)},
                        {mat(SMOOTH_QUARTZ), mat(SMOOTH_QUARTZ), mat(SMOOTH_QUARTZ), mat(SMOOTH_QUARTZ)},
                }, {
                        {mat(SMOOTH_QUARTZ), mat(FLETCHING_TABLE), sf("NE_UPGRADE_CORE"), mat(SMOOTH_QUARTZ)},
                        {mat(WHITE_STAINED_GLASS_PANE), mat(AIR), mat(AIR), mat(WHITE_STAINED_GLASS_PANE)},
                        {mat(WHITE_STAINED_GLASS_PANE), mat(AIR), mat(AIR), mat(WHITE_STAINED_GLASS_PANE)},
                        {mat(WHITE_STAINED_GLASS_PANE), mat(AIR), mat(AIR), mat(WHITE_STAINED_GLASS_PANE)},
                }, {
                        {mat(SMOOTH_QUARTZ), mat(BASALT), mat(BASALT), mat(SMOOTH_QUARTZ)},
                        {mat(WHITE_STAINED_GLASS_PANE), mat(AIR), mat(AIR), mat(WHITE_STAINED_GLASS_PANE)},
                        {mat(WHITE_STAINED_GLASS_PANE), mat(AIR), mat(AIR), mat(WHITE_STAINED_GLASS_PANE)},
                        {mat(WHITE_STAINED_GLASS_PANE), mat(AIR), mat(AIR), mat(WHITE_STAINED_GLASS_PANE)},
                }, {
                        {mat(SMOOTH_QUARTZ), mat(SMOOTH_QUARTZ), mat(SMOOTH_QUARTZ), mat(SMOOTH_QUARTZ)},
                        {mat(WHITE_STAINED_GLASS), mat(SEA_LANTERN), mat(SEA_LANTERN), mat(WHITE_STAINED_GLASS)},
                        {mat(WHITE_STAINED_GLASS), mat(SEA_LANTERN), mat(SEA_LANTERN), mat(WHITE_STAINED_GLASS)},
                        {mat(WHITE_STAINED_GLASS), mat(WHITE_STAINED_GLASS), mat(WHITE_STAINED_GLASS), mat(WHITE_STAINED_GLASS)},
                }
        }, new int[]{1, 0, 1}), 2);
        RESEARCH_LAB.register();

        //research facility smithing

        ItemStack pbb = new ItemStack(Material.POLISHED_BLACKSTONE_BRICKS);
        ItemStack stick = new ItemStack(Material.STICK);
        REDISCOVERY_PICKAXE = new RediscoveryPickaxe(ItemStacks.REDISCOVERY_PICKAXE, "NE_REDISCOVERY_PICKAXE", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                pbb, SlimefunItems.PICKAXE_OF_THE_SEEKER, pbb,
                null, stick, null,
                null, stick, null
        }, LootTables.REDISCOVERY_PICKAXE);
        REDISCOVERY_PICKAXE.register();

        PART_DRILL = new RediscoveryPickaxe(ItemStacks.PART_DRILL, "NE_PART_DRILL", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                ItemStacks.ANCIENT_PART, ItemStacks.REDISCOVERY_PICKAXE, ItemStacks.ANCIENT_PART,
                null, ItemStacks.UPGRADE_CORE, null,
                null, ItemStacks.UPGRADE_CORE, null
        }, LootTables.PART_DRILL);
        PART_DRILL.register();

        StructurePiece any = new AnyStructurePiece();
        StructurePiece extension = u(new CustomItemStack(POLISHED_BLACKSTONE_BRICKS, "Piezas de la máquina de montaje", "&7Cualquier pieza de montaje o ladrillos de piedra negra pulida"), mat(POLISHED_BLACKSTONE_BRICKS));
        BASIC_ASSEMBLER = new Assembler(ItemStacks.BASIC_ASSEMBLER, "NE_BASIC_ASSEMBLER", new Structure(new StructurePiece[][][]{
                {
                        {extension, extension, extension, extension, extension},
                        {extension, mat(CHISELED_POLISHED_BLACKSTONE), mat(CHISELED_POLISHED_BLACKSTONE), mat(CHISELED_POLISHED_BLACKSTONE), extension},
                        {extension, mat(CHISELED_POLISHED_BLACKSTONE), mat(NETHERITE_BLOCK), mat(CHISELED_POLISHED_BLACKSTONE), extension},
                        {extension, mat(CHISELED_POLISHED_BLACKSTONE), mat(CHISELED_POLISHED_BLACKSTONE), mat(CHISELED_POLISHED_BLACKSTONE), extension},
                        {extension, extension, mat(CHISELED_QUARTZ_BLOCK), extension, extension}
                }, {
                        {mat(BLACKSTONE), mat(GRAY_STAINED_GLASS), mat(GRAY_STAINED_GLASS), mat(GRAY_STAINED_GLASS), mat(BLACKSTONE)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(BLACKSTONE), mat(AIR), mat(AIR), mat(AIR), mat(BLACKSTONE)},
                }, {
                        {mat(BLACKSTONE), mat(GRAY_STAINED_GLASS), mat(GRAY_STAINED_GLASS), mat(GRAY_STAINED_GLASS), mat(BLACKSTONE)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(BLACKSTONE), mat(AIR), mat(AIR), mat(AIR), mat(BLACKSTONE)},
                }, {
                        {mat(BLACKSTONE), mat(GRAY_STAINED_GLASS), mat(GRAY_STAINED_GLASS), mat(GRAY_STAINED_GLASS), mat(BLACKSTONE)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(BLACKSTONE), mat(AIR), mat(AIR), mat(AIR), mat(BLACKSTONE)},
                }, {
                        {mat(POLISHED_BLACKSTONE_BRICK_SLAB), mat(POLISHED_BLACKSTONE_BRICK_STAIRS), mat(POLISHED_BLACKSTONE_BRICK_STAIRS), mat(POLISHED_BLACKSTONE_BRICK_STAIRS), mat(POLISHED_BLACKSTONE_BRICK_SLAB)},
                        {mat(POLISHED_BLACKSTONE_BRICK_STAIRS), mat(CHISELED_POLISHED_BLACKSTONE), mat(CHISELED_POLISHED_BLACKSTONE), mat(CHISELED_POLISHED_BLACKSTONE), mat(POLISHED_BLACKSTONE_BRICK_STAIRS)},
                        {mat(POLISHED_BLACKSTONE_BRICK_STAIRS), mat(CHISELED_POLISHED_BLACKSTONE), mat(NETHERITE_BLOCK), mat(CHISELED_POLISHED_BLACKSTONE), mat(POLISHED_BLACKSTONE_BRICK_STAIRS)},
                        {mat(POLISHED_BLACKSTONE_BRICK_STAIRS), mat(CHISELED_POLISHED_BLACKSTONE), mat(CHISELED_POLISHED_BLACKSTONE), mat(CHISELED_POLISHED_BLACKSTONE), mat(POLISHED_BLACKSTONE_BRICK_STAIRS)},
                        {mat(POLISHED_BLACKSTONE_BRICK_SLAB), mat(POLISHED_BLACKSTONE_BRICK_STAIRS), mat(POLISHED_BLACKSTONE_BRICK_STAIRS), mat(POLISHED_BLACKSTONE_BRICK_STAIRS), mat(POLISHED_BLACKSTONE_BRICK_SLAB)},
                }

        }, new int[]{0, 4, 2}));
        BASIC_ASSEMBLER.register();
        ADVANCED_ASSEMBLER = new Assembler(ItemStacks.ADVANCED_ASSEMBLER, "NE_ADVANCED_ASSEMBLER", new Structure(new StructurePiece[][][]{
                {
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS)},
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(CHISELED_POLISHED_BLACKSTONE), mat(CHISELED_POLISHED_BLACKSTONE), mat(CHISELED_POLISHED_BLACKSTONE), mat(CHISELED_POLISHED_BLACKSTONE), mat(POLISHED_BLACKSTONE_BRICKS)},
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(CHISELED_POLISHED_BLACKSTONE), mat(NETHERITE_BLOCK), mat(NETHERITE_BLOCK), mat(CHISELED_POLISHED_BLACKSTONE), mat(POLISHED_BLACKSTONE_BRICKS)},
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(CHISELED_POLISHED_BLACKSTONE), mat(NETHERITE_BLOCK), mat(NETHERITE_BLOCK), mat(CHISELED_POLISHED_BLACKSTONE), mat(POLISHED_BLACKSTONE_BRICKS)},
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(CHISELED_POLISHED_BLACKSTONE), mat(CHISELED_POLISHED_BLACKSTONE), mat(CHISELED_POLISHED_BLACKSTONE), mat(CHISELED_POLISHED_BLACKSTONE), mat(POLISHED_BLACKSTONE_BRICKS)},
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(QUARTZ_PILLAR), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS)},
                },
                {
                        {mat(BLACKSTONE), mat(GRAY_STAINED_GLASS), mat(GRAY_STAINED_GLASS), mat(GRAY_STAINED_GLASS), mat(GRAY_STAINED_GLASS), mat(BLACKSTONE)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(BLACKSTONE), mat(AIR), mat(AIR), mat(AIR), mat(AIR), mat(BLACKSTONE)}
                },
                {
                        {mat(BLACKSTONE), mat(GRAY_STAINED_GLASS), mat(GRAY_STAINED_GLASS), mat(GRAY_STAINED_GLASS), mat(GRAY_STAINED_GLASS), mat(BLACKSTONE)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(BLACKSTONE), mat(AIR), mat(AIR), mat(AIR), mat(AIR), mat(BLACKSTONE)}
                },
                {
                        {mat(BLACKSTONE), mat(GRAY_STAINED_GLASS), mat(GRAY_STAINED_GLASS), mat(GRAY_STAINED_GLASS), mat(GRAY_STAINED_GLASS), mat(BLACKSTONE)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(BLACKSTONE), mat(AIR), mat(AIR), mat(AIR), mat(AIR), mat(BLACKSTONE)}
                },
                {
                        {mat(BLACKSTONE), mat(GRAY_STAINED_GLASS), mat(GRAY_STAINED_GLASS), mat(GRAY_STAINED_GLASS), mat(GRAY_STAINED_GLASS), mat(BLACKSTONE)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(GRAY_STAINED_GLASS), any, any, any, any, mat(GRAY_STAINED_GLASS)},
                        {mat(BLACKSTONE), mat(AIR), mat(AIR), mat(AIR), mat(AIR), mat(BLACKSTONE)}
                },
                {
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS)},
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS)},
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), sf("NE_UPGRADE_CORE"), sf("NE_UPGRADE_CORE"), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS)},
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), sf("NE_UPGRADE_CORE"), sf("NE_UPGRADE_CORE"), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS)},
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS)},
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS)},
                }
        }, new int[]{0, 5, 3}));
        ADVANCED_ASSEMBLER.setNetherRequired(true);
        ADVANCED_ASSEMBLER.register();

        StructurePiece ancientPart = wrap(ItemStacks.ANCIENT_PART);
        BLACKSTONE_CAST = new BlackstoneCast(ItemStacks.BLACKSTONE_CAST, "NE_BLACKSTONE_CAST", new Structure(new StructurePiece[][][]{
                {
                        {ancientPart, mat(AIR), ancientPart},
                        {mat(AIR), mat(AIR), mat(AIR)},
                        {ancientPart, mat(AIR), ancientPart}
                },
                {
                        {mat(IRON_BLOCK), mat(IRON_BLOCK), mat(IRON_BLOCK)},
                        {mat(IRON_BLOCK), mat(CAULDRON), mat(IRON_BLOCK)},
                        {mat(IRON_BLOCK), mat(IRON_BLOCK), mat(IRON_BLOCK)}
                },
                {
                        {mat(IRON_BLOCK), mat(IRON_BLOCK), mat(IRON_BLOCK)},
                        {mat(IRON_BLOCK), mat(AIR), mat(IRON_BLOCK)},
                        {mat(IRON_BLOCK), mat(IRON_BLOCK), mat(IRON_BLOCK)}
                }
        }, new int[]{0, 0, 0}), 12, 12);
        BLACKSTONE_CAST.register();

        PART_EXTRACTOR = new PartExtractor(ItemStacks.PART_EXTRACTOR, "NE_PART_EXTRACTOR", new Structure(new StructurePiece[][][]{
                {
                        {mat(NETHER_BRICKS), mat(NETHER_BRICKS), mat(NETHER_BRICKS)},
                        {mat(NETHER_BRICKS), mat(RED_NETHER_BRICKS), mat(NETHER_BRICKS)},
                        {mat(NETHER_BRICKS), mat(NETHER_BRICKS), mat(NETHER_BRICKS)}
                }, {
                        {mat(RED_NETHER_BRICKS), ancientPart, mat(RED_NETHER_BRICKS)},
                        {ancientPart, ancientPart, ancientPart},
                        {mat(RED_NETHER_BRICKS), ancientPart, mat(RED_NETHER_BRICKS)}
                },
                {
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS)},
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(RED_NETHER_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS)},
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS)}
                }
        }, new int[]{0, 0, 0}), 12, 6, 3);
        PART_EXTRACTOR.register();
        PART_EXTRACTOR_2 = new PartExtractor(ItemStacks.PART_EXTRACTOR_2, "NE_PART_EXTRACTOR_2", new Structure(new StructurePiece[][][]{
                {
                        {mat(NETHER_BRICKS), mat(NETHER_BRICKS), mat(NETHER_BRICKS), mat(NETHER_BRICKS)},
                        {mat(NETHER_BRICKS), mat(NETHER_BRICKS), mat(NETHER_BRICKS), mat(NETHER_BRICKS)},
                        {mat(NETHER_BRICKS), mat(NETHER_BRICKS), mat(NETHER_BRICKS), mat(NETHER_BRICKS)},
                        {mat(NETHER_BRICKS), mat(NETHER_BRICKS), mat(NETHER_BRICKS), mat(NETHER_BRICKS)},
                },
                {
                        {ancientPart, mat(AIR), mat(AIR), ancientPart},
                        {mat(AIR), sf("NE_PART_EXTRACTOR"), sf("NE_UPGRADE_CORE"), mat(AIR)},
                        {mat(AIR), mat(AIR), mat(AIR), mat(AIR)},
                        {ancientPart, mat(AIR), mat(AIR), ancientPart}
                },
                {
                        {ancientPart, mat(AIR), mat(AIR), ancientPart},
                        {mat(AIR), mat(AIR), mat(AIR), mat(AIR)},
                        {mat(AIR), mat(AIR), mat(AIR), mat(AIR)},
                        {ancientPart, mat(AIR), mat(AIR), ancientPart},
                },
                {
                        {mat(NETHER_BRICKS), mat(NETHER_BRICKS), mat(NETHER_BRICKS), mat(NETHER_BRICKS)},
                        {mat(NETHER_BRICKS), mat(NETHER_BRICKS), mat(NETHER_BRICKS), mat(NETHER_BRICKS)},
                        {mat(NETHER_BRICKS), mat(NETHER_BRICKS), mat(NETHER_BRICKS), mat(NETHER_BRICKS)},
                        {mat(NETHER_BRICKS), mat(NETHER_BRICKS), mat(NETHER_BRICKS), mat(NETHER_BRICKS)},
                }
        }), 24, 12, 1);
        PART_EXTRACTOR_2.register();

        ITEM_HOLDER = new ItemHolder(ItemStacks.ITEM_HOLDER, "NE_ITEM_HOLDER", new Structure(new StructurePiece[][][]{
                {
                        {mat(AIR), mat(AIR), mat(AIR)},
                        {mat(AIR), mat(CYAN_STAINED_GLASS), mat(AIR)},
                        {mat(AIR), mat(AIR), mat(AIR)}
                }, {
                        {mat(AIR), mat(CYAN_STAINED_GLASS), mat(AIR)},
                        {mat(CYAN_STAINED_GLASS), mat(AIR), mat(CYAN_STAINED_GLASS)},
                        {mat(AIR), mat(CYAN_STAINED_GLASS), mat(AIR)},
                }, {
                        {mat(AIR), mat(AIR), mat(AIR)},
                        {mat(AIR), mat(CYAN_STAINED_GLASS), mat(AIR)},
                        {mat(AIR), mat(AIR), mat(AIR)}
                },
        }, new int[]{0, 0, 0}));
        ITEM_HOLDER.setRecipeOutput(new CustomItemStack(ItemStacks.ITEM_HOLDER, 6));
        ITEM_HOLDER.register();

        ANCIENT_PART = new NEItem(ItemStacks.ANCIENT_PART, "NE_ANCIENT_PART");
        ANCIENT_PART.register();

        UPGRADE_CORE = new NEAssembly(ItemStacks.UPGRADE_CORE, "NE_UPGRADE_CORE", new Structure(new StructurePiece[][][]{
                {
                        {ancientPart, mat(POLISHED_BLACKSTONE_BRICKS), ancientPart},
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(NETHER_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS)},
                        {ancientPart, mat(POLISHED_BLACKSTONE_BRICKS), ancientPart},
                },
                {
                        {mat(NETHER_BRICKS), mat(AIR), mat(NETHER_BRICKS)},
                        {mat(AIR), mat(TARGET), mat(AIR)},
                        {mat(NETHER_BRICKS), mat(AIR), mat(NETHER_BRICKS)}
                },
                {
                        {ancientPart, mat(POLISHED_BLACKSTONE_BRICKS), ancientPart},
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(NETHER_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS)},
                        {ancientPart, mat(POLISHED_BLACKSTONE_BRICKS), ancientPart},
                }
        }));
        UPGRADE_CORE.register();

        CIVILIZATION_CORE = new CivilizationCore(ItemStacks.CIVILIZATION_CORE, "NE_CIVILIZATION_CORE", new Structure(new StructurePiece[][][]{
                {
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(NETHER_BRICKS), mat(NETHER_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS)},
                        {mat(NETHER_BRICKS), mat(MAGMA_BLOCK), mat(MAGMA_BLOCK), mat(NETHER_BRICKS)},
                        {mat(NETHER_BRICKS), mat(MAGMA_BLOCK), mat(MAGMA_BLOCK), mat(NETHER_BRICKS)},
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(NETHER_BRICKS), mat(NETHER_BRICKS), mat(POLISHED_BLACKSTONE_BRICKS)}
                },
                {
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(AIR), mat(AIR), mat(POLISHED_BLACKSTONE_BRICKS)},
                        {mat(AIR), sf("NE_BLACKSTONE_CAST"), sf("NE_BLACKSTONE_CAST"), mat(AIR)},
                        {mat(AIR), sf("NE_BLACKSTONE_CAST"), sf("NE_BLACKSTONE_CAST"), mat(AIR)},
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(AIR), mat(AIR), mat(POLISHED_BLACKSTONE_BRICKS)},
                },
                {
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(AIR), mat(AIR), mat(POLISHED_BLACKSTONE_BRICKS)},
                        {mat(AIR), sf("NE_PART_EXTRACTOR_2"), sf("NE_PART_EXTRACTOR_2"), mat(AIR)},
                        {mat(AIR), sf("NE_PART_EXTRACTOR_2"), sf("NE_PART_EXTRACTOR_2"), mat(AIR)},
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(AIR), mat(AIR), mat(POLISHED_BLACKSTONE_BRICKS)},
                },
                {
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(AIR), mat(AIR), mat(POLISHED_BLACKSTONE_BRICKS)},
                        {mat(AIR), mat(CONDUIT), mat(CONDUIT), mat(AIR)},
                        {mat(AIR), mat(CONDUIT), mat(CONDUIT), mat(AIR)},
                        {mat(POLISHED_BLACKSTONE_BRICKS), mat(AIR), mat(AIR), mat(POLISHED_BLACKSTONE_BRICKS)},
                }
        }));
        CIVILIZATION_CORE.register();
    }

}
