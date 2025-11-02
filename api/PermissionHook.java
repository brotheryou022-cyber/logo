package net.codava.virtualspawner.api;

import me.serbob.commons.enums.ConfigSelector;
import net.codava.virtualspawner.SpawnerPlugin;
import net.codava.virtualspawner.api.event.SellWandEvent;
import net.codava.virtualspawner.api.event.SpawnerAfterPlaceEvent;
import net.codava.virtualspawner.api.event.SpawnerBreakEvent;
import net.codava.virtualspawner.api.event.SpawnerExplodeEvent;
import net.codava.virtualspawner.api.event.SpawnerMenuOpenEvent;
import net.codava.virtualspawner.api.event.SpawnerPlaceEvent;
import net.codava.virtualspawner.api.event.SpawnerStackEvent;

public abstract class PermissionHook {
   private boolean enabled = false;

   public boolean shouldLoad() {
      if (this.pluginName().isEmpty()) {
         return true;
      } else {
         String var1 = "hooks." + this.pluginName().toLowerCase();
         if (!ConfigSelector.HOOKS.getConfig().contains(var1)) {
            ConfigSelector.HOOKS.getConfig().set(var1, true);
         }

         return ConfigSelector.HOOKS.getConfig().getBoolean(var1, true);
      }
   }

   protected abstract String pluginName();

   public abstract void init(SpawnerPlugin var1);

   public abstract void spawnerBreak(SpawnerBreakEvent var1);

   public void spawnerExplode(SpawnerExplodeEvent event) {
   }

   public abstract void spawnerMenuOpen(SpawnerMenuOpenEvent var1);

   public abstract void spawnerPlace(SpawnerPlaceEvent var1);

   public void spawnerAfterPlace(SpawnerAfterPlaceEvent event) {
   }

   public abstract void spawnerStack(SpawnerStackEvent var1);

   public void sellWand(SellWandEvent event) {
   }

   public void setEnabled(boolean enabled) {
      this.enabled = enabled;
   }

   public boolean isEnabled() {
      return this.enabled;
   }
}
