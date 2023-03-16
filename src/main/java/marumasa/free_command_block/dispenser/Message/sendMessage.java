package marumasa.free_command_block.dispenser.Message;

import marumasa.free_command_block.minecraft;
import marumasa.free_command_block.util.dispenser.stop;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collection;

public class sendMessage {
    public sendMessage(minecraft minecraft, ItemStack item, BlockDispenseEvent event) {
        event.setCancelled(true);
        Location location = event.getBlock().getLocation();
        Collection<? extends Player> playerList = minecraft.getServer().getOnlinePlayers();
        for (Player player : playerList) {
            Location playerLocation = player.getLocation();
            if (playerLocation.getWorld() == location.getWorld()) {
                double distance = location.distance(playerLocation);
                if (distance <= 16) {
                    new stop(player).runTaskTimer(minecraft, 1L, 20L);
                }

                if (distance <= 32) {//切り替え可にする予定
                    ItemMeta meta = item.getItemMeta();
                    if (meta == null) return;
                    //List<String> loreList = meta.getLore();
                    //String lore = String.join("\n",loreList);
                    //player.sendMessage(lore);
                }
            }
        }
    }
}
