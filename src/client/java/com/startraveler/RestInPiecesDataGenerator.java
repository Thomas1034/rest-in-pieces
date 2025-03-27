package com.startraveler;

import com.startraveler.datagen.RIPEnglishNameProvider;
import com.startraveler.datagen.RIPItemTagProvider;
import com.startraveler.datagen.RIPModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class RestInPiecesDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(RIPEnglishNameProvider::new);
        pack.addProvider(RIPModelProvider::new);
        pack.addProvider(RIPItemTagProvider::new);

    }
}
