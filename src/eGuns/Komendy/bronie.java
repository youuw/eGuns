package eGuns.Komendy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

import eGuns.Main;

public class bronie implements CommandExecutor {

	private Main plugin;
	Configuration config;
	public bronie(Main instancja) {
		plugin = instancja;
		config = plugin.getConfig();
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String cmd,
			String[] args) {
		Player gracz = (Player) sender;
		if(cmd.equalsIgnoreCase("bronie")){
			gracz.sendMessage(ChatColor.GOLD + "--= Lista dostępnych broni: =--");
			gracz.sendMessage(ChatColor.GOLD + "- AK-47");
			gracz.sendMessage(ChatColor.GOLD + "- M16");
			gracz.sendMessage(ChatColor.GOLD + "- M14");
			gracz.sendMessage(ChatColor.GOLD + "- Shout Gun");
			gracz.sendMessage(ChatColor.GOLD + "- MP9");
			gracz.sendMessage(ChatColor.GOLD + "");
			gracz.sendMessage(ChatColor.GOLD + "Wszystkie są dostępne w naszym ItemShopie!");
		}
		return false;
	}

}
