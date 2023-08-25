package MEDMEX.Modules.Client;

import java.util.ArrayList;

import MEDMEX.Client;
import MEDMEX.Modules.Module;
import MEDMEX.myClickGUI.GuiClick;
import de.Hero.settings.Setting;
import net.lax1dude.eaglercraft.EaglerAdapter;


public class ClickGUI extends Module {
	
	
	
	public ClickGUI() {
		super("ClickGUI", EaglerAdapter.KEY_Y, Category.CLIENT);
	}
	
	public void onEnable() {
		super.onEnable();
		mc.displayGuiScreen(new GuiClick());
		toggle();
	}
	
	public void onDisable() {
		
		
	}
	
	public void setup() {
		ArrayList<String> options = new ArrayList<>();
		options.add("New");
		options.add("JellyLike");
		Client.settingsmanager.rSetting(new Setting("Design", this, "New", options));
		Client.settingsmanager.rSetting(new Setting("Sound", this, false));
		Client.settingsmanager.rSetting(new Setting("Rainbow", this, true));
		Client.settingsmanager.rSetting(new Setting("R Speed", this, 4, 1, 10, false));
		Client.settingsmanager.rSetting(new Setting("R Saturation", this, 0.6, 0, 1, false));
		Client.settingsmanager.rSetting(new Setting("R Brightness", this, 1, 0, 1, false));
		Client.settingsmanager.rSetting(new Setting("GuiRed", this, 255, 0, 255, true));
		Client.settingsmanager.rSetting(new Setting("GuiGreen", this, 26, 0, 255, true));
		Client.settingsmanager.rSetting(new Setting("GuiBlue", this, 42, 0, 255, true));
	}
	

	

	

}
