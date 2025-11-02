package net.codava.virtualspawner.api;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.UUID;
import net.codava.virtualspawner.SpawnerPlugin;
import net.codava.virtualspawner.api.interfaces.IChunkTicker;
import net.codava.virtualspawner.api.interfaces.IDropType;
import net.codava.virtualspawner.api.interfaces.ISpawnerManager;
import net.codava.virtualspawner.api.interfaces.IStorage;
import net.codava.virtualspawner.api.interfaces.IVirtualSpawner;
import net.codava.virtualspawner.config.SpawnerConfigData;
import net.codava.virtualspawner.spawner.core.VirtualSpawner;
import net.codava.virtualspawner.spawner.listener.SpawnerListener;
import net.codava.virtualspawner.spawner.managers.SpawnerManager;
import net.codava.virtualspawner.ticker.ChunkTicker;
import net.codava.virtualspawner.utils.general.Utils;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class VirtualSpawnerAPI {
   public static VirtualSpawner getByLocation(Location location) {
      ISpawnerManager var1 = (ISpawnerManager)((SpawnerPlugin)SpawnerPlugin.getPlugin(SpawnerPlugin.class)).getManager(SpawnerManager.class);
      ChunkTicker var2 = var1.getChunkTicker(location);
      if (var2 == null) {
         return null;
      } else {
         Iterator var3 = var2.getElements().values().iterator();

         VirtualSpawner var4;
         do {
            if (!var3.hasNext()) {
               return null;
            }

            var4 = (VirtualSpawner)var3.next();
         } while(!Utils.isSameLocation(var4.getLocation(), location));

         return var4;
      }
   }

   public static IChunkTicker getChunkTicker(Chunk chunk) {
      ISpawnerManager var1 = (ISpawnerManager)((SpawnerPlugin)SpawnerPlugin.getPlugin(SpawnerPlugin.class)).getManager(SpawnerManager.class);
      return var1.getChunkTicker(chunk);
   }

   public static Optional<IVirtualSpawner> getSpawner(Location location) {
      Block var1 = location.getBlock();
      if (var1.getType() != Material.SPAWNER) {
         return Optional.empty();
      } else {
         CreatureSpawner var2 = (CreatureSpawner)var1.getState();
         PersistentDataContainer var3 = var2.getPersistentDataContainer();
         if (!var3.has(SpawnerListener.SPAWNER_UUID, PersistentDataType.STRING)) {
            return Optional.empty();
         } else {
            UUID var4 = UUID.fromString((String)var3.get(SpawnerListener.SPAWNER_UUID, PersistentDataType.STRING));
            IChunkTicker var5 = getChunkTicker(location.getChunk());
            VirtualSpawner var6 = var5.getElement(var4);
            return var6 == null ? Optional.empty() : Optional.of(var6);
         }
      }
   }

   public static Collection<IStorage> getSpawnerStorage(IVirtualSpawner virtualSpawner) {
      return virtualSpawner.getContent();
   }

   public static Optional<IDropType> getDropTypeFromMaterial(Material material, SpawnerConfigData configData) {
      IDropType var2 = (IDropType)configData.getDrops().getOrDefault(material, (Object)null);
      return var2 == null ? Optional.empty() : Optional.of(var2);
   }

   public static boolean createSpawner(Location location, EntityType entityType, int stack) {
      SpawnerPlugin var3 = (SpawnerPlugin)SpawnerPlugin.getPlugin(SpawnerPlugin.class);
      SpawnerManager var4 = (SpawnerManager)var3.getManager(SpawnerManager.class);
      if (location.getBlock().getType() != Material.SPAWNER) {
         PrintStream var10000 = System.out;
         Material var10001 = location.getBlock().getType();
         var10000.println("Spawner location point to a " + var10001 + " block. (" + location.toString() + ")");
         return false;
      } else {
         CreatureSpawner var5 = (CreatureSpawner)location.getBlock().getState();
         var5.setSpawnedType(entityType);
         if (!var3.getSpawnerConfigDatas().containsKey(entityType)) {
            System.out.println("The entity '" + entityType + "' isn't support by virtualspawner (" + location.toString() + ")");
            return false;
         } else {
            PersistentDataContainer var6 = var5.getPersistentDataContainer();
            if (var6.has(SpawnerListener.SPAWNER_UUID, PersistentDataType.STRING)) {
               System.out.println("Spawner already added into virtualspawner .. (" + location.toString() + ")");
               return false;
            } else {
               UUID var7 = UUID.randomUUID();
               var6.set(SpawnerListener.SPAWNER_UUID, PersistentDataType.STRING, var7.toString());
               var5.update();
               var4.init(var7, var5, (Material)null, stack);
               return true;
            }
         }
      }
   }
}
