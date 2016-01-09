PhysicsDisabler Bukkit Plugin
=============================

This is a Bukkit Plugin which I wrote years ago. Since it had a few downloads, I decided to release the code for others to have fun with it. 

Tested with CB 1.5.1-R0.1.

License: MIT.

Original BukkitDev description
==============================

This is a tool to disable Minecrafts block updates, item- and creature spawning with a single command. It's useful for illegal block placements with WorldEdit or bad CraftBook-spawners, helps with most of buggy areas.

Just type `disablephysics mode on` and fix the issues with WorldEdit etc and re-enable physics with `disablephysics mode off`. For more details see "Usage" section.

The plugin does not affect the server performance, event-handlers will be unregistered after re-enabling block updates. So you do not have to uninstall it after use.

Installation
------------
Simply copy the `JCPhysicsDisabler.jar` in your plugins folder.

Usage
-----
**The syntax has changed in version 1.1**


**Command syntax:** `/disablephysics [ mode [on|off|region] | addregion (regionname) (worldname) [(x)|(y)|(z) (x)|(y)|(z)] | removeregion (regionname) ]`


`disablephysics mode on` - Disable block updates, item- and creature spawing everywhere on the server

`disablephysics mode off` - Re-enable physics

`disablephysics mode region` - Disable physics in selected regions

`disablephysics addregion (regionname) (worldname)` - Add a world as region

`disablephysics addregion (regionname) (worldname) (x)|(y)|(z) (x)|(y)|(z)` - Add a region between two coordinates.

`disablephysics removeregion (regionname)` - Remova a region.


**Permission** is `JCPD.disablephysics`
