package MEDMEX.Modules.Movement;

import MEDMEX.Client;
import MEDMEX.Event.Event;
import MEDMEX.Event.listeners.EventUpdate;
import MEDMEX.Modules.Module;
import de.Hero.settings.Setting;
import net.lax1dude.eaglercraft.EaglerAdapter;

public class Fly extends Module {
	
	public Fly() {
		super("Fly", EaglerAdapter.KEY_NONE, Category.MOVEMENT);
	}
	
	public void onEnable() {
		
	}
	
	public void onDisable() {
		mc.thePlayer.capabilities.isFlying = false;
		mc.thePlayer.capabilities.setFlySpeed(0.05f);
		
	}
	public void setup() {
		Client.settingsmanager.rSetting(new Setting("Fly Speed", this, 1, 0, 10, false));
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				float modifier = (float) Client.settingsmanager.getSettingByName("Fly Speed").getValDouble();
				this.attribute = " §7[§f"+String.format("%.2f",modifier)+"§7]";
				mc.thePlayer.capabilities.isFlying = true;
				mc.thePlayer.capabilities.setFlySpeed(0.05f * modifier);
			}
		}
	}
	

}
