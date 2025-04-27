package powercyphe.coffins.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import powercyphe.coffins.block.ModBlocks;
import powercyphe.coffins.util.ModTags;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.COFFIN);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.COFFIN);
        getOrCreateTagBuilder(BlockTags.DRAGON_IMMUNE)
                .add(ModBlocks.COFFIN);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("coffins", "coffin_replaceable")))
                .add(Blocks.AIR)
                .add(Blocks.CAVE_AIR)
                .add(Blocks.VOID_AIR)
                .add(Blocks.GRASS)
                .add(Blocks.FERN)
                .add(Blocks.DEAD_BUSH)
                .add(Blocks.DANDELION)
                .add(Blocks.POPPY)
                .add(Blocks.BLUE_ORCHID)
                .add(Blocks.ALLIUM)
                .add(Blocks.AZURE_BLUET)
                .add(Blocks.RED_TULIP)
                .add(Blocks.ORANGE_TULIP)
                .add(Blocks.WHITE_TULIP)
                .add(Blocks.PINK_TULIP)
                .add(Blocks.OXEYE_DAISY)
                .add(Blocks.CORNFLOWER)
                .add(Blocks.LILY_OF_THE_VALLEY)
                .add(Blocks.BROWN_MUSHROOM)
                .add(Blocks.RED_MUSHROOM)
                .forceAddTag(BlockTags.FLOWERS)
                .forceAddTag(BlockTags.SMALL_FLOWERS);

        getOrCreateTagBuilder(ModTags.Blocks.COFFIN_REPLACEABLE)
                .add(Blocks.SEAGRASS)
                .add(Blocks.TALL_SEAGRASS)
                .add(Blocks.KELP)
                .add(Blocks.KELP_PLANT)
                .forceAddTag(BlockTags.TALL_FLOWERS)
                .forceAddTag(BlockTags.SAPLINGS)
                .forceAddTag(BlockTags.CORAL_PLANTS)
                .forceAddTag(BlockTags.REPLACEABLE)
                .forceAddTag(BlockTags.CROPS)
                .add(Blocks.SNOW)
                .add(Blocks.MOSS_CARPET)
                .add(Blocks.CAVE_VINES)
                .add(Blocks.CAVE_VINES_PLANT)
                .add(Blocks.SCULK_VEIN)
                .add(Blocks.WATER)
                .add(Blocks.LAVA);
    }
}
