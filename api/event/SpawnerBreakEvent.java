package net.codava.virtualspawner.api.event;

import net.codava.virtualspawner.api.interfaces.IVirtualSpawner;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SpawnerBreakEvent extends Event implements Cancellable {
   private static final HandlerList HANDLERS = new HandlerList();
   private boolean cancelled = false;
   private IVirtualSpawner virtualSpawner;
   private Player player;

   public SpawnerBreakEvent(Player player, IVirtualSpawner virtualSpawner) {
      this.player = player;
      this.virtualSpawner = virtualSpawner;
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
}
