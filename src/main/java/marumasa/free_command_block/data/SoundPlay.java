package marumasa.free_command_block.data;

import marumasa.free_command_block.Config;
import marumasa.free_command_block.util.sound.blockType;
import org.bukkit.SoundCategory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SoundPlay {


    public String sound;
    public Float volume;
    public Float pitch;
    public SoundCategory category;


    public SoundPlay(ItemMeta itemMeta, Config config) {

        List<String> loreList = itemMeta.getLore();
        if (loreList == null) return;
        if (loreList.size() != 4) return;

        final Map<String, String> data = new HashMap<String, String>() {
            {
                put("sound: ", null);
                put("volume: ", null);
                put("pitch: ", null);
                put("category: ", null);
            }
        };

        List<String> keyList = new ArrayList<>(data.keySet());

        for (int loop = 0; loop < data.size(); loop++) {

            final String key = keyList.get(loop);

            final String[] lore_data = loreList.get(loop).split(key);
            if (lore_data.length == 2) data.replace(key, lore_data[1]);
        }

        try {

            sound = data.get("sound: ");
            volume = Float.parseFloat(data.get("volume: "));
            pitch = Float.parseFloat(data.get("pitch: "));
            category = blockType.get(data.get("category: "));

        } catch (NumberFormatException ignored) {
        }
    }

    public boolean isAllow(Config config) {

        if (sound == null || volume == null || pitch == null || category == null) {
            return false;
        }

        if (volume > config.playSound_F.get("maxVolume")) {
            return false;
        }
        if (pitch > config.playSound_F.get("maxPitch")) {
            return false;
        }
        return true;
    }
}