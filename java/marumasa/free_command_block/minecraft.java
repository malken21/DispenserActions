package marumasa.free_command_block;

import marumasa.free_command_block.commands.blocksoundo;
import org.bukkit.plugin.java.JavaPlugin;

public final class minecraft extends JavaPlugin {

    @Override
    public void onEnable() {
        Config config = new Config(this);
        getServer().getPluginManager().registerEvents(new eventListener(this,config), this);
        getCommand("blocksoundo").setExecutor(new blocksoundo());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}