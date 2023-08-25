package MEDMEX.Modules.Render;


import MEDMEX.Modules.Module;
import net.lax1dude.eaglercraft.EaglerAdapter;

public class NoRender extends Module {
	
	public static NoRender instance;
	
	public NoRender() {
		super("NoRender", EaglerAdapter.KEY_NONE, Category.RENDER);
		instance = this;
	}
	
	
	

}
