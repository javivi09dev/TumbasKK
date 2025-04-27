package powercyphe.coffins.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import powercyphe.coffins.Mod;
import powercyphe.coffins.item.custom.CoffinKeyItem;
import powercyphe.coffins.item.custom.FragilityTomeItem;

public class ModItems {
    // Adding Items

    public static final Item TOME_OF_FRAGILITY = registerItem("tome_of_fragility",
            new FragilityTomeItem(FragilityTomeMaterial.FRAGILITY_TOME_MATERIAL, new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item COFFIN_KEY = registerItem("coffin_key",
            new CoffinKeyItem(new FabricItemSettings().maxCount(16)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Mod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Mod.debugMessage("Registering Items");
    }
}
