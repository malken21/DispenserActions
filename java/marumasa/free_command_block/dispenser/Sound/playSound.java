package marumasa.free_command_block.dispenser.Sound;

import marumasa.free_command_block.minecraft;
import org.bukkit.Location;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collection;
import java.util.List;

public class playSound {
    public playSound(minecraft minecraft, ItemStack item, BlockDispenseEvent event) {
        event.setCancelled(true);
        Location location = event.getBlock().getLocation();
        Collection<? extends Player> playerList = minecraft.getServer().getOnlinePlayers();
        for (Player player : playerList) {
            Location playerLocation = player.getLocation();
            if (playerLocation.getWorld() == location.getWorld()) {
                double distance = location.distance(playerLocation);
                if (distance <= 16) {
                    new stopSound(player).runTaskTimer(minecraft, 1L, 20L);
                }
            }
        }
        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta == null || location.getWorld() == null) return;
        List<String> loreList = itemMeta.getLore();
        if (loreList == null) return;
        location.getWorld().playSound(location, loreList.get(0), SoundCategory.BLOCKS, Float.parseFloat(loreList.get(1)), Float.parseFloat(loreList.get(2)));
    }
}
