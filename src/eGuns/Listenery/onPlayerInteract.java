package eGuns.Listenery;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.World;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import eGuns.Main;

public class onPlayerInteract implements Listener{

	private Main plugin;
	Configuration config;
	public onPlayerInteract(Main instancja) {
		plugin = instancja;
		config = plugin.getConfig();
	}
	
	
	
	
	@EventHandler
	  public void onGraczInteract(PlayerInteractEvent pie) {
	  Player gracz = (Player) pie.getPlayer();
	  String mb = pie.getPlayer().getItemInHand().getItemMeta().getDisplayName();
	      if(mb.equals(plugin.nameM9) || mb.equals(plugin.nameSG) || mb.equals(plugin.nameM14) || mb.equals(plugin.nameM16) || mb.equals(plugin.nameAK47)) {
	        if (pie.getAction() == Action.LEFT_CLICK_BLOCK
	          || pie.getAction() == Action.LEFT_CLICK_AIR) {	  
	        World world = gracz.getWorld();
	        org.bukkit.Location loc = pie.getPlayer().getEyeLocation();
	        Projectile zmienna = (Projectile) world.spawnEntity(loc,
	            EntityType.SNOWBALL);
	        Vector loce = gracz.getLocation().getDirection().multiply(4);
	        zmienna.setShooter(gracz);
	        zmienna.setVelocity(loce);
	    Map<Projectile, Amunicja> projMap = plugin.nabojeMap.get(gracz.getName());
	    if (projMap == null)
	    {
	    projMap = new HashMap<>();
	    plugin.nabojeMap.put(gracz.getName(), projMap);
	    }
	    if(mb.equals(plugin.nameAK47)) {
		    projMap.put(zmienna, Amunicja.amoAK47);	
	    } else if(mb.equals(plugin.nameM16)) {
		    projMap.put(zmienna, Amunicja.amoM16);	
	    } else if(mb.equals(plugin.nameM14)) {
		    projMap.put(zmienna, Amunicja.amoM14);	
	    } else if(mb.equals(plugin.nameSG)) {
		    projMap.put(zmienna, Amunicja.amoSG);	
	    } else if(mb.equals(plugin.nameM9)) {
		    projMap.put(zmienna, Amunicja.amoM9);	
	    } 

	      }
	    } 
	  }
}
