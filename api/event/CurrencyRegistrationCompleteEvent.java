package net.codava.virtualspawner.api.event;

import java.util.Map;
import net.codava.virtualspawner.api.currency.CurrencyHook;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class CurrencyRegistrationCompleteEvent extends Event {
   private static final HandlerList HANDLERS = new HandlerList();
   private final Map<String, CurrencyHook> registeredCurrencies;
   private final CurrencyHook activeCurrency;

   public CurrencyRegistrationCompleteEvent(Map<String, CurrencyHook> registeredCurrencies, CurrencyHook activeCurrency) {
      this.registeredCurrencies = registeredCurrencies;
      this.activeCurrency = activeCurrency;
   }

   @NotNull
   public HandlerList getHandlers() {
      return HANDLERS;
   }

   public static HandlerList getHandlerList() {
      return HANDLERS;
   }

   public Map<String, CurrencyHook> getRegisteredCurrencies() {
      return this.registeredCurrencies;
   }

   public CurrencyHook getActiveCurrency() {
      return this.activeCurrency;
   }
}
