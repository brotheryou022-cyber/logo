package net.codava.virtualspawner.api.interfaces;

import java.util.Collection;
import java.util.UUID;
import net.codava.virtualspawner.config.SpawnerConfigData;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface IVirtualSpawner {
   UUID getUuid();

   boolean isCorrupted();

   long getContentAmount();

   SpawnerConfigData getSpawnerConfigData();

   void remove();

   void remove(boolean var1);

   Collection<IStorage> getContent();

   IStorage getContent(Material var1);

   Location getLocation();

   void addStack();

   void addStack(int var1);

   void setStack(int var1);

   void removeStack();

   void removeStack(int var1);

   long getStack();

   EntityType getEntityType();

   void clearStock();

   int getXp();

   void setXp(int var1);

   void takeOne(Player var1, Material var2);

   int takeStack(Player var1, Material var2);

   void takeAll(Player var1);

   ItemStack getItemFromStock(Material var1, int var2);

   void sellStock(Player var1, int var2, double var3, boolean var5);

   void sellXP(Player var1, int var2, boolean var3);

   default void sellStock(Player player, int delay, double multiplier) {
      this.sellStock(player, delay, multiplier, true);
   }

   default void sellStock(Player player, int delay, boolean showNotification) {
      this.sellStock(player, delay, 1.0D, showNotification);
   }

   default void sellStock(Player player, int delay) {
      this.sellStock(player, delay, 1.0D, true);
   }

   default void sellXP(Player player, int delay) {
      this.sellXP(player, delay, true);
   }
}
