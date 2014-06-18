package eGuns.Listenery;

import java.util.Map;

import org.bukkit.configuration.Configuration;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import eGuns.Main;

public class onEntityDamageByEntity implements Listener{

	private Main plugin;
	Configuration config;
	public onEntityDamageByEntity(Main instancja) {
		plugin = instancja;
		config = plugin.getConfig();
	}
	
	@EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
    public void onBronDamageByEntity(EntityDamageByEntityEvent edbe) {
      if (!(edbe.getDamager() instanceof Projectile) || !(edbe.getEntity() instanceof LivingEntity))
      {
        return;
      }
      Projectile proj = (Projectile) edbe.getDamager();
      if (proj == null || !(proj.getShooter() instanceof Player))
      {
        return;
      }
      Player shooter = (Player) proj.getShooter();
      Map<Projectile, Amunicja> mapeczka = plugin.nabojeMap.get(shooter.getName());
      if(mapeczka == null) {
        return;
      }
      Amunicja pobranaAmunicja = mapeczka.get(proj);
      if(pobranaAmunicja == null) {
        return;
      }
      edbe.setDamage(pobranaAmunicja.getDamage());
    }

}
