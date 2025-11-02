package net.codava.virtualspawner.api.interfaces;

import java.util.Map;
import net.codava.virtualspawner.abstracts.AbstractGui;
import net.codava.virtualspawner.abstracts.AbstractManager;
import net.codava.virtualspawner.config.EntityConfig;
import net.codava.virtualspawner.config.SpawnerConfigData;
import org.bukkit.entity.EntityType;

public interface ISpawnerPlugin {
   EntityConfig getEntityConfig();

   Map<EntityType, SpawnerConfigData> getSpawnerConfigDatas();

   SpawnerConfigData getSpawnerConfig(EntityType var1);

   <T extends AbstractManager> T getManager(Class<T> var1);

   <T extends AbstractGui> T getGui(Class<T> var1);
}
