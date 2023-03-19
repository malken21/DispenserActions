package marumasa.dispenser_actions.blocks;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.CommandBlock;
import org.bukkit.scheduler.BukkitRunnable;

public class SettingCommandBlock extends BukkitRunnable {
    private final Location location;

    public SettingCommandBlock(Location loc) {
        location = loc;
    }

    @Override
    public void run() {
        Block command_block = location.getBlock();
        CommandBlock commandBlock = (CommandBlock) command_block.getState();
        commandBlock.setCommand("summon tnt ~ ~ ~");
        this.cancel();
    }
}