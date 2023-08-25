package MEDMEX.Modules.Render;


import MEDMEX.Modules.Module;
import net.lax1dude.eaglercraft.EaglerAdapter;

public class Fullbright extends Module {
	
	
	
	public Fullbright() {
		super("Fullbright", EaglerAdapter.KEY_NONE, Category.RENDER);
		
	}
	
	public void onEnable() {
		mc.gameSettings.gammaSetting = 100;
	}
	
	public void onDisable() {
		mc.gameSettings.gammaSetting = 1;
	}
	

}
