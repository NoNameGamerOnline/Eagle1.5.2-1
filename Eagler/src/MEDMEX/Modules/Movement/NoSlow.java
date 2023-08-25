package MEDMEX.Modules.Movement;


import MEDMEX.Modules.Module.Category;
import net.lax1dude.eaglercraft.EaglerAdapter;
import MEDMEX.Event.Event;
import MEDMEX.Event.listeners.EventUpdate;
import MEDMEX.Modules.Module;

public class NoSlow extends Module {
	
	public static NoSlow instance;
	public NoSlow() {
		super("NoSlow", EaglerAdapter.KEY_NONE, Category.MOVEMENT);
		instance = this;
		
	}
	
	
	

}