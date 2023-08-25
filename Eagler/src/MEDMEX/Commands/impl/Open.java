package MEDMEX.Commands.impl;

import MEDMEX.Client;
import MEDMEX.Commands.Command;
import MEDMEX.Modules.Module;
import MEDMEX.Modules.Player.KeepContainer;

public class Open extends Command {
	
	public Open() {
		super("Open", "Open last container", "Open", "open");
		
	}

	@Override
	public void onCommand(String[] args, String command) {
		try {
			if (!KeepContainer.instance.isEnabled())
			{
				Client.addChatMessage("Turn on KeepContainer first.");
				return;
			}
			if(KeepContainer.instance.container == null)
			{
				Client.addChatMessage("Open a container first.");
				return;
			}
			KeepContainer.instance.shouldOpen = true;
			Client.addChatMessage("Attempted to open last container.");
			
		} catch (Exception e) {
			Client.addChatMessage("Usage: Open");
		}
		
	}

}
