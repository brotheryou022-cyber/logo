package net.codava.virtualspawner.api.interfaces;

import org.bukkit.Material;

public interface IDropType {
   Material getMaterial();

   int getMinAmount();

   int getMaxAmount();

   double getChance();

   double getPrice();

   int getCustomModelData();

   String getItemsAdderName();

   void setPrice(double var1);

   int rollAmount();

   boolean roll();
}
