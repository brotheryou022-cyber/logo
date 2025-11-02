package net.codava.virtualspawner.api.event;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SpawnerPlaceEvent extends Event implements Cancellable {
   private static final HandlerList HANDLERS = new HandlerList();
   private boolean cancelled = false;
   private boolean blockCancelled = false;
   private Player player;
   private Location location;
   private EntityType entityType;

   public SpawnerPlaceEvent(Player player, Location location, EntityType entityType) {
      this.player = player;
      this.entityType = entityType;
      this.location = location;
   }

   public Player getPlayer() {
      return this.player;
   }

   public EntityType getEntityType() {
      return this.entityType;
   }

   public Location getLocation() {
      return this.location;
   }

   public static HandlerList getHandlerList() {
      return HANDLERS;
   }

   public HandlerList getHandlers() {
      return HANDLERS;
   }

   public boolean isCancelled() {
      return this.cancelled;
   }

   public void setCancelled(boolean b) {
      this.cancelled = b;
   }

   public void setBlockCancelled(boolean blockCancelled) {
      this.blockCancelled = blockCancelled;
   }

   public boolean isBlockCancelled() {
      return this.blockCancelled;
   }
}
