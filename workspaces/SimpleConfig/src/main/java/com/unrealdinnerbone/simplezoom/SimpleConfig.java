package com.unrealdinnerbone.simplezoom;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.keybinding.FabricKeyBinding;
import net.fabricmc.fabric.api.client.keybinding.KeyBindingRegistry;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public class SimpleZoom implements ModInitializer {

    private static FabricKeyBinding ZOOM_KEYBIND;
    private static final String MOD_ID = "simplezoom";

    @Override
	public void onInitialize() {
        System.out.println("Loading SimpleZoom!");
        ZOOM_KEYBIND = FabricKeyBinding.Builder.create(new Identifier(MOD_ID, "zoom"), InputUtil.Type.KEY_KEYBOARD, GLFW.GLFW_KEY_Z, "SimpleZoom").build();
        KeyBindingRegistry.INSTANCE.addCategory("SimpleZoom");
        KeyBindingRegistry.INSTANCE.register(ZOOM_KEYBIND);
    }

    public static void getRender(CallbackInfoReturnable<Double> callbackInfoReturnable) {
        if(ZOOM_KEYBIND.isPressed()) {
            callbackInfoReturnable.setReturnValue(5.0);
        }
    }
}
