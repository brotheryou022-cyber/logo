package net.codava.virtualspawner.api.currency;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Player;

public class CurrencyManager {
   private final Map<String, CurrencyHook> registeredCurrencies = new HashMap();
   private CurrencyHook activeCurrency = null;

   public static CurrencyManager getInstance() {
      return CurrencyManager.LazyHolder.INSTANCE;
   }

   private CurrencyManager() {
   }

   public void registerCurrency(CurrencyHook currencyHook) {
      this.registeredCurrencies.put(currencyHook.getName().toLowerCase(), currencyHook);
   }

   public boolean setActiveCurrency(String currencyName) {
      if (currencyName.equalsIgnoreCase("none")) {
         this.activeCurrency = null;
         return true;
      } else {
         CurrencyHook var2 = (CurrencyHook)this.registeredCurrencies.get(currencyName.toLowerCase());
         if (var2 != null) {
            this.activeCurrency = var2;
            var2.init();
            return true;
         } else {
            return false;
         }
      }
   }

   public double getBalance(Player player) {
      return this.activeCurrency == null ? 0.0D : this.activeCurrency.getBalance(player);
   }

   public void withdraw(Player player, double amount) {
      if (this.activeCurrency != null) {
         this.activeCurrency.withdraw(player, amount);
      }

   }

   public void deposit(Player player, double amount) {
      if (this.activeCurrency != null) {
         this.activeCurrency.deposit(player, amount);
      }

   }

   public CurrencyHook getActiveCurrency() {
      return this.activeCurrency;
   }

   public Map<String, CurrencyHook> getRegisteredCurrencies() {
      return this.registeredCurrencies;
   }

   private static class LazyHolder {
      public static CurrencyManager INSTANCE = new CurrencyManager();
   }
}
