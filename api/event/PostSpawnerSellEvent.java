package net.codava.virtualspawner.api.event;

import java.util.Collection;
import net.codava.virtualspawner.api.interfaces.IStorage;
import net.codava.virtualspawner.api.interfaces.IVirtualSpawner;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PostSpawnerSellEvent extends Event {
   private static final HandlerList HANDLERS = new HandlerList();
   private final Player player;
   private final IVirtualSpawner virtualSpawner;
   private double money;
   private Collection<IStorage> content;

   public static HandlerList getHandlerList() {
      return HANDLERS;
   }

   public HandlerList getHandlers() {
      return HANDLERS;
   }

   public Player getPlayer() {
      return this.player;
   }

   public IVirtualSpawner getVirtualSpawner() {
      return this.virtualSpawner;
   }

   public double getMoney() {
      return this.money;
   }

   public PostSpawnerSellEvent(Player player, IVirtualSpawner virtualSpawner, double money, Collection<IStorage> content) {
      this.player = player;
      this.virtualSpawner = virtualSpawner;
      this.money = money;
      this.content = content;
   }

   public void setMoney(double money) {
      this.money = money;
   }

   public Collection<IStorage> getContent() {
      return this.content;
   }
}
