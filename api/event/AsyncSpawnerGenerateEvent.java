package net.codava.virtualspawner.api.event;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import net.codava.virtualspawner.api.interfaces.IDropType;
import net.codava.virtualspawner.api.interfaces.IStorage;
import net.codava.virtualspawner.api.interfaces.IVirtualSpawner;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AsyncSpawnerGenerateEvent extends Event implements Cancellable {
   private static final HandlerList HANDLERS = new HandlerList();
   private boolean cancelled = false;
   private final IVirtualSpawner virtualSpawner;
   private long xp;
   private final IDropType[] dropTypes;
   private final long[] amounts;
   private final int dropCount;

   public AsyncSpawnerGenerateEvent(IVirtualSpawner virtualSpawner, long xp, IDropType[] dropTypes, long[] amounts, int dropCount) {
      super(true);
      this.virtualSpawner = virtualSpawner;
      this.xp = xp;
      this.dropTypes = dropTypes;
      this.amounts = amounts;
      this.dropCount = dropCount;
   }

   public int getDropCount() {
      return this.dropCount;
   }

   public IDropType getDropType(int index) {
      return this.dropTypes[index];
   }

   public long getAmount(int index) {
      return this.amounts[index];
   }

   public void setAmount(int index, long amount) {
      this.amounts[index] = amount;
   }

   public long getXp() {
      return this.xp;
   }

   public void setXp(long xp) {
      this.xp = xp;
   }

   /** @deprecated */
   @Deprecated
   public Map<IDropType, Long> getDrops() {
      HashMap var1 = new HashMap(this.dropCount);

      for(int var2 = 0; var2 < this.dropTypes.length; ++var2) {
         if (this.amounts[var2] > 0L) {
            var1.put(this.dropTypes[var2], this.amounts[var2]);
         }
      }

      return var1;
   }

   /** @deprecated */
   @Deprecated
   public void setDrops(Map<IDropType, Long> drops) {
      Arrays.fill(this.amounts, 0L);

      for(int var2 = 0; var2 < this.dropTypes.length; ++var2) {
         Long var3 = (Long)drops.get(this.dropTypes[var2]);
         if (var3 != null) {
            this.amounts[var2] = var3;
         }
      }

   }

   public IVirtualSpawner getVirtualSpawner() {
      return this.virtualSpawner;
   }

   public Collection<IStorage> getContent() {
      return this.virtualSpawner.getContent();
   }

   public static HandlerList getHandlerList() {
      return HANDLERS;
   }

   public HandlerList getHandlers() {
      return HANDLERS;
   }

   public boolean isCancelled() {
      return this.cancelled;
   }

   public void setCancelled(boolean cancelled) {
      this.cancelled = cancelled;
   }
}
