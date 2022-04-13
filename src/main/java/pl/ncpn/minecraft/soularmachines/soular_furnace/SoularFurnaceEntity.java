package pl.ncpn.minecraft.soularmachines.soular_furnace;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import pl.ncpn.minecraft.soularmachines.ImplementedInventory;
import pl.ncpn.minecraft.soularmachines.SoularMachinesMod;

import javax.annotation.Nullable;

import static pl.ncpn.minecraft.soularmachines.SoularMachinesMod.SOULAR_FURNACE_ENTITY;

public class SoularFurnaceEntity extends BlockEntity  implements ImplementedInventory {

    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(2, ItemStack.EMPTY);
    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    // Store the current value of the number
    private int usedCount = 0;

    public SoularFurnaceEntity(BlockPos pos, BlockState state) {
        super(SOULAR_FURNACE_ENTITY, pos, state);
    }

    // Serialize the BlockEntity
    @Override
    public void writeNbt(NbtCompound tag) {
        // Save the current value of the number to the tag
        tag.putInt("number", usedCount);
        Inventories.writeNbt(tag, items);

        super.writeNbt(tag);
    }

    // Deserialize the BlockEntity
    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
        Inventories.readNbt(tag, items);

        usedCount = tag.getInt("number");
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    public static void tick(World world, BlockPos pos, BlockState state, SoularFurnaceEntity be) {
        if( be.usedCount % 100 == 21 ) {
            SoularMachinesMod.LOGGER.info("numbah " + be.usedCount + "pos " + pos.toString());
        }

        be.usedCount += 1;
    }
}
