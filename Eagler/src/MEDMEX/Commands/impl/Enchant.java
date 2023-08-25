package MEDMEX.Commands.impl;

import MEDMEX.Client;
import MEDMEX.Commands.Command;
import MEDMEX.Commands.CommandManager;
import net.minecraft.client.Minecraft;
import net.minecraft.src.Enchantment;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.NBTTagString;

public class Enchant extends Command {
	
	public Enchant() {
		super("Enchant", "Enchants item with 32k level enchantments", "Enchant <level>", "enchant");
	}

	@Override
	public void onCommand(String[] args, String command) {
		for(Enchantment enchs : Enchantment.enchantmentsList) {
			if(enchs != null) {
				Minecraft.getMinecraft().thePlayer.getHeldItem().addEnchantment(enchs, Integer.valueOf(args[0]));
				}
				
			}
		}
	}
