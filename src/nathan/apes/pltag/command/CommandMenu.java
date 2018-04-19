package nathan.apes.pltag.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandMenu implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player){
			
			Player player = (Player) sender;
			
			Inventory inv = Bukkit.createInventory(player, InventoryType.CHEST, "Menu");
			
			ItemStack pli = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
			
			ItemMeta plm = pli.getItemMeta();
			
			plm.setDisplayName("Players to Tag");
			
			pli.setItemMeta(plm);
			
			inv.setItem(13, pli);
			
			player.openInventory(inv);
			
		}
		
		else{
			
			sender.sendMessage("[" + ChatColor.RED + "PlayerTagger" + ChatColor.RESET + "]" + ChatColor.DARK_RED + " This is a player used command-it doesn't work this way...");
			
		}
		
		return true;
	}

}
;