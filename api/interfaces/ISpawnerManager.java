package net.codava.virtualspawner.api.interfaces;

import java.util.UUID;
import net.codava.virtualspawner.ticker.ChunkTicker;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;

public interface ISpawnerManager {
   ChunkTicker getChunkTicker(Chunk var1);

   ChunkTicker getChunkTicker(Location var1);

   void init(UUID var1, CreatureSpawner var2, Material var3, int var4);

   void init(UUID var1, CreatureSpawner var2, Material var3);
}
