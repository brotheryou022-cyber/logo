package net.codava.virtualspawner.api.event;

import net.codava.virtualspawner.api.interfaces.IVirtualSpawner;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SpawnerExplodeEvent extends Event implements Cancellable {
   private static final HandlerList HANDLERS = new HandlerList();
   private boolean cancelled = false;
   private final IVirtualSpawner virtualSpawner;
   private final Entity source;

   public SpawnerExplodeEvent(Entity source, IVirtualSpawner virtualSpawner) {
      this.source = source;
      this.virtualSpawner = virtualSpawner;
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

   public IVirtualSpawner getVirtualSpawner() {
      return this.virtualSpawner;
   }

   public Entity getSource() {
      return this.source;
   }
}
