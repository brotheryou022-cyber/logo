package me.aquatic.confirmsell;

import net.codava.virtualspawner.api.event.PreSpawnerSellEvent;
import net.codava.virtualspawner.api.event.SpawnerMenuOpenEvent;
import net.codava.virtualspawner.api.interfaces.IVirtualSpawner;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ConfirmSellPlugin extends JavaPlugin implements Listener {

    private final Map<Player, IVirtualSpawner> pendingSell = new HashMap<>();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPreSell(PreSpawnerSellEvent event) {
        Player player = event.getPlayer();
        event.setCancelled(true); // Cancel original sell
        pendingSell.put(player, event.getVirtualSpawner());
        openConfirmMenu(player);
    }

    private void openConfirmMenu(Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, "ᴄᴏɴꜰɪʀᴍ ѕᴇʟʟ");

        // Cancel button
        ItemStack cancel = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta cancelMeta = cancel.getItemMeta();
        cancelMeta.setDisplayName(ChatColor.RED + "ᴄᴀɴᴄᴇʟ");
        cancelMeta.setLore(Collections.singletonList(ChatColor.WHITE + "Click to cancel"));
        cancel.setItemMeta(cancelMeta);
        inv.setItem(11, cancel);

        // Confirm button
        ItemStack confirm = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        ItemMeta confirmMeta = confirm.getItemMeta();
        confirmMeta.setDisplayName(ChatColor.GREEN + "ᴄᴏɴꜰɪʀᴍ");
        confirmMeta.setLore(Collections.singletonList(ChatColor.WHITE + "Click to confirm"));
        confirm.setItemMeta(confirmMeta);
        inv.setItem(15, confirm);

        player.openInventory(inv);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player player)) return;
        if (!event.getView().getTitle().equals("ᴄᴏɴꜰɪʀᴍ ѕᴇʟʟ")) return;

        event.setCancelled(true);

        IVirtualSpawner spawner = pendingSell.get(player);
        if (spawner == null) {
            player.closeInventory();
            return;
        }

        int slot = event.getSlot();

        if (slot == 11) { // Cancel
            player.closeInventory();
            pendingSell.remove(player);
            Bukkit.getPluginManager().callEvent(new SpawnerMenuOpenEvent(player, spawner));
            return;
        }

        if (slot == 15) { // Confirm
            player.closeInventory();
            pendingSell.remove(player);

            // Take all stock from spawner and sell
            spawner.takeAll(player);
            spawner.sellStock(player, 1, 1.0, true);

            player.sendMessage(ChatColor.GREEN + "Spawner stock sold successfully!");
        }
    }
}
