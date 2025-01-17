package com.sammy.malum.common.item.curiosities.curios.runes.madness;

import com.google.common.collect.Multimap;
import com.sammy.malum.common.item.curiosities.curios.runes.AbstractRuneCurioItem;
import com.sammy.malum.registry.common.SpiritTypeRegistry;
import com.sammy.malum.registry.common.item.ItemRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import team.lodestar.lodestone.helpers.CurioHelper;
import top.theillusivec4.curios.api.SlotContext;

import java.util.function.Consumer;

public class RuneUnnaturalStaminaItem extends AbstractRuneCurioItem {

    public RuneUnnaturalStaminaItem(Properties builder) {
        super(builder, SpiritTypeRegistry.AERIAL_SPIRIT);
    }

    @Override
    public void addExtraTooltipLines(Consumer<Component> consumer) {
        consumer.accept(positiveEffect("always_sprint"));
    }

    @Override
    public void addAttributeModifiers(Multimap<Attribute, AttributeModifier> map, SlotContext slotContext, ItemStack stack) {
        addAttributeModifier(map, Attributes.MOVEMENT_SPEED, uuid -> new AttributeModifier(uuid,
                "Curio Movement Speed", 0.2f, AttributeModifier.Operation.MULTIPLY_TOTAL));
    }


    public static boolean forceSprint(LivingEntity livingEntity) {
        return CurioHelper.hasCurioEquipped(livingEntity, ItemRegistry.RUNE_OF_UNNATURAL_STAMINA.get());
    }
}
