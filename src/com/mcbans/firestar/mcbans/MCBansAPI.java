package com.mcbans.firestar.mcbans;

import com.mcbans.firestar.mcbans.pluginInterface.Ban;
import com.mcbans.firestar.mcbans.pluginInterface.Kick;
import org.bukkit.entity.Player;

/**
 *
 * @author Sean (rakiru)
 */
public class MCBansAPI {

	BukkitInterface plugin;
	Settings config;

	public MCBansAPI (BukkitInterface plugin) {
		this.plugin = plugin;
		this.config = plugin.Settings;
	}

	/**
	 * Ban a player using the MCBans system
	 *
	 * @param playerName Full name of the player to be banned (no partial names)
	 * @param playerIP String representation of the player's IP address
	 * @param type Type of ban: "g" = global, "l" = local
	 * @param reason Reason for the ban
	 * @param adminName Name to be attached as player who placed the ban
	 * @param duration Number of time units to temporarily ban player for
	 * @param measure Type of time units to temporarily ban for
	 */
	private void banPlayer(String playerName, String playerIP, String type, String reason, String adminName, String duration, String measure) {
		new Ban(plugin, type, playerName, playerIP, adminName, reason, duration, measure).start();
	}

	/**
	 * Ban a player using the MCBans system
	 *
	 * @param playerName Full name of the player to be banned (no partial names)
	 * @param playerIP String representation of the player's IP address
	 * @param type Type of ban: "g" = global, "l" = local
	 * @param reason Reason for the ban
	 * @param adminName Name to be attached as player who placed the ban
	 */
	private void banPlayer(String playerName, String playerIP, String type, String reason, String adminName) {
		banPlayer(playerName, playerIP, type, reason, adminName, "", "");
	}

	/**
	 * Ban a player globally using the MCBans system
	 *
	 * @param playerName Full name of the player to be banned (no partial names)
	 * @param playerIP String representation of the player's IP address
	 * @param reason Reason for the ban
	 * @param adminName Name to be attached as player who placed the ban
	 */
	public void globalBanPlayer(String playerName, String playerIP, String reason, String adminName) {
		banPlayer(playerName, playerIP, "globalBan", reason, adminName);
	}

	/**
	 * Ban a player globally using the MCBans system
	 *
	 * @param playerName Full name of the player to be banned (no partial names)
	 * @param reason Reason for the ban
	 * @param adminName Name to be attached as player who placed the ban
	 */
	public void globalBanPlayer(String playerName, String reason, String adminName) {
		globalBanPlayer(playerName, getPlayerIP(playerName), reason, adminName);
	}

	/**
	 * Ban a player globally using the MCBans system as console
	 *
	 * @param playerName Full name of the player to be banned (no partial names)
	 * @param reason Reason for the ban
	 */
	public void globalBanPlayer(String playerName, String reason) {
		globalBanPlayer(playerName, reason, "console");
	}

	/**
	 * Ban a player locally using the MCBans system
	 *
	 * @param playerName Full name of the player to be banned (no partial names)
	 * @param playerIP String representation of the player's IP address
	 * @param reason Reason for the ban
	 * @param adminName Name to be attached as player who placed the ban
	 */
	public void localBanPlayer(String playerName, String playerIP, String reason, String adminName) {
		banPlayer(playerName, playerIP, "localBan", reason, adminName);
	}

	/**
	 * Ban a player locally using the MCBans system
	 *
	 * @param playerName Full name of the player to be banned (no partial names)
	 * @param reason Reason for the ban
	 * @param adminName Name to be attached as player who placed the ban
	 */
	public void localBanPlayer(String playerName, String reason, String adminName) {
		localBanPlayer(playerName, getPlayerIP(playerName), reason, adminName);
	}

	/**
	 * Ban a player locally using the MCBans system as console
	 *
	 * @param playerName Full name of the player to be banned (no partial names)
	 * @param reason Reason for the ban
	 */
	public void localBanPlayer(String playerName, String reason) {
		localBanPlayer(playerName, reason, "console");
	}

	/**
	 * Ban a player locally using the MCBans system for the default ban reason as console
	 *
	 * @param playerName Full name of the player to be banned (no partial names)
	 */
	public void localBanPlayer(String playerName) {
		localBanPlayer(playerName, config.getString("defaultLocal"));
	}

