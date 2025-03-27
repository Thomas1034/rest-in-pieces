package com.startraveler.datagen;

import com.startraveler.RIPItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class RIPModelProvider extends FabricModelProvider {
    public RIPModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        RIPItems.ITEMS.forEach(item -> itemModelGenerator.register(item, Models.GENERATED));
    }

    @Override
    public String getName() {
        return "Rest in Pieces Model Provider";
    }

}
