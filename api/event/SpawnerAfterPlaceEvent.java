package net.codava.virtualspawner.api.event;

import java.util.UUID;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SpawnerAfterPlaceEvent extends Event {
   private static final HandlerList HANDLERS = new HandlerList();
   private final Player player;
   private final UUID virtualSpawnerUuid;

   public SpawnerAfterPlaceEvent(Player player, UUID virtualSpawnerUuid) {
      this.player = player;
      this.virtualSpawnerUuid = virtualSpawnerUuid;
   }

   public static HandlerList getHandlerList() {
      return HANDLERS;
   }

   public HandlerList getHandlers() {
      return HANDLERS;
   }

   public Player getPlayer() {
      return this.player;
   }

   public UUID getVirtualSpawnerUuid() {
      return this.virtualSpawnerUuid;
   }
}
