package net.codava.virtualspawner.api.shop;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public interface ShopHook {
   String getName();

   void init();

   double getSellPrice(Material var1);

   double getSellPrice(Player var1, Material var2);
}
