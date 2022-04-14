package pl.ncpn.minecraft.soularmachines;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import pl.ncpn.minecraft.soularmachines.soular_furnace.SoularFurnaceScreen;

public class SoularMachinesClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(SoularMachinesMod.SOULAR_SCREEN_HANDLER, SoularFurnaceScreen::new);
    }
}
