package net.codava.virtualspawner.api.interfaces;

import org.bukkit.Material;

public interface IStorage {
   Material getMaterial();

   long getAmount();

   void setMaterial(Material var1);

   void setAmount(long var1);
}
