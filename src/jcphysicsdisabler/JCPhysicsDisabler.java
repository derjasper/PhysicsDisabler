package jcphysicsdisabler;

import java.util.logging.Logger;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class JCPhysicsDisabler extends JavaPlugin {
    private JCPDListenerSimple listener;
    private JCPDListenerRegions listener2;
    private JCPDCommandExecutor command;
    private static final Logger log = Logger.getLogger("Minecraft");
    
    @Override
    public void onEnable() {       
        listener = new JCPDListenerSimple(this);
        listener2 = new JCPDListenerRegions(this);
        command = new JCPDCommandExecutor(this);

        getCommand("disablephysics").setExecutor(command);
        
        log.info("JCPhysicsDisabler by JupiterCraft.de.vu started");
    }
    
    @Override
    public void onDisable(){
        log.info("JCPhysicsDisabler by JupiterCraft.de.vu stopped");
    }
    
    public void setDisabled(int i) {
        HandlerList.unregisterAll(listener);
        HandlerList.unregisterAll(listener2);
        
        if (i==1) {
            getServer().getPluginManager().registerEvents(listener, this);
        }
        else if (i==2) {
            getServer().getPluginManager().registerEvents(listener2, this);
        }
    }
    
    public void addRegion(String name, JCPDRegion region) {
        listener2.addRegion(name, region);
    }
    
    public void removeRegion(String name) {
        listener2.removeRegion(name);
    }
    
    public boolean existsRegion(String name) {
        return listener2.existsRegion(name);
    }
}
