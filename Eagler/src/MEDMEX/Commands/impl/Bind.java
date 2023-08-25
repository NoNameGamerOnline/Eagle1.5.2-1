package MEDMEX.Commands.impl;


import MEDMEX.Client;
import MEDMEX.Commands.Command;
import MEDMEX.Modules.Module;
import MEDMEX.Utils.lwjgl;
import net.lax1dude.eaglercraft.EaglerAdapter;



public class Bind extends Command {
	
	public Bind() {
		super("Bind", "Binds a module by name.", "bind <name/clear> <key>", "b");
		
	}

	@Override
	public void onCommand(String[] args, String command) {
		if(args.length == 0) {
			Client.addChatMessage("Usage: bind <module> <key> or bind clear");
		}
		if(args.length == 2) {
			String moduleName = args[0];
			String keyName = args[1];
			
			for(Module module : Client.modules) {
				if(module.name.equalsIgnoreCase(moduleName)) {
					module.keyCode.setKeyCode(lwjgl.getKeyIndex(keyName.toUpperCase()));
					Client.addChatMessage(String.format("Bound %s to %s", module.name, EaglerAdapter.getKeyName(module.getKey())));
					
					break;
				}
			}
		}
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("clear")) {
				Client.addChatMessage("Cleared all binds.");
				for(Module module : Client.modules) {
					module.keyCode.setKeyCode(EaglerAdapter.KEY_NONE);
				}
			}else {
				Client.addChatMessage("Usage: bind <module> <key> or bind clear");
			}
		
		}
		
	}

}
