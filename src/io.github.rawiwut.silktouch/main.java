package io.github.rawiwut.sliktouch;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	public static main plugin;
	PluginDescriptionFile pdfFile = this.getDescription();
	
	@Override
    public void onEnable(){
		getLogger().info("Enable");
		saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new blockbreaklistener(this), this);
        
        
	}   
	
	
	@Override
    public void onDisable(){
	
		getLogger().info("Disable");		
    }

}
