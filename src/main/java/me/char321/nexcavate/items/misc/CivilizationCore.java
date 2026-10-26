package me.char321.nexcavate.items.misc;

import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import me.char321.nexcavate.slimefun.NEAssembly;
import me.char321.nexcavate.structure.Structure;
import me.char321.nexcavate.util.Utils;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class CivilizationCore extends NEAssembly {
    public CivilizationCore(ItemStack item, String id, Structure assembly) {
        super(item, id, assembly);
    }

    @Override
    public void preRegister() {
        super.preRegister();

        addItemHandler(new BlockPlaceHandler(false) {
            @Override
            public void onPlayerPlace(@Nonnull BlockPlaceEvent e) {
                playCutscene(e.getPlayer());
            }
        });
    }

    private void playCutscene(Player player) {
        player.playSound(player, Sound.BLOCK_END_PORTAL_SPAWN, 1, 1);
        Utils.runWithDelay(80L,
                () -> {
                    player.sendMessage(Utils.color("&dColocas un núcleo de civilización."));
                }, () -> {
                    player.playSound(player, Sound.ENTITY_PIGLIN_RETREAT, 1, 0.5f);
                    player.sendMessage(Utils.color("&9&o¿Qué? ¿Quién me despertó de mi sueño profundo?？"));
                }, () -> {
                    player.playSound(player, Sound.ENTITY_PIGLIN_ADMIRING_ITEM, 1, 0.5f);
                    player.sendMessage(Utils.color("&a&o...¿que es eso?"));
                }, () -> {
                    player.playSound(player, Sound.ENTITY_PIGLIN_RETREAT, 1, 0.5f);
                    player.sendMessage(Utils.color("&9&odice&e" + player.getName()));
                }, () -> {
                    player.playSound(player, Sound.ENTITY_PIGLIN_RETREAT, 1, 0.5f);
                    player.sendMessage(Utils.color("&9&oellos reconstruyeron...nuestra civilización. ¿Son esos nuestros trabajadores de la construcción??"));
                }, () -> {
                    player.playSound(player, Sound.ENTITY_PIGLIN_ADMIRING_ITEM, 1, 0.5f);
                    player.sendMessage(Utils.color("&a&o¿Cómo consiguieron las piezas para construirlo??"));
                }, () -> {
                    player.playSound(player, Sound.ENTITY_PIGLIN_RETREAT, 1, 0.5f);
                    player.sendMessage(Utils.color("&9&oDeben haber viajado desde otro mundo."));
                }, () -> {
                    player.playSound(player, Sound.ENTITY_PIGLIN_ADMIRING_ITEM, 1, 0.5f);
                    player.sendMessage(Utils.color("&a&o¿Viste eso? ¡Te dije que alguien vendría a salvarnos! lo sabía！"));
                }, () -> {
                    player.playSound(player, Sound.ENTITY_PIGLIN_RETREAT, 1, 0.5f);
                    player.sendMessage(Utils.color("&9&oSí, por supuesto. Desde esa extinción masiva, sólo ha sido necesario aproximadamente179000Año。"));
                }, () -> {
                    player.playSound(player, Sound.ENTITY_PIGLIN_ADMIRING_ITEM, 1, 0.5f);
                    player.sendMessage(Utils.color("&a&oBueno, aún deberías estar agradecido. &e" + player.getName() + "&a&onos salvó"));
                }, () -> {
                    player.playSound(player, Sound.ENTITY_PIGLIN_RETREAT, 1, 0.5f);
                    player.sendMessage(Utils.color("&9&oPor supuesto. Me alegro de que nuestra civilización siga existiendo después de miles de años.。"));
                }, () -> {

                }, () -> {
                    player.playSound(player, Sound.MUSIC_DISC_BLOCKS, 1, 1f);
                    player.sendMessage(Utils.color("&e&lcapitulo final"));
                }, () -> {
                    player.sendMessage(Utils.color("&e&lgracias por jugar!"));
                }
        );
    }
}
