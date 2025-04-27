package powercyphe.coffins.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import powercyphe.coffins.Mod;
import powercyphe.coffins.block.ModBlocks;

public class ModItemGroup {
    public static final ItemGroup COFFINS = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier(Mod.MOD_ID, "coffins"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup.coffins.coffins"))
                    .icon(() -> new ItemStack(ModBlocks.COFFIN))
                    .build()
    );

    public static void registerItemGroups() {
        Mod.debugMessage("Registering Item Groups");
    }
}
