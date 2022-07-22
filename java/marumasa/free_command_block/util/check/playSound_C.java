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

        sound = loreList.get(0).replace(con.playSound_S.get("sound") + "sound: ", "");
        final String vol = loreList.get(1).replace(con.playSound_S.get("volume") + "volume: ", "");
        final String pit = loreList.get(2).replace(con.playSound_S.get("pitch") + "pitch: ", "");
        final String cate = loreList.get(3).replace(con.playSound_S.get("category") + "category: ", "");

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
