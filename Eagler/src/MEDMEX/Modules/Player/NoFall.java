package MEDMEX.Modules.Player;


import MEDMEX.Client;
import MEDMEX.Event.Event;
import MEDMEX.Event.EventPacket;
import MEDMEX.Event.listeners.EventUpdate;
import MEDMEX.Modules.Module;
import net.lax1dude.eaglercraft.EaglerAdapter;
import net.minecraft.src.EntityClientPlayerMP;
import net.minecraft.src.Packet10Flying;

public class NoFall extends Module {
	public static NoFall instance;
	
	public NoFall() {
		super("NoFall", EaglerAdapter.KEY_NONE, Category.PLAYER);
		instance = this;
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				if(mc.thePlayer.fallDistance >= 3) {
					Client.sendPacket(new Packet10Flying(true));
				}
			}
		}		
	}
}
