package net.codava.virtualspawner.api.event;

import java.util.Collection;
import net.codava.virtualspawner.api.interfaces.IStorage;
import net.codava.virtualspawner.api.interfaces.IVirtualSpawner;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PreSpawnerSellEvent extends Event implements Cancellable {
   private static final HandlerList HANDLERS = new HandlerList();
   private boolean cancelled = false;
   private IVirtualSpawner virtualSpawner;
   private Player player;
   private double amount;

   public PreSpawnerSellEvent(Player player, IVirtualSpawner virtualSpawner, double amount) {
      this.player = player;
      this.virtualSpawner = virtualSpawner;
      this.amount = amount;
   }

   public double getAmount() {
      return this.amount;
   }

   public void setAmount(double amount) {
      this.amount = amount;
   }

   public Collection<IStorage> getContent() {
      return this.virtualSpawner.getContent();
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
