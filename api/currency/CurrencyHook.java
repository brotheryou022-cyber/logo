package net.codava.virtualspawner.api.currency;

import org.bukkit.entity.Player;

public interface CurrencyHook {
   String getName();

   void init();

   double getBalance(Player var1);

   void withdraw(Player var1, double var2);

   void deposit(Player var1, double var2);
}
