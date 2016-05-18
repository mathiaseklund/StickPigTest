package me.mathiaseklund.stickpig;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	private static Main main;

	public static Main getMain() {
		return main;
	}

	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
	}

}
