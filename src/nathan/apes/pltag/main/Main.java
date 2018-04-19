package nathan.apes.pltag.main;

import nathan.apes.pltag.command.CommandClear;
import nathan.apes.pltag.command.CommandList;
import nathan.apes.pltag.command.CommandMenu;
import nathan.apes.pltag.event.EventClick;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public static FileConfiguration config = null;
	
	public void onEnable(){
		
		config = this.getConfig();
		
		config.addDefault("tagentries", "");
		
		config.options().copyDefaults(true);
		this.saveConfig();
		
		this.getCommand("tagmenu").setExecutor(new CommandMenu());
		this.getCommand("listtags").setExecutor(new CommandList());
		this.getCommand("cleartags").setExecutor(new CommandClear());
		
		this.getServer().getPluginManager().registerEvents(new EventClick(), this);
		
		this.getLogger().info("Enabling PlayerTagger...");
		
	}
	
	public void onDisable(){
		
		this.getLogger().info("Disabling PlayerTagger...");
		
	}
	
}
 