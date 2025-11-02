package net.codava.virtualspawner.api.event;

import java.util.Map;
import net.codava.virtualspawner.api.shop.ShopHook;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ShopRegistrationCompleteEvent extends Event {
   private static final HandlerList HANDLERS = new HandlerList();
   private final Map<String, ShopHook> registeredShops;
   private final ShopHook activeShop;

   public ShopRegistrationCompleteEvent(Map<String, ShopHook> registeredShops, ShopHook activeShop) {
      this.registeredShops = registeredShops;
      this.activeShop = activeShop;
   }

   @NotNull
   public HandlerList getHandlers() {
      return HANDLERS;
   }

   public static HandlerList getHandlerList() {
      return HANDLERS;
   }

   public Map<String, ShopHook> getRegisteredShops() {
      return this.registeredShops;
   }

   public ShopHook getActiveShop() {
      return this.activeShop;
   }
}
