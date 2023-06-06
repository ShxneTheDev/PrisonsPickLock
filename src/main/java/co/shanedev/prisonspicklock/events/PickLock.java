package co.shanedev.prisonspicklock.events;

import co.shanedev.prisonspicklock.config;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;

public class PickLock implements Listener {


    @EventHandler
    public void InvClickLock (InventoryClickEvent event) { //clicktypes
        Player player = (Player) event.getWhoClicked();
        if(player.hasPermission("ppl.bypass")){
                // do nothing
        } else {

        if(event.getCurrentItem() == null) {
                //do nothing
            }
        else {
        if(event.getCurrentItem().getType().equals(Material.DIAMOND_PICKAXE)) {
            event.setCancelled(true);
            player.sendMessage(config.get().getString("Prefix").replace("&", "§") + config.get().getString("LockMessage").replace("&", "§"));
        }
        else if (event.getClick() == ClickType.NUMBER_KEY ) {
            event.setCancelled(true);
        }
        else if (event.getCursor().getType().equals(Material.DIAMOND_PICKAXE)) {
            event.setCancelled(true);
        }
    }}}

    @EventHandler
    public void InvDrop (PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if(player.hasPermission("ppl.bypass")){
            // do nothing
        } else {
        if(event.getItemDrop().getItemStack().getType().equals(Material.DIAMOND_PICKAXE)) {
            event.setCancelled(true);
            player.sendMessage(config.get().getString("Prefix").replace("&", "§") + config.get().getString("LockMessage").replace("&", "§"));
        }
    }}

    @EventHandler
    public void SwapHand (PlayerSwapHandItemsEvent event) {
        Player player = event.getPlayer();
        if(player.hasPermission("ppl.bypass")){
            // do nothing
        } else {
        if(event.getMainHandItem().getType().equals(Material.DIAMOND_PICKAXE) || event.getOffHandItem().getType().equals(Material.DIAMOND_PICKAXE)) {
            event.setCancelled(true);
            player.sendMessage(config.get().getString("Prefix").replace("&", "§") + config.get().getString("LockMessage").replace("&", "§"));
        }
    }}

}
