package net.codava.virtualspawner.api.interfaces;

import java.util.Map;
import java.util.UUID;
import net.codava.virtualspawner.api.utils.ChunkWrapper;
import net.codava.virtualspawner.api.utils.WorldWrapper;
import net.codava.virtualspawner.spawner.core.VirtualSpawner;
import net.codava.virtualspawner.ticker.ChunkTicker;
import org.bukkit.Location;

public interface ISpawnerTicker {
   VirtualSpawner getSpawner(Location var1, UUID var2);

   void removeSpawner(UUID var1);

   Map<WorldWrapper, Map<ChunkWrapper, ChunkTicker>> getChunkMap();
}
