package net.mineon.procedures;

import net.mineon.MineonModElements;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;

import java.util.Map;

@MineonModElements.ModElement.Tag
public class AdminMenuDayNightbuttononclickProcedure extends MineonModElements.ModElement {
	public AdminMenuDayNightbuttononclickProcedure(MineonModElements instance) {
		super(instance, 11);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure AdminMenuDayNightbuttononclick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((12000 < (world.getWorld().getDayTime()))) {
			if (world instanceof World)
				world.getWorld().setDayTime((int) 0);
		} else if ((12000 > (world.getWorld().getDayTime()))) {
			if (world instanceof World)
				world.getWorld().setDayTime((int) 18000);
		}
	}
}
