package nathan.apes.pltag.command;

import nathan.apes.pltag.main.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandClear implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player){
			
			Main.config.set("tagentries", "");
			
			sender.sendMessage("[" + ChatColor.RED + "PlayerTagger" + ChatColor.RESET + "]" + ChatColor.AQUA + " Cleared the tag entries made by staff...");
		
		}
		
		else{
			
			sender.sendMessage("[" + ChatColor.RED + "PlayerTagger" + ChatColor.RESET + "]" + ChatColor.DARK_RED + " This is a player used command-it doesn't work this way...");
			
		}
		
		return true;
	}

}
