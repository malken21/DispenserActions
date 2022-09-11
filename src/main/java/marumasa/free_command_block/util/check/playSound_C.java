package marumasa.free_command_block.util.check;

import marumasa.free_command_block.Config;
import marumasa.free_command_block.util.sound.blockType;
import org.bukkit.SoundCategory;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DecimalFormat;
import java.util.List;

public class playSound_C {

    private final Config config;

    public String sound;
    public float volume;
    public float pitch;
    public SoundCategory category;

    public boolean status = false;

    public playSound_C(ItemStack item, Config con) {
        config = con;

        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta == null) return;

        List<String> loreList = itemMeta.getLore();
        if (loreList == null) return;
        if (loreList.size() != 4) return;

        String[] lore_data = loreList.get(0).split("sound: ");
        if (lore_data.length != 2) return;
        sound = lore_data[1];

        lore_data = loreList.get(1).split("volume: ");
        if (lore_data.length != 2) return;
        final String vol = lore_data[1];

        lore_data = loreList.get(2).split("pitch: ");
        if (lore_data.length != 2) return;
        final String pit = lore_data[1];

        lore_data = loreList.get(3).split("category: ");
        if (lore_data.length != 2) return;
        final String cate = lore_data[1];
        category = blockType.get(cate);

        float volu;
        float pitc;
        try {
            volu = Float.parseFloat(vol);
            pitc = Float.parseFloat(pit);
        } catch (NumberFormatException error) {
            return;
        }
        volume = volu;
        pitch = pitc;

        status = true;
    }

    public void onInventory(HumanEntity player) {
        if (!status) return;
        if (volume > config.playSound_F.get("maxVolume")) {
            DecimalFormat format = new DecimalFormat("0.#");
            player.sendMessage(String.format("§6最大の音量を超えています\n自動で音量が%sとして再生されます", format.format(config.playSound_F.get("maxVolume"))));
        }
        if (pitch > config.playSound_F.get("maxPitch")) {
            DecimalFormat format = new DecimalFormat("0.#");
            player.sendMessage(String.format("§6最大のピッチを超えています\n自動でピッチが%sとして再生されます", format.format(config.playSound_F.get("maxPitch"))));
        }
    }
}
