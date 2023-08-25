package MEDMEX.Commands.impl;

import MEDMEX.Client;
import MEDMEX.Commands.Command;
import MEDMEX.Commands.CommandManager;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.NBTTagString;

public class Pages extends Command {
    
    public Pages() {
        super("Pages", "Adds pages to a book", "pages <amount>", "pages");
        
    }

    @Override
    public void onCommand(String[] args, String command) {
        if(!(mc.thePlayer.getHeldItem() == null)) {
            if(mc.thePlayer.getHeldItem().getItemName().equals("item.writingBook")) {
                if(!mc.thePlayer.getHeldItem().hasTagCompound()) 
                    mc.thePlayer.getHeldItem().stackTagCompound = new NBTTagCompound();
                if(!mc.thePlayer.getHeldItem().getTagCompound().hasKey("pages"))
                    mc.thePlayer.getHeldItem().stackTagCompound.setTag("pages", new NBTTagList());
                
                for(int i = 0; i < Integer.valueOf(args[0]); i++)
                {
                    String s = "";
                    
                    if(Integer.valueOf(args[0]) == i + 1) {
                        mc.thePlayer.getHeldItem().getTagCompound().getTagList("pages").appendTag(new NBTTagString(String.valueOf(i), "bottom text"));
                    }
                    else
                    {
                    mc.thePlayer.getHeldItem().getTagCompound().getTagList("pages").appendTag(new NBTTagString(String.valueOf(i), s));
                    }
                }
            }
        }
    }
}