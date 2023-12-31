package MEDMEX.Commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import MEDMEX.Client;
import MEDMEX.Commands.impl.*;
import MEDMEX.Event.listeners.EventChat;



public class CommandManager {
	
	
	public static boolean chatencryption = false;
	public static List<Command> commands = new ArrayList<Command>();
	public String prefix = ".";
	
	public CommandManager() {
		setup();
	}
	
	public void setup() {
		commands.add(new Toggle());
		commands.add(new DupeBook1());
		commands.add(new DupeBook2());
		commands.add(new Bind());
		commands.add(new Open());
		commands.add(new Vclip());
		commands.add(new Pages());
		commands.add(new Enchant());
		
	}
	
	public void handleChat(EventChat event) {
		String message = event.getMessage();
		
		
		if(!message.startsWith(prefix))
			return;
		
		
		event.setCancelled(true);
		
		message = message.substring(prefix.length());
		
		boolean foundCommand = false;
		
		if(message.split(" ").length > 0);
		String commandName = message.split(" ")[0];
		
		for(Command c : commands) {
			if(c.aliases.contains(commandName) || c.name.equalsIgnoreCase(commandName)) {
				c.onCommand(Arrays.copyOfRange(message.split(" "), 1, message.split(" ").length), message);
				foundCommand = true;
				break;
			}
			
		}
		if(!foundCommand) {
			Client.addChatMessage("Could not find command.");
		}
		
	}
	
	
}