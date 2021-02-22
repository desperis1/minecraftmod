package net.mineon.procedures;

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
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\uFFFDcYou feel indescribable pain as you abandon your humanity."),
						(false));
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\uFFFDcYou are already a cybernetic."), (false));
			}
		}

	}

}
