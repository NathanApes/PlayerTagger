package nathan.apes.pltag.event;

import java.util.ArrayList;

import nathan.apes.pltag.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class EventClick implements Listener{
	
	private int tagcount = -1;
	
	private ArrayList<Player> players = new ArrayList<Player>();
	
	public static ArrayList<Player> taggedplayers = new ArrayList<Player>();
	
	@EventHandler
	public void onClick(InventoryClickEvent ice){
		
		Player clickpl = (Player) ice.getWhoClicked();
		
		if(ice.getInventory().getName().equals("Menu")){
			
				Inventory inv = Bukkit.createInventory(clickpl, InventoryType.CHEST, "Players");
			
				OfflinePlayer[] offplayers = Bukkit.getOfflinePlayers();
				
				for(int i = 0; i < offplayers.length; i++){ if(offplayers[i].isOnline()){ players.add(offplayers[i].getPlayer()); } }
				
				ItemStack[] plhs = null;
				
				for(int i2 = 0; i2 < players.size(); i2++){
					
					ItemStack pli = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
					
					plhs = new ItemStack[players.size()];
					
					SkullMeta plim = (SkullMeta) pli.getItemMeta();
					
					plim.setDisplayName("Tag Player " + "'" + players.get(i2).getPlayerListName() + "'");
					
					plim.setOwner(players.get(i2).getPlayerListName());
					
					pli.setItemMeta(plim);
					
					plhs[i2] = pli;
					
				}
				
				inv.setContents(plhs);
				
				clickpl.openInventory(inv);
				
		}
		
		if(ice.getClickedInventory().getName().equals("Players")){
		
			clickpl.closeInventory();
			
			taggedplayers.add(players.get(ice.getSlot()));
			
			tagcount += 1;
			
			Main.config.set("tagentries", Main.config.getString("tagentries") + " " + taggedplayers.get(tagcount).getPlayerListName());
			
			clickpl.sendMessage("[" + ChatColor.RED + "PlayerTagger" + ChatColor.RESET + "]" + ChatColor.AQUA + " Tagging player '" + players.get(ice.getSlot()).getPlayerListName() + "'");
			
		}
		
	}
	
}
