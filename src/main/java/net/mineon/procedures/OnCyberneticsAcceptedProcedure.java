package net.mineon.procedures;

import net.mineon.MineonModVariables;
import net.mineon.MineonModElements;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@MineonModElements.ModElement.Tag
public class OnCyberneticsAcceptedProcedure extends MineonModElements.ModElement {
	public OnCyberneticsAcceptedProcedure(MineonModElements instance) {
		super(instance, 18);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure OnCyberneticsAccepted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getPersistentData().getBoolean("mineon:cybernetic")) == (false))) {
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(MineonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.isCybernetic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cYou feel indescribable pain as you abandon your humanity."),
						(false));
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cYou are already a cybernetic."), (false));
			}
		}
	}
}
