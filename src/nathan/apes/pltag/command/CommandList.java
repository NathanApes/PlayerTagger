package nathan.apes.pltag.command;

import nathan.apes.pltag.main.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandList implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player){
			
			if(!(Main.config.getString("tagentries").isEmpty())){
				
				sender.sendMessage("[" + ChatColor.RED + "PlayerTagger" + ChatColor.RESET + "]" + ChatColor.AQUA + " Tagged Players to Deal With:" + Main.config.getString("tagentries"));
			
			} else {
				
				sender.sendMessage("[" + ChatColor.RED + "PlayerTagger" + ChatColor.RESET + "]" + ChatColor.AQUA + " You have no tagged players...");
				
			}
			
		}
		
		else{
			
			sender.sendMessage("[" + ChatColor.RED + "PlayerTagger" + ChatColor.RESET + "]" + ChatColor.DARK_RED + " This is a player used command-it doesn't work this way...");
			
		}
		
		return true;
	}

}
