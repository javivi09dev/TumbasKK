package powercyphe.coffins.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import powercyphe.coffins.Mod;


public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> COFFIN_REPLACEABLE =
                createTag("coffin_replaceable");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Mod.MOD_ID, name));
        }
    }

    public static class Items {
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(Mod.MOD_ID, name));
        }
    }
}
