package marumasa.free_command_block;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    public final String playSound_text_sound;
    public final String playSound_text_volume;
    public final String playSound_text_pitch;

    public final String playSound_colour_sound;
    public final String playSound_colour_volume;
    public final String playSound_colour_pitch;

    public final float playSound_maxVolume;
    public final float playSound_maxPitch;

    public Config(minecraft plugin) {
        plugin.saveDefaultConfig();
        FileConfiguration config = plugin.getConfig();

        playSound_text_sound = config.getString("playSound.lore.text.sound");
        playSound_text_volume = config.getString("playSound.lore.text.volume");
        playSound_text_pitch = config.getString("playSound.lore.text.pitch");

        playSound_colour_sound = config.getString("playSound.lore.colour.sound");
        playSound_colour_volume = config.getString("playSound.lore.colour.volume");
        playSound_colour_pitch = config.getString("playSound.lore.colour.pitch");

        playSound_maxVolume = (float) config.getDouble("playSound.maxVolume");
        playSound_maxPitch = (float) config.getDouble("playSound.maxPitch");
    }
}