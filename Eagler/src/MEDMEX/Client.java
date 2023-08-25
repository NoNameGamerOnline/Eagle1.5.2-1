package MEDMEX;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import MEDMEX.Commands.CommandManager;
import MEDMEX.Config.WebConfig;
import MEDMEX.Event.Event;
import MEDMEX.Event.EventPacket;
import MEDMEX.Event.listeners.EventChat;
import MEDMEX.Modules.Module;
import MEDMEX.Modules.Module.Category;
import MEDMEX.Modules.Client.*;
import MEDMEX.Modules.Combat.*;
import MEDMEX.Modules.Movement.*;
import MEDMEX.Modules.Player.*;
import MEDMEX.Modules.Render.*;
import MEDMEX.Modules.World.ServerCrasher;
import de.Hero.settings.SettingsManager;
import net.lax1dude.eaglercraft.LocalStorageManager;
import net.minecraft.client.Minecraft;
import net.minecraft.src.Packet;

public class Client {
	public static String name = "OddFutureX", version = "1";
	public static ArrayList<Integer> xrayblocks = new ArrayList<Integer>();
	public static ArrayList<Module> modules = new ArrayList<Module>();
	public static ArrayList<String> friends = new ArrayList<String>();
	public static ArrayList<Module> drawn = new ArrayList<Module>();
	public static CommandManager commandManager = new CommandManager();
	public static SettingsManager settingsmanager;

	
	public static void startup(){
		settingsmanager = new SettingsManager();
		
		modules.add(new ClickGUI());
		modules.add(new HUD());
		modules.add(new Nametags());
		modules.add(new Sprint());
		modules.add(new Speed());
		modules.add(new NoSlow());
		modules.add(new KillAura());
		modules.add(new Tracers());
		modules.add(new Freecam());
		modules.add(new Fullbright());
		modules.add(new KeepContainer());
		modules.add(new Xray());
		modules.add(new ServerCrasher());
		modules.add(new Fastplace());
		modules.add(new NoRender());
		modules.add(new Regen());
		modules.add(new TargetStrafe());
		modules.add(new NoFall());
		modules.add(new AntiHunger());
		modules.add(new FastUse());
		modules.add(new Fly());
		modules.add(new Velocity());
		modules.add(new Shadow());
		
		LocalStorageManager.loadConfig();
		WebConfig.loadConfig();
		
		System.out.println("Loading "+ name +" "+ version);
	}
	
public static void onEvent(Event e) {
		
		if(e instanceof EventChat) {
			commandManager.handleChat((EventChat)e);
			
		}
		
		for(Module m: modules) {
			if(!m.toggled)
				continue;
			
			m.onEvent(e);
		}
	}
public static void keyPress(int key) {
	for(Module m : modules) {
		if(key == m.getKey()) {
			m.toggle();
		}
	}
	
}

public static String onMessage(String s) {
	for(Module m : modules) {
		m.onMessage(s);
	}
	return s;
}

public static void onRenderGUI() {
	  for(Module m : modules) {
		  if(!m.toggled)
			  continue;
		  m.onRenderGUI();
	  }
	  
}

public static void sendPacket(Packet p) {
	Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(p);
}

public static void onRender() {
    for (Module m : modules)
      m.onRender(); 
    for (Module m : modules)
      m.onLateRender(); 
  }

public static void onRenderEntities() {
	  for(Module m : modules) {
		  if(!m.toggled)
			  continue;
		  m.onRender();
}
}

public static void getPacket(EventPacket e) {
	  for(Module m : modules) {
		  if(!m.toggled)
			  continue;
		  m.getPacket(e);
	  }
}

public static List<Module> getModuleByCategory(Category c){
	List<Module> modules = new ArrayList<Module>();
	for(Module m : Client.modules) {
		if(m.category == c)
			modules.add(m);
	}
	return modules;
	
}

public static List<Module> getModules(){
	List<Module> modules = new ArrayList<Module>();
	for(Module m : Client.modules) {
			modules.add(m);
	}
	
	return modules;
	
}

public static void addChatMessage(String message) {
	message = "\2474>\u00A77" + message;
	Minecraft.theMinecraft.thePlayer.addChatMessage(new String(message));
}
}
