package MEDMEX.Modules.Combat;

import java.util.List;

import net.lax1dude.eaglercraft.EaglerAdapter;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityBoat;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Packet10Flying;
import net.minecraft.src.Packet28EntityVelocity;
import net.minecraft.src.Packet60Explosion;
import MEDMEX.Client;
import MEDMEX.Event.Event;
import MEDMEX.Event.EventPacket;
import MEDMEX.Event.listeners.EventUpdate;
import MEDMEX.Modules.Module;
import de.Hero.settings.Setting;


public class Shadow extends Module{
	public static Shadow instance;
	
	public Shadow() {
		super("Shadow", EaglerAdapter.KEY_NONE, Category.COMBAT);
		instance = this;
	}
	
	
	public void onEvent(Event e) 
	{
		if(e instanceof EventUpdate && e.isPre()) 
		{
			if (KillAura.currentTarget == null)
				return;
			
			Entity t = KillAura.currentTarget;
			
			double tX = t.posX;
			double tY = t.posY;
			double tZ = t.posZ;
			
			double tYaw = t.rotationYaw;
			int dir =  MathHelper.floor_double((double) (tYaw * 4.0F / 360.0F) + 0.5D) & 3;;
			double abYaw = Math.abs(tYaw);
			
			double x = 0; double z = 0;
			double relYaw = (abYaw) % 90;
			if(dir == 0)
			{
				double div = relYaw / 90;
				x = 0 + div;
				z = -1 + div;
			}
			
			if(dir == 1)
			{
				double div = relYaw / 90;
				x = 1 - div;
				z = 0 + div;
			}
			if(dir == 2)
			{
				double div = relYaw / 90;
				x = 0 - div;
				z = 1 + div;
			}
			if(dir == 3)
			{
				double div = relYaw / 90;
				x = -1 + div;
				z = 0 + div;
			}
			
			mc.thePlayer.setPosition(tX + x, mc.thePlayer.posY, tZ + z);
			
			
		}	
	}
}

