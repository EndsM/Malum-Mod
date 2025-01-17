package com.sammy.malum.mixin;

import com.sammy.malum.client.renderer.text.SubtractiveTextGlyphRenderTypes;
import com.sammy.malum.registry.client.RenderTypeRegistry;
import net.minecraft.client.gui.font.GlyphRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GlyphRenderTypes.class)
public class GlyphRenderTypesMixin implements SubtractiveTextGlyphRenderTypes {

	@Unique
	private RenderType malum$subtractive;

	@Inject(method = "createForIntensityTexture", at = @At("RETURN"))
	private static void setSubtractiveLayerForIntensity(ResourceLocation pId, CallbackInfoReturnable<GlyphRenderTypes> cir) {
		((GlyphRenderTypesMixin) (Object) cir.getReturnValue()).malum$subtractive = RenderTypeRegistry.SUBTRACTIVE_INTENSE_TEXT.apply(pId);
	}

	@Inject(method = "createForColorTexture", at = @At("RETURN"))
	private static void setSubtractiveLayerForColor(ResourceLocation pId, CallbackInfoReturnable<GlyphRenderTypes> cir) {
		((GlyphRenderTypesMixin) (Object) cir.getReturnValue()).malum$subtractive = RenderTypeRegistry.SUBTRACTIVE_TEXT.apply(pId);
	}

	@Override
	public RenderType malum$getSubtractiveType() {
		return malum$subtractive;
	}
}
