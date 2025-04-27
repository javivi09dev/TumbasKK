package powercyphe.coffins.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import powercyphe.coffins.Mod;

public class ModSounds {
    public static SoundEvent COFFIN_OPEN = registerSoundevent("coffin_open");
    public static SoundEvent COFFIN_CLOSE = registerSoundevent("coffin_close");
    public static SoundEvent COFFIN_LOCKED = registerSoundevent("coffin_locked");

    private static SoundEvent registerSoundevent(String path) {
        Identifier id = new Identifier(Mod.MOD_ID, path);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    public static void registerModSounds() {
        Mod.debugMessage("Registering Sounds");
    }
}
