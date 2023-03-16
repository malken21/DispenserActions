package marumasa.free_command_block.config;

import marumasa.free_command_block.minecraft;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    public final playSoundConfig playSound;
    public final stopSoundConfig stopSound;


    public Config(minecraft plugin) {
        plugin.saveDefaultConfig();
        FileConfiguration config = plugin.getConfig();

        playSound = new playSoundConfig(config);
        stopSound = new stopSoundConfig(config);
    }
}