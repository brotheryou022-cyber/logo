package net.codava.virtualspawner.api.shop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.codava.virtualspawner.SpawnerPlugin;
import net.codava.virtualspawner.config.DropType;
import net.codava.virtualspawner.config.SpawnerConfigData;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ShopManager {
   private final Map<String, ShopHook> registeredShops = new HashMap();
   private ShopHook activeShop = null;

   public static ShopManager getInstance() {
      return ShopManager.LazyHolder.INSTANCE;
   }

   private ShopManager() {
   }

   public void registerShop(ShopHook shopHook) {
      this.registeredShops.put(shopHook.getName().toLowerCase(), shopHook);
   }

   public boolean setActiveShop(String shopName) {
      if (shopName.equalsIgnoreCase("none")) {
         this.activeShop = null;
         return true;
      } else {
         ShopHook var2 = (ShopHook)this.registeredShops.get(shopName.toLowerCase());
         if (var2 != null) {
            this.activeShop = var2;
            var2.init();
            return true;
         } else {
            return false;
         }
      }
   }

   public double getPrice(Material material) {
      return this.activeShop == null ? -1.0D : this.activeShop.getSellPrice(material);
   }

   public double getPrice(Player player, Material material) {
      return this.activeShop == null ? -1.0D : this.activeShop.getSellPrice(player, material);
   }

   public ShopHook getActiveShop() {
      return this.activeShop;
   }

   public boolean hasAnActiveShop() {
      return this.activeShop != null;
   }

   public void syncPrices() {
      if (this.activeShop != null) {
         Iterator var1 = SpawnerPlugin.get().getItemSpawnerConfig().getItemSpawnerConfigMap().values().iterator();

         SpawnerConfigData var2;
         Iterator var3;
         DropType var4;
         double var5;
         while(var1.hasNext()) {
            var2 = (SpawnerConfigData)var1.next();
            var3 = var2.getDrops().values().iterator();

            while(var3.hasNext()) {
               var4 = (DropType)var3.next();
               var5 = this.activeShop.getSellPrice(var4.getMaterial());
               if (var5 > 0.0D) {
                  var4.setPrice(var5);
               }
            }
         }

         var1 = SpawnerPlugin.get().getSpawnerConfigDatas().values().iterator();

         while(var1.hasNext()) {
            var2 = (SpawnerConfigData)var1.next();
            var3 = var2.getDrops().values().iterator();

            while(var3.hasNext()) {
               var4 = (DropType)var3.next();
               var5 = this.activeShop.getSellPrice(var4.getMaterial());
               if (var5 > 0.0D) {
                  var4.setPrice(var5);
               }
            }
         }

      }
   }

   public Map<String, ShopHook> getRegisteredShops() {
      return this.registeredShops;
   }

   private static class LazyHolder {
      public static ShopManager INSTANCE = new ShopManager();
   }
}
