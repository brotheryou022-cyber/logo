package net.codava.virtualspawner.api.event;

import net.codava.virtualspawner.api.interfaces.IVirtualSpawner;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SpawnerStackEvent extends Event implements Cancellable {
   private static final HandlerList HANDLERS = new HandlerList();
   private boolean cancelled = false;
   private Player player;
   private EntityType entityType;
   private IVirtualSpawner virtualSpawner;
   private int stack;
   private SpawnerStackEvent.StackType stackType;

   public SpawnerStackEvent(Player player, EntityType entityType, IVirtualSpawner virtualSpawner, int stack, SpawnerStackEvent.StackType stackType) {
      this.player = player;
      this.virtualSpawner = virtualSpawner;
      this.entityType = entityType;
      this.stack = stack;
      this.stackType = stackType;
   }

   public int getStack() {
      return this.stack;
   }

   public EntityType getEntityType() {
      return this.entityType;
   }

   public SpawnerStackEvent.StackType getStackType() {
      return this.stackType;
   }

   /** @deprecated */
   @Deprecated
   public Location getLocation() {
      return this.virtualSpawner.getLocation();
   }

   public Player getPlayer() {
      return this.player;
   }

   public IVirtualSpawner getVirtualSpawner() {
      return this.virtualSpawner;
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

   public static enum StackType {
      BREAK,
      ADD;

      // $FF: synthetic method
      private static SpawnerStackEvent.StackType[] $values() {
         return new SpawnerStackEvent.StackType[]{BREAK, ADD};
      }
   }
}
