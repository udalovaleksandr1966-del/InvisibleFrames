package com.example.invisibleframes;

import com.example.invisibleframes.listeners.FrameListener;
import org.bukkit.plugin.java.JavaPlugin;

public class InvisibleFrames extends JavaPlugin {

    private static InvisibleFrames instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new FrameListener(), this);
        getLogger().info("InvisibleFrames v2.0 enabled!");
        getLogger().info("Use Shears + Shift to toggle frame visibility");
    }

    @Override
    public void onDisable() {
        getLogger().info("InvisibleFrames disabled!");
    }

    public static InvisibleFrames getInstance() {
        return instance;
    }
}
