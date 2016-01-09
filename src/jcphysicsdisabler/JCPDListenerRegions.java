package jcphysicsdisabler;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.ItemSpawnEvent;

public class JCPDListenerRegions implements Listener {
    private JCPhysicsDisabler plugin;
    private HashMap<String,JCPDRegion> regions;
    
    public JCPDListenerRegions(JCPhysicsDisabler plugin) {
        this.plugin=plugin;
        this.regions=new HashMap<String,JCPDRegion>();
    }
    
    public void addRegion(String name, JCPDRegion region) {
        this.regions.put(name, region);
    }
    
    public void removeRegion(String name) {
        this.regions.remove(name);
    }
    
    public boolean existsRegion(String name) {
        return this.regions.containsKey(name);
    }
    
    public boolean isInRegion(Location l) {
        for(Map.Entry<String,JCPDRegion> e : this.regions.entrySet()){
            if (e.getValue().isInRegion(l)) return true;
        }
        return false;
    }
    
    @EventHandler
    public void onBlockPhysics(BlockPhysicsEvent event) {
        if (this.isInRegion(event.getBlock().getLocation())) event.setCancelled(true);
    }
    
    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (this.isInRegion(event.getLocation())) event.setCancelled(true);
    }
    
    @EventHandler
    public void onItemSpawn(ItemSpawnEvent event) {
        if (this.isInRegion(event.getLocation())) event.setCancelled(true);
    }
}