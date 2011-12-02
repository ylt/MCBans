package com.mcbans.firestar.mcbans.log;

import com.mcbans.firestar.mcbans.BukkitInterface;
import org.bukkit.ChatColor;

public class Logger {
    private BukkitInterface MCBans = null;

    public Logger (BukkitInterface p) {
        MCBans = p;
    }

    public void log (String message) {
        log(LogLevels.NONE, message);
    }

    public void log (LogLevels type, String message) {
        if (MCBans.useColor) {
            switch (type) {
                case INFO:
                    MCBans.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + MCBans.Settings.getPrefix() + ChatColor.LIGHT_PURPLE + " [INFO] " + ChatColor.WHITE + message);
                    break;
                case WARNING:
                    MCBans.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + MCBans.Settings.getPrefix() + ChatColor.YELLOW + " [WARNING] " + ChatColor.WHITE + message);
                    break;
                case SEVERE:
                    MCBans.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + MCBans.Settings.getPrefix() + ChatColor.GOLD + " [SEVERE] " + ChatColor.WHITE + message);
                    break;
                case FATAL:
                    MCBans.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + MCBans.Settings.getPrefix() + ChatColor.RED + " [FATAL] " + ChatColor.WHITE + message);
                    MCBans.getServer().getPluginManager().disablePlugin(MCBans.pluginInterface("mcbans"));
                    break;
                default:
                    MCBans.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + MCBans.Settings.getPrefix() + " " + ChatColor.WHITE +  message);
                    break;
            }
        } else {
            switch (type) {
                case INFO:
                    MCBans.getServer().getConsoleSender().sendMessage(MCBans.Settings.getPrefix() + " [INFO] " + message);
                    break;
                case WARNING:
                    MCBans.getServer().getConsoleSender().sendMessage(MCBans.Settings.getPrefix() + " [WARNING] " + message);
                    break;
                case SEVERE:
                    MCBans.getServer().getConsoleSender().sendMessage(MCBans.Settings.getPrefix() + " [SEVERE] " + message);
                    break;
                case FATAL:
                    MCBans.getServer().getConsoleSender().sendMessage(MCBans.Settings.getPrefix() + " [FATAL] " + message);
                    MCBans.getServer().getPluginManager().disablePlugin(MCBans.pluginInterface("mcbans"));
                    break;
                default:
                    MCBans.getServer().getConsoleSender().sendMessage(MCBans.Settings.getPrefix() + " " + message);
                    break;
            }
        }
    }
}
