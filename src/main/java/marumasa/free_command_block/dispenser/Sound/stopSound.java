package marumasa.free_command_block.dispenser.Sound;

import marumasa.free_command_block.Config;
import marumasa.free_command_block.minecraft;
import marumasa.free_command_block.util.check.stopSound_C;
import marumasa.free_command_block.util.dispenser.stop;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;

public class stopSound {
    public stopSound(minecraft minecraft, ItemStack item, BlockDispenseEvent event, Config config) {

        final stopSound_C checkSound = new stopSound_C(item, config);

        if (!checkSound.status) return;

        final Block block = event.getBlock();

        final Location location = block.getLocation();
        final Collection<? extends Player> playerList = block.getWorld().getPlayers();

        float distance = checkSound.distance;
        if (distance > config.stopSound_F.get("maxDistance")) distance = config.stopSound_F.get("maxDistance");

        event.setCancelled(true);
        for (Player player : playerList) {
            Location playerLocation = player.getLocation();
            double dis = location.distance(playerLocation);
            if (dis <= 16) {
                new stop(player).runTaskTimer(minecraft, 1L, 20L);
            }
            if (dis <= distance) {
                if (checkSound.category == null) {
                    player.stopSound(checkSound.sound);
                } else {
                    player.stopSound(checkSound.sound, checkSound.category);
                }
            }
        }
    }
}
