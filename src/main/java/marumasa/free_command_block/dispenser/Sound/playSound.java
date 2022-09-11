package marumasa.free_command_block.dispenser.Sound;

import marumasa.free_command_block.Config;
import marumasa.free_command_block.minecraft;
import marumasa.free_command_block.util.check.playSound_C;
import marumasa.free_command_block.util.dispenser.stop;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;

public class playSound {
    public playSound(minecraft minecraft, ItemStack item, BlockDispenseEvent event, Config config) {

        final playSound_C checkSound = new playSound_C(item, config);

        if (!checkSound.status) return;

        final Block block = event.getBlock();

        final Location location = block.getLocation();
        final Collection<? extends Player> playerList = block.getWorld().getPlayers();

        event.setCancelled(true);
        for (Player player : playerList) {
            Location playerLocation = player.getLocation();
            double dis = location.distance(playerLocation);
            if (dis <= 16) {
                new stop(player).runTaskTimer(minecraft, 1L, 20L);
            }
        }

        float volume = checkSound.volume;
        float pitch = checkSound.pitch;
        if (volume > config.playSound_F.get("maxVolume")) volume = config.playSound_F.get("maxVolume");
        if (pitch > config.playSound_F.get("maxPitch")) pitch = config.playSound_F.get("maxPitch");

        if (checkSound.category == null) {
            block.getWorld().playSound(location, checkSound.sound, volume, pitch);
        } else {
            block.getWorld().playSound(location, checkSound.sound, checkSound.category, volume, pitch);
        }
    }
}