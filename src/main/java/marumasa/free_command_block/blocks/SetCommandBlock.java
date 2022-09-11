package marumasa.free_command_block.blocks;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class SetCommandBlock {
    public SetCommandBlock(Location location) {
        Block command_block = location.getBlock();
        command_block.setType(Material.COMMAND_BLOCK);
    }
}