	/**
	 * Ban a player for a specific time using the MCBans system
	 *
	 * @param playerName Full name of the player to be banned (no partial names)
	 * @param playerIP String representation of the player's IP address
	 * @param time Number of units the ban should last
	 * @param units Units of time to measure in: "m" = minutes, "h" = hours, "d" = days
	 * @param reason Reason for the ban
	 * @param adminName Name to be attached as player who placed the ban
	 */
	public void tempBanPlayer(String playerName, String playerIP, float time, String units, String reason, String adminName) {
		banPlayer(playerName, playerIP, "tempBan", reason, adminName);
	}

	/**
	 * Ban a player for a specific time using the MCBans system
	 *
	 * @param playerName Full name of the player to be banned (no partial names)
	 * @param time Number of units the ban should last
	 * @param units Units of time to measure in: "m" = minutes, "h" = hours, "d" = days
	 * @param reason Reason for the ban
	 * @param adminName Name to be attached as player who placed the ban
	 */
	public void tempBanPlayer(String playerName, float time, String units, String reason, String adminName) {
		tempBanPlayer(playerName, getPlayerIP(playerName), time, units, reason, adminName);
	}

	/**
	 * Ban a player for a specific time using the MCBans system
	 *
	 * @param playerName Full name of the player to be banned (no partial names)
	 * @param playerIP String representation of the player's IP address
	 * @param time Number of units the ban should last
	 * @param units Units of time to measure in: "m" = minutes, "h" = hours, "d" = days
	 * @param adminName Name to be attached as player who placed the ban
	 */
	public void tempBanPlayer(String playerName, String playerIP, float time, String units, String adminName) {
		tempBanPlayer(playerName, playerIP, time, units, config.getString("defaultTemp"), adminName);
	}

	/**
	 * Ban a player for a specific time using the MCBans system for the default ban reason
	 *
	 * @param playerName Full name of the player to be banned (no partial names)
	 * @param time Number of units the ban should last
	 * @param units Units of time to measure in: "m" = minutes, "h" = hours, "d" = days
	 * @param adminName Name to be attached as player who placed the ban
	 */
	public void tempBanPlayer(String playerName, float time, String units, String adminName) {
		tempBanPlayer(playerName, time, units, config.getString("defaultTemp"), adminName);
	}

	/**
	 * Unban a player using the MCBans system
	 *
	 * @param playerName Full name of the player to be banned (no partial names)
	 * @param adminName Name to be attached as player who placed the ban
	 */
	public void unbanPlayer(String playerName, String adminName) {
		banPlayer(playerName, "", "unBan", "", adminName);
	}

	/**
	 * Unban a player using the MCBans system as console
	 *
	 * @param playerName Full name of the player to be banned (no partial names)
	 */
	public void unbanPlayer(String playerName) {
		unbanPlayer(playerName, "console");
	}

	/**
	 * Kick a player using the MCBans system (the MCBans plugin will log the kick)
	 *
	 * @param playerName Full name of the player to be banned (no partial names)
	 * @param reason Reason for the kick
	 * @param adminName Name to be attached as player who kicked the player
	 */
	public void kickPlayer(String playerName, String reason, String adminName) {
		new Kick(config, plugin, playerName, adminName, reason).start();
	}

	/**
	 * Kick a player using the MCBans system for the default kick reason (the MCBans plugin will log the kick)
	 *
	 * @param playerName Full name of the player to be banned (no partial names)
	 * @param adminName Name to be attached as player who kicked the player
	 */
	public void kickPlayer(String playerName, String adminName) {
		kickPlayer(playerName, config.getString("defaultKick"), adminName);
	}

	/**
	 * Kick a player using the MCBans system for the default kick reason  as console(the MCBans plugin will log the kick)
	 *
	 * @param playerName Full name of the player to be banned (no partial names)
	 */
	public void kickPlayer(String playerName) {
		kickPlayer(playerName, "console");
	}

	/**
	 * Checks if a given player is a member of the MCBans team
	 *
	 * @param playerName Full name of the player to be checked
	 * @return Whether or not the player is a member of staff
	 */
	private boolean isMCBansStaff(String playerName) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	////////////////////////////
	/////// Util methods ///////
	////////////////////////////

	private String getPlayerIP(String playerName) {
		Player player = plugin.getServer().getPlayerExact(playerName);
		if (player != null) {
			return player.getAddress().getAddress().getHostAddress();
		} else {
			return "";
		}
	}
}
