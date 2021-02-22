package net.mineon.procedures;

import net.mineon.MineonModElements;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@MineonModElements.ModElement.Tag
public class GrapplingHookRightClickedInAirProcedure extends MineonModElements.ModElement {
	public GrapplingHookRightClickedInAirProcedure(MineonModElements instance) {
		super(instance, 9);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure GrapplingHookRightClickedInAir!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure GrapplingHookRightClickedInAir!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure GrapplingHookRightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure GrapplingHookRightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure GrapplingHookRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure GrapplingHookRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double dX = 0;
		double dY = 0;
		double dZ = 0;
		double topVelocity = 0;
		double magnitude = 0;
		double velocityX = 0;
		double velocityZ = 0;
		double velocityY = 0;
		double lookingX = 0;
		double lookingY = 0;
		double lookingZ = 0;
		if ((!((world
				.getBlockState(
						new BlockPos(
								(int) (entity.world.rayTraceBlocks(
										new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 25, entity.getLook(1f).y * 25,
														entity.getLook(1f).z * 25),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
										.getPos().getX()),
								(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 25, entity.getLook(1f).y * 25,
												entity.getLook(1f).z * 25),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
								(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 25, entity.getLook(1f).y * 25,
												entity.getLook(1f).z * 25),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()))))
												.getMaterial() == net.minecraft.block.material.Material.AIR))) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 20);
			lookingX = (double) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
					entity.getEyePosition(1f).add(entity.getLook(1f).x * 25, entity.getLook(1f).y * 25, entity.getLook(1f).z * 25),
					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX());
			lookingY = (double) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
					entity.getEyePosition(1f).add(entity.getLook(1f).x * 25, entity.getLook(1f).y * 25, entity.getLook(1f).z * 25),
					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY());
			lookingZ = (double) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
					entity.getEyePosition(1f).add(entity.getLook(1f).x * 25, entity.getLook(1f).y * 25, entity.getLook(1f).z * 25),
					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ());
			topVelocity = (double) 20;
			dX = (double) ((lookingX) - x);
			dY = (double) ((lookingY) - y);
			dZ = (double) ((lookingZ) - z);
			magnitude = (double) Math.sqrt((Math.pow((dX), 2) + (Math.pow((dY), 2) + Math.pow((dZ), 2))));
			velocityX = (double) ((topVelocity) * ((dX) / Math.pow((magnitude), 2)));
			velocityY = (double) ((topVelocity) * ((dY) / Math.pow((magnitude), 2)));
			velocityZ = (double) ((topVelocity) * ((dZ) / Math.pow((magnitude), 2)));
			entity.setMotion((velocityX), (velocityY), (velocityZ));
		}
	}
}
