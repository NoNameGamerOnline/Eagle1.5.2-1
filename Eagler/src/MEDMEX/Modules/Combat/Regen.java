package MEDMEX.Modules.Combat;

import java.util.List;

import net.lax1dude.eaglercraft.EaglerAdapter;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityBoat;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.Packet10Flying;
import net.minecraft.src.Packet28EntityVelocity;
import MEDMEX.Client;
import MEDMEX.Event.Event;
import MEDMEX.Event.EventPacket;
import MEDMEX.Event.listeners.EventUpdate;
import MEDMEX.Modules.Module;
import de.Hero.settings.Setting;


public class Regen extends Module{
	private boolean isHealing;
	public static Regen instance;
	
	public Regen() {
		super("Regen", EaglerAdapter.KEY_NONE, Category.COMBAT);
		instance = this;
	}
	
	public void setup() {
		Client.settingsmanager.rSetting(new Setting("Packets", this, 20, 0, 100, true));
		Client.settingsmanager.rSetting(new Setting("Regen InAir", this, false));
		Client.settingsmanager.rSetting(new Setting("Regen OnFire", this, false));
		
	}
	
	public static boolean ishealing = false;
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {			
				if (!Client.settingsmanager.getSettingByName("Regen InAir").getValBoolean() && !mc.thePlayer.onGround)
					return;
				if(!Client.settingsmanager.getSettingByName("Regen OnFire").getValBoolean() && mc.thePlayer.isBurning())
					return;
				
				boolean canHeal = (mc.thePlayer.onGround || mc.thePlayer.isInWater() || mc.thePlayer.isOnLadder());
				boolean shouldHeal = (mc.thePlayer.getHealth() <= 19.0F && mc.thePlayer.getFoodStats().getFoodLevel() > 17);
				if(canHeal && shouldHeal && !this.isHealing) 
					(new Thread(){
						public void run() {
							Regen.this.isHealing = true;
							for (short s = 0; s <= Client.settingsmanager.getSettingByName("Packets").getValDouble(); s = (short)(s + 1))
								Client.sendPacket(new Packet10Flying(mc.thePlayer.onGround));
							Regen.this.isHealing = false;
							
						}
				}).start();
			}			
		}
	}
}

