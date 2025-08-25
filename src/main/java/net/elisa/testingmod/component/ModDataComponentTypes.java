package net.elisa.testingmod.component;

import net.elisa.testingmod.Testingmod;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
    public static final ComponentType<BlockPos> COORDINATES  =
            register("coordinates",builder -> builder.codec(BlockPos.CODEC));


    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator){
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(Testingmod.MOD_ID, name),
                builderOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataComponentTypes() {
        Testingmod.LOGGER.info("Registering data component types for "+Testingmod.MOD_ID);
    }
}
