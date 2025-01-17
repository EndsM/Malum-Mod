package com.sammy.malum.client.renderer.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.sammy.malum.common.block.storage.jar.SpiritJarBlockEntity;
import com.sammy.malum.common.item.spirit.SpiritJarItem;
import com.sammy.malum.core.handlers.*;
import com.sammy.malum.core.systems.spirit.MalumSpiritType;
import com.sammy.malum.registry.common.block.BlockRegistry;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class SpiritJarItemRenderer extends BlockEntityWithoutLevelRenderer {

    private final SpiritJarBlockEntity jar = new SpiritJarBlockEntity(BlockPos.ZERO, BlockRegistry.SPIRIT_JAR.get().defaultBlockState());

    private final BlockEntityRenderDispatcher blockEntityRenderDispatcher;

    public SpiritJarItemRenderer(BlockEntityRenderDispatcher pBlockEntityRenderDispatcher, EntityModelSet pEntityModelSet) {
        super(pBlockEntityRenderDispatcher, pEntityModelSet);
        this.blockEntityRenderDispatcher = pBlockEntityRenderDispatcher;
    }

    @Override
    public void renderByItem(ItemStack pStack, ItemDisplayContext pTransformType, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        if (pStack.getItem() instanceof SpiritJarItem) {
            if (pStack.hasTag() && pStack.getTag().contains("spirit")) {
                MalumSpiritType spirit = SpiritHarvestHandler.getSpiritType(pStack.getTag().getString("spirit"));
                int count = pStack.getTag().getInt("count");
                jar.type = spirit;
                jar.count = count;

                this.blockEntityRenderDispatcher.renderItem(jar, pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
            }
        }
    }
}
