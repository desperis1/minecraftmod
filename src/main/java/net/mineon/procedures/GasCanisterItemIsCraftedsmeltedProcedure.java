package net.mineon.procedures;

import net.mineon.MineonModElements;

import net.minecraft.item.ItemStack;

import java.util.Random;
import java.util.Map;

@MineonModElements.ModElement.Tag
public class GasCanisterItemIsCraftedsmeltedProcedure extends MineonModElements.ModElement {
	public GasCanisterItemIsCraftedsmeltedProcedure(MineonModElements instance) {
		super(instance, 19);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure GasCanisterItemIsCraftedsmelted!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		{
			ItemStack _ist = (itemstack);
			if (_ist.attemptDamageItem((int) 99, new Random(), null)) {
				_ist.shrink(1);
				_ist.setDamage(0);
			}
		}
		(itemstack).getOrCreateTag().putString("FillWith", "None");
	}
}
