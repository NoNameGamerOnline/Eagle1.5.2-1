package MEDMEX.Commands.impl;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Random;
import java.util.stream.IntStream;

import MEDMEX.Client;
import MEDMEX.Commands.Command;
import net.minecraft.src.Enchantment;
import net.minecraft.src.GuiScreenBook;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.NBTTagString;
import net.minecraft.src.Packet;
import net.minecraft.src.Packet250CustomPayload;

public class DupeBook2 extends Command {
	
	public DupeBook2() {
		super("DupeBook2", "Creates Dupe Book2", "DupeBook2", "dupebook2");
	}
	@Override
	public void onCommand(String[] args, String command) {
		if(!(mc.thePlayer.getHeldItem() == null)) {
		if(mc.thePlayer.getHeldItem().getItemName().equals("item.writingBook")) {
		if(!mc.thePlayer.getHeldItem().hasTagCompound()) 
			mc.thePlayer.getHeldItem().stackTagCompound = new NBTTagCompound();
		if(!mc.thePlayer.getHeldItem().getTagCompound().hasKey("pages"))
			mc.thePlayer.getHeldItem().stackTagCompound.setTag("pages", new NBTTagList());
		Random random = new Random(2);
		for(int i = 0; i < 50; i++) {
	        String s = "";
		    int begin =0x0800;
		    int end =  0x10FFFF;
		    IntStream ints = random.ints(256, begin, end);
		    for(int in : ints.toArray()) {
		        char c = (char) in;
		        s = s + c;
		    }
			mc.thePlayer.getHeldItem().getTagCompound().getTagList("pages").appendTag(new NBTTagString(String.valueOf(i), s));
		}
		GuiScreenBook b = new GuiScreenBook(mc.thePlayer, mc.thePlayer.getHeldItem(), true);
		String var8 = "MC|BSign";
		mc.thePlayer.inventory.getCurrentItem().setTagInfo("author", new NBTTagString("author", mc.thePlayer.username));
		mc.thePlayer.inventory.getCurrentItem().setTagInfo("title", new NBTTagString("title", "2"));
		mc.thePlayer.inventory.getCurrentItem().itemID = Item.writtenBook.itemID;
		ByteArrayOutputStream var3 = new ByteArrayOutputStream();
		DataOutputStream var4 = new DataOutputStream(var3);
		try {
			Packet.writeItemStack(mc.thePlayer.inventory.getCurrentItem(), var4);
			this.mc.getNetHandler().addToSendQueue(new Packet250CustomPayload(var8, var3.toByteArray()));
		} catch (Exception var6) {
			var6.printStackTrace();
		}
		
        
		}else {
			Client.addChatMessage("Hold a book & quill");
		}
		}else {
			Client.addChatMessage("Hold a book & quill");
		}
}
}
		
