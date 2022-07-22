package marumasa.free_command_block.util.check;

import marumasa.free_command_block.Config;
import marumasa.free_command_block.minecraft;
import marumasa.free_command_block.util.sound.blockType;
import org.bukkit.SoundCategory;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DecimalFormat;
import java.util.List;

public class stopSound_C {

    private final Config config;

    public String sound;
    public float distance;
    public SoundCategory category;

    public boolean status = false;

    public stopSound_C(ItemStack item, Config con) {
        config = con;

        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta == null) return;

        List<String> loreList = itemMeta.getLore();
        if (loreList == null) return;
        if (loreList.size() != 3) return;

        sound = loreList.get(0).replace(con.stopSound_S.get("sound") + "sound: ", "");
        final String dis = loreList.get(1).replace(con.stopSound_S.get("distance") + "distance: ", "");
        final String cate = loreList.get(2).replace(con.stopSound_S.get("category") + "category: ", "");

        category = blockType.get(cate);


        float dist;
        try {
            dist = Float.parseFloat(dis);
        } catch (NumberFormatException error) {
            return;
        }
        distance = dist;

        status = true;
    }

    public void onInventory(HumanEntity player) {
        if (!status) return;
        if (distance > config.playSound_F.get("maxVolume")) {
            DecimalFormat format = new DecimalFormat("0.#");
            player.sendMessage(String.format("§6最大の距離を超えています\n自動で距離が%sとして再生されます", format.format(config.playSound_F.get("maxVolume"))));
        }
    }
}
