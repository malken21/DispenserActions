package marumasa.free_command_block;

import marumasa.free_command_block.dispenser.Message.sendMessage;
import marumasa.free_command_block.dispenser.Sound.playSound;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.ItemStack;

public class eventListener implements Listener {
    private final minecraft minecraft;

    public eventListener(minecraft data) {
        minecraft = data;
    }

    @EventHandler
    public void onDispense(BlockDispenseEvent event) {
        ItemStack item = event.getItem();

        if (item.getType() == Material.NOTE_BLOCK) {
            new playSound(minecraft, item, event);
        }

        if (item.getType() == Material.PAPER) {
            new sendMessage(minecraft, item, event);
        }
    }
}