package powercyphe.coffins;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import powercyphe.coffins.datagen.ModBlockTagProvider;
import powercyphe.coffins.datagen.ModItemTagProvider;
import powercyphe.coffins.datagen.ModModelProvider;
import powercyphe.coffins.datagen.ModRecipeProvider;

public class ModDataGen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		
		ModBlockTagProvider blockTagProvider = pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider((output, registriesFuture) -> new ModItemTagProvider(output, registriesFuture, blockTagProvider));
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
