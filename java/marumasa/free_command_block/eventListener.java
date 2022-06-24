package marumasa.free_command_block;

import marumasa.free_command_block.dispenser.Message.sendMessage;
import marumasa.free_command_block.dispenser.Sound.playSound;
import marumasa.free_command_block.dispenser.Sound.checkSound;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.ItemStack;

public class eventListener implements Listener {
    private final minecraft minecraft;
    private final Config config;

    public eventListener(minecraft data, Config con) {
        minecraft = data;
        config = con;
    }

    @EventHandler
    public void onDispense(BlockDispenseEvent event) {
        ItemStack item = event.getItem();

        if (item.getType() == Material.NOTE_BLOCK) {
            new playSound(minecraft, item, event, config);
        }

        if (item.getType() == Material.PAPER) {
            new sendMessage(minecraft, item, event);
        }
    }

    @EventHandler
    public void onInventory(InventoryClickEvent event) {

        ItemStack item = event.getCurrentItem();

        if(item == null)return;

        if (item.getType() == Material.NOTE_BLOCK) {
            checkSound checkSound = new checkSound(item, config);
            checkSound.onInventory(event.getWhoClicked());
        }

        if (item.getType() == Material.PAPER) {
        }
    }
}