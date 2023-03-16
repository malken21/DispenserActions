package marumasa.free_command_block.data;

import marumasa.free_command_block.config.Config;
import marumasa.free_command_block.minecraft;
import marumasa.free_command_block.util.dispenser.stop;
import marumasa.free_command_block.util.sound.SoundType;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Location;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Float.isNaN;

public class SoundPlay {

    public String sound;
    public float volume;
    public float pitch;
    public SoundCategory category;

    public SoundPlay(ItemMeta itemMeta, Config config) {

        List<Component> loreList = itemMeta.lore();
        if (loreList == null) return;

        final Map<String, String> data = new LinkedHashMap<>() {
            {
                put(config.playSound.Sound, null);
                put(config.playSound.Volume, null);
                put(config.playSound.Pitch, null);
                put(config.playSound.Category, null);
            }
        };

        final int size = data.size();
        if (loreList.size() != size) return;

        final List<String> keyList = new ArrayList<>(data.keySet());
        final PlainTextComponentSerializer plainText = PlainTextComponentSerializer.plainText();

        for (int loop = 0; loop < data.size(); loop++) {

            final String key = keyList.get(loop);

            final String[] text = plainText.serialize(loreList.get(loop)).split(key);

            if (text.length != 2) return;
            data.replace(key, text[1]);
        }


        sound = data.get(config.playSound.Sound);
        volume = Float.parseFloat(data.get(config.playSound.Volume));
        pitch = Float.parseFloat(data.get(config.playSound.Pitch));
        category = SoundType.get(data.get(config.playSound.Category));
    }

    public void run(final Block block, minecraft mc) {
        final Location location = block.getLocation();

        if (category == null) {
            block.getWorld().playSound(location, sound, volume, pitch);
        } else {
            block.getWorld().playSound(location, sound, category, volume, pitch);
        }

        for (Player player : location.getNearbyPlayers(16))
            new stop(player).runTaskLater(mc, 0L);
    }

    public String getWarnText(final Config config) {

        if (sound == null || isNaN(volume) || isNaN(pitch)) {
            return config.playSound.NotEnoughSettings;
        }

        if (volume > config.playSound.MaxVolume) {
            return config.playSound.ExceedingMaxVolume;
        }
        if (pitch > config.playSound.MaxPitch) {
            return config.playSound.ExceedingMaxPitch;
        }
        return null;
    }
}