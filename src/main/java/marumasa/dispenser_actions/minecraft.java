package marumasa.dispenser_actions;

import marumasa.dispenser_actions.config.Config;
import org.bukkit.plugin.java.JavaPlugin;

public final class minecraft extends JavaPlugin {

    @Override
    public void onEnable() {
        Config config = new Config(this);
        getServer().getPluginManager().registerEvents(new Events(this,config), this);
        //getCommand("blocksoundo").setExecutor(new blocksoundo());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}