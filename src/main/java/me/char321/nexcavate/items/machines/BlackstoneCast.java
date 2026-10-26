package me.char321.nexcavate.items.machines;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.implementation.handlers.SimpleBlockBreakHandler;
import me.char321.nexcavate.items.ItemStacks;
import me.char321.nexcavate.slimefun.NEAssembly;
import me.char321.nexcavate.structure.Structure;
import me.char321.nexcavate.util.Utils;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class BlackstoneCast extends NEAssembly implements EnergyNetComponent {
    private static final int[] BACKGROUND = {0, 1, 2, 6, 7, 8, 9, 10, 11, 15, 16, 17, 18, 19, 20, 24, 25, 26};
    private static final int[] SLOT_BORDER = {3, 4, 5, 12, 14, 21, 22, 23};
    private static final int SLOT = 13;

    private int capacity;
    private int consumption;

    public BlackstoneCast(ItemStack item, String id, Structure assembly, int capacity, int consumption) {
        super(item, id, assembly);
        this.capacity = capacity;
        this.consumption = consumption;
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
        }, new BlockPlaceHandler(true) {
            @Override
            public void onPlayerPlace(@Nonnull BlockPlaceEvent e) {
                if (!e.getBlock().getWorld().getEnvironment().equals(World.Environment.NETHER)) {
                    e.getPlayer().sendMessage(ChatColor.RED + "Esta maquina no funciona aqui. Prueba en el Nether.");
                    e.setCancelled(true);
                    Utils.removeBlock(e.getBlock(), true);
                }
            }
        }, new BlockTicker() {
            @Override
            public boolean isSynchronized() {
                return false;
            }

            @Override
            public void tick(Block b, SlimefunItem item, Config config) {
                Block fluid = b.getRelative(BlockFace.DOWN);

                if (fluid.getType().equals(Material.LAVA) && fluid.getBlockData() instanceof Levelled data && data.getLevel() == 0 && getCharge(b.getLocation()) >= consumption) {
                    BlockMenu menu = BlockStorage.getInventory(b);

                    ItemStack blackstone = new ItemStack(Material.BLACKSTONE);
                    if (!menu.fits(blackstone, SLOT)) {
                        return;
                    }

                    removeCharge(b.getLocation(), consumption);
                    menu.pushItem(blackstone, SLOT);
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
                if (flow.equals(ItemTransportFlow.WITHDRAW)) {
                    return new int[]{SLOT};
                }
                return new int[]{};
            }
        };
    }

    @Nonnull
    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }
}
