package dev.enderdevelopment.verticalpanorama.mixin;

import net.minecraft.client.render.CubeMapRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(CubeMapRenderer.class)
public abstract class CubeMapRendererMixin {
    @ModifyConstant(method = "draw", constant = @Constant(floatValue = 20.0F))
    private float verticalPanorama$scrollVertically(float originalTilt) {
        double time = (System.currentTimeMillis() % 100000L) / 100000.0D;
        return (float) (Math.sin(time * Math.PI * 2.0D) * 25.0D);
    }
}
