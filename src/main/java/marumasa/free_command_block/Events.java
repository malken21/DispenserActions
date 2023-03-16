package marumasa.free_command_block;

import marumasa.free_command_block.config.Config;
import marumasa.free_command_block.data.SoundPlay;
import marumasa.free_command_block.data.SoundStop;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Events implements Listener {
    private final minecraft minecraft;
    private final Config config;

    public Events(minecraft mc, Config cfg) {
        minecraft = mc;
        config = cfg;
    }

    @EventHandler
    public void onDispense(BlockDispenseEvent event) {
        final Block block = event.getBlock();


        if (block.getType() == Material.DISPENSER) {
            final ItemStack item = event.getItem();
            final ItemMeta itemMeta = item.getItemMeta();
            if (itemMeta == null) return;

            //-----start-----//
            final Material material = item.getType();

            if (material == Material.NOTE_BLOCK) {
                final SoundPlay soundPlay = new SoundPlay(itemMeta, config);
                final String warn = soundPlay.getWarnText(config);
                if (warn != null) return;

                soundPlay.run(block, minecraft);
                event.setCancelled(true);

            } else if (material == Material.FEATHER) {
                final SoundStop soundStop = new SoundStop(itemMeta, config);
                final String warn = soundStop.getWarnText(config);
                if (warn != null) return;

                soundStop.run(block, minecraft);
                event.setCancelled(true);

            } else if (material == Material.PAPER) {
                //new sendMessage(minecraft, item, event);
            }
            //-----end-----//
        }

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().getType() != InventoryType.DISPENSER) return;

        ItemStack item = event.getCurrentItem();
        if (item == null) return;
        final ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta == null) return;

        final Material material = item.getType();

        if (material == Material.NOTE_BLOCK) {
            final SoundPlay soundPlay = new SoundPlay(itemMeta, config);
            final String warn = soundPlay.getWarnText(config);
            if (warn == null) return;
            event.getWhoClicked().sendMessage(warn);
        } else if (material == Material.FEATHER) {
            final SoundStop soundStop = new SoundStop(itemMeta, config);
            final String warn = soundStop.getWarnText(config);
            if (warn == null) return;
            event.getWhoClicked().sendMessage(warn);
        } else if (material == Material.PAPER) {
        }
    }
}