package net.codava.virtualspawner.api.utils;

import java.util.Objects;
import org.bukkit.Bukkit;
import org.bukkit.World;

public class WorldWrapper {
   private final String name;

   public WorldWrapper(String name) {
      this.name = name;
   }

   public WorldWrapper(World world) {
      this.name = world.getName();
   }

   public String getName() {
      return this.name;
   }

   public World getBukkit() {
      return Bukkit.getWorld(this.name);
   }

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         WorldWrapper var2 = (WorldWrapper)o;
         return Objects.equals(this.name, var2.name);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.name});
   }

   public String toString() {
      return "WorldWrapper{name='" + this.name + "'}";
   }
}
