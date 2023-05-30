Simple Resource on creating Join Messages.
Links to the Documentation are at the Bottom!

The Main Class
This class extends 'JavaPlugin', it by default it should look something like this.
[code=Java]package com.example.joinmessages;

import org.bukkit.plugin.java.JavaPlugin;

public final class JoinMessages extends JavaPlugin {

    @Override
    public void onEnable() {
    }
}[/code]

The Listener
Now that we have our Main Class, we can start with our Listener, a Listener, is a Class that Listens for certain event, like the Join Event or the Death Event, these can be very useful if used correctly!

Well start out with an empty Java Class:
[code=Java]package com.example.joinmessages;

public class JoinListener {
}[/code]

Now, we implement the Bukkit Listener 'Listener' it should look something like this:
[code=Java]package com.example.joinmessages;

import org.bukkit.event.Listener;

public class JoinListener implements Listener {
}[/code]

Then, we create our first Function in this case ill call it 'onPlayerJoinEvent':
[code=Java]
package com.example.joinmessages;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(){
    }
}[/code]
Into this functions Brackets, we add our Listener in this case, because were trying to get a Join Message, were using 'PlayerJoinEvent', behind that, we add how we want to call the Event in this case I'm using 'event', but you can use whatever you want, but 'e' or 'event' is recommended! We also import 'org.bukkit.event.player.PlayerJoinEvent', your Listener class should now look something like this:
[code=Java]package com.example.joinmessages;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;

public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();
    }

}[/code]
In our function we now get the player from the event with:
[code=Java]Player player = event.getPlayer();[/code]
Now, we can edit the Join Message, by entering a valid String, following is an example:
[code=Java]event.setJoinMessage("[+] " + player.getName());[/code]
Our Event Class should now look something like this:

[code=Java]package com.example.joinmessages;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage("[+] " + player.getName());
    }

}[/code]

Registering the Event/Listener
Now we go back to our Main Class and add the Following code to our 'onEnable()'
[code=Java]Bukkit.getPluginManager().registerEvents(new JoinListener(), this);[/code]
The variable 'this', since were in the Main Class, is the Plugin (Instance).
Our Main Class should finally look something like this:
[code=Java]package com.example.joinmessages;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoinMessages extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
    }
}[/code]

Extra
If you want to add extra flare (Color) to your Join Message or your Messages in general you can add this:
[code=Java]ChatColor.RED
ChatColor.YELLOW
ChatColor.GREEN
ChatColor.BLUE
ChatColor.AQUA[/code]

An Example of Color Usage on our Join Message:
[code=Java]event.setJoinMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + ChatColor.GRAY + player.getName());[/code]

Useful Content
https://hub.spigotmc.org/javadocs/spigot/index.html?overview-summary.html
[SPOILER="Just to Test"]https://github.com/Bedlesssgod/Spigot-JoinMessages[/SPOILER]

If you think there's any naming conventions that need fixing Please let me know!