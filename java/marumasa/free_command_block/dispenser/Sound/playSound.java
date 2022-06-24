package marumasa.free_command_block.dispenser.Sound;

import marumasa.free_command_block.Config;
import marumasa.free_command_block.minecraft;
import org.bukkit.Location;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;

public class playSound {
    public playSound(minecraft minecraft, ItemStack item, BlockDispenseEvent event, Config config) {

        checkSound checkSound = new checkSound(item, config);

        if (!checkSound.status) return;

        Location location = event.getBlock().getLocation();
        Collection<? extends Player> playerList = minecraft.getServer().getOnlinePlayers();

        event.setCancelled(true);
        for (Player player : playerList) {
            Location playerLocation = player.getLocation();
            if (playerLocation.getWorld() == location.getWorld()) {
                double distance = location.distance(playerLocation);
                if (distance <= 16) {
                    new stopSound(player).runTaskTimer(minecraft, 1L, 20L);
                }
            }
        }

        float volume = checkSound.volume;
        float pitch = checkSound.pitch;
        if (volume > config.playSound_maxVolume) volume = config.playSound_maxVolume;
        if (pitch > config.playSound_maxPitch) pitch = config.playSound_maxPitch;

        location.getWorld().playSound(location, checkSound.sound, SoundCategory.BLOCKS, volume, pitch);
    }
}