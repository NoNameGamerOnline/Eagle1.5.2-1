package MEDMEX.Modules.Combat;

import java.util.List;

import net.lax1dude.eaglercraft.EaglerAdapter;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityBoat;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.Packet10Flying;
import net.minecraft.src.Packet28EntityVelocity;
import net.minecraft.src.Packet60Explosion;
import MEDMEX.Client;
import MEDMEX.Event.Event;
import MEDMEX.Event.EventPacket;
import MEDMEX.Event.listeners.EventUpdate;
import MEDMEX.Modules.Module;
import de.Hero.settings.Setting;


public class Velocity extends Module{
	public static Velocity instance;
	
	public Velocity() {
		super("Velocity", EaglerAdapter.KEY_NONE, Category.COMBAT);
		instance = this;
	}
	
	
	public void getPacket(EventPacket e) {
		if(this.isEnabled()) {
			if(mc.thePlayer != null && mc.theWorld != null) {
				if(e.getPacket() instanceof Packet28EntityVelocity) {
					Packet28EntityVelocity packet = (Packet28EntityVelocity)e.getPacket();
					if(packet.entityId == mc.thePlayer.entityId) {
						e.setCancelled(true);
					}
				}
				if(e.getPacket() instanceof Packet60Explosion) {
					Packet60Explosion packet = (Packet60Explosion)e.getPacket();
						e.setCancelled(true);
					
				}	
			}		
		}			
	}
}

