package com.bukkit.meta1203.Cauldrons;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Handle events for all Player related events
 * @author meta1203
 */
public class CauldronsPlayerListener extends PlayerListener {
    private final Cauldrons plugin;

    public CauldronsPlayerListener(Cauldrons instance) {
        plugin = instance;
    }

    //Insert Player related code here
}

