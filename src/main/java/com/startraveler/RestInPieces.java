package com.startraveler;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.block.EndPortalBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class RestInPieces implements ModInitializer {
    public static final String MOD_ID = "rest-in-pieces";
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final TagKey<Item> CLOTHS = TagKey.of(RegistryKeys.ITEM, RestInPieces.id("cloths"));
    private static final Optional<RegistryKey<LootTable>> ZOMBIE_LOOT_TABLE = EntityType.ZOMBIE.getLootTableKey();
    private static final Optional<RegistryKey<LootTable>> ZOMBIE_VILLAGER_LOOT_TABLE = EntityType.ZOMBIE_VILLAGER.getLootTableKey();
    private static final Optional<RegistryKey<LootTable>> HUSK_LOOT_TABLE = EntityType.HUSK.getLootTableKey();
    private static final Optional<RegistryKey<LootTable>> DROWNED_LOOT_TABLE = EntityType.DROWNED.getLootTableKey();

    public static void modifyZombieLootTable() {

        ZOMBIE_LOOT_TABLE.ifPresentOrElse(
                zombieLootTable -> LootTableEvents.MODIFY.register((key, lootTableBuilder, lootTableSource, wrapperLookup) -> {
                    if (zombieLootTable.equals(key)) {
                        LootPool.Builder poolBuilder = LootPool.builder()
                                .rolls(new ConstantLootNumberProvider(1))
                                .with(ItemEntry.builder(Items.AIR).weight(2))
                                .with(ItemEntry.builder(RIPItems.BLUE_CLOTH).weight(1));

                        lootTableBuilder.pool(poolBuilder);
                    }
                }), () -> LOGGER.warn("Warning: could not locate Zombie loot table for mod {}", MOD_ID)
        );

        HUSK_LOOT_TABLE.ifPresentOrElse(
                zombieLootTable -> LootTableEvents.MODIFY.register((key, lootTableBuilder, lootTableSource, wrapperLookup) -> {
                    if (zombieLootTable.equals(key)) {
                        LootPool.Builder poolBuilder = LootPool.builder()
                                .rolls(new ConstantLootNumberProvider(1))
                                .with(ItemEntry.builder(Items.AIR).weight(2))
                                .with(ItemEntry.builder(RIPItems.BROWN_CLOTH).weight(1));

                        lootTableBuilder.pool(poolBuilder);
                    }
                }), () -> LOGGER.warn("Warning: could not locate Husk loot table for mod {}", MOD_ID)
        );

        DROWNED_LOOT_TABLE.ifPresentOrElse(
                zombieLootTable -> LootTableEvents.MODIFY.register((key, lootTableBuilder, lootTableSource, wrapperLookup) -> {
                    if (zombieLootTable.equals(key)) {
                        LootPool.Builder poolBuilder = LootPool.builder()
                                .rolls(new ConstantLootNumberProvider(1))
                                .with(ItemEntry.builder(Items.AIR).weight(2))
                                .with(ItemEntry.builder(RIPItems.CYAN_CLOTH).weight(1));

                        lootTableBuilder.pool(poolBuilder);
                    }
                }), () -> LOGGER.warn("Warning: could not locate Drowned loot table for mod {}", MOD_ID)
        );

        ZOMBIE_VILLAGER_LOOT_TABLE.ifPresentOrElse(
                zombieLootTable -> LootTableEvents.MODIFY.register((key, lootTableBuilder, lootTableSource, wrapperLookup) -> {
                    if (zombieLootTable.equals(key)) {
                        LootPool.Builder poolBuilder = LootPool.builder()
                                .rolls(new ConstantLootNumberProvider(1))
                                .with(ItemEntry.builder(Items.AIR).weight(20))
                                .with(ItemEntry.builder(RIPItems.YELLOW_CLOTH).weight(1))
                                .with(ItemEntry.builder(RIPItems.GREEN_CLOTH).weight(1))
                                .with(ItemEntry.builder(RIPItems.LIGHT_GRAY_CLOTH).weight(1))
                                .with(ItemEntry.builder(RIPItems.WHITE_CLOTH).weight(1))
                                .with(ItemEntry.builder(RIPItems.RED_CLOTH).weight(1))
                                .with(ItemEntry.builder(RIPItems.BROWN_CLOTH).weight(5));

                        lootTableBuilder.pool(poolBuilder);
                    }
                }), () -> LOGGER.warn("Warning: could not locate Zombie Villager loot table for mod {}", MOD_ID)
        );

    }

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }

    public static void addToItemGroups() {
        RIPItems.ITEMS.forEach(item -> ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(item)));
    }

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        RIPItems.onInitialize();
        RestInPieces.addToItemGroups();
        RestInPieces.modifyZombieLootTable();
    }

}