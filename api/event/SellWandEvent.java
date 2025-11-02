package net.codava.virtualspawner.api.event;

import java.util.List;
import net.codava.virtualspawner.api.enums.SellWandMode;
import net.codava.virtualspawner.api.interfaces.IVirtualSpawner;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SellWandEvent extends Event implements Cancellable {
   private static final HandlerList HANDLERS = new HandlerList();
   private boolean cancelled = false;
   private final Player player;
   private final SellWandMode mode;
   private List<IVirtualSpawner> spawners;
   private double price;
   private double multiplier;

   public SellWandEvent(Player player, SellWandMode mode, List<IVirtualSpawner> spawners, double price, double multiplier) {
      this.player = player;
      this.mode = mode;
      this.spawners = spawners;
      this.price = price;
      this.multiplier = multiplier;
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

   public Player getPlayer() {
      return this.player;
   }

   public SellWandMode getMode() {
      return this.mode;
   }

   public List<IVirtualSpawner> getSpawners() {
      return this.spawners;
   }

   public double getPrice() {
      return this.price;
   }

   public double getMultiplier() {
      return this.multiplier;
   }

   public void setSpawners(List<IVirtualSpawner> spawners) {
      this.spawners = spawners;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public void setMultiplier(double multiplier) {
      this.multiplier = multiplier;
   }
}
