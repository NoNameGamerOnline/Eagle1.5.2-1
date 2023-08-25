package MEDMEX.Modules.Player;

import MEDMEX.Client;
import MEDMEX.Event.Event;
import MEDMEX.Event.EventPacket;
import MEDMEX.Event.listeners.EventUpdate;
import MEDMEX.Modules.Module;
import de.Hero.settings.Setting;
import net.lax1dude.eaglercraft.EaglerAdapter;
import net.minecraft.src.EntityClientPlayerMP;
import net.minecraft.src.Packet10Flying;
import net.minecraft.src.Packet19EntityAction;


//Credit 29

public class AntiHunger extends Module 
{
	public static AntiHunger instance;
	
	private boolean isOnGround = false;
	
	public AntiHunger() 
	{
		super("AntiHunger", EaglerAdapter.KEY_NONE, Category.PLAYER);
		instance = this;
	}
	
	public void setup() 
	{
		Client.settingsmanager.rSetting(new Setting("AH Sprint", this, false));
		Client.settingsmanager.rSetting(new Setting("AH Ground", this, false));
	}
		
    public void onEnable() 
    {
        if (Client.settingsmanager.getSettingByName("AH Sprint").getValBoolean() && mc.thePlayer != null) 
        {
            Client.sendPacket(new Packet19EntityAction(mc.thePlayer, 5)); //stop sprinting
        }
	}
	
	public void onDisable() 
	{
        if (Client.settingsmanager.getSettingByName("AH Sprint").getValBoolean() && mc.thePlayer.isSprinting()) 
        {
            Client.sendPacket(new Packet19EntityAction(mc.thePlayer, 4)); //start sprinting
        }
	}
	
    public void getPacket(EventPacket e) 
    {
        if(e.getPacket() instanceof Packet19EntityAction)
        {
            Packet19EntityAction action = (Packet19EntityAction) e.getPacket();
            if (Client.settingsmanager.getSettingByName("AH Sprint").getValBoolean() && (action.state == 4 || action.state == 5)) {
                e.setCancelled(true);
            }
        }
        if (e.getPacket() instanceof Packet10Flying) {
            Packet10Flying player = (Packet10Flying) e.getPacket();
            boolean ground = mc.thePlayer.onGround;
            if (Client.settingsmanager.getSettingByName("AH Ground").getValBoolean() && isOnGround && ground && player.yPosition == (!player.moving ? 0.0 : mc.thePlayer.posY)) {
                player.onGround = false;
            }
            isOnGround = ground;
        }
    }
}
