package marumasa.free_command_block;

import marumasa.free_command_block.commands.blocksoundo;
import org.bukkit.plugin.java.JavaPlugin;

public final class minecraft extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new eventListener(this), this);
        getCommand("blocksoundo").setExecutor(new blocksoundo());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}