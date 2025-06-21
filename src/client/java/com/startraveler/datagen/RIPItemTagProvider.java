package com.startraveler.datagen;

import com.startraveler.RIPItems;
import com.startraveler.RestInPieces;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class RIPItemTagProvider extends FabricTagProvider.FabricValueLookupTagProvider<Item> {
    public RIPItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ITEM, registriesFuture, item -> item.getRegistryEntry().registryKey());
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(RestInPieces.CLOTHS)
                .add(RIPItems.BLACK_CLOTH)
                .add(RIPItems.GRAY_CLOTH)
                .add(RIPItems.LIGHT_GRAY_CLOTH)
                .add(RIPItems.WHITE_CLOTH)
                .add(RIPItems.PINK_CLOTH)
                .add(RIPItems.RED_CLOTH)
                .add(RIPItems.ORANGE_CLOTH)
                .add(RIPItems.YELLOW_CLOTH)
                .add(RIPItems.LIME_CLOTH)
                .add(RIPItems.GREEN_CLOTH)
                .add(RIPItems.CYAN_CLOTH)
                .add(RIPItems.LIGHT_BLUE_CLOTH)
                .add(RIPItems.BLUE_CLOTH)
                .add(RIPItems.PURPLE_CLOTH)
                .add(RIPItems.MAGENTA_CLOTH)
                .add(RIPItems.BROWN_CLOTH);
    }
}
