package pl.ncpn.minecraft.soularmachines;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MusicalSoularSoul extends Item {
    public MusicalSoularSoul(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        SoularMachinesMod.LOGGER.info("Meow says cow");
        playerEntity.playSound(SoundEvents.ENTITY_IRON_GOLEM_REPAIR, 1.0F, 1.0F);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
