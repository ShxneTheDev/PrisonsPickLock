package co.shanedev.prisonspicklock.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DeathEvent implements Listener {



    ItemStack is = new ItemStack(Material.DIAMOND_PICKAXE); // and more itemstacks for other pickaxes


    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player player = e.getEntity().getPlayer();
        assert player != null;
        if(player.getInventory().contains(is)) {
            e.getDrops().remove(is);
        }


    }


    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        Player player = e.getPlayer();
        //map.get(is);
        player.getInventory().addItem(is);
    }


}

