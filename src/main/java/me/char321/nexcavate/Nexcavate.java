package me.char321.nexcavate;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.char321.nexcavate.command.NexcavateCommand;
import me.char321.nexcavate.gui.NEGUI;
import me.char321.nexcavate.items.Items;
import me.char321.nexcavate.listener.Listeners;
import me.char321.nexcavate.research.Researches;
import me.char321.nexcavate.research.progress.AutoSaveTask;
import me.char321.nexcavate.research.progress.ProgressManager;
import me.char321.nexcavate.research.progress.ResearchUpdateTask;
import me.char321.nexcavate.slimefun.NEItemGroup;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.logging.Level;

public final class Nexcavate extends JavaPlugin implements SlimefunAddon {
    private static Nexcavate instance;
    private NexcavateRegistry registry;
    private ProgressManager progressManager;

    public Nexcavate() {
        instance = this;
    }

    public static Nexcavate instance() {
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        registry = new NexcavateRegistry();
        progressManager = new ProgressManager();

        getCommand("nexcavate").setExecutor(new NexcavateCommand(this));

        Listeners.init();
        NEGUI.init();
        Items.init();
        Researches.init();
        NEItemGroup.init();

        AutoSaveTask.init();
        ResearchUpdateTask.init();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        save();
    }

    public void save() {
        try {
            Nexcavate.instance().getProgressManager().save();
        } catch (IOException e) {
            Nexcavate.instance().getLogger().log(Level.SEVERE, e, () -> "Could not save player progress");
            e.printStackTrace();
        }
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/DrakesCraft-Labs/Nexcavate/issues";
    }

    public NexcavateRegistry getRegistry() {
        return registry;
    }

    public ProgressManager getProgressManager() {
        return progressManager;
    }

    @Nonnull
    public static NamespacedKey key(@Nonnull String key) {
        return new NamespacedKey(instance, key);
    }

    public static void info(String msg) {
        instance.getLogger().info(msg);
    }
}
