package MEDMEX.Modules.Player;


import MEDMEX.Client;
import MEDMEX.Event.Event;
import MEDMEX.Event.EventPacket;
import MEDMEX.Event.listeners.EventUpdate;
import MEDMEX.Modules.Module;
import net.lax1dude.eaglercraft.EaglerAdapter;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.GuiInventory;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.Packet101CloseWindow;

public class KeepContainer extends Module {
	
	public GuiContainer container;
	public static KeepContainer instance;
	public static boolean shouldOpen = false;
	
	public KeepContainer() {
		super("KeepContainer", EaglerAdapter.KEY_NONE, Category.PLAYER);
		instance = this;
	}
	
	public void onDisable()
	{
		if (container != null)
			Client.sendPacket(new Packet101CloseWindow(container.inventorySlots.windowId));
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				if (mc.currentScreen instanceof GuiContainer && !(mc.currentScreen instanceof GuiInventory))
				{
					container = (GuiContainer)mc.currentScreen;
				}
				
				if (shouldOpen)
				{
					mc.displayGuiScreen(container);
					shouldOpen = false;
				}
			}	
		}		
	}
	
	
	public void getPacket(EventPacket e) {
		if(this.isEnabled()) {
			if(mc.thePlayer != null && mc.theWorld != null) {
				if (e.getPacket() instanceof Packet101CloseWindow)
				{
					e.setCancelled(true);
				}
			}
		}	
	}
}
