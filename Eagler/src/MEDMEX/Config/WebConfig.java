package MEDMEX.Config;

import MEDMEX.Client;
import net.lax1dude.eaglercraft.LocalStorageManager;
import net.minecraft.src.NBTTagCompound;
import MEDMEX.Modules.Module;
import de.Hero.settings.Setting;

public class WebConfig {
	
	public static void loadConfig()
	{
		NBTTagCompound cfg = LocalStorageManager.ClientConfig;
		if (!cfg.hasNoTags()) 
		{
			for (Module m : Client.modules)
			{
				if (cfg.hasKey(m.name))
				{
					if (cfg.getBoolean(m.name))
						m.toggle();
				}
				
				if (cfg.hasKey(m.name+"Key"))
				{
					m.keyCode.setKeyCode(cfg.getInteger(m.name+"Key"));
				}
			}
			
			for (Setting s : Client.settingsmanager.getSettings())
			{
				if (cfg.hasKey(s.getName()))
				{
					if (s.isCheck()) s.setValBoolean(cfg.getBoolean(s.getName()));
					
					if (s.isSlider()) s.setValDouble(cfg.getDouble(s.getName()));
					
					if (s.isCombo()) s.setValString(cfg.getString(s.getName()));
				}
			}
		}
	}
	
	public static void saveConfig()
	{
		NBTTagCompound cfg = LocalStorageManager.ClientConfig;
		for (Module m : Client.modules)
		{
			cfg.setBoolean(m.name, m.isEnabled());
			cfg.setInteger(m.name+"Key", m.getKey());
			
			if (Client.settingsmanager.getSettingsByMod(m) != null)
			{
				for (Setting s : Client.settingsmanager.getSettingsByMod(m))
				{
					if (s.isCheck()) 
					{
						cfg.setBoolean(s.getName(), s.getValBoolean());
					}
					if (s.isSlider())
					{
						cfg.setDouble(s.getName(), s.getValDouble());
					}
					if (s.isCombo())
					{
						cfg.setString(s.getName(), s.getValString());
					}
				}
			}
		}
		
		LocalStorageManager.saveConfig();
	}
}
