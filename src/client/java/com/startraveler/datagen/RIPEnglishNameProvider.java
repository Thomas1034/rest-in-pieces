package com.startraveler.datagen;

import com.startraveler.RIPItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import org.apache.commons.lang3.text.WordUtils;

import java.util.concurrent.CompletableFuture;

public class RIPEnglishNameProvider extends FabricLanguageProvider {
    public RIPEnglishNameProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        // Specifying en_us is optional, as it's the default language code
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        RIPItems.ITEMS.forEach(item -> {
            translationBuilder.add(
                    item.getTranslationKey(),
                    WordUtils.capitalize(item.getRegistryEntry()
                            .registryKey()
                            .getValue()
                            .getPath()
                            .replace('/', ' ')
                            .replace('_', ' '))
            );
        });
        translationBuilder.add("tag.item.rest-in-pieces.cloths", "Cloths");
    }

    @Override
    public String getName() {
        return "Rest in Pieces en_us Language Provider";
    }
}

