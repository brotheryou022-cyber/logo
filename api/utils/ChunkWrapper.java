package net.codava.virtualspawner.api.utils;

import java.util.Objects;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;

public class ChunkWrapper {
   private final int x;
   private final int z;

   public ChunkWrapper(Location location) {
      this.x = location.getBlockX() >> 4;
      this.z = location.getBlockZ() >> 4;
   }

   public ChunkWrapper(Chunk chunk) {
      this.x = chunk.getX();
      this.z = chunk.getZ();
   }

   public int getX() {
      return this.x;
   }

   public int getZ() {
      return this.z;
   }

   public Chunk getBukkit(World world) {
      return world.getChunkAt(this.x, this.z);
   }

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         ChunkWrapper var2 = (ChunkWrapper)o;
         return this.x == var2.x && this.z == var2.z;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.x, this.z});
   }
}
