package pl.ncpn.minecraft.soularmachines;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ncpn.minecraft.soularmachines.soular_furnace.SoularFurnace;
import pl.ncpn.minecraft.soularmachines.soular_furnace.SoularFurnaceEntity;

public class SoularMachinesMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MODID = "soularmachines";
	public static final Logger LOGGER = LoggerFactory.getLogger(SoularMachinesMod.MODID);


	public static final Item SOULAR_SOUL = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item MUSICAL_SOULAR_SOUL = new MusicalSoularSoul(new FabricItemSettings().group(ItemGroup.MISC));

//	public static final Item SOULAR_FURNACE_ITEM = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Block SOULAR_FURNACE_BLOCK = new SoularFurnace(FabricBlockSettings.of(Material.METAL).strength(2.0f));
	public static BlockEntityType<SoularFurnaceEntity> SOULAR_FURNACE_ENTITY;


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		Registry.register(Registry.ITEM, new Identifier(SoularMachinesMod.MODID, "soular_soul"), SOULAR_SOUL);
		Registry.register(Registry.ITEM, new Identifier(SoularMachinesMod.MODID, "musical_soular_soul"), MUSICAL_SOULAR_SOUL);

		Registry.register(Registry.BLOCK, new Identifier(SoularMachinesMod.MODID, "soular_furnace"), SOULAR_FURNACE_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(SoularMachinesMod.MODID, "soular_furnace"),
				new BlockItem(SOULAR_FURNACE_BLOCK, new FabricItemSettings().group(ItemGroup.MISC))
		);

		SOULAR_FURNACE_ENTITY =  Registry.register(Registry.BLOCK_ENTITY_TYPE, "soularmachines:soular_furnace_entity",
				FabricBlockEntityTypeBuilder.create(SoularFurnaceEntity::new,
						SOULAR_FURNACE_BLOCK).build(null));
	}
}
