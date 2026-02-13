package com.example.invisibleframes.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class FrameListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        if (!(event.getRightClicked() instanceof ItemFrame frame)) {
            return;
        }

        Player player = event.getPlayer();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();

        if (itemInHand.getType() != Material.SHEARS) {
            return;
        }

        if (!player.isSneaking()) {
            return;
        }

        if (!player.hasPermission("invisibleframes.use")) {
            player.sendMessage(ChatColor.RED + "No permission!");
            return;
        }

        event.setCancelled(true);

        boolean isInvisible = !frame.isVisible();
        frame.setVisible(isInvisible);
        frame.setFixed(isInvisible);

        player.playSound(player.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_HIT, 1.0f, isInvisible ? 0.5f : 1.5f);

        String status = isInvisible ? ChatColor.GREEN + "invisible" : ChatColor.GRAY + "visible";
        player.sendMessage(ChatColor.YELLOW + "Frame is now " + status + ChatColor.YELLOW + "!");

        if (itemInHand.getDurability() < itemInHand.getType().getMaxDurability() - 1) {
            itemInHand.setDurability((short) (itemInHand.getDurability() + 1));
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onHangingBreak(HangingBreakByEntityEvent event) {
        if (!(event.getEntity() instanceof ItemFrame frame)) {
            return;
        }

        if (!frame.isVisible()) {
            if (event.getRemover() instanceof Player player) {
                if (!player.hasPermission("invisibleframes.break")) {
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "Protected invisible frame! Use Shears + Shift.");
                }
            } else {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onInteractInvisibleFrame(PlayerInteractEntityEvent event) {
        if (!(event.getRightClicked() instanceof ItemFrame frame)) {
            return;
        }

        if (frame.isVisible()) {
            return;
        }

        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item.getType() == Material.SHEARS && player.isSneaking()) {
            return;
        }

        if (!player.hasPermission("invisibleframes.interact")) {
            event.setCancelled(true);
        }
    }
}
