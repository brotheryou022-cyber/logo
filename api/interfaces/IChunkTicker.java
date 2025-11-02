package net.codava.virtualspawner.api.interfaces;

import java.util.Map;
import java.util.UUID;
import net.codava.virtualspawner.spawner.core.VirtualSpawner;

public interface IChunkTicker {
   VirtualSpawner getElement(UUID var1);

   void addElement(VirtualSpawner var1);

   void removeElement(UUID var1);

   void removeAllHolo();

   int size();

   Map<UUID, VirtualSpawner> getElements();
}
