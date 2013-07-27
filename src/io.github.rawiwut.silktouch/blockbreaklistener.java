package io.github.rawiwut.sliktouch;

//import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
//import org.bukkit.Material;
//import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class blockbreaklistener implements Listener {

	private main plugin;
	 
    public blockbreaklistener(main plugin) {
         this.plugin = plugin;
    }	
	
	@EventHandler
    public void Iteminhand(BlockBreakEvent event) {
		Player p = event.getPlayer();
		ItemStack inhand=p.getItemInHand();
    	final Enchantment SILK_TOUCH = new EnchantmentWrapper(33);
    	if(inhand.containsEnchantment(SILK_TOUCH))
    	{ 
    		Block tobreak = event.getBlock();
    		for(int i=0;i<plugin.getConfig().getMapList("blocks").size();i++)
    		{
    			int blockID = (Integer) plugin.getConfig().getMapList("blocks").get(i).get("blockID");
    			if(tobreak.getTypeId()==blockID)
    			{
    				int dropID = (Integer) plugin.getConfig().getMapList("blocks").get(i).get("dropID");
        			int count = (Integer) plugin.getConfig().getMapList("blocks").get(i).get("count");
        			short damage =0;
        			if(plugin.getConfig().getMapList("blocks").get(i).containsKey("damage"))
        				{
        					int x = (Integer) plugin.getConfig().getMapList("blocks").get(i).get("damage");
        					damage = (short) x;
        					
        				}
        			event.setCancelled(true);
    				tobreak.setType(Material.AIR);
    				event.getPlayer().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(dropID, count, damage));
    				break;
    			}    			
    		}
    	 	
    		
    		/*for(int i : blockid)
    		{
    			p.sendMessage(ChatColor.BLUE+"[Debug]"+ChatColor.WHITE+"Now Checking"+i+" "+tobreak);
    			if(tobreak.getTypeId()==i)
    			{
    				int todrop = plugin.getConfig().getInt("block.blockID."+i+"dropID");
    				int amount = plugin.getConfig().getInt("block.blockID."+i+"amount");
    				short damage = (short) plugin.getConfig().get("block.blockID."+i+"dropID"+todrop);
    				event.setCancelled(true);
    				tobreak.setType(Material.AIR);
    				event.getPlayer().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(todrop, amount, damage));
    				
    				
    			}
    		}*/
    		/*
    		if(tobreak.getTypeId() == 16)
    		{
    			event.setCancelled(true);
    			tobreak.setType(Material.AIR);
    			event.getPlayer().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.COAL,1));
    		}
    		else if(tobreak.getTypeId() == 21)
    		{
    			event.setCancelled(true);
    			tobreak.setType(Material.AIR);
    			event.getPlayer().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.INK_SACK,1,(short)4));
    		}
    		else if(tobreak.getTypeId() == 56)
    		{
    			event.setCancelled(true);
    			tobreak.setType(Material.AIR);
    			event.getPlayer().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.DIAMOND,1));
    		}*/
    	}
    }
}
