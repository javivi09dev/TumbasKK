package powercyphe.coffins.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import powercyphe.coffins.block.ModBlocks;
import powercyphe.coffins.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        // Receta para el ataúd
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COFFIN.asItem())
                .pattern("PPP")
                .pattern("CBC")
                .pattern("PPP")
                .input('P', Items.MANGROVE_PLANKS)
                .input('C', Items.CHEST)
                .input('B', Items.BONE_BLOCK)
                .criterion("has_bone_block", conditionsFromItem(Items.BONE_BLOCK))
                .offerTo(exporter, new Identifier("coffins", "coffin"));

        // Receta para el fragmento de eco
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.ECHO_SHARD, 4)
                .pattern("BBB")
                .pattern("BSB")
                .pattern("BBB")
                .input('B', Items.BONE_MEAL)
                .input('S', Items.SCULK)
                .criterion("has_sculk", conditionsFromItem(Items.SCULK))
                .offerTo(exporter, new Identifier("coffins", "echo_shard_from_sculk"));
        
        // Receta para la llave del ataúd
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COFFIN_KEY, 1)
                .pattern(" E ")
                .pattern(" I ")
                .pattern(" I ")
                .input('I', Items.IRON_INGOT)
                .input('E', Items.ECHO_SHARD)
                .criterion("has_echo_shard", conditionsFromItem(Items.ECHO_SHARD))
                .offerTo(exporter, new Identifier("coffins", "coffin_key"));
    }
}
