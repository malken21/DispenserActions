package marumasa.free_command_block.dispenser.Sound;

import marumasa.free_command_block.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DecimalFormat;
import java.util.List;

public class checkSound {

    private final ItemMeta itemMeta;
    private final List<String> loreList;
    private final Config config;

    public String sound;
    public float volume;
    public float pitch;

    public boolean status = false;

    public checkSound(ItemStack item, Config con) {
        config = con;
        itemMeta = item.getItemMeta();
        loreList = itemMeta.getLore();
        if (loreList == null) return;
        if (loreList.size() != 3) return;
        sound = loreList.get(0).replace(con.playSound_colour_sound + con.playSound_text_sound + "sound: ", "");
        final String vol = loreList.get(1).replace(con.playSound_colour_volume + con.playSound_text_volume + "volume: ", "");
        final String pit = loreList.get(2).replace(con.playSound_colour_pitch + con.playSound_text_pitch + "pitch: ", "");
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
        if (volume > config.playSound_maxVolume) {
            DecimalFormat format = new DecimalFormat("0.#");
            player.sendMessage(String.format("§6最大の音量を超えています\n自動で音量が%sとして再生されます", format.format(config.playSound_maxVolume)));
        }
        if (pitch > config.playSound_maxPitch) {
            DecimalFormat format = new DecimalFormat("0.#");
            player.sendMessage(String.format("§6最大のピッチを超えています\n自動でピッチが%sとして再生されます", format.format(config.playSound_maxPitch)));
        }
    }
}
