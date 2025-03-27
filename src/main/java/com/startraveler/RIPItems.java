package com.startraveler;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Function;

public class RIPItems {

    public static final Set<Item> ITEMS = new LinkedHashSet<>();

    public static final Item BLACK_CLOTH = register("black_cloth", Item::new, new Item.Settings());
    public static final Item GRAY_CLOTH = register("gray_cloth", Item::new, new Item.Settings());
    public static final Item LIGHT_GRAY_CLOTH = register("light_gray_cloth", Item::new, new Item.Settings());
    public static final Item WHITE_CLOTH = register("white_cloth", Item::new, new Item.Settings());
    public static final Item PINK_CLOTH = register("pink_cloth", Item::new, new Item.Settings());
    public static final Item RED_CLOTH = register("red_cloth", Item::new, new Item.Settings());
    public static final Item ORANGE_CLOTH = register("orange_cloth", Item::new, new Item.Settings());
    public static final Item YELLOW_CLOTH = register("yellow_cloth", Item::new, new Item.Settings());
    public static final Item LIME_CLOTH = register("lime_cloth", Item::new, new Item.Settings());
    public static final Item GREEN_CLOTH = register("green_cloth", Item::new, new Item.Settings());
    public static final Item CYAN_CLOTH = register("cyan_cloth", Item::new, new Item.Settings());
    public static final Item LIGHT_BLUE_CLOTH = register("light_blue_cloth", Item::new, new Item.Settings());
    public static final Item BLUE_CLOTH = register("blue_cloth", Item::new, new Item.Settings());
    public static final Item PURPLE_CLOTH = register("purple_cloth", Item::new, new Item.Settings());
    public static final Item MAGENTA_CLOTH = register("magenta_cloth", Item::new, new Item.Settings());
    public static final Item BROWN_CLOTH = register("brown_cloth", Item::new, new Item.Settings());


    private RIPItems() {
    }

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, RestInPieces.id(name));

        // Create the item instance.
        Item item = itemFactory.apply(settings);

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        ITEMS.add(item);

        return item;
    }


    public static void onInitialize() {
    }

}

