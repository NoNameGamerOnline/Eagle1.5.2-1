package MEDMEX.Modules.Movement;




import MEDMEX.Client;
import MEDMEX.Event.Event;
import MEDMEX.Event.listeners.EventUpdate;
import net.lax1dude.eaglercraft.EaglerAdapter;
import net.lax1dude.eaglercraft.adapter.Tessellator;
import net.minecraft.client.Minecraft;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.MathHelper;
import net.minecraft.src.RenderManager;
import MEDMEX.Modules.Module;
import MEDMEX.Modules.Combat.KillAura;
import MEDMEX.Utils.Color;
import de.Hero.settings.Setting;

public class TargetStrafe extends Module {
	public static TargetStrafe instance;
	static int direction = -1;

	public TargetStrafe() {
		super("TargetStrafe", EaglerAdapter.KEY_NONE, Category.MOVEMENT);
		instance = this;
	}
	 public void setup() {
	        Client.settingsmanager.rSetting(new Setting("Strafe Speed", this, 0.25, 0, 1, false));
	        Client.settingsmanager.rSetting(new Setting("Strafe Distance", this, 4, 0, 6, false));
	       
	        
	    }
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				 if (mc.thePlayer.isCollidedHorizontally) {
		             switchDirection();
		         }
				 
				 if(KillAura.currentTarget != null && KillAura.currentTarget instanceof EntityPlayer) {
					 doStrafeAtSpeed(Client.settingsmanager.getSettingByName("Strafe Speed").getValDouble());
				 }
			}	
		}		
	}

	
	private void switchDirection() {
        if (direction == 1) {
            direction = -1;
        } else {
            direction = 1;
        }
    }
	
	 public final boolean doStrafeAtSpeed(final double moveSpeed) {
	        final boolean strafe = canStrafe();

	        if (strafe) {
	            float[] rotations = getNeededRotations((EntityLiving) KillAura.currentTarget);
	            if (mc.thePlayer.getDistanceToEntity(KillAura.currentTarget) <= Client.settingsmanager.getSettingByName("Strafe Distance").getValDouble()) {
	               setSpeed(moveSpeed, rotations[0], direction, 0);
	            } else {
	                setSpeed(moveSpeed, rotations[0], direction, 1);
	            }
	        }

	        return strafe;
	    }
	 public void setSpeed(final double moveSpeed, final float pseudoYaw, final double pseudoStrafe, final double pseudoForward) {
	        double forward = pseudoForward;
	        double strafe = pseudoStrafe;
	        float yaw = pseudoYaw;

	        if (forward == 0.0 && strafe == 0.0) {
	            mc.thePlayer.motionZ = 0;
	            mc.thePlayer.motionX = 0;
	        } else {
	            if (forward != 0.0) {
	                if (strafe > 0.0) {
	                    yaw += ((forward > 0.0) ? -45 : 45);
	                } else if (strafe < 0.0) {
	                    yaw += ((forward > 0.0) ? 45 : -45);
	                }
	                strafe = 0.0;
	                if (forward > 0.0) {
	                    forward = 1.0;
	                } else if (forward < 0.0) {
	                    forward = -1.0;
	                }
	            }
	            final double cos = Math.cos(Math.toRadians(yaw + 90.0f));
	            final double sin = Math.sin(Math.toRadians(yaw + 90.0f));

	            mc.thePlayer.motionX = (forward * moveSpeed * cos + strafe * moveSpeed * sin);
	            mc.thePlayer.motionZ = (forward * moveSpeed * sin - strafe * moveSpeed * cos);
	        }
	    }
	 
	 public  float[] getNeededRotations(EntityLiving entityIn) {
	        double d0 = entityIn.posX - mc.thePlayer.posX;
	        double d1 = entityIn.posZ - mc.thePlayer.posZ;
	        double d2 = entityIn.posY + entityIn.getEyeHeight() - (mc.thePlayer.boundingBox.minY + (mc.thePlayer.boundingBox.maxY - mc.thePlayer.boundingBox.minY));
	        double d3 = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
	        float f = (float) (Math.atan2(d1, d0) * 180.0D / Math.PI) - 90.0F;
	        float f1 = (float) (-(Math.atan2(d2, d3) * 180.0D / Math.PI));
	        return new float[]{f, f1};
	    }
	 
	 
	
	    
	 
	 public static boolean canStrafe() {
	        return KillAura.currentTarget != null && TargetStrafe.instance.isEnabled();
	    }
	
	
	

}
