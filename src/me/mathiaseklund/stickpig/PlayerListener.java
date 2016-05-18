package me.mathiaseklund.stickpig;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class PlayerListener implements Listener {

	private static PlayerListener instance = new PlayerListener();

	Main plugin = Main.getMain();

	public static PlayerListener getInstance() {
		return instance;
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Player p = e.getPlayer();
			if (p.getItemInHand().getType() == Material.STICK) {
				launchPig(p);
			}
		}
	}

	public void launchPig(Player p) {
		Location loc = p.getEyeLocation();
		Vector v = p.getLocation().getDirection();
		loc.add(v);
		LivingEntity le = (LivingEntity) Bukkit.getWorld(loc.getWorld().getName()).spawnEntity(loc, EntityType.PIG);
		v = v.multiply(2);
		le.setVelocity(v);
	}
}