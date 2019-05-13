// 
// Decompiled by Procyon v0.5.30
// 

package plugins.oldhc.motd;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener
{
    String motd1;
    String motd2;
    
    public Main() {
        this.motd1 = ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("motd1"));
        this.motd2 = ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("motd2"));
    }
    
    public void onEnable() {
        this.saveDefaultConfig();
        Bukkit.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this);
    }
    
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onServerListPing(final ServerListPingEvent event) {
        event.setMotd(String.valueOf(this.motd1) + "\n" + this.motd2);
    }
}
