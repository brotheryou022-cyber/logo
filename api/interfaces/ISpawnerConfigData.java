package net.codava.virtualspawner.api.interfaces;

import java.util.Map;
import me.serbob.commons.objectholders.item.ClassicItem;
import me.serbob.commons.utils.builder.ItemBuilder;
import net.codava.virtualspawner.config.DropType;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;

public interface ISpawnerConfigData {
   ClassicItem getHead();

   EntityType getEntityType();

   Map<Material, DropType> getDrops();

   ItemBuilder getItem(int var1);

   Material getItemSpawnerMaterial();

   ItemBuilder getHead(ItemBuilder var1);

   String getDisplayName();

   long getMinUpdateTick();

   long getMaxUpdateTick();

   int getMinXp();

   int getMaxXp();

   String getColor();

   long getStorage();

   long getStorageXp();

   boolean isFullToCollect();

   boolean isItemSpawner();

   int getStackLimit();
}
