package marumasa.free_command_block.dispenser.Sound;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class stopSound extends BukkitRunnable {
    private final Player PLAYER;
    public stopSound(Player player){
        PLAYER = player;
    }
    @Override
    public void run(){
        PLAYER.stopSound(Sound.BLOCK_DISPENSER_DISPENSE, SoundCategory.BLOCKS);
        this.cancel();
    }
}