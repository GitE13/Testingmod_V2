package net.elisa.testingmod.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class ModFoodComponenets {
    public static final FoodComponent CAULIFLOWER_FOOD_COMPONENT = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f).build();
    public static final ConsumableComponent CAULIFLOWER_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200), 0.15f))
            .build();
}
