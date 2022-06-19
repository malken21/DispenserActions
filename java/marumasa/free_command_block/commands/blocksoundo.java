package marumasa.free_command_block.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class blocksoundo implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        ItemStack item = new ItemStack(Material.FURNACE);

        ItemMeta itemMeta = item.getItemMeta();

        Player player = (Player) sender;
        player.getInventory().addItem();
        return false;
    }
}