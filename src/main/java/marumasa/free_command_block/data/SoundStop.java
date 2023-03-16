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

public class SoundStop {

    public String sound;
    public float distance;
    public SoundCategory category;

    public SoundStop(ItemMeta itemMeta, Config config) {

        List<Component> loreList = itemMeta.lore();
        if (loreList == null) return;

        final Map<String, String> data = new LinkedHashMap<>() {
            {
                put(config.stopSound.Sound, null);
                put(config.stopSound.Distance, null);
                put(config.stopSound.Category, null);
            }
        };

        final int size = data.size();
        if (loreList.size() != size) return;

        final List<String> keyList = new ArrayList<>(data.keySet());
        final PlainTextComponentSerializer plainText = PlainTextComponentSerializer.plainText();

        for (int loop = 0; loop < size; loop++) {

            final String key = keyList.get(loop);

            final String[] text = plainText.serialize(loreList.get(loop)).split(key);

            if (text.length != 2) return;
            data.replace(key, text[1]);
        }


        sound = data.get(config.stopSound.Sound);
        distance = Float.parseFloat(data.get(config.stopSound.Distance));
        category = SoundType.get(data.get(config.stopSound.Category));
    }

    public void run(final Block block, minecraft mc) {
        final Location location = block.getLocation();

        for (Player player : location.getNearbyPlayers(distance)) {
            if (category == null) {
                player.stopSound(sound);
            } else {
                player.stopSound(sound, category);
            }
        }

        for (Player player : location.getNearbyPlayers(16))
            new stop(player).runTaskLater(mc, 0L);
    }

    public String getWarnText(final Config config) {

        if (sound == null || isNaN(distance)) {
            return config.stopSound.NotEnoughSettings;
        }

        if (distance > config.stopSound.MaxDistance) {
            return config.stopSound.ExceedingMaxDistance;
        }
        return null;
    }
}
